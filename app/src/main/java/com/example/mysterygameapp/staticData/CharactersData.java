package com.example.mysterygameapp.staticData;

import com.example.mysterygameapp.modelsDB.Character;

import java.util.ArrayList;

public class CharactersData {

    private static ArrayList<Character> characters = new ArrayList<>();

    public static void setCharacters () {
        characters.add(new Character(0, "Tony", "Mckenzie", "Private Investigator", 39));
        characters.add(new Character(1, "Bruce", "Wallace", "Police Detective", 42));
        characters.add(new Character(2, "Theresa", "Jones", "Reporter", 33));
        characters.add(new Character(3, "Marie", "Clarke", "Police Detective", 37));
    }

    public static ArrayList<Character> getCharacters () {
        return characters;
    }

    public static Character getCharacter (int pos) {
        return characters.get(pos);
    }

}
