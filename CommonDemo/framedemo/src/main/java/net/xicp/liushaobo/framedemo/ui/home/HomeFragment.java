package net.xicp.liushaobo.framedemo.ui.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import net.xicp.liushaobo.comlib.http.AsyncListener;
import net.xicp.liushaobo.comlib.http.HttpRequest;
import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.utils.T;
import net.xicp.liushaobo.framedemo.adapter.StoreAdapter;
import net.xicp.liushaobo.framedemo.entity.Store;
import net.xicp.liushaobo.framedemo.ui.baseui.LoadingFragment;
import net.xicp.liushaobo.pulltorefreshlib.ui.PullToRefreshBase;
import net.xicp.liushaobo.pulltorefreshlib.ui.PullToRefreshListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by liushaobo.xicp.net on 2016/6/6.
 */
public class HomeFragment extends LoadingFragment {


    private Context context;
    private ListView mListView;
    private PullToRefreshListView mPullListView;
    private StoreAdapter storeAdapter;
    private List<Store> stores;
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");
    @Override
    protected void initHeadView() {

        context = ctx;
        L.v();

    }

    @Override
    protected void initBodyView() {
        mPullListView = new PullToRefreshListView(context);
        mPullListView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //setBodyView(mPullListView);
        ((ViewGroup)getBodyView()).addView(mPullListView);


    }

    @Override
    protected void initUIWidget() {
        mPullListView.setPullLoadEnabled(false);
        mPullListView.setScrollLoadEnabled(true);

        stores = new ArrayList<Store>();
        storeAdapter = new StoreAdapter(context,stores);

        mListView = mPullListView.getRefreshableView();
        mListView.setAdapter(storeAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
                //String text = mListItems.get(position) + ", index = " + (position + 1);
                //Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                Store store = (Store) arg0.getAdapter().getItem(position);
                T.show(context,store.store_name,Toast.LENGTH_SHORT);
            }
        });

        mPullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                request(true);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                request();
            }
        });

    }

    @Override
    protected void initLogic() {
        mPullListView.doPullRefreshing(true, 500);
        setLastUpdateTime();

    }

    @Override
    protected void setUI() {

    }

    private int page = 0;

    private void request(boolean isStart){
        if(isStart){
            page = 0;
            stores.clear();
        }
        request();
    }

    private void request(){
        HashMap<String, String> mHashMap = new HashMap<String, String>() {
            {
                put("keywords", "");
                put("latitude", "");
                put("longitude", "");
                put("region_id", "");
                put("num", "10");
                put("order_by", "");
                put("page", page+ 1 + "");
            }
        };
        L.v(mHashMap);
        HttpRequest.getInstance().request(context, "http://api.carisok.com/icarapi.php/sstore/get_nearby_sstores/", mHashMap, new AsyncListener() {
            @Override
            public void onComplete(String values) {
                JSONObject json = JSONObject.parseObject(values);

                List<Store> data = JSONObject.parseArray(json.getJSONObject("data").getString("data"), Store.class);
                stores.addAll(data);
                storeAdapter.notifyDataSetChanged();

                page++;
                if(json.getJSONObject("data").getIntValue("page_count")>page){
                    mPullListView.setHasMoreData(true);
                }


                mPullListView.onPullDownRefreshComplete();
                mPullListView.onPullUpRefreshComplete();
                setLastUpdateTime();


            }

            @Override
            public void onException(Object exceptionInfo) {

            }
        });
    }

    @Override
    protected boolean isDataNotLoad() {
        return true;
    }



    private void setLastUpdateTime() {
        String text = formatDateTime(System.currentTimeMillis());
        mPullListView.setLastUpdatedLabel(text);
    }

    private String formatDateTime(long time) {
        if (0 == time) {
            return "";
        }

        return mDateFormat.format(new Date(time));
    }


}
