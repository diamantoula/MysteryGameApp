package com.example.mysterygameapp.singletons;

import com.example.mysterygameapp.handlers.MarkersHandler;
import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.Character;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.modelsDB.User;
import com.example.mysterygameapp.staticData.BonusData;
import com.example.mysterygameapp.staticData.CharactersData;
import com.example.mysterygameapp.staticData.CountersData;
import com.example.mysterygameapp.staticData.MarkersData;
import com.example.mysterygameapp.staticData.NPCsData;
import com.example.mysterygameapp.staticData.ObjectsData;
import com.example.mysterygameapp.staticData.UserData;
import com.google.android.gms.maps.model.Marker;

import org.w3c.dom.CharacterData;

import java.util.ArrayList;

public class SingletonData {

    private static ArrayList<Object> objects;
    private static ArrayList<NPC> npcs;
    private static ArrayList<Bonus> bonuses;

    private static ArrayList<Integer> objCounters;
    private static ArrayList<Integer> npcCounters;
    private static ArrayList<Integer> bonusCounters;

    private static ArrayList<Marker> objMarkers;
    private static ArrayList<Marker> npcMarkers;
    private static ArrayList<Marker> bonusMarkers;

    private static ArrayList<Character> characters;
    private static User user;

//================================================================================================//
    //CONSTRUCTOR, SETDATA, GETDATA

    public SingletonData(){
        setData();
        getData();
    }

    private static void setData () {
        ObjectsData.setObjects();
        NPCsData.setNpcs();
        BonusData.setBonuses();
        CountersData.setCounters();
        CharactersData.setCharacters();
        UserData.setUser();
        //set markers
    }

    private void getData () {
        objects = ObjectsData.getObjects();
        npcs = NPCsData.getNPCs();
        bonuses = BonusData.getBonuses();

        objCounters = CountersData.getCounters("object");
        npcCounters = CountersData.getCounters("npc");
        bonusCounters = CountersData.getCounters("bonus");

        //objMarkers;
        //npcMarkers;
        //bonusMarkers;

        characters = CharactersData.getCharacters();
        user = UserData.getUser();
    }

//================================================================================================//
    //MARKERS SET, GET, UPDATE?

    public static void setMarkers (ArrayList<Marker> markers, String type) {

        switch (type) {
            case "object":
                objMarkers = markers;
                break;
            case "npc":
                npcMarkers = markers;
                break;
            case "bonus":
                bonusMarkers = markers;
                break;
            default:
                break;
        }
    }

    public static ArrayList<Marker> getMarkers (String type) {

        switch (type) {
            case "object":
                return objMarkers;
            case "npc":
                return npcMarkers;
            case "bonus":
                return bonusMarkers;
            default:
                return null;
        }
    }

//================================================================================================//
    //GETTERS

    public static ArrayList<Object> getObjects () { return objects; }
    public static ArrayList<NPC> getNPCs () { return npcs; }
    public static ArrayList<Bonus> getBonuses () { return bonuses; }
    public static ArrayList<Character> getCharacters () { return characters; }
    public static User getUser () { return user; }

    public static ArrayList<Integer> getCounters (String type) {

        switch (type) {
            case "object":
                return objCounters;
            case "npc":
                return npcCounters;
            case "bonus":
                return bonusCounters;
            default:
                return null;
        }
    }

//================================================================================================//
    //FIND ENTITY INFO

    public static int findEntityID (String title) {
        ArrayList<Object> objs = getObjects();
        ArrayList<NPC> npcs = getNPCs();
        ArrayList<Bonus> bonus = getBonuses();

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
        ArrayList<Object> objs = getObjects();
        ArrayList<NPC> npcs = getNPCs();
        ArrayList<Bonus> bonus = getBonuses();

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
