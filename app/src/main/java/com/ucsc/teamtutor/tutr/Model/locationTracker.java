package com.ucsc.teamtutor.tutr.Model;

/**
 * Created by HP on 1/11/2015.
 */

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class locationTracker {
    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
}
