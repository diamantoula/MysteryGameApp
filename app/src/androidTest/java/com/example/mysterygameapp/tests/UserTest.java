package com.example.mysterygameapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.modelsDB.User;

import junit.framework.TestCase;

public class UserTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //GETTERS
    @SmallTest
    public void testGetUserId () {

        User user = new User(1, "", "", "", 0, 0, 0);
        int result = user.getUserId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testGetUsername () {

        User user = new User(0, "micky", "", "", 0, 0, 0);
        String result = user.getUsername();
        assertEquals("micky", result);
    }

    @SmallTest
    public void testGetPassword () {

        User user = new User(0, "", "12345", "", 0, 0, 0);
        String result = user.getPassword();
        assertEquals("12345", result);
    }

    @SmallTest
    public void testGetMail () {

        User user = new User(0, "", "", "e@mail.com", 0, 0, 0);
        String result = user.getMail();
        assertEquals("e@mail.com", result);
    }

    @SmallTest
    public void testGetCount () {

        User user = new User(0, "", "", "", 8, 0, 0);
        int result = user.getCount();
        assertEquals(8, result);
    }

    @SmallTest
    public void testGetBonus () {

        User user = new User(0, "", "", "", 0, 35, 0);
        int result = user.getBonus();
        assertEquals(35, result);
    }

    @SmallTest
    public void testGetCharId () {

        User user = new User(0, "", "", "", 0, 0, 3);
        int result = user.getCharId();
        assertEquals(3, result);
    }

    //SETTERS
    @SmallTest
    public void testSetUserId () {

        User user = new User();
        user.setUserId(1);
        int result = user.getUserId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testSetUsername () {

        User user = new User();
        user.setUsername("micky");
        String result = user.getUsername();
        assertEquals("micky", result);
    }

    @SmallTest
    public void testSetPassword() {

        User user = new User();
        user.setPassword("12345");
        String result = user.getPassword();
        assertEquals("12345", result);
    }

    @SmallTest
    public void testSetMail () {

        User user = new User();
        user.setMail("e@mail.com");
        String result = user.getMail();
        assertEquals("e@mail.com", result);
    }

    @SmallTest
    public void testSetCount () {

        User user = new User();
        user.setCount(8);
        int result = user.getCount();
        assertEquals(8, result);
    }

    @SmallTest
    public void testSetBonus () {

        User user = new User();
        user.setBonus(35);
        int result = user.getBonus();
        assertEquals(35, result);
    }

    @SmallTest
    public void testSetCharId () {

        User user = new User();
        user.setCharId(3);
        int result = user.getCharId();
        assertEquals(3, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}

