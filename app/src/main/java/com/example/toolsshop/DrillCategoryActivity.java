package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;
    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle(R.string.drill_dscr_actionbar);

        listViewDrills = findViewById(R.id.ListViewDrills);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();   //скрыть Акшин-бар
        }

        drills = new ArrayList<>();    //создаем массив
        drills.add(new Drill(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol));
        drills.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.makito));
        drills.add(new Drill(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewault));
                                    //  оздаем адаптер для размещения массива дрелей в listViewDrills
        ArrayAdapter<Drill> adapter = new ArrayAdapter <>(getApplicationContext(), android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);   //вносим данные на listView

        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Drill drill = drills.get(position);
                                 //вызываем активность с детальной информацией
                        Intent intent = new Intent(getApplicationContext(), DrillDetaleActivity.class);
                        intent.putExtra("title", drill.getTitle());
                        intent.putExtra("info", drill.getInfo());
                        intent.putExtra("resId", drill.getImageResourceId());
                        startActivity(intent);
            }
        });


    }
}