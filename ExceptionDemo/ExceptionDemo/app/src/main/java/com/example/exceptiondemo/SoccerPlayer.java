package com.example.exceptiondemo;

import java.security.InvalidParameterException;

public class SoccerPlayer {

    private int playerNumber;
    private String name;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        if (playerNumber < 1 || playerNumber > 99)
        {
            throw new InvalidParameterException();
        }
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
