package com.example.mysterygameapp.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mysterygameapp.R;
import com.example.mysterygameapp.StartOptions;
import com.example.mysterygameapp.modelsDB.Bonus;
import com.example.mysterygameapp.modelsDB.Character;
import com.example.mysterygameapp.modelsDB.NPC;
import com.example.mysterygameapp.modelsDB.Object;
import com.example.mysterygameapp.modelsDB.User;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.staticData.UserData;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername;
    EditText etPassword;
    Button loginBtn;

    private String username;
    private String password;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = UserData.getUser();

        etUsername = (EditText) findViewById(R.id.loginUsername);
        etPassword = (EditText) findViewById(R.id.loginPassword);

        loginBtn = (Button) findViewById(R.id.loginSubmit);
        loginBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        /*if ( username.equals(staticUser.getUsername()) && password.equals(staticUser.getPassword()) ) {
            //initialize all staticData
            SingletonData staticData = new SingletonData();
            startActivity(new Intent(Login.this, StartOptions.class));
        } else {
            Toast.makeText(this, "Incorrect Username or Password.\nTry again", Toast.LENGTH_SHORT).show();
            etUsername.setText("");
            etPassword.setText("");
        }*/

        new SingletonData();
        startActivity(new Intent(Login.this, StartOptions.class));

    }

}
