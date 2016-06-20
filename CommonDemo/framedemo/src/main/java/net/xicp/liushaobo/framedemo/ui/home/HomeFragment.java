package net.xicp.liushaobo.framedemo.ui.home;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import net.xicp.liushaobo.comlib.http.HttpBase;
import net.xicp.liushaobo.comlib.http.Http;
import net.xicp.liushaobo.comlib.utils.L;
import net.xicp.liushaobo.comlib.utils.T;
import net.xicp.liushaobo.framedemo.adapter.StoreAdapter;
import net.xicp.liushaobo.framedemo.bus.MessageEvent;
import net.xicp.liushaobo.framedemo.entity.Store;
import net.xicp.liushaobo.framedemo.entity.greendao.DaoMaster;
import net.xicp.liushaobo.framedemo.entity.greendao.DaoSession;
import net.xicp.liushaobo.framedemo.entity.greendao.Note;
import net.xicp.liushaobo.framedemo.entity.greendao.NoteDao;
import net.xicp.liushaobo.framedemo.ui.baseui.LoadingFragment;
import net.xicp.liushaobo.pulltorefreshlib.ui.PullToRefreshBase;
import net.xicp.liushaobo.pulltorefreshlib.ui.PullToRefreshListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

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
                L.v("stores.size()"+stores.size());
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

        //初始化Database
        setupDatabase();
        //下拉刷新请求数据
        mPullListView.doPullRefreshing(true, 3000);
        //设置下拉更新时间
        //setLastUpdateTime();

        String str = search("stores"+page);
        List<Store> temp = formatStores(str);
        stores.addAll(temp);
        storeAdapter.notifyDataSetChanged();

    }

    @Override
    protected void setUI() {

    }

    @Override
    public void onStart() {
        super.onStart();
        //注册事件
        L.v(EventBus.getDefault().isRegistered(this));
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
    public void onMessageEvent(MessageEvent event){
        L.v("12345");
        Toast.makeText(getActivity(), "监听，接收传递数据:"+event.message, Toast.LENGTH_SHORT).show();
        mPullListView.doPullRefreshing(true, 0);
    }


    private int page = 0;

    private void request(boolean isStart){
        if(isStart){
            page = 0;
            //请求时不需要清空数据，遇到网络失败后体验不佳
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
        //YHttpRequest.getInstance().request(context, "http://api.carisok.com/icarapi.php/sstore/get_nearby_sstores/", mHashMap, new YAsyncListener() {
        HttpBase.getDefaultRequest().request(context, "http://api.carisok.com/icarapi.php/sstore/get_nearby_sstores/", mHashMap, new Http.onHttpListener() {

            @Override
            public void onComplete(String values) {
                JSONObject json = JSONObject.parseObject(values);

                List<Store> data = formatStores(json.getJSONObject("data").getString("data"));
                if(page == 0){
                    //如果是下拉刷新或者第一次请求，当请求成功返回时才可以清空列表数据
                    stores.clear();
                }
                stores.addAll(data);
                storeAdapter.notifyDataSetChanged();
                if(page == 0){
                    //save to db
                    addNote(JSONObject.toJSONString(data),"stores"+page);
                }
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
        return false;
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

    private List<Store> formatStores(String str){
        List<Store> list = JSONObject.parseArray(str, Store.class);
        return list;
    }


    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;
    private Cursor cursor;



    private void addNote(String msg,String flag) {

        //先清空数据表
        getDaoSession().getNoteDao().deleteAll();

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = flag;

        if (msg == null || msg.equals("")) {
            T.showShort(context,"Please enter a note to add");
        } else {
            // 插入操作，简单到只要你创建一个 Java 对象
            Note note = new Note(null, msg, comment, new Date());
            getDaoSession().getNoteDao().insert(note);
            L.v( "Inserted new note, ID: " + note.getId());
            cursor.requery();
        }

    }

    private String search(String str) {

        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        if (str == null || str.equals("")) {
            T.showShort(context.getApplicationContext(), "Please enter a note to query");
            return "";
        }

        // Query 类代表了一个可以被重复执行的查询
        Query query = getDaoSession().getNoteDao().queryBuilder()
                .where(NoteDao.Properties.Comment.eq(str))
                .orderAsc(NoteDao.Properties.Date)
                .build();

        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;

        // 查询结果以 List 返回
        List<Note> notes = query.list();
        if(notes == null ||  notes.isEmpty()){
            return "";
        }

        return notes.get(0).getText();

    }
    private void setupDatabase() {
        // init DaoHelper.
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(context, "_temp", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        // init cursor
        String textColumn = NoteDao.Properties.Text.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = getDb().query(getDaoSession().getNoteDao().getTablename(),getDaoSession().getNoteDao().getAllColumns(), null, null, null, null, orderBy);

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

}
