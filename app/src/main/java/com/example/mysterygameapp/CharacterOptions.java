package com.example.mysterygameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class CharacterOptions extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Switch swChar1;
    Switch swChar2;
    Switch swChar3;

    String char1 = setCharacterProperties("Tony Mckenzie", "Private Investigator", 39, "");
    String char2 = setCharacterProperties("Bruce Wallace", "Police Detective", 42, "");
    String char3 = setCharacterProperties("Theresa Jones", "Reporter", 33, "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_options);

        Button submit = (Button) findViewById(R.id.characterSubmit);
        submit.setOnClickListener(this);

        swChar1 = (Switch) findViewById(R.id.swChar1);
        swChar2 = (Switch) findViewById(R.id.swChar2);
        swChar3 = (Switch) findViewById(R.id.swChar3);

        swChar1.setOnCheckedChangeListener(this);
        swChar2.setOnCheckedChangeListener(this);
        swChar3.setOnCheckedChangeListener(this);

        TextView tvChar1 = (TextView) findViewById(R.id.tvChar1);
        TextView tvChar2 = (TextView) findViewById(R.id.tvChar2);
        TextView tvChar3 = (TextView) findViewById(R.id.tvChar3);

        tvChar1.setText(char1);
        tvChar2.setText(char2);
        tvChar3.setText(char3);
    }

    public String setCharacterProperties(String name, String profession, int age, String info){
        String completeStr = "Name: " + name + "\n"
                + "Profession: " + profession + "\n"
                + "Age: " + age + "\n"
                + "Other Info: " + info;

        return completeStr;
    }

    @Override
    public void onCheckedChanged(CompoundButton button, boolean b) {

        if (button.isChecked()){

            switch (button.getId()){
                case R.id.swChar1:
                    swChar2.setChecked(false);
                    swChar3.setChecked(false);
                    break;

                case R.id.swChar2:
                    swChar1.setChecked(false);
                    swChar3.setChecked(false);
                    break;

                case R.id.swChar3:
                    swChar1.setChecked(false);
                    swChar2.setChecked(false);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(CharacterOptions.this, Login.class));

    }

}