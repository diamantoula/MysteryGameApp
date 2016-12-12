package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.NPC;

import java.util.ArrayList;

public class NPCsData {

    private static ArrayList<NPC> npcs = new ArrayList<>();

    public static void setNpcs () {
        npcs.add(new NPC(0, "victim friend", 41.090948, 23.550072, "", "")); //1
        npcs.add(new NPC(1, "pedestrian", 41.090653, 23.549042, "", "")); //4
        npcs.add(new NPC(2, "ticket agent", 41.088251, 23.547229, "", "")); //6
        npcs.add(new NPC(3, "waiter", 41.085244, 23.545252, "", "")); //8
        npcs.add(new NPC(4, "storage owner", 41.082229, 23.545148, "", "")); //10
    }

    public static ArrayList<NPC> getNPCs () {
        return npcs;
    }

    public static NPC getNPC (int pos) {
        return npcs.get(pos);
    }

}
