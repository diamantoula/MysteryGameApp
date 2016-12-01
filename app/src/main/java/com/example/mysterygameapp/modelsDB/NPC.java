package com.example.mysterygameapp.modelsDB;

public class NPC {

    private int id;
    private String name;
    private double lat;
    private double lng;

    public NPC(){
        id = -1;
        name = null;
        lat = 0;
        lng = 0;
    }

    public NPC(int id1, String name1, double lat1, double lng1){
        id = id1;
        name = name1;
        lat = lat1;
        lng = lng1;
    }


    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getLat(){
        return lat;
    }
    public double getLng(){
        return lng;
    }


    public void setId(int id1){
        id = id1;
    }
    public void setName(String name1){
        name = name1;
    }
    public void setLat(double lat1){
        lat = lat1;
    }
    public void setLng(double lng1){
        lng = lng1;
    }
}

