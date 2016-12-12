package com.example.mysterygameapp.singletons;

import com.example.mysterygameapp.handlers.MarkersHandler;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SingletonData {

    private static ArrayList<Object> objs = new ArrayList<>();
    private static ArrayList<NPC> npcs = new ArrayList<>();
    private static ArrayList<Integer> counters = new ArrayList<>();
    private static ArrayList<Marker> markers = new ArrayList<>();

    public SingletonData(){
        setObjects();
        setNpcs();
        setCounters();
    }

    //================================================================================//

    //0-4
    public static void setObjects () {
        objs.add(new Object(2, "wallet", "no", 41.090824, 23.54957, "", ""));
        objs.add(new Object(3, "knife", "no", 41.090751, 23.54928, "", ""));
        objs.add(new Object(5, "parking ticket", "no", 41.090127, 23.548624, "", ""));
        objs.add(new Object(7, "receipt", "no", 41.088202, 23.546993, "", ""));
        objs.add(new Object(9, "car", "no", 41.085054, 23.545593, "", ""));
    }
    public ArrayList<Object> getObjects () { return objs; }
    public Object getObject (int pos) { return objs.get(pos); }

    //================================================================================//

    //5-9
    public void setNpcs () {
        npcs.add(new NPC(1, "victim friend", 41.090948, 23.550072, "", ""));
        npcs.add(new NPC(4, "pedestrian", 41.090653, 23.549042, "", ""));
        npcs.add(new NPC(6, "ticket agent", 41.088251, 23.547229, "", ""));
        npcs.add(new NPC(8, "waiter", 41.085244, 23.545252, "", ""));
        npcs.add(new NPC(10, "storage owner", 41.082229, 23.545148, "", ""));
    }
    public ArrayList<NPC> getNPCs () { return npcs; }
    public NPC getNPC (int pos) { return npcs.get(pos); }

    //================================================================================//

    public void setCounters () {
        for (int i=0; i<10; i++) { counters.add(0); }
    }
    public ArrayList<Integer> getCounters () { return counters; }
    public int getCounter (int pos) { return counters.get(pos); }
    public void incrementCounter (int pos) {
        int count = counters.get(pos);
        count++;
        counters.set(pos, count);
    }
    public void decrementCounter (int pos) {
        int count = counters.get(pos);
        count--;
        counters.set(pos, count);
    }

    //================================================================================//

    public void setMarker (Marker marker) { markers.add(marker); }
    public ArrayList<Marker> getMarkers () { return markers; }

    //================================================================================//

    public int findEntityID (String name) {
        int id = -1;

        for (int i =0; i<5; i++) {

            if ( name.equals(objs.get(i).getObjName()) ) {
                id = objs.get(i).getObjId();
            }
            if ( name.equals(npcs.get(i).getNPCName()) ) {
                id = npcs.get(i).getNPCId();
            }
        }

        return id;
    }

}
