package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.NPC;

import java.util.ArrayList;

public class NPCsData {

    private static ArrayList<NPC> npcs = new ArrayList<>();

    public static void setNpcs () {
        npcs.add(new NPC(0, "victim friend", 41.090928, 23.550254, "", "")); //1
        npcs.add(new NPC(1, "pedestrian", 41.089133, 23.550933, "", "")); //3
        npcs.add(new NPC(2, "ticket agent", 41.087592, 23.548122, "", "")); //5
        npcs.add(new NPC(3, "waiter", 41.086452, 23.546503, "", "")); //7
        npcs.add(new NPC(4, "storage owner", 41.083686, 23.544786, "", "")); //9
    }

    public static ArrayList<NPC> getNPCs () {
        return npcs;
    }

    public static NPC getNPC (int pos) {
        return npcs.get(pos);
    }

}
