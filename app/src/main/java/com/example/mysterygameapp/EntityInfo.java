package com.example.mysterygameapp;

import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonData;

import java.util.ArrayList;

public class EntityInfo {

    public static int findEntityID (String title) {
        ArrayList<Object> objs = SingletonData.getObjects();
        ArrayList<NPC> npcs = SingletonData.getNPCs();
        ArrayList<Bonus> bonus = SingletonData.getBonuses();

        int id = -1;

        for (int i =0; i<5; i++) {

            if ( title.equals(objs.get(i).getObjName()) ) {
                id = objs.get(i).getObjId();
            }
            if ( title.equals(npcs.get(i).getNPCName()) ) {
                id = npcs.get(i).getNPCId();
            }
            if ( title.equals(bonus.get(i).getName() )) {
                id = bonus.get(i).getId();
            }
        }

        return id;
    }

    public static String findEntityType (String title) {
        ArrayList<Object> objs = SingletonData.getObjects();
        ArrayList<NPC> npcs = SingletonData.getNPCs();
        ArrayList<Bonus> bonus = SingletonData.getBonuses();

        for (int i =0; i<5; i++) {

            if ( title.equals(objs.get(i).getObjName()) ) {
                return "object";
            }
            if ( title.equals(npcs.get(i).getNPCName()) ) {
                return "npc";
            }
            if ( title.equals(bonus.get(i).getName()) ) {
                return "bonus";
            }
        }
        return null;
    }

}
