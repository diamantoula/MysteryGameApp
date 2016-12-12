package com.example.mysterygameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    TextView tvUsername;
    TextView tvPassword;
    TextView tvEmail;
    TextView tvCharacter;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvUsername = (TextView) findViewById(R.id.profileUsername);
        tvPassword = (TextView) findViewById(R.id.profilePassword);
        tvEmail = (TextView) findViewById(R.id.profileEmail);
        tvCharacter = (TextView) findViewById(R.id.profileCharacter);

        tvUsername.setText("kaori");
        tvPassword.setText("kaori");
        tvEmail.setText("kaori");
        tvCharacter.setText("kaori");
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
            case R.id.action_back:

                return true;
            case R.id.action_dropdown:

                return true;
            case R.id.action_profile:
                startActivity(new Intent(UserProfile.this, UserProfile.class));
                return true;
            case R.id.action_settings:

                return true;
            case R.id.action_save:

                return true;
            case R.id.action_logout:
                startActivity(new Intent(UserProfile.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
