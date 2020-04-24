package com.example.aademo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addNewTodoItem).setOnClickListener(this);
        ListView listView = findViewById(R.id.todoListView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.addNewTodoItem) {
            EditText editor = findViewById(R.id.todoEditor);
            String text = editor.getText().toString();
            ToDoItem newItem = new ToDoItem();
            newItem.setItemText(text);

            ToDoModel model = ToDoApplication.getModel(this);
            model.addNewTodoItem(newItem);
            updateListUi();
        }
    }

    private void updateListUi() {
        ListView todoListView = findViewById(R.id.todoListView);

        ToDoModel model = ToDoApplication.getModel(this);
        List<ToDoItem> allItems = model.getTodoItems();

        ArrayList<String> itemTexts = new ArrayList<String>();
        for (int i = 0; i < allItems.size(); i++) {
            itemTexts.add(allItems.get(i).getItemText());
        }

        ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, itemTexts);

        todoListView.setAdapter(todoAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Intent intent = new Intent(this, ToDoItemViewActivity.class);
        startActivity(intent);
    }
}
