package com.example.nutrion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BMIPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmipage);
    }
    public void onClickNext(View v)
    {
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

}
