package com.example.mysterygameapp.handlers;

import android.content.res.Resources;
import android.widget.Toast;

import com.example.mysterygameapp.EntityInfo;
import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.staticData.BonusData;
import com.example.mysterygameapp.staticData.CountersData;
import com.example.mysterygameapp.staticData.MarkersData;
import com.example.mysterygameapp.staticData.NPCsData;
import com.example.mysterygameapp.staticData.ObjectsData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Map;

public class MarkersHandler extends MapDemoActivity {

//============================================================================//
    //DISPLAYING MARKERS

    //CALLED UPDATEUSERMARKER
    public Marker setUserOnMap(GoogleMap map, LatLng location){

        Marker marker = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .snippet("This is Me...")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );
        marker.showInfoWindow();

        return marker;
    }

    //CALLED ONMARKERCLICK (first time click)
    public Marker updateUserMarker(GoogleMap map, Marker user, LatLng newLocation){
        if (user != null) {
            user.remove();
        }
        user = setUserOnMap(map, newLocation);

        return user;
    }

    //CALLED ONCONNECTED
    public void setMarkersOnMap(GoogleMap map){

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
                    .snippet("You found a " + objs.get(i).getObjName())
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
                    .snippet("Hello Detective...\n" + "I am " + npcs.get(i).getNPCName())
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
                    .snippet("You found a Bonus!")
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
            setVisible(marker);
            marker = npcMarkers.get(i);
            setVisible(marker);
        }
    }

    public void hideMarkers (int userCount, Marker user) {
        ArrayList<Marker> objMarkers = SingletonData.getMarkers("object");
        ArrayList<Marker> npcMarkers = SingletonData.getMarkers("npc");
        Marker marker;

        for (int i=0; i<5; i++) {
            marker = objMarkers.get(i);
            setInvisible(marker);
            marker = npcMarkers.get(i);
            setInvisible(marker);
        }

        displayNextEntity(userCount, user);
    }

    public void displayNextEntity (int userCount, Marker user) {
        Marker nextMarker;
        int id;
        int markerCount = 0;

        switch (userCount) {
            case 0:
                id = 0;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("npc").get(id);
                break;

            case 1:
                id = 0;
                nextMarker = SingletonData.getMarkers("object").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("object").get(id);
                break;

            case 2:
                id = 1;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("npc").get(id);
                break;

            case 3:
                id = 1;
                nextMarker = SingletonData.getMarkers("object").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("object").get(id);
                break;

            case 4:
                id = 2;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("npc").get(id);
                break;

            case 5:
                id = 2;
                nextMarker = SingletonData.getMarkers("object").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("object").get(id);
                break;

            case 6:
                id = 3;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("npc").get(id);
                break;

            case 7:
                id = 3;
                nextMarker = SingletonData.getMarkers("object").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("object").get(id);
                break;

            case 8:
                id = 4;
                nextMarker = SingletonData.getMarkers("npc").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("npc").get(id);
                break;

            case 9:
                id = 4;
                nextMarker = SingletonData.getMarkers("object").get(id);
                setVisible(nextMarker);
                markerCount = SingletonData.getCounters("object").get(id);
                break;

            default:
                break;
        }

        //setInvisible(currentMarker); //hide current marker
        setVisible(user); //display user on map
    }

//============================================================================//

    public void removeMarker(Marker marker){
        marker.remove();
    }

    public void setVisible(Marker marker) {
        marker.setVisible(true);
    }

    public void setInvisible(Marker marker) {
        marker.setVisible(false);
    }

//============================================================================//
    //INTERACTION

    public void startInteraction (Marker currentMarker, int pos, String type) {

        if (!type.equals("bonus")){
            currentMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        }
        SingletonData.incrementCounter(type, pos);
    }

    public void interactionMode (Marker currentMarker, int pos, String type) {

        if (type.equals("bonus")) {
            int bonus = SingletonData.getUser().getBonus() + SingletonData.getBonuses().get(pos).getBonus();
            SingletonData.getUser().setBonus(bonus);
        }
        SingletonData.incrementCounter(type, pos);
        SingletonData.incrementUserCount();
    }

    public void terminateInteraction(Marker user, int pos, String type) {
        if (!type.equals("bonus")){
            displayNextEntity(SingletonData.getUser().getCount(), user);
        }
    }

}
