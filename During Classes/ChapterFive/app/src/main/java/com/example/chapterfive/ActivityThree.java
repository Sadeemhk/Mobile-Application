package com.example.chapterfive;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ActivityThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
    }
    public void OnToggleButtonClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            // ToggleButton is ON
            Toast.makeText(this, "ToggleButton is ON", Toast.LENGTH_SHORT).show();
        } else {
            // ToggleButton is OFF
            Toast.makeText(this, "ToggleButton is OFF", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSwitchClicked(View view) {
        boolean on = ((Switch) view).isChecked();
        if (on) {
            // Switch is ON
            Toast.makeText(this, "Switch is ON", Toast.LENGTH_SHORT).show();
        } else {
            // Switch is OFF
            Toast.makeText(this, "Switch is OFF", Toast.LENGTH_SHORT).show();
        }
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        if (view.getId() == R.id.checkbox_milk)
            if (checked) {
                // Add code for milky coffee
                Toast.makeText(this, "Milky Coffee selected", Toast.LENGTH_SHORT).show();
            }else {
                // Add code for black coffee
                Toast.makeText(this, "Black Coffee selected", Toast.LENGTH_SHORT).show();
            }else if (view.getId() == R.id.checkbox_sugar)
               if (checked) {
                  // Add code for sweet coffee
                  Toast.makeText(this, "Sweet Coffee selected", Toast.LENGTH_SHORT).show();
               }else {
                  // Add code for bitter coffee
                  Toast.makeText(this, "Bitter Coffee selected", Toast.LENGTH_SHORT).show();
               }
       }
}



