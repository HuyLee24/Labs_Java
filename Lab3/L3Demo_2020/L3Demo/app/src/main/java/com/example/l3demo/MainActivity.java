package com.example.l3demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.openActivity).setOnClickListener(this);

/*      LinearLayout parent = new LinearLayout(this);
        parent.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        parent.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);
        button.setText("Press me!");
        button.setOnClickListener(this);


        parent.addView(button);

        TextView textView = new TextView(this);
        textView.setText("Helllo class!");
        parent.addView(textView);

        setContentView(parent);
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.app_settings) {
            // Settings has been selected...
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.openActivity) {
            EditText editor = findViewById(R.id.textEditor);
            String tel = editor.getText().toString();

            Intent intent = new Intent(this, PhoneDetailsActivity.class);
            intent.putExtra("PHONE_NUMBER", tel);

            startActivityForResult(intent, REQ_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            String returnString = data.getStringExtra("RETURN");
            TextView textView = findViewById(R.id.centerTextView);
            textView.setText(returnString);
        }
    }
}
