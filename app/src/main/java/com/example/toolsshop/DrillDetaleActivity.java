package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetaleActivity extends AppCompatActivity {

    private ImageView imageViewDrill;
    private TextView textViewTitle;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detale);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();   //скрыть Акшин-бар
        }
        imageViewDrill = findViewById(R.id.imageViewDrill);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);

        Intent intent = getIntent();
        if(intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resID")){
            textViewTitle.setText(intent.getStringExtra("title"));
            textViewInfo.setText(intent.getStringExtra("info"));
            imageViewDrill.setImageResource(intent.getIntExtra("resId", 0));
        } else{
            Intent intentBack = new Intent(this, DrillCategoryActivity.class);
            startActivity(intentBack);
        }



    }
}