package com.android.demo.manager;

import android.location.Location;
import android.location.LocationManager;

/**
 * Created by liushaobo on 2018/2/12.
 */

public class LocationProvider implements ILocationProvider {

    private LocationManager locationManager;

    @Override
    public Location getLocation() {
        return null;
    }

    @Override
    public void requestLocationUpdates(String provider, long minTime, float minDistance, LocationListener listener) {

    }

    public LocationProvider getInstance(){
        return LocationInstance.mLocationProvider;
    }

    private static class LocationInstance{
        private static LocationProvider mLocationProvider = new LocationProvider();
    }

}
