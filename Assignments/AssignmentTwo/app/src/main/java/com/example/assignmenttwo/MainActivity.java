package com.example.assignmenttwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private EditText countryName;
    private EditText CountryCode;
    private Button submitButton;
    private ApiConnector apiConnector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countryName = findViewById(R.id.countryName);
        CountryCode = findViewById(R.id.countryCode);
        submitButton = findViewById(R.id.btn_submit);

        apiConnector = new ApiConnector(getBaseContext());

        submitButton.setOnClickListener(v -> {
            if (countryName.getText().toString().trim().isEmpty() ||
                    CountryCode.getText().toString().trim().isEmpty()  ){
                Toast.makeText(getBaseContext(),"Please fill in all fields",Toast.LENGTH_LONG).show();  //This method makes sure that the user enters a correct inputs
            }else{
                apiConnector.getData(countryName.getText().toString(), CountryCode.getText().toString(), new ApiConnector.ResponseListener() {
                    @Override
                    public void onActionCompleted(String response) throws JSONException {
                        JSONObject jsonObject = new JSONObject(response);

                        JSONArray weatherArray = jsonObject.getJSONArray("weather");
                        JSONObject weatherObject = weatherArray.getJSONObject(0);
                        String weatherConditions = weatherObject.getString("main");
                        String description = weatherObject.getString("description");
                        String icon_code = weatherObject.getString("icon");

                        JSONObject mainObject = jsonObject.getJSONObject("main");
                        double temperatureCelsius = mainObject.getDouble("temp");
                        temperatureCelsius = temperatureCelsius - 273.15;

                        double humidity = mainObject.getDouble("humidity");

                        JSONObject windObject = jsonObject.getJSONObject("wind");
                        double speed = windObject.getDouble("speed");

                        Intent intent = new Intent(getBaseContext(), ResultActivity.class);;
                        intent.putExtra("weatherConditions",weatherConditions);
                        intent.putExtra("description",description);
                        intent.putExtra("icon_code",icon_code);
                        intent.putExtra("temperatureCelsius",temperatureCelsius);
                        intent.putExtra("humidity",humidity);
                        intent.putExtra("speed",speed);
                        startActivity(intent);
                    }

                    @Override
                    public void onActionFailed(VolleyError error) {
                        Toast.makeText(getBaseContext(),"Your address is not recognized",Toast.LENGTH_LONG).show();
                    }
                });

            }

        });
    }
}