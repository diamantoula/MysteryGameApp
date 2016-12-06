package com.example.mysterygameapp.modelsDB;

public class NPC {

    private int npc_id;
    private String npc_name;
    private double lat;
    private double lng;
    private String text1;
    private String text2;

    public NPC(){
        npc_id = -1;
        npc_name = "";
        lat = 0;
        lng = 0;
        text1 = "";
        text2 = "";
    }

    public NPC(int id1, String name1,  double lat1, double lng1, String txt1, String txt2){
        npc_id = id1;
        npc_name = name1;
        lat = lat1;
        lng = lng1;
        text1 = txt1;
        text2 = txt2;
    }


    public int getNPCId(){
        return npc_id;
    }
    public String getNPCName(){
        return npc_name;
    }
    public double getLat(){
        return lat;
    }
    public double getLng(){
        return lng;
    }
    public String getText1(){
        return text1;
    }
    public String getText2(){
        return text2;
    }


    public void setNPCId(int id1){ npc_id = id1; }
    public void setNPCName(String name1){ npc_name = name1; }
    public void setLat(double lat1){
        lat = lat1;
    }
    public void setLng(double lng1){
        lng = lng1;
    }
    public void setText1(String txt1){
        text1 = txt1;
    }
    public void setText2(String txt2){ text2 = txt2; }

}

