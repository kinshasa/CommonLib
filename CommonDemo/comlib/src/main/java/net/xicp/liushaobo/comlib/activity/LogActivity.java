package net.xicp.liushaobo.comlib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import net.xicp.liushaobo.comlib.utils.log.L;


/**
 * Created by liusp@gagc.com.cn on 2016/6/24.
 */
public class LogActivity extends AppCompatActivity {

    /**
     * 当前页面是否需要加入生命周期日志记录
     */
    protected static boolean lifeCycleLog = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(lifeCycleLog){
            L.v();
        }
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(lifeCycleLog){
            L.v();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(lifeCycleLog){
            L.v();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(lifeCycleLog){
            L.v();
        }
    }
    
}
