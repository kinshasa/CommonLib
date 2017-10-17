// IData.aidl
package net.xicp.liushaobo.server;

// Declare any non-default types here with import statements

//parcelable Data;

interface IData {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}
