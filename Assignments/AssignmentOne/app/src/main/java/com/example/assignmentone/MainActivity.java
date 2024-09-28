package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner Country;
    private ImageView FlagImages;
    private Button Flag;
    private MediaPlayer id;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Country = findViewById(R.id.Country);
        FlagImages = findViewById(R.id.FlagImages);
        Flag = findViewById(R.id.Flag);
        id = MediaPlayer.create(this, R.raw.id);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Country.setAdapter(adapter);

        Flag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String selectedCountry = Country.getSelectedItem().toString().toLowerCase();
                Flag=findViewById(R.id.Flag);
                int flagResourceId = 0;
                switch (selectedCountry){
                    case "saudi arabia": //When the user choose Saudi flag a toast message will appear and button color will change
                        flagResourceId = R.drawable.saudi;
                        Flag.setBackgroundColor(getResources().getColor(R.color.green));
                        CharSequence text1 = "Saudi Arabia, Happy 93rd National Day!!!";
                        int duration1 = Toast.LENGTH_SHORT;
                        Toast toast1 = Toast.makeText(MainActivity.this, text1, duration1);
                        toast1.show();
                        break;
                    case "united arab emirates": //When the user choose Emirates flag a toast message will appear and button color will change
                        flagResourceId = R.drawable.emirates;
                        Flag.setBackgroundColor(getResources().getColor(R.color.red));
                        CharSequence text2 = "United Arab Emirates";
                        int duration2 = Toast.LENGTH_SHORT;
                        Toast toast2 = Toast.makeText(MainActivity.this, text2, duration2);
                        toast2.show();
                        break;
                    case "kuwait":
                        flagResourceId = R.drawable.kuwait; //When the user choose Kuwait flag a toast message will appear and button color will change
                        Flag.setBackgroundColor(getResources().getColor(R.color.blue));
                        CharSequence text3 = "Kuwait";
                        int duration3 = Toast.LENGTH_SHORT;
                        Toast toast3 = Toast.makeText(MainActivity.this, text3, duration3);
                        toast3.show();
                }
                if (flagResourceId != 0) {
                    FlagImages.setImageResource(flagResourceId);
                }
            }
        });
        FlagImages.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                MediaPlayer id= MediaPlayer.create(MainActivity.this, R.raw.id);
                        id.start();
                return false;
            }
        });
    }
}

