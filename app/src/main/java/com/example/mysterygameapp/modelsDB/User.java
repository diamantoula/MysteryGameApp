package com.example.mysterygameapp.modelsDB;

public class User {

    private int user_id;
    private String username;
    private String password;
    private String mail;
    private int count;
    private int bonus;
    private int char_id;

    public User(){
        user_id = -1;
        username = "";
        password = "";
        mail = "";
        count = 0;
        bonus = 0;
        char_id = -1;
    }

    public User(int id1, String username1, String password1, String mail1, int count1, int bonus1, int charId1){
        user_id = id1;
        username = username1;
        password = password1;
        mail = mail1;
        count = count1;
        bonus = bonus1;
        char_id = charId1;
    }

    public int getUserId() { return user_id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getMail() { return mail; }
    public int getCount() { return count; }
    public int getBonus() { return bonus; }
    public int getCharId() { return char_id; }

    public void setUserId(int id1) { user_id = id1; }
    public void setUsername(String username1) { username = username1; }
    public void setPassword(String password1) { password = password1; }
    public void setMail(String mail1) { mail = mail1; }
    public void setCount(int count1) { count = count1; }
    public void setBonus(int bonus1) { bonus = bonus1; }
    public void setCharId(int charId1) { char_id = charId1; }

}
