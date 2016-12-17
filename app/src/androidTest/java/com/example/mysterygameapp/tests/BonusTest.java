package com.example.mysterygameapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.modelsDB.Bonus;

import junit.framework.TestCase;

public class BonusTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //GETTERS
    @SmallTest
    public void testGetId () {

        Bonus bonus = new Bonus(1, "", 0, "", 0, 0);
        int result = bonus.getId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testGetName () {

        Bonus bonus = new Bonus(0, "bonus1", 0, "", 0, 0);
        String result = bonus.getName();
        assertEquals("bonus1", result);
    }

    @SmallTest
    public void testGetBonus () {

        Bonus bonus = new Bonus(0, "", 15, "", 0, 0);
        int result = bonus.getBonus();
        assertEquals(15, result);
    }

    @SmallTest
    public void testGetTaken () {

        Bonus bonus = new Bonus(0, "", 0, "no", 0, 0);
        String result = bonus.getTaken();
        assertEquals("no", result);
    }

    @SmallTest
    public void testGetLat () {

        Bonus bonus = new Bonus(0, "", 0, "", 7.5555555, 0);
        double result = bonus.getLat();
        assertEquals(7.5555555, result);
    }

    @SmallTest
    public void testGetLng () {

        Bonus bonus = new Bonus(0, "", 0, "", 0, 9.3333333);
        double result = bonus.getLng();
        assertEquals(9.3333333, result);
    }

    //SETTERS
    @SmallTest
    public void testSetId () {

        Bonus bonus = new Bonus();
        bonus.setId(1);
        int result = bonus.getId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testSetName () {

        Bonus bonus = new Bonus();
        bonus.setName("bonus1");
        String result = bonus.getName();
        assertEquals("bonus1", result);
    }

    @SmallTest
    public void testSetBonus (){

        Bonus bonus = new Bonus();
        bonus.setBonus(15);
        int result = bonus.getBonus();
        assertEquals(15, result);
    }

    @SmallTest
    public void testSetTaken () {

        Bonus bonus = new Bonus();
        bonus.setTaken("no");
        String result = bonus.getTaken();
        assertEquals("no", result);
    }

    @SmallTest
    public void testSetLat () {

        Bonus bonus = new Bonus();
        bonus.setLat(7.5555555);
        double result = bonus.getLat();
        assertEquals(7.5555555, result);
    }

    @SmallTest
    public void testSetLng () {

        Bonus bonus = new Bonus();
        bonus.setLng(9.3333333);
        double result = bonus.getLng();
        assertEquals(9.3333333, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
