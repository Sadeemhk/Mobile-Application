package com.example.chaptertwo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Called when the button gets clicked
    public void onClickFindBeer(View view){
        //Get a reference to the TextView
        TextView brands= (TextView) findViewById(R.id.brands);
        //Get a reference to the Spinner
        Spinner color= (Spinner) findViewById(R.id.color);
        //Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());
        //Get recommendation from the BeerExpert class
        List<String> brandList=expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandList){
            brandsFormatted.append(brand).append('\n');
        }
        //Display the beers
        brands.setText(brandsFormatted);
    }
}
