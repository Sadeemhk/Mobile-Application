package com.example.assignmenttwo;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private TextView weatherConditions,humidity,rain,wind_speed,temperature,celsius,fahrenheit;
    private ImageView weatherConditions_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        temperature = findViewById(R.id.Temperature);
        humidity = findViewById(R.id.humidity);
        wind_speed = findViewById(R.id.windSpeed);
        weatherConditions = findViewById(R.id.weatherConditions);
        weatherConditions_icon = findViewById(R.id.weatherConditions_icon);
        celsius = findViewById(R.id.Celsius);
        fahrenheit = findViewById(R.id.Fahrenheit);
        rain=findViewById(R.id.rain);

        Intent intent = getIntent();
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        double D_temperature = intent.getDoubleExtra("temperatureCelsius",0);
        temperature.setText(decimalFormat.format(D_temperature)+"°C");

        celsius.setOnClickListener(v -> {
            temperature.setText(decimalFormat.format(D_temperature)+"°C"); //Converts to celsius
        });

        fahrenheit.setOnClickListener(v -> {
            double fahrenheit = (D_temperature * 9/5) + 32;
            temperature.setText(decimalFormat.format(fahrenheit)+"°F"); //Converts to fahrenheit
        });

        double Dhumidity = intent.getDoubleExtra("humidity",0); //humidity
        humidity.setText("Humidity= "+decimalFormat.format(Dhumidity)+"%");

        double wind_speedd = intent.getDoubleExtra("speed",0); //wind speed
        wind_speed.setText("Wind= "+decimalFormat.format(wind_speedd)+" m/s");

        double rainn = intent.getDoubleExtra("rain",0); //rain
        rain.setText("Rain = "+decimalFormat.format(rainn)+"%");


        weatherConditions.setText(intent.getStringExtra("description"));

        String iconCode = intent.getStringExtra("icon_code");
        String imageUrl = String.format("https://openweathermap.org/img/wn/%s.png",iconCode);
        Picasso.get().load(imageUrl).into(weatherConditions_icon);
    }
}