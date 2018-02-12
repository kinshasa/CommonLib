package com.android.demo.activity.list;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.android.base.activity.BaseActivity;
import com.android.demo.R;
import com.android.log.L;

import java.util.List;

/**
 * Created by liushaobo on 2018/1/31.
 */

public class SensorDataCollectActivity extends BaseActivity {

    private static final String TAG = "SensorDataCollectActivity";

    private Context mContext = SensorDataCollectActivity.this;

    private TextView tvLocationMsg;

    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.v();
        setContentView(R.layout.activity_sensor_data_collect);
        init();

    }

    private void init() {
        L.v();
        initView();
        initLocationManager();
    }

    private void initView() {
        L.v();
        tvLocationMsg = (TextView) findViewById(R.id.tvLocationMsg);
    }

    private void initLocationManager() {
        L.v();
        if (!checkPermission()) {
            return;
        }
        // 获取系统LocationManager服务
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) {
            L.v("locationManager is null.");
            return;
        }
        //获取当前可用的位置控制器
        List<String> list = locationManager.getProviders(true);
        if (list.contains(LocationManager.GPS_PROVIDER)) {
            //是否为GPS位置控制器
            provider = LocationManager.GPS_PROVIDER;
        } else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
            //是否为网络位置控制器
            provider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(this, "请检查网络或GPS是否打开", Toast.LENGTH_LONG).show();
            return;
        }
        // 从GPS获取最近的定位信息
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        updateView(location);
        // 将location里的位置信息显示在EditText中
        // 设置每2秒获取一次GPS的定位信息
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                2000, 8, new LocationListener() {

                    @Override
                    public void onLocationChanged(Location location) {
                        // 当GPS定位信息发生改变时，更新位置
                        updateView(location);
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                        updateView(null);
                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                        if (!checkPermission()) {
                            return;
                        }
                        // 当GPS LocationProvider可用时，更新位置
                        updateView(locationManager.getLastKnownLocation(provider));
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }
                });
    }

    public boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            L.v(false);
            return false;
        }
        L.v(true);
        return true;
    }

    private void updateView(Location location) {
        L.v(location);
        if (location != null) {
            String sb = "实时的位置信息：\n经度：" +
                    location.getLongitude() +
                    "\n纬度：" +
                    location.getLatitude() +
                    "\n高度：" +
                    location.getAltitude() +
                    "\n速度：" +
                    location.getSpeed() +
                    "\n方向：" +
                    location.getBearing() +
                    "\n精度：" +
                    location.getAccuracy();
            tvLocationMsg.setText(sb);
        } else {
            // 如果传入的Location对象为空则清空EditText
            tvLocationMsg.setText("null");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
