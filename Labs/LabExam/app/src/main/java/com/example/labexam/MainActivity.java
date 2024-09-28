package com.example.labexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextStudentName = findViewById(R.id.stdname);
        final EditText editTextProgramName = findViewById(R.id.program);
        final EditText editTextDuration = findViewById(R.id.duration);
        Button buttonSubmit = findViewById(R.id.submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studentName = editTextStudentName.getText().toString();
                String programName = editTextProgramName.getText().toString();
                String duration = editTextDuration.getText().toString();

                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("studentName", studentName);
                intent.putExtra("programName", programName);
                intent.putExtra("duration", duration);
                startActivity(intent);
            }
        });
    }
}
