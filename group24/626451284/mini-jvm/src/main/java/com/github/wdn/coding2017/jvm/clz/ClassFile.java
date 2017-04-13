package com.github.wdn.coding2017.jvm.clz;

import com.github.wdn.coding2017.jvm.constant.ConstantPool;

/**
 * Created by Administrator on 2017/4/6 0006.
 */
public class ClassFile {
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private AccessFlag accessFlag;
    private ClassIndex classIndex;
    public void print() {
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public AccessFlag getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(AccessFlag accessFlag) {
        this.accessFlag = accessFlag;
    }

    public ClassIndex getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(ClassIndex classIndex) {
        this.classIndex = classIndex;
    }

    public ClassIndex getClzIndex() {
        return null;
    }
}