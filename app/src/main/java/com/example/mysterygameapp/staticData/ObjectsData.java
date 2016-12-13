package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.Object;

import java.util.ArrayList;

public class ObjectsData {

    private static ArrayList<Object> objects = new ArrayList<>();

    public static void setObjects () {
        objects.add(new Object(0, "wallet", "no", 41.090779, 23.549385, "", "")); //2
        objects.add(new Object(1, "knife", "no", 41.087786, 23.550922, "", "")); //4
        objects.add(new Object(2, "parking ticket", "no", 41.087333, 23.547908, "", "")); //6
        objects.add(new Object(3, "receipt", "no", 41.085093, 23.546138, "", "")); //8
        objects.add(new Object(4, "car", "no", 41.082821, 23.545398, "", "")); //10
    }

    public static ArrayList<Object> getObjects () {
        return objects;
    }

    public static Object getObject (int pos) { return objects.get(pos); }

}
