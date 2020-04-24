package lab3.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String timer = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ButtonClick(View view)
    {
        Intent intent = new Intent(this, TimerCountdownActivity.class);
        EditText editText = (EditText) findViewById(R.id.time);
        String text = editText.getText().toString();
        intent.putExtra(timer,text);
        startActivity(intent);
    }
}
