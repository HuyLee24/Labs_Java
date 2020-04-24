package com.example.secondoodemo;

import android.util.Log;

public class Referee extends Person {

    private String whistleSensitivity;

    public String getWhistleSensitivity() {
        return whistleSensitivity;
    }

    public void setWhistleSensitivity(String whistleSensitivity) {
        this.whistleSensitivity = whistleSensitivity;
    }

    @Override
    public String greet() {
       return "Hi, I'm REFEREE with name:" + getName() + "and sensitivity:" + getWhistleSensitivity();
    }
}
