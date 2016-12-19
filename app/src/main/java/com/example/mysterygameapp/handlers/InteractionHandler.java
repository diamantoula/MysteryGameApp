package com.example.mysterygameapp.handlers;

import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.Toast;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.singletons.SingletonData;
import com.google.android.gms.maps.model.Marker;

public class InteractionHandler extends AppCompatActivity implements View.OnClickListener {

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

        //if user clicked on bonus -> increment user bonus
        if (mType.equals("bonus")) {
            int bonus = SingletonData.getUser().getBonus() + SingletonData.getBonuses().get(mId).getBonus();
            SingletonData.getUser().setBonus(bonus);
        }
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
                //if user clicked on bonus -> set user bonus
                if (!mType.equals("bonus")) {
                    //if user clicked on object or npc -> increment user count
                    SingletonData.incrementUserCount();
                }

                startActivity(new Intent(InteractionHandler.this, MapDemoActivity.class));
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
                //increment Counters and user Counter
                message = getObjectMessage(id, clueNumber);
                break;

            case "npc":
                //increment Counters and user Counter
                message = getNPCMessage(id, clueNumber);
                break;

            case "bonus":
                //increment Counters and user Counter
                //increment user Bonus
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

}

