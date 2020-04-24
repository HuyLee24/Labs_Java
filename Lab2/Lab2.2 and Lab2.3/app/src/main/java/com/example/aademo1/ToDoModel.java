package com.example.aademo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToDoModel {
    private ArrayList<String> todoItems = new ArrayList<String>();


    public ToDoModel (){

        final String [] COUNTRIES = new String[]{
                "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan"
        };
        todoItems.addAll(Arrays.asList(COUNTRIES));
    }


    void addNewTodoItem(String item) {
        todoItems.add(item);
    }

    public List<String> getTodoItems() {
        return todoItems;
    }

}
