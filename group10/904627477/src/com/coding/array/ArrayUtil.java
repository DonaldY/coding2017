package com.coding.array;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin){
		if(origin==null){
			return ;
		}
		int len = origin.length;
		for (int i = 0; i < len/2 ; i++) {
			int temp = origin[len-1-i];
			origin[len-1-i] = origin[i];
			origin[i] = temp;
		}
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public int[] removeZero(int[] oldArray){
		if(oldArray==null){
			return new int[0];
		}
		int[] tempArr = new int[oldArray.length];
		int size = 0;
		for (int i = 0; i < oldArray.length; i++) {
			if(oldArray[i]!=0){
				tempArr[size] = oldArray[i];
				size++;
			}
		}		
		int[] newArr = new int[size];
		System.arraycopy(tempArr, 0, newArr, 0, size);
		return newArr;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		if(array1==null&&array2==null){
			return new int[0];
		}else if(array1==null||array2==null){
			return array1==null?array2:array1;
		}
		int[] arr3 = new int[array1.length+array2.length];
		int len1 = array1.length;
		int len2 = array2.length; 
		int i=0,j=0,k=0;
		while(true){
			if(i<len1&&j<len2){
				if(array1[i]<array2[j]){
					arr3[k++] = array1[i++];
				}else if(array1[i]>array2[j]){
					arr3[k++]=array2[j++];
				}else{
					arr3[k++] = array1[i++];
					j++;
				}
			}else if(i>=len1&&j<len2){
				arr3[k++]=array2[j++];
			}else if(i<len1&&j>=len2){
				arr3[k++]=array1[i++];
			}else{
				break;
			}
		}
		int[] newArr = new int[k];
		System.arraycopy(arr3, 0, newArr, 0, k);
		return newArr;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		if(oldArray==null){
			return new int[0];
		}
		if(size<0){
			throw new IllegalArgumentException();
		}
		int[] newArr = new int[oldArray.length + size];
		for (int i = 0; i < oldArray.length; i++) {
			newArr[i] = oldArray[i];
		}
		return newArr;
	}
	
	public static byte[] grow(byte[] oldArray,  int size){
		if(oldArray==null){
			return new byte[0];
		}
		if(size<0){
			throw new IllegalArgumentException();
		}
		byte[] newArr = new byte[oldArray.length + size];
		for (int i = 0; i < oldArray.length; i++) {
			newArr[i] = oldArray[i];
		}
		return newArr;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		if(max<1){
			throw new IllegalArgumentException();
		}
		int[] arr = new int[0];
		int temp = 1;
		for (int i = 0; max > temp; i++) {
			arr = grow(arr, 1);
			arr[arr.length-1] = temp;
			temp = getFibonacci(i+1);
		}
		return arr;
	}
	
	public int getFibonacci(int n){
		if(n==0||n==1){
			return 1;
		}else{
			return getFibonacci(n-1)+getFibonacci(n-2);
		}
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	//对大于1的自然数n，如果用2到  开根号n 之间的所有整数去除，均无法整除，则n为质数
	public int[] getPrimes(int max){
		int[] arr = new int[0];
		if(max<2){
			return arr;
		}
		for(int i=2;i<max;i++){
			if(isPrimes(i)){
				arr = grow(arr, 1);
				arr[arr.length-1] = i;
			}
		}
		return arr;
	}
	
	public boolean isPrimes(int n){
		if(n<=3){
			return n>1;
		}		
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		int[] arr = new int[0];
		if(max<1){
			return arr;
		}
		for (int i = 0; i < max; i++) {
			if(isPerfectNumber(i)){
				arr = grow(arr, 1);
				arr[arr.length-1] = i;
			}
		}
		return arr;
	}
	
	public boolean isPerfectNumber(int n){
		if(n<=1){
			return false;
		}
		int result = 1;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i==0){
				result = result + i + n/i;
			}
		}
		if(result==n){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	/*My
	 public String join(int[] array, String seperator){
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result = result + array[i] + seperator;
		}
		int index = result.lastIndexOf(seperator);
		return result.substring(0, index);
	}*/
	
	public String join(int[] array, String seperator){
		if(array==null){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			if(i<array.length-1){
				sb.append(seperator);
			}
		}
		return sb.toString();
	}
	

}
