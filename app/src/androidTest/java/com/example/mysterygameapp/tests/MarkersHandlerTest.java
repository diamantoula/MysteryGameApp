package com.example.mysterygameapp.tests;

import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.SmallTest;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.handlers.MarkersHandler;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class MarkersHandlerTest extends TestCase {

    private MarkersHandler markersHandler;

    @Override
    protected void setUp() throws Exception {
        markersHandler = new MarkersHandler();
        super.setUp();
    }

    @Before
    public void shouldNotBeNull () {
    }

    @Test
    public void test (){
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
