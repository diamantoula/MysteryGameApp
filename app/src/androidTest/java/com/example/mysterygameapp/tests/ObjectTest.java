package com.example.mysterygameapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.modelsDB.Object;

import junit.framework.TestCase;

public class ObjectTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //GETTERS
    @SmallTest
    public void testGetObjId(){

        Object object = new Object(1, "", "", 0, 0, "", "");
        int result = object.getObjId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testGetObjName(){

        Object object = new Object(0, "John", "", 0, 0, "", "");
        String result = object.getObjName();
        assertEquals("John", result);
    }

    @SmallTest
    public void testGetUsed(){

        Object object = new Object(0, "", "no", 0, 0, "", "");
        String result = object.getUsed();
        assertEquals("no", result);
    }

    @SmallTest
    public void testGetLat(){

        Object object = new Object(0, "", "", 7.5555555, 0, "", "");
        double result = object.getLat();
        assertEquals(7.5555555, result);
    }

    @SmallTest
    public void testGetLng(){

        Object object = new Object(0, "", "", 0, 9.3333333, "", "");
        double result = object.getLng();
        assertEquals(9.3333333, result);
    }

    @SmallTest
    public void testGetText1(){

        Object object = new Object(0, "", "", 0, 0, "this is text1", "");
        String result = object.getText1();
        assertEquals("this is text1", result);
    }

    @SmallTest
    public void testGetText2(){

        Object object = new Object(0, "", "", 0, 0, "", "this is text2");
        String result = object.getText2();
        assertEquals("this is text2", result);
    }

    //SETTERS
    @SmallTest
    public void testSetObjId(){

        Object object = new Object();
        object.setObjId(1);
        int result = object.getObjId();
        assertEquals(1, result);
    }

    @SmallTest
    public void testSetObjName(){

        Object object = new Object();
        object.setObjName("John");
        String result = object.getObjName();
        assertEquals("John", result);
    }

    @SmallTest
    public void testSetUsed(){

        Object object = new Object();
        object.setUsed("no");
        String result = object.getUsed();
        assertEquals("no", result);
    }

    @SmallTest
    public void testSetLat(){

        Object object = new Object();
        object.setLat(0.6666666);
        double result = object.getLat();
        assertEquals(0.6666666, result);
    }

    @SmallTest
    public void testSetLng(){

        Object object = new Object();
        object.setLng(2.6666666);
        double result = object.getLng();
        assertEquals(2.6666666, result);
    }

    @SmallTest
    public void testSetText1(){

        Object object = new Object();
        object.setText1("this is text1");
        String result = object.getText1();
        assertEquals("this is text1", result);
    }

    @SmallTest
    public void testSetText2(){

        Object object = new Object();
        object.setText2("this is text2");
        String result = object.getText2();
        assertEquals("this is text2", result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
