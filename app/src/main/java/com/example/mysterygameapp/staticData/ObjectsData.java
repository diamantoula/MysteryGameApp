package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.Object;

import java.util.ArrayList;

public class ObjectsData {

    private static ArrayList<Object> objects = new ArrayList<>();

    public static void setObjects () {
        objects.add(new Object(0, "wallet", "no", 41.090824, 23.54957, "", "")); //2
        objects.add(new Object(1, "knife", "no", 41.090751, 23.54928, "", "")); //3
        objects.add(new Object(2, "parking ticket", "no", 41.090127, 23.548624, "", "")); //5
        objects.add(new Object(3, "receipt", "no", 41.088202, 23.546993, "", "")); //7
        objects.add(new Object(4, "car", "no", 41.085054, 23.545593, "", "")); //9
    }

    public static ArrayList<Object> getObjects () {
        return objects;
    }

    public static Object getObject (int pos) {
        return objects.get(pos);
    }

}
