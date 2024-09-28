package com.example.afterchapterseven;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addMember(View view) {
        // Retrieve user input
        EditText nameEditText = findViewById(R.id.editName);
        EditText idEditText = findViewById(R.id.editID);
        String name = nameEditText.getText().toString();
        String id = idEditText.getText().toString();

        // Pass the data to the second activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
