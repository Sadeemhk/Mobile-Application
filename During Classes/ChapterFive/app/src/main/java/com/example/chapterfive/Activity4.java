package com.example.chapterfive;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // Change the ID to match your layout XML
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == -1) {
            // no item selected
            Toast.makeText(this,"No item selected", Toast.LENGTH_SHORT).show();
        } else {
            RadioButton radioButton = findViewById(id);
        }
    }

    public void onRadioButtonCLicked(View view) {
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        if (id == R.id.radio_cavemen) {
            // Handle Cavemen win
            Toast.makeText(this, "Cavemen selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.radio_astronauts){
                // Handle Astronauts win
                Toast.makeText(this,"Astronauts selected",Toast.LENGTH_SHORT).show();

        }
    }
}
