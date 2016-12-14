package com.example.mysterygameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mysterygameapp.singletons.SingletonData;

public class StartOptions extends AppCompatActivity implements View.OnClickListener{

    public static final String FILENAME = "SavedGameFile";
    public static final String USER_COUNT = "userCount";
    public static final String USER_BONUS = "userBonus";

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_options);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button resumeBtn = (Button) findViewById(R.id.resumeBtn);

        startBtn.setOnClickListener(this);
        resumeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startBtn:
                startActivity(new Intent(StartOptions.this, Prologue.class));
                break;

            case R.id.resumeBtn:
                startActivity(new Intent(StartOptions.this, MapDemoActivity.class));
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch ( item.getItemId() ) {

            case R.id.action_profile:
                startActivity(new Intent(StartOptions.this, UserProfile.class));
                break;

            case R.id.action_logout:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
