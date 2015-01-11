package com.ucsc.teamtutor.tutr.Model;

/**
 * Created by HP on 1/11/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class locationTracker extends Activity{
    Context theContext;
    String context = Context.LOCATION_SERVICE;

    //we need to pass a context in order to to access the location manager
    public locationTracker(Context context){
        theContext = context;
    }

    //location manager is used for most location functions
    LocationManager locationManager = (LocationManager)theContext.getSystemService(context);

    /*location listener is supposed to be used to updated location occasionally
    //right now it is not set up
    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            // Called when a new location is found by the network location provider.
            makeUseOfNewLocation(location);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {}

        public void onProviderEnabled(String provider) {}

        public void onProviderDisabled(String provider) {}
    };
    // Register the listener with the Location Manager to receive location updates NOT SET UP
    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

   */

    public Location getLocation() {
        String tracker = LocationManager.GPS_PROVIDER;
        //gets last known location
        Location position = locationManager.getLastKnownLocation(tracker);
        return position;
    }

    public double getLongitude(Location myLocation){
        return myLocation.getLongitude();
    }

    public double getLatitude(Location myLocation){
        return myLocation.getLatitude();
    }
}
