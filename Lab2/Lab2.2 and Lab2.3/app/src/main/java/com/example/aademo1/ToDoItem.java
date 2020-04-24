package com.example.aademo1;

import java.util.Date;

public class ToDoItem {
    private String itemText;
    private Date creationTime = new Date();

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Date getCreationTime() {
        return creationTime;
    }
}
