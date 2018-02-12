package com.android.demo.manager;

import android.location.Location;

/**
 * Created by liushaobo on 2018/2/12.
 */

public interface ILocationProvider {

    Location getLocation();

    void requestLocationUpdates(String provider, long minTime, float minDistance,LocationListener listener);
}
