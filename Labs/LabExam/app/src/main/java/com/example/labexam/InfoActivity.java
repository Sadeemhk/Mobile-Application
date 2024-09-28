package com.example.labexam;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class InfoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_info);

            TextView textViewStudentName = findViewById(R.id.tvStdname);
            TextView textViewProgramName = findViewById(R.id.tvProgram);
            TextView textViewDuration = findViewById(R.id.tvDuration);

            Intent intent = getIntent();
            String studentName = intent.getStringExtra("studentName");
            String programName = intent.getStringExtra("programName");
            String duration = intent.getStringExtra("duration");

            textViewStudentName.setText("Student Name: " + studentName);
            textViewProgramName.setText("Program Name: " + programName);
            textViewDuration.setText("Duration: " + duration);
        }
    }
