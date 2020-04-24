package lab3.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.widget.TextView;

public class TimerCountdownActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_count_down_activity);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.timer);
        final TextView textView = findViewById(R.id.textView);
        new CountDownTimer(Integer.parseInt(message)*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView.setText("" + millisUntilFinished / 1000);
                textView.setGravity(Gravity.CENTER);
            }

            public void onFinish() {
                textView.setText("done!");

            }
        }.start();

    }
}

