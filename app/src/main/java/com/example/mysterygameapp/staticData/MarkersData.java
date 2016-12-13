package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.Bonus;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

public class MarkersData {

    private static ArrayList<Marker> objMarkers = new ArrayList<>();
    private static ArrayList<Marker> npcMarkers = new ArrayList<>();
    private static ArrayList<Marker> bonusMarkers = new ArrayList<>();

    public static void setObjMarker (Marker marker) {
        objMarkers.add(marker);
    }
    public static void setNpcMarker (Marker marker) { npcMarkers.add(marker); }
    public static void setBonusMarker (Marker marker) { bonusMarkers.add(marker); };

    public static ArrayList<Marker> getMarkers (String type) {

        switch (type) {
            case "object":
                return objMarkers;
            case "npc":
                return npcMarkers;
            case "bonus":
                return bonusMarkers;
            default:
                return null;
        }
    }

}
