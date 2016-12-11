package com.example.mysterygameapp.handlers;

import android.content.Context;
import android.content.res.Resources;
import android.media.ResourceBusyException;

import com.android.volley.toolbox.StringRequest;
import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonMarkers;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

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

        ArrayList<Object> objs = new SingletonMarkers().getObjects();
        ArrayList<NPC> npcs = new SingletonMarkers().getNPCs();
        Marker marker;
        LatLng latLng;

        //objects
        for (int i=0; i<5; i++) {
            latLng = new LatLng(objs.get(i).getLat(), objs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title("You found an Object")
                    .snippet("this is a " + objs.get(i).getObjName())
                    .visible(true)
                    .alpha(1.0f)
            );
        }

        //npcs
        for (int i=0; i<5; i++) {
            latLng = new LatLng(npcs.get(i).getLat(), npcs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(npcs.get(i).getNPCName())
                    .snippet("Hello Detective...")
                    .visible(true)
                    .alpha(1.0f)
            );
        }
    }

    public void setOpacity(Marker marker){ marker.setAlpha(0.4f); }

    public void removeMarker(Marker marker){
        marker.remove();
    }

    public void setInvisible(Marker marker) {
        marker.setVisible(false);
    }

    public void setSnippet (Marker marker, Resources res) {

    }


}
