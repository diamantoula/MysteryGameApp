package com.example.mysterygameapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.ParcelUuid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mysterygameapp.handlers.MarkersHandler;
import com.google.android.gms.maps.model.Marker;

public class Interaction extends AppCompatActivity implements View.OnClickListener {

    //INTERACTION LAYOUT
    RelativeLayout interactionLayout;
    TextView tvGreeting;
    Button bShowClue1;
    Button bShowClue2;
    Button bReturn;

    //POPUP WINDOW
    PopupWindow popupWindow;
    LayoutInflater layoutInflater;
    ViewGroup container;

    TextView tvClue;
    Button bOkWindow;

    //RETRIEVE INFO FROM INTENT
    int mId;
    String mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction);

        //INTERACTION LAYOUT
        interactionLayout = (RelativeLayout) findViewById(R.id.activity_interaction);
        tvGreeting = (TextView) findViewById(R.id.tvInteractionGreeting);
        bShowClue1 = (Button) findViewById(R.id.bShowClue1);
        bShowClue2 = (Button) findViewById(R.id.bShowClue2);
        bReturn = (Button) findViewById(R.id.bInteractionReturn);

        //POPUP WINDOW
        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        container = (ViewGroup) layoutInflater.inflate(R.layout.window_interaction, null);

        tvClue = (TextView) container.findViewById(R.id.tvClue);
        bOkWindow = (Button) container.findViewById(R.id.bOkWindow);

        //BUTTON LISTENERS
        bShowClue1.setOnClickListener(this);
        bShowClue2.setOnClickListener(this);
        bReturn.setOnClickListener(this);
        bOkWindow.setOnClickListener(this);

        //retrieve info from intent
        mId = getIntent().getIntExtra("markerId", 0);
        mType = getIntent().getStringExtra("markerType");

        setTvGreeting(mType);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bShowClue1:
                setTvClue(mId, mType, 1);

                popupWindow = new PopupWindow(container, 400, 600, true);
                popupWindow.showAtLocation(interactionLayout, Gravity.CENTER, 0, 0);
                break;

            case R.id.bShowClue2:
                setTvClue(mId, mType, 2);

                popupWindow = new PopupWindow(container, 400, 600, true);
                popupWindow.showAtLocation(interactionLayout, Gravity.CENTER, 0, 0);
                break;

            case R.id.bOkWindow:
                popupWindow.dismiss();
                break;

            case R.id.bInteractionReturn:
                startActivity(new Intent(Interaction.this, MapDemoActivity.class));
                break;

            default:
                break;
        }

    }

//================================================================================================//
    //SETTING TEXTVIEWS

    public void setTvGreeting (String markerType) {
        String message;

        switch (markerType) {
            case "object":
                message = getResources().getString(R.string.objectGreeting);
                break;
            case "npc":
                message = getResources().getString(R.string.npcGreeting);
                break;
            case "bonus":
                message = getResources().getString(R.string.bonusGreeting);
                break;
            default:
                message = "Hello...";
                break;
        }
        tvGreeting.setText(message);
    }

    public void setTvClue (int id, String markerType, int clueNumber) {
        String message;

        switch (markerType) {
            case "object":
                message = getObjectMessage(id, clueNumber);
                break;

            case "npc":
                message = getNPCMessage(id, clueNumber);
                break;

            case "bonus":
                message = getBonusMessage();
                break;

            default:
                message = "No clue found...";
                break;
        }
        tvClue.setText(message);
    }

//================================================================================================//
    //RETRIEVING STRING CLUES FROM XML

    //RETRIEVE OBJECT MESSAGE FROM XML
    public String getObjectMessage (int id, int clueNumber) {
        String message = "";

        switch (clueNumber) {
            case 1:
                String[] clueArray = getResources().getStringArray(R.array.objects_clues);
                message = clueArray[id];
                break;

            case 2:
                break;

            default:
                break;
        }

        return message;
    }

    //RETRIEVE NPC MESSAGE FROM XML
    public String getNPCMessage (int id, int clueNumber) {
        String message = "";

        switch (clueNumber) {
            case 1:
                String[] clueArray = getResources().getStringArray(R.array.npcs_clues);
                message = clueArray[id];
                break;

            case 2:
                break;

            default:
                break;
        }

        return message;
    }

    //RETRIEVE BONUS MESSAGE FROM XML
    public String getBonusMessage () {

        String message = getResources().getString(R.string.bonusTaken);
        return message;
    }

//================================================================================================//
    //INTERACTION ACTIONS

    public void interactionGreeting (Marker clickedMarker, int markerId, String markerType, Resources res) {

        MarkersHandler markersHandler = new MarkersHandler();
        markersHandler.startInteraction(clickedMarker, markerId, markerType);
        //clickedMarker.setSnippet( markersHandler.getSnippetMessage(clickedMarker, res, "tvGreeting") );
    }

    public void interactionClue1 (Marker clickedMarker, int markerId, String markerType, Resources res) {

        MarkersHandler markersHandler = new MarkersHandler();
        markersHandler.interactionMode(clickedMarker, markerId, markerType);
        //clickedMarker.setSnippet( markersHandler.getSnippetMessage(clickedMarker, res, "main") );
    }

    public void interactionClue2 (Marker clickedMarker, int markerId, String markerType, Resources res) {

    }

    public void interactionBack (Marker clickedMarker, Marker userMarker, int markerId, String markerType, Resources res) {

        MarkersHandler markersHandler = new MarkersHandler();
        markersHandler.terminateInteraction(userMarker, markerId, markerType);
        //clickedMarker.setSnippet( markersHandler.getSnippetMessage(clickedMarker, res, "back") );
    }

}

