package com.example.nutrion;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                nextActivity();
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    public void nextActivity()
    {
        Intent intentSecond=new Intent(this,BMIPage.class);
        startActivity(intentSecond);
    }

    public void buttonExitOnClick(View v)
    {
        finish();
        System.exit(0);
    }
}
