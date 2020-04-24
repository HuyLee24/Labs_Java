package com.example.l3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PhoneDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_details);

        final Intent intent = getIntent();
        String text = intent.getStringExtra("PHONE_NUMBER");

        TextView textView = findViewById(R.id.phoneNumberTextView);
        textView.setText(text);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                intent.putExtra("RETURN", "This is the secret message");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
