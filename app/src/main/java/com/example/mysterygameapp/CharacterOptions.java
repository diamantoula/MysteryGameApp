package com.example.mysterygameapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mysterygameapp.loginregister.Login;
import com.example.mysterygameapp.loginregister.LoginRequest;
import com.example.mysterygameapp.modelsDB.Character;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.singletons.SingletonUser;
import com.example.mysterygameapp.staticData.CharactersData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CharacterOptions extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Switch swChar1;
    Switch swChar2;
    Switch swChar3;
    Switch swChar4;

    TextView tvChar1;
    TextView tvChar2;
    TextView tvChar3;
    TextView tvChar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_options);

        Button submit = (Button) findViewById(R.id.characterSubmit);
        submit.setOnClickListener(this);

        swChar1 = (Switch) findViewById(R.id.swChar1);
        swChar2 = (Switch) findViewById(R.id.swChar2);
        swChar3 = (Switch) findViewById(R.id.swChar3);
        swChar4 = (Switch) findViewById(R.id.swChar4);

        swChar1.setOnCheckedChangeListener(this);
        swChar2.setOnCheckedChangeListener(this);
        swChar3.setOnCheckedChangeListener(this);
        swChar4.setOnCheckedChangeListener(this);

        tvChar1 = (TextView) findViewById(R.id.tvChar1);
        tvChar2 = (TextView) findViewById(R.id.tvChar2);
        tvChar3 = (TextView) findViewById(R.id.tvChar3);
        tvChar4 = (TextView) findViewById(R.id.tvChar4);

        String char1 = setCharacterString(SingletonData.getCharacters().get(0));
        String char2 = setCharacterString(SingletonData.getCharacters().get(1));
        String char3 = setCharacterString(SingletonData.getCharacters().get(2));
        String char4 = setCharacterString(SingletonData.getCharacters().get(3));

        tvChar1.setText(char1);
        tvChar2.setText(char2);
        tvChar3.setText(char3);
        tvChar4.setText(char4);
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean b) {

        if (button.isChecked()){

            switch (button.getId()){
                case R.id.swChar1:
                    swChar2.setChecked(false);
                    swChar3.setChecked(false);
                    swChar4.setChecked(false);
                    //SingletonUser.setCharId(1);
                    break;

                case R.id.swChar2:
                    swChar1.setChecked(false);
                    swChar3.setChecked(false);
                    swChar4.setChecked(false);
                    //SingletonUser.setCharId(2);
                    break;

                case R.id.swChar3:
                    swChar1.setChecked(false);
                    swChar2.setChecked(false);
                    swChar4.setChecked(false);
                    //SingletonUser.setCharId(3);
                    break;

                case R.id.swChar4:
                    swChar1.setChecked(false);
                    swChar2.setChecked(false);
                    swChar3.setChecked(false);
                    //SingletonUser.setCharId(4);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(CharacterOptions.this, Login.class));

    }

    public String setCharacterString(Character character){
        String completeStr = "Name: " + character.getCharName() + " " + character.getCharLastname() + "\n"
                + "Profession: " + character.getProfession() + "\n"
                + "Age: " + character.getAge() ;

        return completeStr;
    }

}