package com.android.demo.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.android.log.L;

import net.xicp.liushaobo.server.IDataTransferAidlInterface;

/**
 * Created by liushaobo on 2017/10/17.
 */

public class DataTransferClient{

    private static DataTransferClient mInstance;
    private IDataTransferAidlInterface dataInterface ;
    private static final String INTENT_DATA_TRANSFER_SERVICE = "net.xicp.liushaobo.server.DataTransferService";

    public static DataTransferClient getInstance() {
        if(mInstance == null){
            synchronized(DataTransferClient.class){
                if(mInstance == null){
                    mInstance = new DataTransferClient();
                }
            }
        }
        return mInstance;
    }
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            dataInterface = IDataTransferAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            dataInterface = null;
        }
    };

    public void connectService(Context context){
        Intent intent = new Intent();
        intent.setAction(INTENT_DATA_TRANSFER_SERVICE);
        intent.setPackage("net.xicp.liushaobo.server");
        context.bindService(intent,conn,Context.BIND_AUTO_CREATE);
    }

    public IDataTransferAidlInterface getDataInterface(){
        if(dataInterface == null){
            L.v("dataInterface == null.");
        }
        return dataInterface;
    }

}
