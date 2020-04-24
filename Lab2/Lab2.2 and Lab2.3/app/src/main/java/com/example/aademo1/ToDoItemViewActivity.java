package com.example.aademo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ToDoItemViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_item_view);

        ToDoModel model = ToDoApplication.getModel(this);


        if (model.getTodoItems().size() > 2) {
            String item = model.getTodoItems().get(2);
            TextView textView = findViewById(R.id.itemText);
            textView.setText(item);
        }
    }
}
