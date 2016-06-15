package net.xicp.liushaobo.framedemo.ui.others;

import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.utils.T;
import net.xicp.liushaobo.framedemo.R;
import net.xicp.liushaobo.framedemo.bus.MessageEvent;
import net.xicp.liushaobo.framedemo.ui.baseui.LoadingFragment;
import net.xicp.liushaobo.pulltorefreshlib.ui.PullToRefreshBase;
import net.xicp.liushaobo.pulltorefreshlib.ui.PullToRefreshListView;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

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

}
