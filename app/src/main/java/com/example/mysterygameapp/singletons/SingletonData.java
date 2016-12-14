package com.example.mysterygameapp.singletons;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.mysterygameapp.SaveLoadHandler;
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

import java.net.PortUnreachableException;
import java.util.ArrayList;

public class SingletonData extends AppCompatActivity {

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

    //CALLED IN THE MAIN ACTIVITY BEFORE THE USER LOGS IN OR REGISTERS
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
        characters = CharactersData.getCharacters();
        user = UserData.getUser();
        //objMarkers; npcMarkers; bonusMarkers;
    }

//================================================================================================//
    //COUNTERS GET, INCREMENT, DECREMENT

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

    public static void incrementCounter (String type, int pos) {
        int count;

        switch (type) {
            case "object":
                count = objCounters.get(pos);
                count++;
                objCounters.set(pos, count);
                break;
            case "npc":
                count = npcCounters.get(pos);
                count++;
                npcCounters.set(pos, count);
                break;
            case "bonus":
                count = bonusCounters.get(pos);
                count++;
                bonusCounters.set(pos, count);
                break;
            default:
                break;
        }
    }

    public static void decrementObjCounter (String type, int pos) {
        int count;

        switch (type) {
            case "object":
                count = objCounters.get(pos);
                count--;
                objCounters.set(pos, count);
                break;
            case "npc":
                count = npcCounters.get(pos);
                count--;
                npcCounters.set(pos, count);
                break;
            case "bonus":
                count = bonusCounters.get(pos);
                count--;
                bonusCounters.set(pos, count);
                break;
            default:
                break;
        }
    }

//================================================================================================//
    //MARKERS SET, GET

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
    //USER GET, SETCOUNT, SETBONUS

    public static User getUser () { return user; }

    public static void setUserCount (int count1) {
        user.setCount(count1);
    }

    public static void setUserBonus (int bonus1) {
        user.setBonus(bonus1);
    }

    public static void incrementUserCount () {
        int count = user.getCount();
        count++;
        user.setCount(count);
    }

//================================================================================================//
    //GETTERS

    public static ArrayList<Object> getObjects () { return objects; }
    public static ArrayList<NPC> getNPCs () { return npcs; }
    public static ArrayList<Bonus> getBonuses () { return bonuses; }
    public static ArrayList<Character> getCharacters () { return characters; }

}
