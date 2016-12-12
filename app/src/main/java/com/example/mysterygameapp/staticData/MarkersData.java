package com.example.mysterygameapp.staticData;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

public class MarkersData {

    private static ArrayList<Marker> objMarkers = new ArrayList<>();
    private static ArrayList<Marker> npcMarkers = new ArrayList<>();

    public static void setObjMarker (Marker marker) {
        objMarkers.add(marker);
    }
    public static void setNpcMarker (Marker marker) {
        npcMarkers.add(marker);
    }

    public static ArrayList<Marker> getMarkers (String type) {

        if (type.equals("object")) {
            return objMarkers;
        } else {
            return npcMarkers;
        }
    }

}
