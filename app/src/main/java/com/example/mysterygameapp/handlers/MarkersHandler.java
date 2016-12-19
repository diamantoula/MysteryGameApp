package com.example.mysterygameapp.handlers;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.staticData.MarkersData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MarkersHandler extends MapDemoActivity {

//============================================================================//
    //DISPLAYING MARKERS

    //CALLED ON ON_CONNECTED AND ON_CLICK
    public Marker setUserOnMap(GoogleMap map, LatLng location, Marker user){

        if (user != null) {
            user.remove();
        }

        user = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .snippet("This is Me...")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );
        user.showInfoWindow();

        return user;
    }

    //CALLED ON_CONNECTED
    public void setMarkersOnMap(GoogleMap map, int userCount){

        ArrayList<Object> objs = SingletonData.getObjects();
        ArrayList<NPC> npcs = SingletonData.getNPCs();
        ArrayList<Bonus> bonus = SingletonData.getBonuses();
        Marker marker;
        LatLng latLng;

        //objects
        for (int i=0; i<5; i++) {
            latLng = new LatLng(objs.get(i).getLat(), objs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(objs.get(i).getObjName())
                    .visible(false)
                    .alpha(1.0f)
            );
            MarkersData.setMarker(marker, "object");
        }

        //npcs
        for (int i=0; i<5; i++) {
            latLng = new LatLng(npcs.get(i).getLat(), npcs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(npcs.get(i).getNPCName())
                    .visible(false)
                    .alpha(1.0f)
            );
            MarkersData.setMarker(marker, "npc");
        }

        //bonus
        for (int i=0; i<5; i++) {
            latLng = new LatLng(bonus.get(i).getLat(), bonus.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(bonus.get(i).getName())
                    .visible(true)
                    .alpha(0.4f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
            );
            MarkersData.setMarker(marker, "bonus");
        }

        //initialize markers in SingletonData
        SingletonData.setMarkers(MarkersData.getMarkers("object"), "object");
        SingletonData.setMarkers(MarkersData.getMarkers("npc"), "npc");
        SingletonData.setMarkers(MarkersData.getMarkers("bonus"), "bonus");
    }

    public void showAllMarkers () {
        ArrayList<Marker> objMarkers = SingletonData.getMarkers("object");
        ArrayList<Marker> npcMarkers = SingletonData.getMarkers("npc");
        Marker marker;

        for (int i=0; i<5; i++) {
            marker = objMarkers.get(i);
                marker.setVisible(true);
            marker = npcMarkers.get(i);
                marker.setVisible(true);
        }
    }

    //HIDE OBJECT AND NPC MARKERS
    public void hideMarkers () {
        ArrayList<Marker> objMarkers = SingletonData.getMarkers("object");
        ArrayList<Marker> npcMarkers = SingletonData.getMarkers("npc");
        Marker marker;

        for (int i=0; i<5; i++) {
            marker = objMarkers.get(i);
                marker.setVisible(false);
            marker = npcMarkers.get(i);
                marker.setVisible(false);
        }
    }

    public void displayNextEntity (GoogleMap map, int userCount) {
        Marker nextMarker;
        int id;

        switch (userCount) {
            case 0:
                id = 0;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                break;

            case 1:
                id = 0;
                nextMarker = SingletonData.getMarkers("object").get(id);
                break;

            case 2:
                id = 1;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                break;

            case 3:
                id = 1;
                nextMarker = SingletonData.getMarkers("object").get(id);
                break;

            case 4:
                id = 2;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                break;

            case 5:
                id = 2;
                nextMarker = SingletonData.getMarkers("object").get(id);
                break;

            case 6:
                id = 3;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                break;

            case 7:
                id = 3;
                nextMarker = SingletonData.getMarkers("object").get(id);
                break;

            case 8:
                id = 4;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                break;

            case 9:
                id = 4;
                nextMarker = SingletonData.getMarkers("object").get(id);
                break;

            default:
                //on default go to first
                id = 0;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                break;
        }

        //setting next marker on map
        nextMarker = map.addMarker(new MarkerOptions()
                .position(nextMarker.getPosition())
                .title(nextMarker.getTitle())
                .snippet("This is Next Location...")
        );
        nextMarker.showInfoWindow();
    }

}
