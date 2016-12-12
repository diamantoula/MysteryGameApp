package com.example.mysterygameapp.staticData;

import java.util.ArrayList;

public class CountersData {

    private static ArrayList<Integer> objCounters = new ArrayList<>();
    private static ArrayList<Integer> npcCounters = new ArrayList<>();

    public static void setCounters () {
        for (int i=0; i<10; i++) { objCounters.add(0); }
        for (int i=0; i<10; i++) { npcCounters.add(0); }
    }

    public static ArrayList<Integer> getCounters (String type) {

        if (type.equals("object")) {
            return objCounters;
        } else {
            return npcCounters;
        }
    }

    public static void setCounter (String type, int pos, int value) {

        if (type.equals("object")) {
            objCounters.set(pos, value);
        } else {
            npcCounters.set(pos, value);
        }
    }

    public static int getCounter (String type, int pos) {

        if (type.equals("object")) {
            return objCounters.get(pos);
        } else {
            return npcCounters.get(pos);
        }
    }

    public static void incrementCounter (String type, int pos) {

        if (type.equals("object")) {
            int count = getCounter(type, pos);
            count++;
            objCounters.set(pos, count);
        } else {
            int count = getCounter(type, pos);
            count++;
            npcCounters.set(pos, count);
        }
    }

    public static void decrementObjCounter (String type, int pos) {

        if (type.equals("object")) {
            int count = getCounter(type, pos);
            count--;
            objCounters.set(pos, count);
        } else {
            int count = getCounter(type, pos);
            count--;
            npcCounters.set(pos, count);
        }
    }

}
