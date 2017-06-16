package com.example.android.anothertabtest;

/**
 * Created by Omer's on 4/26/2017.
 */

public class CharacterSkill {
    private int points;
    private String name;

    public CharacterSkill(String name) {
        this.points = 0;
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints() {
        this.points++;
    }

    public void decreasePoints() {
        this.points--;
    }

    public String getName() {
        return name;
    }
}
