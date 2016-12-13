package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.User;

public class UserData {

    private static int user_id;
    private static String username;
    private static String password;
    private static String mail;
    private static int count;
    private static int bonus;
    private static int char_id;

    public static void setUser () {
        user_id = 3;
        username = "k";
        password = "12345";
        mail = "k@mail.com";
        count = 0;
        bonus = 0;
        char_id = 1;
    }

    public static User getUser () {
        User user = new User(user_id, username, password, mail, count, bonus, char_id);
        return user;
    }

    public static void setUserId(int id1) { user_id = id1; }
    public static void setUsername(String username1) { username = username1; }
    public static void setPassword(String password1) { password = password1; }
    public static void setMail(String mail1) { mail = mail1; }
    public static void setCount(int count1) { count = count1; }
    public static void setBonus (int bonus1) { bonus = bonus1; }
    public static void setCharId(int charId1) { char_id = charId1; }

    public static int getUserId() { return user_id; }
    public static String getUsername() { return username; }
    public static String getPassword() { return password; }
    public static String getMail() { return mail; }
    public static int getCount() { return count; }
    public static int getBonus() { return bonus; }
    public static int getCharId() { return char_id; }

}
