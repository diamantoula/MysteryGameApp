package com.example.mysterygameapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysterygameapp.modelsDB.Character;
import com.example.mysterygameapp.modelsDB.User;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.staticData.CharactersData;
import com.example.mysterygameapp.staticData.UserData;

import static com.example.mysterygameapp.StartOptions.USER_BONUS;

public class UserProfile extends AppCompatActivity {

    TextView tvUsername;
    TextView tvPassword;
    TextView tvEmail;
    TextView tvBonus;
    TextView tvCharacter;

    ImageView ivCharImage;

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
        tvBonus = (TextView) findViewById(R.id.profileBonus);
        tvCharacter = (TextView) findViewById(R.id.profileCharacter);

        ivCharImage = (ImageView) findViewById(R.id.profileCharImage);

        tvUsername.setText(SingletonData.getUser().getUsername());
        tvPassword.setText(SingletonData.getUser().getPassword());
        tvEmail.setText(SingletonData.getUser().getMail());
        tvBonus.setText(String.valueOf(SingletonData.getUser().getBonus()));

        setCharacterName(SingletonData.getUser().getCharId());
        setCharacterImage(SingletonData.getUser().getCharId());
    }

    public void setCharacterName (int id) {
        String wholeName = CharactersData.getCharacter(id).getCharName() +
                        " " + CharactersData.getCharacter(id).getCharLastname();
        tvCharacter.setText(wholeName);
    }

    public void setCharacterImage (int id) {

        switch (id) {
            case 0:
                ivCharImage.setImageResource(R.drawable.char1);
                break;
            case 1:
                ivCharImage.setImageResource(R.drawable.char2);
                break;
            case 2:
                ivCharImage.setImageResource(R.drawable.char3);
                break;
            case 3:
                ivCharImage.setImageResource(R.drawable.char4);
                break;
            default:
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
            case R.id.action_back:

                break;
            case R.id.action_dropdown:

                break;
            case R.id.action_profile:
                startActivity(new Intent(UserProfile.this, UserProfile.class));
                break;

            case R.id.action_settings:

                break;
            case R.id.action_save:
                break;

            case R.id.action_logout:
                startActivity(new Intent(UserProfile.this, MainActivity.class));
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
