package com.example.afterchaptertwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Members group=new Members();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickedButton(View view){
        TextView textView=(TextView) findViewById(R.id.textView);
        Spinner std_names=(Spinner) findViewById(R.id.names);
        String GroupMembers = String.valueOf(std_names.getSelectedItem());

        List<String> StdList=group.getStd(GroupMembers);
        StringBuilder StdFormatted =new StringBuilder();
        for (String Std:StdList){
            StdFormatted.append(Std).append('\n');
        }
        textView.setText(StdFormatted);
    }
}