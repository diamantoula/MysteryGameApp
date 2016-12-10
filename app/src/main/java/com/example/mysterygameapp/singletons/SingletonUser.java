package com.example.mysterygameapp.singletons;

public class SingletonUser {

    private String username;
    private String password;
    private int count;
    private int char_id;

    public SingletonUser(){
        username = "";
        password = "";
        count = 0;
        char_id = -1;
    }

    public SingletonUser(String username1, String password1, int count1, int charId1){
        username = username1;
        password = password1;
        count = count1;
        char_id = charId1;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public int getCount() { return count; }
    public int getCharId() { return char_id; }

    public void setUsername(String username1) { username = username1; }
    public void setPassword(String password1) { password = password1; }
    public void setCount(int count1) { count = count1; }
    public void setCharId(int charId1) { char_id = charId1; }

}
