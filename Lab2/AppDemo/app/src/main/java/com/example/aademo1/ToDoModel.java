package com.example.aademo1;

import java.util.ArrayList;
import java.util.List;

public class ToDoModel {

    private ArrayList<ToDoItem> todoItems = new ArrayList<ToDoItem>();

    void addNewTodoItem(ToDoItem item) {
        todoItems.add(item);
    }

    public List<ToDoItem> getTodoItems() {
        return todoItems;
    }

}
