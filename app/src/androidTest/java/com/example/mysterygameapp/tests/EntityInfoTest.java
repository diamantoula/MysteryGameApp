package com.example.mysterygameapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.functions.EntityInfo;
import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.singletons.SingletonData;

import junit.framework.TestCase;

import org.junit.Before;

import java.util.ArrayList;

public class EntityInfoTest extends TestCase {

    private SingletonData data;
    private ArrayList<Object> objs;
    private ArrayList<NPC> npcs;
    private ArrayList<Bonus> bonus;

    private static final String OBJECT= "object";
    private static final String NPC = "npc";
    private static final String BONUS = "bonus";
    private static final String OTHER = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        data = new SingletonData();
        objs = data.getObjects();
        npcs = data.getNPCs();
        bonus = data.getBonuses();
    }

    @SmallTest
    public void testShouldNotBeNull () {
        assertNotNull(objs);
        assertNotNull(npcs);
        assertNotNull(bonus);
    }

    @SmallTest
    public void testFindEntityID () {

        int expected;
        int result;
        int id = 3;

        //FOR OBJECT -> (3, receipt)
        expected = objs.get(id).getObjId();
        result = EntityInfo.findEntityID("receipt");
        assertEquals(expected, result);

        //FOR NPC -> (3, waiter)
        expected = npcs.get(id).getNPCId();
        result = EntityInfo.findEntityID("waiter");
        assertEquals(expected, result);

        //FOR BONUS -> (3, bonusD)
        expected = bonus.get(id).getId();
        result = EntityInfo.findEntityID("bonusD");
        assertEquals(expected, result);

        //FOR other -> default = 1
        expected = -1;
        result = EntityInfo.findEntityID("other");
        assertEquals(expected, result);

    }

    @SmallTest
    public void testFindEntityType () {

        String expected;
        String result;
        int id = 3;

        //FOR OBJECT -> (3, receipt)
        expected = OBJECT;
        result = EntityInfo.findEntityType("receipt");
        assertEquals(expected, result);

        //FOR NPC -> (3, waiter)
        expected = NPC;
        result = EntityInfo.findEntityType("waiter");
        assertEquals(expected, result);

        //FOR BONUS -> (3, bonusD)
        expected = BONUS;
        result = EntityInfo.findEntityType("bonusD");
        assertEquals(expected, result);

        //FOR other -> default = 1
        expected = null;
        result = EntityInfo.findEntityType("other");
        assertEquals(expected, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
