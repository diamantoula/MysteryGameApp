package com.example.mysterygameapp.startupActions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mysterygameapp.MapDemoActivity;
import com.example.mysterygameapp.R;

public class Prologue extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prologue);

        String text = "Hello Detective. There was a call made to your office about an hour ago from a woman, " +
                "claiming her daughter has gone missing. \nShe says her daughter had been acting strange lately, " +
                "as if she was afraid of something. She would lock herself in her house, wouldn't go outside " +
                "unless it was necessary. She would always hurry and constantly look behind her shoulder. \nThe " +
                "mother said when she finally confronted her daughter about her paranoid behaviour they ended up " +
                "fighting and the girl stormed out of the house. That was the last time she saw her and that was " +
                "two days ago. \nShe didn't call the police because she is afraid her daughter might be mixed in " +
                "something illegal, so she decided to call your office for help. \nThe last place she was seen was " +
                "in front of the coffee shop 'NAME'. ";

        TextView tvPrologue = (TextView) findViewById(R.id.tvPrologue);
        Button continueBtn = (Button) findViewById(R.id.prologueContinue);

        continueBtn.setOnClickListener(this);

        tvPrologue.setText(text);
    }

    @Override
    public void onClick(View view) {

        startActivity(new Intent(Prologue.this, MapDemoActivity.class));

    }
}
