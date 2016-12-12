package com.example.mysterygameapp.singletons;

import com.example.mysterygameapp.UserProfile;
import com.example.mysterygameapp.modelsDB.User;
import com.example.mysterygameapp.staticData.UserData;

public class SingletonUser {

    private static int user_id;
    private static String username;
    private static String password;
    private static String mail;
    private static int count;
    private static int char_id;

    public SingletonUser (){
        user_id = UserData.getUserId();
        username = UserData.getUsername();
        password = UserData.getPassword();
        mail = UserData.getMail();
        count = UserData.getCount();
        char_id = UserData.getCharId();
    }

    /*public SingletonUser(){
        user_id = -1;
        username = "";
        password = "";
        mail = "";
        count = 0;
        char_id = -1;
    }*/

    public SingletonUser(int id1, String username1, String password1, String mail1, int count1, int charId1){
        user_id = id1;
        username = username1;
        password = password1;
        mail = mail1;
        count = count1;
        char_id = charId1;
    }

    public static int getUserId() { return user_id; }
    public static String getUsername() { return username; }
    public static String getPassword() { return password; }
    public static String getMail() { return mail; }
    public static int getCount() { return count; }
    public static int getCharId() { return char_id; }

    public static void setUserId(int id1) { user_id = id1; }
    public static void setUsername(String username1) { username = username1; }
    public static void setPassword(String password1) { password = password1; }
    public static void setMail(String mail1) { mail = mail1; }
    public static void setCount(int count1) { count = count1; }
    public static void setCharId(int charId1) { char_id = charId1; }

}
