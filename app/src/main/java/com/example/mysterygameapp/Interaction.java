package com.example.mysterygameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mysterygameapp.handlers.MarkersHandler;
import com.example.mysterygameapp.singletons.SingletonData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import static com.example.mysterygameapp.R.id.map;

public class Interaction extends AppCompatActivity implements View.OnClickListener {

    TextView greeting;
    Button bOpenWindowClue1;
    Button bOpenWindowClue2;
    Button bReturn;

    RelativeLayout interactionLayout;
    PopupWindow popupWindow;
    LayoutInflater layoutInflater;
    ViewGroup container;

    Button bOkWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        greeting = (TextView) findViewById(R.id.tvGreetingInteraction);

        bOpenWindowClue1 = (Button) findViewById(R.id.bOpenWindowClue1);
        bOpenWindowClue2 = (Button) findViewById(R.id.bOpenWindowClue2);
        bReturn = (Button) findViewById(R.id.bReturnFromInteraction);

        bOpenWindowClue1.setOnClickListener(this);
        bOpenWindowClue2.setOnClickListener(this);
        bReturn.setOnClickListener(this);

        interactionLayout = (RelativeLayout) findViewById(R.id.activity_interaction);
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        container = (ViewGroup) layoutInflater.inflate(R.layout.window_interaction, null);

        bOkWindow = (Button) container.findViewById(R.id.bOkWindow);
        bOkWindow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bOpenWindowClue1:
                popupWindow = new PopupWindow(container, 400, 600, true);
                popupWindow.showAtLocation(interactionLayout, Gravity.CENTER, 0, 0);
                break;

            case R.id.bOpenWindowClue2:
                popupWindow = new PopupWindow(container, 400, 600, true);
                popupWindow.showAtLocation(interactionLayout, Gravity.CENTER, 0, 0);
                break;

            case R.id.bOkWindow:
                popupWindow.dismiss();
                break;

            case R.id.bReturnFromInteraction:
                startActivity(new Intent(Interaction.this, MapDemoActivity.class));
                break;

            default:
                break;
        }

    }

//================================================================================================//
    //INTERACTION ACTIONS

    public void interactionGreeting (Marker clickedMarker, int id, String type) {

    }

    public void interactionClue1 (Marker clickedMarker, int id, String type) {

    }

    public void interactionClue2 (Marker clickedMarker, Marker userMarker, int id, String type) {

    }

    public void interactionBack (Marker clickedMarker, Marker userMarker, int id, String type) {

    }

}
