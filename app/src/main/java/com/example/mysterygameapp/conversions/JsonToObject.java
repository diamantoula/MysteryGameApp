package com.example.mysterygameapp.conversions;

import com.example.mysterygameapp.modelsDB.Item;
import com.example.mysterygameapp.modelsDB.NPC;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonToObject {

    public ArrayList<Item> toItem(String strToConvert) throws JSONException {

        JSONObject parentObj = new JSONObject(strToConvert);
        JSONArray parentArray = parentObj.getJSONArray("items");

        ArrayList<Item> itemList = new ArrayList<>();

        for (int i=0; i<parentArray.length(); i++){
            JSONObject object = parentArray.getJSONObject(i);

            Item item = new Item();
            item.setId(object.getInt("id"));
            item.setName(object.getString("name"));
            item.setLat(object.getDouble("lat"));
            item.setLng(object.getDouble("lng"));

            itemList.add(item);
        }

        return itemList;
    }

    public ArrayList<NPC> toNPC(String strToConvert) throws JSONException {

        JSONObject parentObj = new JSONObject(strToConvert);
        JSONArray parentArray = parentObj.getJSONArray("npcs");

        ArrayList<NPC> npcList = new ArrayList<>();

        for (int i=0; i<parentArray.length(); i++){
            JSONObject object = parentArray.getJSONObject(i);

            NPC npc = new NPC();
            npc.setId(object.getInt("id"));
            npc.setName(object.getString("name"));
            npc.setLat(object.getDouble("lat"));
            npc.setLng(object.getDouble("lng"));

            npcList.add(npc);
        }

        return npcList;
    }

}
