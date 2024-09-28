package com.example.chapterfive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        ImageButton imageButton = findViewById(R.id.Button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClicked(v);
            }
        });
    }

    public void onButtonClicked(View view) {
        // Handle the ImageButton click event here
        Toast.makeText(this, "ImageButton Clicked", Toast.LENGTH_SHORT).show();
    }
}
