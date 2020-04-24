package com.example.secondoodemo;

import android.util.Log;

abstract public class Person {
    private String name;
    private String socialSecurityNumber;

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setName(String newName) {
        if (newName != null && newName.length() > 0 )
        {
            this.name = newName;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        if (socialSecurityNumber.length() != 11)
        {
            throw new IllegalArgumentException();
        }
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String greet()
    {
       return "Hi, I'm person with name:" + getName();
    }
}
