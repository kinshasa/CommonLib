package net.xicp.liushaobo.server.service;

import android.os.IBinder;
import android.os.RemoteException;

import net.xicp.liushaobo.server.IDataTransferAidlInterface;

/**
 * Created by liushaobo on 2017/10/17.
 */

public class DataTransferService extends IDataTransferAidlInterface.Stub{
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public int getData() throws RemoteException {
        return 100000;
    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
