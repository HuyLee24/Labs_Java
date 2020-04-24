package com.example.exceptiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SoccerPlayer player = new SoccerPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView textView = findViewById(R.id.textView);
        EditText editor = findViewById(R.id.editor);
        String text = editor.getText().toString();

        try {
            int playerNumber = new Integer(text).intValue();
            player.setPlayerNumber(playerNumber);
        } catch (Exception e) {
            textView.setText("Soccer Player number not valid!");
        }
    }
}
