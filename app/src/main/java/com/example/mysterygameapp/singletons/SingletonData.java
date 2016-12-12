package com.example.mysterygameapp.singletons;

import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.staticData.CountersData;
import com.example.mysterygameapp.staticData.MarkersData;
import com.example.mysterygameapp.staticData.NPCsData;
import com.example.mysterygameapp.staticData.ObjectsData;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

public class SingletonData {

    public SingletonData(){
        ObjectsData.setObjects();
        NPCsData.setNpcs();
        CountersData.setCounters();
    }

    public static int findEntityID (String title) {
        ArrayList<Object> objs = ObjectsData.getObjects();
        ArrayList<NPC> npcs = NPCsData.getNPCs();

        int id = -1;

        for (int i =0; i<5; i++) {

            if ( title.equals(objs.get(i).getObjName()) ) {
                id = objs.get(i).getObjId();
            }
            if ( title.equals(npcs.get(i).getNPCName()) ) {
                id = npcs.get(i).getNPCId();
            }
        }

        return id;
    }

    public static String findEntityType (String title) {
        ArrayList<Object> objs = ObjectsData.getObjects();
        ArrayList<NPC> npcs = NPCsData.getNPCs();

        for (int i =0; i<5; i++) {

            if ( title.equals(objs.get(i).getObjName()) ) {
                return "object";
            }
            if ( title.equals(npcs.get(i).getNPCName()) ) {
                return "npc";
            }
        }
        return null;
    }

}
