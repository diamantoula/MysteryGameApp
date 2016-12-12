package com.example.mysterygameapp.handlers;

import android.content.res.Resources;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonData;
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

    public void setMarkersOnMap(GoogleMap map, SingletonData data){

        ArrayList<Object> objs = data.getObjects();
        ArrayList<NPC> npcs = data.getNPCs();
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
            marker.setTag(0);
            data.setMarker(marker);
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
            marker.setTag(0);
            data.setMarker(marker);
        }
    }

    public void setOpacity(Marker marker){ marker.setAlpha(0.4f); }

    public void removeMarker(Marker marker){
        marker.remove();
    }

    public void setInvisible(Marker marker) {
        marker.setVisible(false);
    }

    //the function will search the string to find the entity's name
    //and accordingly return the correct message
/*    public String getSnippetMessage(Marker marker, SingletonData data, Resources res) {
        //String clue;
        String clue = "dfg0";
        int id = getMarkerId(marker, data);

        switch (id) {
            case 0:
                clue = res.getString(R.string.clue0);
                break;
            case 1:
                clue = res.getString(R.string.clue1);
                break;
            case 2:
                clue = res.getString(R.string.clue2);
                break;
            case 3:
                clue = res.getString(R.string.clue3);
                break;
            case 4:
                clue = res.getString(R.string.clue4);
                break;
            case 5:
                clue = res.getString(R.string.clue5);
                break;
            case 6:
                clue = res.getString(R.string.clue6);
                break;
            case 7:
                clue = res.getString(R.string.clue7);
                break;
            case 8:
                clue = res.getString(R.string.clue8);
                break;
            case 9:
                clue = res.getString(R.string.clue9);
                break;
            default:
                clue = res.getString(R.string.defaultClue);
                break;
        }

        return clue;
    }*/

 /*   public int getMarkerId (Marker marker, SingletonData data) {
        int id = -1;

        ArrayList<Marker> markers = data.getMarkers();
        boolean flag = false;
        int i = 0;

        while (flag == false) {

            if ( marker.getTitle() == "ticket agent") {
                if ( i>=0 && i<5 ) {
                    id = data.getObject(i).getObjId();
                } else {
                    id = data.getNPC(i).getNPCId();
                }
                flag = true;
            }
            i++;
        }

        return id;
    }*/

}
