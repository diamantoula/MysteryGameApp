package com.example.mysterygameapp.loginregister;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mysterygameapp.CharacterOptions;
import com.example.mysterygameapp.MainActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.StartOptions;
import com.example.mysterygameapp.modelsDB.User;
import com.example.mysterygameapp.singletons.SingletonData;
import com.example.mysterygameapp.singletons.SingletonUser;
import com.example.mysterygameapp.staticData.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements View.OnClickListener{

    EditText etUsername;
    EditText etPassword;
    Button loginBtn;

    private String username;
    private String password;

    private static User user;

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

        /*if ( username.equals(user.getUsername()) && password.equals(user.getPassword()) ) {
            //initialize all data
            SingletonData data = new SingletonData();
            startActivity(new Intent(Login.this, StartOptions.class));
        } else {
            Toast.makeText(this, "Incorrect Username or Password.\nTry again", Toast.LENGTH_SHORT).show();
            etUsername.setText("");
            etPassword.setText("");
        }*/

        SingletonData data = new SingletonData();
        startActivity(new Intent(Login.this, StartOptions.class));

        /*Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jsonResponse = null;

                try {
                    jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        String mail = jsonResponse.getString("mail");

                        SingletonUser singletonUser = new SingletonUser(
                                jsonResponse.getString("username"),
                                jsonResponse.getString("password"),
                                jsonResponse.getInt("count"),
                                jsonResponse.getInt("char_id") );

                        startActivity(new Intent(Login.this, StartOptions.class));

                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Login.this);
        queue.add(loginRequest); */

    }

}
