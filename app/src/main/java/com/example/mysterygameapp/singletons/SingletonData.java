package com.example.mysterygameapp.singletons;

import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.Character;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.staticData.BonusData;
import com.example.mysterygameapp.staticData.CharactersData;
import com.example.mysterygameapp.staticData.CountersData;
import com.example.mysterygameapp.staticData.MarkersData;
import com.example.mysterygameapp.staticData.NPCsData;
import com.example.mysterygameapp.staticData.ObjectsData;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.CharacterData;

import java.util.ArrayList;

public class SingletonData {

    public SingletonData(){
        ObjectsData.setObjects();
        NPCsData.setNpcs();
        BonusData.setBonuses();
        CountersData.setCounters();
        CharactersData.setCharacters();
        //markers
    }

    public static int findEntityID (String title) {
        ArrayList<Object> objs = ObjectsData.getObjects();
        ArrayList<NPC> npcs = NPCsData.getNPCs();
        ArrayList<Bonus> bonus = BonusData.getBonuses();

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
        ArrayList<Object> objs = ObjectsData.getObjects();
        ArrayList<NPC> npcs = NPCsData.getNPCs();
        ArrayList<Bonus> bonus = BonusData.getBonuses();

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
