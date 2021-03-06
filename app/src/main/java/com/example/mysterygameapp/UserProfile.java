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

import com.example.mysterygameapp.handlers.CameraHandler;
import com.example.mysterygameapp.handlers.MarkersHandler;
import com.example.mysterygameapp.modelsDB.Character;
import com.example.mysterygameapp.modelsDB.User;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.staticData.CharactersData;
import com.example.mysterygameapp.staticData.UserData;

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
