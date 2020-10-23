package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DrillDetaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detale);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();   //скрыть Акшин-бар
        }

    }
}