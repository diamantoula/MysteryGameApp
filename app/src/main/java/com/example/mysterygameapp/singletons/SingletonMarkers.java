package com.example.mysterygameapp.singletons;

import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;

import java.util.ArrayList;
import java.util.Arrays;

public class SingletonMarkers {

    private static ArrayList<Object> objs = new ArrayList<>();
    private static ArrayList<NPC> npcs = new ArrayList<>();
    private static ArrayList<Integer> counters = new ArrayList<>();

    public SingletonMarkers(){
        setObjects();
        setNpcs();
        setCounters();
    }

    //================================================================================//

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
        for (int i=5; i<5; i++) { counters.add(0); }
    }
    public ArrayList<Integer> getCounters () { return counters; }
    public int getCounter (int pos) { return counters.get(pos); }

}
