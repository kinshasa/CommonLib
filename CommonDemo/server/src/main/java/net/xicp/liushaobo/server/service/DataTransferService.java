package net.xicp.liushaobo.server.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import net.xicp.liushaobo.server.IDataTransferAidlInterface;

/**
 * Created by liushaobo on 2017/10/17.
 */

public class DataTransferService extends Service{

    private DataTransferBinder dataTransferBinder;

    private class DataTransferBinder extends IDataTransferAidlInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int getData() throws RemoteException {
            return 100000;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        dataTransferBinder = new DataTransferBinder();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return dataTransferBinder;
    }
}
