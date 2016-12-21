package com.example.mysterygameapp.tests;

import android.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;
import android.widget.TextView;

import com.example.mysterygameapp.R;
import com.example.mysterygameapp.handlers.InteractionHandler;

import org.junit.Test;

public class InteractionHandlerTest extends ActivityInstrumentationTestCase2<InteractionHandler>{

    private InteractionHandler activity;

    public InteractionHandlerTest() {
        super(InteractionHandler.class);
    }

    @Override
    protected void setUp () throws Exception {
        super.setUp();
        activity = new InteractionHandler();
    }

    @Test
    public void test1 () {


        assertNotNull(activity);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
