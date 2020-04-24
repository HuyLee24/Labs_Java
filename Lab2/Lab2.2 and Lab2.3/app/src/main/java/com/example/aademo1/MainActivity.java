package com.example.aademo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    public ArrayList<String> countries = new ArrayList<>();
    Context MainActivity;
    final String [] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
            "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
            "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout btnLayout = new LinearLayout(this);
        btnLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        btnLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(btnLayout);
        LinearLayout child = new LinearLayout(this);
        child.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        child.setOrientation(LinearLayout.HORIZONTAL );
        child.setPadding(150,0,0,0);
        final Button addBtn = new Button(this);
        addBtn.setText("Add");
        addBtn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        final Button editBtn = new Button(this);
        editBtn.setText("Edit");
        editBtn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Button rmBtn = new Button(this);
        rmBtn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        rmBtn.setText("Remove");
        child.addView(addBtn);
        child.addView(editBtn);
        child.addView(rmBtn);
        btnLayout.addView(child);
        final EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        btnLayout.addView(editText);
        final ListView listView = new ListView(this);
        listView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        btnLayout.addView(listView);
        addBtn.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    ToDoModel model = ToDoApplication.getModel( MainActivity.this);
                    List<String> allItems = model.getTodoItems();
                    ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, allItems);
                    listView.setAdapter(todoAdapter);
                    String text = editText.getText().toString();
                    model.addNewTodoItem(text);
                    Log.i("Test", text);
                }
        });
        rmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLayout.removeView(listView);
            }
        });
        rmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoModel model = ToDoApplication.getModel( MainActivity.this);
                List<String> allItems = model.getTodoItems();
                final ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, allItems);
                listView.setAdapter(todoAdapter);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete All Tasks?")
                        .setMessage("Do you really want to delete all the tasks?")
                        .setPositiveButton("Delete All Tasks", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                todoAdapter.clear();
                                listView.setAdapter(todoAdapter);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });
        ToDoModel model = ToDoApplication.getModel( MainActivity.this);
        List<String> allItems = model.getTodoItems();
        ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, allItems);
        listView.setAdapter(todoAdapter);

        //updateListUi();
    }

    /*
    @Override
    public void onClick(View view) {


            String text = editText.getText().toString();

            ToDoModel model = ToDoApplication.getModel(this);
            model.addNewTodoItem(text);

            updateListUi()

    }

    private void updateListUi() {
        ListView todoListView = findViewById(R.id.todoListView);

        ToDoModel model = ToDoApplication.getModel(this);
        List<String> allItems = model.getTodoItems();


        ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allItems);

        todoListView.setAdapter(todoAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
        Intent intent = new Intent(this, ToDoItemViewActivity.class);
        startActivity(intent);
    }*/
}
