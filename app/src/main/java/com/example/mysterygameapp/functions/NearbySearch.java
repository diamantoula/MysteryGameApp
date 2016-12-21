package com.example.mysterygameapp.functions;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class NearbySearch {

    //store user's location
    static LatLng userLocation = null;

    private static ArrayList<Location> objLocations = new ArrayList<>();
    private static ArrayList<Location> npcLocations = new ArrayList<>();

    private static int posObj = -1;
    private static int posNPC = -1;

    private static final float DEFAULT_DIST = 500;

    static Object foundEntity = null;

    //Constructor
    NearbySearch (LatLng user){
        this.userLocation = user;
    }

    //fetch the objects' locations from database
    private void fetchObjectsFromDB(){
        //// TODO: 11/14/16
        //store in objects ArrayList
    }

    //fetch the NPCs' location from database
    private void fetchNPCsFromDB(){
        //// TODO: 11/14/16
        //store in npcs ArrayList
    }

    //
    public static LatLng findEntity(){
        float distToObj;
        float distToNPC;

        //convert 'userLocation' from LatLng to Location
        Location currentLoc = null;
        currentLoc.setLatitude( userLocation.latitude );
        currentLoc.setLongitude( userLocation.longitude );

        //distance between user and object
        distToObj = getDistance(objLocations, currentLoc, "OBJECT");
        //distance between user and npc
        distToNPC = getDistance(npcLocations, currentLoc, "NPC");

        if ( (distToObj < distToNPC) && (distToObj != DEFAULT_DIST) ){
            //there is an object close to the user
            foundEntity = objLocations.get( posObj );
            return (LatLng) foundEntity;

        }else if ( (distToNPC < distToObj) && (distToNPC != DEFAULT_DIST) ){
            //there is an npc close to the user
            foundEntity = npcLocations.get( posNPC );
            return (LatLng) foundEntity;

        }else {
            //there is nothing close to the user
            return null;
        }

    }

    //return the distance between the user and the nearest entity
    // that is within a 10 meter radius from the user
    // if there is no entity within the radius return DEFAULT_DIST value
    private static float getDistance(ArrayList<Location> list, Location userLocation, String entity){
        //default value
        float distance = DEFAULT_DIST;
        float tempDist;

        //search if there is an entity within 10 meter radius from user's location
        for (int i=0; i<list.size(); i++){

            //distance between user and an entity
            tempDist = userLocation.distanceTo(list.get(i));

            //if there is an entity within the user's radius
            if( (tempDist < 10) && (tempDist < distance) ){

                //store minimum distance found
                distance = tempDist;

                //store entity position in ArrayList
                if (entity == "OBJECT"){
                    posObj = i;
                }else if (entity == "NPC"){
                    posNPC =i;
                }
            }

        }
        return distance;
    }


}