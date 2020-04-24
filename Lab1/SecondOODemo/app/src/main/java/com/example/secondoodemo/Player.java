package com.example.secondoodemo;

public class Player extends Person {

    private int playerNr = -1;

    public int getPlayerNr() {
        return playerNr;
    }

    public void setPlayerNr(int playerNr) {
        if (playerNr > 0 && playerNr < 100) {
            this.playerNr = playerNr;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
