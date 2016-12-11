package com.example.mysterygameapp.handlers;

import android.content.Context;
import android.content.res.Resources;
import android.media.ResourceBusyException;

import com.android.volley.toolbox.StringRequest;
import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkersHandler extends MapDemoActivity {

    public Marker setUserOnMap(GoogleMap map, LatLng location){

        Marker marker = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );

        return marker;
    }

    public void setMarkersOnMap(GoogleMap map){

        Marker m1 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086316, 23.547215))
                .title("obj1")
                .snippet("")
                .visible(true)
        );

        Marker m2 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086652, 23.546853))
                .title("obj2")
                .snippet("")
                .visible(true)
        );

        Marker m3 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086409, 23.546440))
                .title("obj3")
                .snippet("")
                .visible(true)
        );

        Marker m4 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086172, 23.546035))
                .title("obj4")
                .snippet("")
                .visible(true)
        );

        Marker m5 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086586, 23.545613))
                .title("obj5")
                .snippet("")
                .visible(true)
        );
    }

    public void highlightMarker(Marker marker){
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
    }

    public void removeMarker(Marker marker){
        marker.remove();
    }

    public void setInvisible(Marker marker) {
        marker.setVisible(false);
    }

    public void setSnippet (Marker marker, String title, int tag, Resources res) {

    }


}
