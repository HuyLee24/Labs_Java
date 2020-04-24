package lab.excercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);
        final EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(editText);
        final LinearLayout child = new LinearLayout(this);
        child.setOrientation(LinearLayout.HORIZONTAL);
        final Button English = new Button(this);
        English.setText("English");
        English.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        final Button Sverige = new Button(this);
        Sverige.setText("Sverige");
        Sverige.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        child.addView(English);
        child.addView(Sverige);
        child.setGravity(Gravity.CENTER);
        final LinearLayout child1 = new LinearLayout(this);
        child1.setOrientation(LinearLayout.HORIZONTAL);
        child1.setGravity(Gravity.CENTER);
        final Button Suomeksi = new Button(this);
        Suomeksi.setText("Suomeksi");
        Suomeksi.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        final Button Suprise = new Button(this);
        Suprise.setText("Suprise");
        Suprise.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        child1.addView(Suomeksi);
        child1.addView(Suprise);
        linearLayout.addView(child);
        linearLayout.addView(child1);
        final TextView textView = new TextView(this);
        textView.setText("hello");
        textView.setPadding(0,150,0,0);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(30);
        linearLayout.addView(textView);
        English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                textView.setText("Hi " + name);
            }
        });
        Sverige.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                textView.setText("Hejjsan " + name);
            }
        });
        Suomeksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                textView.setText("Terve " + name);
            }
        });
        Suprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                textView.setText("Hola " + name);
            }
        });
    }
}
