package com.example.mysterygameapp.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysterygameapp.R;
import com.example.mysterygameapp.singletons.SingletonData;

public class Sample extends AppCompatActivity implements View.OnClickListener {

    EditText et1;
    TextView tv1;

    Button save;
    Button clear;
    Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        int userBonus = getIntent().getIntExtra("userBonus", 0);
        int userCount = getIntent().getIntExtra("userCount", 0);

        //int userBonus = SingletonData.getUser().getBonus();
        //int userCount = SingletonData.getUser().getCount();

        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
        save = (Button) findViewById(R.id.save);
        clear = (Button) findViewById(R.id.clear);
        load = (Button) findViewById(R.id.load);

        save.setOnClickListener(this);
        clear.setOnClickListener(this);
        load.setOnClickListener(this);

        tv1.setText(userBonus + " " + userCount);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.save:

                SharedPreferences save = getSharedPreferences("myfile",MODE_PRIVATE);
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("bonus", SingletonData.getUser().getBonus());
                editor.apply();

                Toast.makeText(getApplicationContext(), "saved",Toast.LENGTH_SHORT).show();
                break;
            case R.id.clear:

                tv1.setText("");
                et1.setText("");

                Toast.makeText(getApplicationContext(), "clear",Toast.LENGTH_SHORT).show();
                break;
            case R.id.load:

                SharedPreferences load = getSharedPreferences("myfile", MODE_PRIVATE);
                int text = load.getInt("bonus", -10);
                tv1.setText(text);

                Toast.makeText(getApplicationContext(), "loaded",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
