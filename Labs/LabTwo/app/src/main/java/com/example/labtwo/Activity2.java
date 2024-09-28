package com.example.labtwo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String[] arraySpinner =new String[]{
                "Wed, September 13,2023", "Thursday, December 14,2023 "
        };
        Spinner s =(Spinner) findViewById(R.id.dates);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        arraySpinner= new String[]{
                "8:00am", "9:00am"
        };
        s = (Spinner) findViewById(R.id.times);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}