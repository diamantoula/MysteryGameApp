package com.example.mysterygameapp.modelsDB;

public class Bonus {

    private int id;
    private String name;
    private int bonus;
    private String taken;
    private double lat;
    private double lng;

    public Bonus () {
        id = -1;
        name = "";
        bonus = 0;
        taken = "no";
        lat = 0;
        lng = 0;
    }

    public Bonus (int id1, String name1, int bonus1, String taken1, double lat1, double lng1) {
        id = id1;
        name = name1;
        bonus = bonus1;
        taken = taken1;
        lat = lat1;
        lng = lng1;
    }

    public int getId () { return id; }
    public String getName () { return name; }
    public int getBonus () { return bonus; }
    public String getTaken () { return taken; }
    public double getLat () { return lat; }
    public double getLng () { return lng; }

    public void setId (int id1) { id = id1; }
    public void setName (String name1) { name = name1; }
    public void setBonus (int bonus1){
        bonus = bonus1;
    }
    public void setTaken (String taken1) { taken = taken1; }
    public void setLat (double lat1) { lat = lat1; }
    public void setLng (double lng1) { lng = lng1; }

}
