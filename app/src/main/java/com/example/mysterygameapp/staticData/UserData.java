package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.User;

public class UserData {

    private static int user_id = 3;
    private static String username = "k";
    private static String password = "12345";
    private static String mail = "k@mail.com";
    private static int count = 0;
    private static int bonus = 0;
    private static int char_id = 1;

    public static int getUserId() { return user_id; }
    public static String getUsername() { return username; }
    public static String getPassword() { return password; }
    public static String getMail() { return mail; }
    public static int getCount() { return count; }
    public static int getBonus() { return bonus; }
    public static int getCharId() { return char_id; }

    public static User getUser () {
        User user = new User(user_id, username, password, mail, count, bonus, char_id);
        return user;
    }

}
