package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/11/2017.
 */

import java.util.ArrayList;
/**
 * this class represents the Character ability (strength, constitution...).
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ability
{
    // instance variables - replace the example below with your own
    private int abilityRank;
    private String abilityName;
    private int abilityBonus;
    //private ArrayList<ability> abilities=new ArrayList<ability>();
    /**
     * Constructs a new ability at the given rank.
     */
    public ability(String abilityName, int abilityRank)
    {
        // initialise instance variables
        this.abilityName = abilityName;
        this.abilityRank = abilityRank;
        this.abilityBonus= this.setAbilityBonus();
    }

    /**
     * Constructs a new ability at the rank 0.
     */
    public ability(String abilityName)
    {
        // initialise instance variables
        this.abilityName = abilityName;
        this.abilityRank = 0;
        //abilities.add(this);
    }
    /**
     * this methods retrieves the ability's rank.
     *
     * @return    ability's rank.
     */
    public int getAbilityRank()
    {
        // put your code here
        return this.abilityRank;
    }
    /**
     * this methods retrieves the ability's bonus.
     *
     * @return ability's bonus.
     */
    public int setAbilityBonus()
    {
        // put your code here
        return (this.abilityRank/2)%1-5;
    }
    /**
     * this methods changes the ability's rank by a given amount.
     *
     * @param the amount to add/substract from the ability.
     */
    public void changeAbilityRank(int amount)
    {
        // put your code here
        this.abilityRank=this.abilityRank+amount;
    }
    /**
     * this methods changes the ability's rank to a specific rank.
     *
     * @param the rank to change the ability to.
     */
    public void newAbilityRank(int rank)
    {
        // put your code here
        this.abilityRank=rank;
    }
    /**
     * this methods prints out the ability's rank.
     *
     */
    public void printAbilityRank()
    {
        // put your code here
        System.out.println("this Character has "+this.abilityRank+" "+this.abilityName);
    }
    /**
     * this methods prints out the ability's bonus.
     *
     */
    public void printAbilityBonus()
    {
        // put your code here
        System.out.println(this.abilityBonus);
    }
}
