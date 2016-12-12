package com.example.mysterygameapp.handlers;

import android.content.res.Resources;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonData;
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

    public void setMarkersOnMap(GoogleMap map){

        ArrayList<Object> objs = ObjectsData.getObjects();
        ArrayList<NPC> npcs = NPCsData.getNPCs();
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
            MarkersData.setObjMarker(marker);
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
            MarkersData.setNpcMarker(marker);
        }
    }

    public void setOpacity(Marker marker){ marker.setAlpha(0.4f); }

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

    //GET THE APPROPRIATE CLUE
    public String getSnippetMessage(Marker marker, Resources res) {
        String clue;

        String title = marker.getTitle();
        String entityType = getEntityType( title );

        if (entityType.equals("object")) {
            clue = getObjClue(title, res);

        } else if (entityType.equals("npc")) {
            clue = getNpcClue(title, res);

        } else {
            clue = res.getString(R.string.defaultClue);
        }

        return clue;
    }

    //BASED ON THE MARKER'S TITLE, FIND WHAT TYPE OF ENTITY IT IS
    public String getEntityType (String title) {

        if ( SingletonData.findEntityType(title).equals("object") ) {
            return "object";
        } else if ( SingletonData.findEntityType(title).equals("npc") ) {
            return "npc";
        } else {
            //default = null
            return null;
        }
    }

    //RETRIEVE OBJECT CLUE FROM XML
    public String getObjClue (String title, Resources res) {
        String[] clueArray = res.getStringArray(R.array.objects_clues);

        int id = SingletonData.findEntityID(title);

        return clueArray[id];
    }

    //RETRIEVE NPC CLUE FROM XML
    public String getNpcClue (String title, Resources res) {
        String[] clueArray = res.getStringArray(R.array.npcs_clues);

        int id = SingletonData.findEntityID(title);

        return clueArray[id];
    }

}
