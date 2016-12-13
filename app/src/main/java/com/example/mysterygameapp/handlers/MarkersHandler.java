package com.example.mysterygameapp.handlers;

import android.content.res.Resources;
import android.widget.Toast;

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

public class MarkersHandler extends MapDemoActivity {

    public Marker setUserOnMap(GoogleMap map, LatLng location){

        Marker marker = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );

        return marker;
    }

    public static void setMarkersOnMap(GoogleMap map){

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
                    .visible(true)
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
                    .visible(true)
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

    public void startInteraction (Marker marker, int pos, String type) {

        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        CountersData.incrementCounter(type, pos);
    }

    public void interactionMode (Marker marker, int pos, String type) {

        if (type.equals("bonus")) {
            int bonus = SingletonData.getUser().getBonus() + SingletonData.getBonuses().get(pos).getBonus();
            SingletonData.getUser().setBonus(bonus);
        }

        CountersData.incrementCounter(type, pos);
    }

    public void terminateInteraction(Marker marker, int pos, String type) {
        marker.setAlpha(0.4f);
    }

//============================================================================//

    public String getSnippetMessage (Marker marker, Resources res, String messageType) {
        String message;

        String title = marker.getTitle();
        String type = SingletonData.findEntityType(title);

        switch (type) {
            case "object":
                message = getObjMessage(title, res, messageType);
                break;
            case "npc":
                message = getNpcMessage(title, res, messageType);
                break;
            case "bonus":
                message = getBonusMessage(title, res, messageType);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }

    //RETRIEVE OBJECT MESSAGE FROM XML
    public String getObjMessage (String title, Resources res, String messageType) {
        String message;

        switch (messageType) {
            case "greeting":
                message = res.getString(R.string.objectGreeting);
                break;
            case "main":
                String[] clueArray = res.getStringArray(R.array.objects_clues);
                int id = SingletonData.findEntityID(title);
                message = clueArray[id];
                break;
            case "back":
                message = res.getString(R.string.objectBack);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }

    //RETRIEVE NPC MESSAGE FROM XML
    public String getNpcMessage (String title, Resources res, String messageType) {
        String message;

        switch (messageType) {
            case "greeting":
                message = res.getString(R.string.npcGreeting);
                break;
            case "main":
                String[] clueArray = res.getStringArray(R.array.npcs_clues);
                int id = SingletonData.findEntityID(title);
                message = clueArray[id];
                break;
            case "back":
                message = res.getString(R.string.npcBack);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }

    //RETRIEVE BONUS MESSAGE FROM XML
    public String getBonusMessage (String title, Resources res, String messageType) {
        String message;

        switch (messageType) {
            case "greeting":
                message = res.getString(R.string.bonusGreeting);
                break;
            case "main":
                message = res.getString(R.string.bonusTaken);
                break;
            case "back":
                message = res.getString(R.string.bonusBack);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }
}
