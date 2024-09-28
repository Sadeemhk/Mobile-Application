package com.example.labthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //implicit intent example
        Button btn_Implicit = (Button) findViewById(R.id.button_im);
        btn_Implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ur1 = "https://uj.edu.sa";
                //Action
                Intent i = new Intent(Intent.ACTION_VIEW);
                //Data
                i.setData(Uri.parse(ur1));
                startActivity(i);
            }

        });
        //Explicit intent example
        Button btn_Explicit = (Button) findViewById(R.id.button_ex);
        btn_Explicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onPressDone(View view){
        EditText edit = (EditText) findViewById(R.id.std_id);
        String text=edit.getText().toString();
        Intent intent= new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.EXTRA_ID,text);
        startActivity(intent);

    }
}
/*
public void onSendMessage(View view) {
        EditText messageView= (EditText)findViewById(R.id.message) ;
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE,messageText);
        startActivity(intent);
    }
}
 */