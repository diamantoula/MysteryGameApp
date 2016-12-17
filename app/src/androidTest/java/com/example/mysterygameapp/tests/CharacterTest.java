package com.example.mysterygameapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.modelsDB.Character;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //GETTERS
    @SmallTest
    public void testGetCharId () {

        Character character = new Character(1, "", "", "", 0);
        int result = character.getCharId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testGetCharName () {

        Character character = new Character(0, "John", "", "", 0);
        String result = character.getCharName();
        assertEquals("John", result);
    }

    @SmallTest
    public void testGetCharLastname () {

        Character character = new Character(0, "", "Smith", "", 0);
        String result = character.getCharLastname();
        assertEquals("Smith", result);
    }

    @SmallTest
    public void testGetProfession () {

        Character character = new Character(0, "", "", "detective", 0);
        String result = character.getProfession();
        assertEquals("detective", result);
    }

    @SmallTest
    public void testGetAge () {

        Character character = new Character(0, "", "", "", 25);
        int result = character.getAge();
        assertEquals(25, result);
    }

    //SETTERS
    @SmallTest
    public void testSetCharId () {

        Character character = new Character();
        character.setCharId(1);
        int result = character.getCharId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testSetCharName () {

        Character character = new Character();
        character.setCharName("John");
        String result = character.getCharName();
        assertEquals("John", result);
    }

    @SmallTest
    public void testSetCharLastname () {

        Character character = new Character();
        character.setCharLastname("Smith");
        String result = character.getCharLastname();
        assertEquals("Smith", result);
    }

    @SmallTest
    public void testSetProfession () {

        Character character = new Character();
        character.setProfession("detective");
        String result = character.getProfession();
        assertEquals("detective", result);
    }

    @SmallTest
    public void testSetAge () {

        Character character = new Character();
        character.setAge(25);
        int result = character.getAge();
        assertEquals(25, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
