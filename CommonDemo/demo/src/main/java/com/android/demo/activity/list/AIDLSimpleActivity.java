package com.android.demo.activity.list;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.android.base.activity.BaseActivity;
import com.android.demo.service.DataTransferClient;
import com.android.log.L;

/**
 * Created by liushaobo on 2017/10/17.
 */

public class AIDLSimpleActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.v();
        try {
            int value = DataTransferClient.getInstance().getDataInterface().getData();
            L.v(value);
        } catch (RemoteException e) {
            L.v(e.getMessage());
        }catch (Exception e){
            //Attempt to invoke interface method 'int net.xicp.liushaobo.server.IDataTransferAidlInterface.getData()' on a null object reference
            L.v(e.getMessage());
        }

    }
}
