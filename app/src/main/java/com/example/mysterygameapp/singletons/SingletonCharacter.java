package com.example.mysterygameapp.singletons;

public class SingletonCharacter {

    private static int char_id;
    private static String char_name;
    private static String char_lastname;
    private static String profession;
    private static int age;

    public SingletonCharacter(){
        char_id = -1;
        char_name = "";
        char_lastname = "";
        profession = "";
        age = -1;
    }

    public SingletonCharacter(int id1, String name1, String lastname1, String profession1, int age1){
        char_id = id1;
        char_name = name1;
        char_lastname = lastname1;
        profession = profession1;
        age = age1;
    }

    public static int getCharId() { return char_id; }
    public static String getCharName() { return char_name; }
    public static String getCharLastname() { return char_lastname; }
    public static String getProfession() { return profession; }
    public static int getAge() { return age; }

    public static void setCharId(int id1) { char_id = id1; }
    public static void setCharName(String name1) { char_name = name1; }
    public static void setCharLastname(String lastname1) { char_lastname = lastname1; }
    public static void setProfession(String profession1) { profession = profession1; }
    public static void setAge(int age1) { age = age1; }

}
