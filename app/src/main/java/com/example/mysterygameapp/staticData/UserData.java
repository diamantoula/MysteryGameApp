package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.User;

public class UserData {

    private int user_id = 3;
    private String username = "k";
    private String password = "12345";
    private String mail = "k@mail.com";
    private int count = 0;
    private int char_id = 2;

    public int getUserId() { return user_id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getMail() { return mail; }
    public int getCount() { return count; }
    public int getCharId() { return char_id; }

    public User getUser () {
        User user = new User(user_id, username, password, mail, count, char_id);
        return user;
    }

}
