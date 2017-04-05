package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/11/2017.
 */

import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Class here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Class
{
    public String className;
    public ArrayList<Integer> classBaseAttackBonus;
    public ArrayList<Integer> classSecondBaseAttackBonus;
    public ArrayList<Integer> classThirdBaseAttackBonus;
    public ArrayList<Integer> classFourthBaseAttackBonus;
    public ArrayList<Integer> classFortitudeSave;
    public ArrayList<Integer> classReflexSave;
    public ArrayList<Integer> classWillSave;
    /**
     * Constructor for objects of class Class
     */
    public Class(String className, ArrayList<Integer> classBaseAttackBonus, ArrayList<Integer> classSecondBaseAttackBonus, ArrayList<Integer> classThirdBaseAttackBonus,
                 ArrayList<Integer> classFourthBaseAttackBonus, ArrayList<Integer> classFortitudeSave, ArrayList<Integer> classReflexSave, ArrayList<Integer> classWillSave)
    {
        this.className=className;
        this.classBaseAttackBonus=classBaseAttackBonus;
        this.classSecondBaseAttackBonus=classSecondBaseAttackBonus;
        this.classThirdBaseAttackBonus=classThirdBaseAttackBonus;
        this.classFourthBaseAttackBonus=classFourthBaseAttackBonus;
        this.classFortitudeSave=classFortitudeSave;
        this.classReflexSave=classReflexSave;
        this.classWillSave=classWillSave;
    }

    /**
     * this method returns the class's name
     *
     * @return     the class's name
     */
    public String getClassName()
    {
        return this.className;
    }

    /**
     * this method returns the class's base attack bonus
     *
     * @return     the class's base attack bonus
     */
    public ArrayList<Integer> getClassBaseAttackBonus()
    {
        return this.classBaseAttackBonus;
    }

    /**
     * this method returns the class's second base attack bonus
     *
     * @return     the class's scond base attack bonus
     */
    public ArrayList<Integer> getClassSecondBaseAttackBonus()
    {
        return this.classSecondBaseAttackBonus;
    }

    /**
     * this method returns the class's third base attack bonus
     *
     * @return     the class's third base attack bonus
     */
    public ArrayList<Integer> getClassThirdBaseAttackBonus()
    {
        return this.classThirdBaseAttackBonus;
    }

    /**
     * this method returns the class's fourth base attack bonus
     *
     * @return     the class's fourth base attack bonus
     */
    public ArrayList<Integer> getClassFourthBaseAttackBonus()
    {
        return this.classFourthBaseAttackBonus;
    }

    /**
     * this method returns the class's fortitude save
     *
     * @return     the class's fortitude save
     */
    public ArrayList<Integer> getClassFortitudeSave()
    {
        return this.classFortitudeSave;
    }

    /**
     * this method returns the class's reflex save
     *
     * @return     the class's reflex save
     */
    public ArrayList<Integer> getClassReflexSave()
    {
        return this.classReflexSave;
    }

    /**
     * this method returns the class's will save
     *
     * @return     the class's will save
     */
    public ArrayList<Integer> getClassWillSave()
    {
        return this.classWillSave;
    }
}
