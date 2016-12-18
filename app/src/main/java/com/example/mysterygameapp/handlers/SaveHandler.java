package com.example.mysterygameapp.handlers;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;
import com.example.mysterygameapp.singletons.SingletonData;

import static com.example.mysterygameapp.MapDemoActivity.MAP_DEMO_ACTIVITY;

public class SaveHandler extends AppCompatActivity implements View.OnClickListener {

    Button btnSave;
    Button btnCancel;
    Button btnReturn;

    private final static String FILENAME = "DataStoredFile";
    public final static String USER_COUNT = "count";
    public final static String USER_BONUS = "bonus";
    public final static String TARGET_INTENT = "bonus";

    private int uCount;
    private int uBonus;
    private String targetActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_handler);

        uCount = SingletonData.getUser().getCount();
        uBonus = SingletonData.getUser().getBonus();

        btnSave = (Button) findViewById(R.id.btnSave);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSave:

                SharedPreferences save = getSharedPreferences(FILENAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = save.edit();
                editor.putInt(USER_COUNT, uCount);
                editor.putInt(USER_BONUS, uBonus);
                editor.apply();

                Toast.makeText(getApplicationContext(), "GAME SAVED SUCCESSFULLY !", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btnCancel:
            case R.id.btnReturn:
                startActivity(new Intent(SaveHandler.this, MapDemoActivity.class));
                break;

            default:
                break;
        }

    }

}
