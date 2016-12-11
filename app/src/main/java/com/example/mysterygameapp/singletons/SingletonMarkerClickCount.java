package com.example.mysterygameapp.singletons;

import java.util.ArrayList;
import java.util.Arrays;

public class SingletonMarkerClickCount {

    private ArrayList<Integer> array;

    public SingletonMarkerClickCount(){
        array = new ArrayList<>(Arrays.asList(0,0,0,0,0));
    }

}
