package com.example.mysterygameapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.modelsDB.NPC;

import junit.framework.TestCase;

public class NPCTest extends TestCase{

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }




    //GETTERS
    @SmallTest
    public void testGetNPCId(){

        NPC npc = new NPC(1, "", 0, 0, "", "");
        int result = npc.getNPCId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testGetNPCName(){

        NPC npc = new NPC(0, "John", 0, 0, "", "");
        String result = npc.getNPCName();
        assertEquals("John", result);
    }

    @SmallTest
    public void testGetLat(){

        NPC npc = new NPC(0, "", 7.5555555, 0, "", "");
        double result = npc.getLat();
        assertEquals(7.5555555, result);
    }

    @SmallTest
    public void testGetLng(){

        NPC npc = new NPC(0, "", 0, 9.3333333, "", "");
        double result = npc.getLng();
        assertEquals(9.3333333, result);
    }

    @SmallTest
    public void testGetText1(){

        NPC npc = new NPC(0, "", 0, 0, "this is text1", "");
        String result = npc.getText1();
        assertEquals("this is text1", result);
    }

    @SmallTest
    public void testGetText2(){

        NPC npc = new NPC(0, "", 0, 0, "", "this is text2");
        String result = npc.getText2();
        assertEquals("this is text2", result);
    }

    //SETTERS
    @SmallTest
    public void testSetNPCId(){

        NPC npc = new NPC();
        npc.setNPCId(1);
        int result = npc.getNPCId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testSetNPCName(){

        NPC npc = new NPC();
        npc.setNPCName("John");
        String result = npc.getNPCName();
        assertEquals("John", result);
    }

    @SmallTest
    public void testSetLat(){

        NPC npc = new NPC();
        npc.setLat(7.5555555);
        double result = npc.getLat();
        assertEquals(7.5555555, result);
    }

    @SmallTest
    public void testSetLng(){

        NPC npc = new NPC();
        npc.setLng(9.3333333);
        double result = npc.getLng();
        assertEquals(9.3333333, result);
    }

    @SmallTest
    public void testSetText1(){

        NPC npc = new NPC();
        npc.setText1("this is text1");
        String result = npc.getText1();
        assertEquals("this is text1", result);
    }

    @SmallTest
    public void testSetText2(){

        NPC npc = new NPC();
        npc.setText2("this is text2");
        String result = npc.getText2();
        assertEquals("this is text2", result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
