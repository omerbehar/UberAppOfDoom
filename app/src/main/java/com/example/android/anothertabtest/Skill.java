package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/11/2017.
 */

/**
 * Creats a skill and uses it.
 *
 * @author Omer Behar
 * @version 1.0 31.7.2016
 */
public class Skill
{
    public String skillName;
    public String skillAbility;
    public int untrained;
    public int armorCheckPenalty;

    /**
     * Constracts a new skill with a chosen name
     */
    public Skill(String skillName, String skillAbility, int untrained, int armorCheckPenalty)
    {
        this.skillName = skillName;
        this.skillAbility = skillAbility;
        this.untrained = untrained;
        this.armorCheckPenalty = armorCheckPenalty;
    }

    /**
     * this method returns the skill's name.
     * @return     Skill's name
     */
    public String getSkillName()
    {
        return skillName;
    }

    /**
     * this method returns the key stat of this skill.
     * @return     Skill's key stat.
     */
//    public String getKeyStat()
//    {
//        return keyStat;
//    }

    /**
     * this method returns weather or not the skill can be used untrained
     * @return     true if can be used untrained
     */
    public boolean getUntrained()
    {
        if (untrained==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * this method returns the skill's armor penalty check factor.
     * @return     Skill's armor penalty check factor.
     */
    public int getArmorCheckPenalty()
    {
        return armorCheckPenalty;
    }

    public String getSkillAbility() {
        return skillAbility;
    }
}
