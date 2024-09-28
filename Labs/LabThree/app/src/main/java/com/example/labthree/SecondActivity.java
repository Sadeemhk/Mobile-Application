package com.example.labthree;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_ID="std_id";
    
        @Override
           protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
             Intent intent=getIntent();
             String text= intent.getStringExtra(EXTRA_ID);
             TextView edit = (TextView) findViewById(R.id.std_id);
             edit.setText(text);

    }
}
