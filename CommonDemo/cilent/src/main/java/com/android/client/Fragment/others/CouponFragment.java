package com.android.client.Fragment.others;

import android.os.Handler;
import android.view.View;

import com.android.lib.fragment.LoadingFragment;
import com.android.lib.utils.T;
import com.android.client.R;
import com.android.client.receiver.CouponEvent;
import com.android.client.receiver.MessageEvent;
import com.android.log.L;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liushaobo.xicp.net on 2016/6/6.
 */
public class CouponFragment extends LoadingFragment {

    @Override
    protected void initHeadView() {
        L.v();

    }

    @Override
    protected void initBodyView() {

        setBodyView(R.layout.fragment_coupon);
    }

    @Override
    protected void initUIWidget(){
        getBodyView().findViewById(R.id.btn_eventbus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.showShort(getContext(),"3秒后右面自动刷新数据");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String str = new SimpleDateFormat("MM-dd HH:mm")
                                .format(new Date(System.currentTimeMillis()));
                        EventBus.getDefault().post(new MessageEvent(str));
                    }
                },3000);

            }
        });
    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void setUI() {

    }

    @Override
    protected boolean isDataNotLoad() {
        return false;
    }


    @Override
    public void onStart() {
        super.onStart();
        //注册事件
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

    }

    @Override
    public void onDestroy() {
        //销毁事件
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void onCouponEvent(CouponEvent event){
        L.v("12345");
        getBodyView().findViewById(R.id.btn_eventbus).performClick();
    }


}
