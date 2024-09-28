package com.example.afterchapterthree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      }

      public void onSendMessage(View view) {
        EditText message= (EditText)findViewById(R.id.Id);
        EditText View= (EditText)findViewById(R.id.Name);
        String messageText = message.getText().toString();
        String Text = View.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(MainActivity2.EXTRA_MESSAGE,messageText);
        intent.putExtra(MainActivity2.EXTRA,Text);
        startActivity(intent);
    }
}