package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/11/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
/**
 * creates a d20 3.5 edition feat.
 *
 * @author Omer Behar
 * @version 1.0 10.6.2016
 */
public class feat
{
    // instance variables
    public Map<String,Integer> benefitMap=new HashMap<String,Integer>();
    private String featName;
    private String featDescription;
    private String benefitDescription;
    private String featPrerequisitesDescription;
    public boolean isSelected=false;
    public ArrayList<String> prerequisiteFeatList=new ArrayList<String>();
    public boolean isFighterFeat=false;
    public int minimumLevel=0;
    public ArrayList<String> abilityAtleast13List=new ArrayList<String>();
    public String abilityAtleast15=null;
    public String abilityAtleast17=null;
    public String abilityAtleast19=null;
    public int minimumBaseAttackBonus;
    public int minimumRideRank;
    public int minimumFighterLevel;
    public int minimumCasterLevel;
    public int minimumWizardLevel;
    public int abilityToTurn;
    public int abilityToWildShape;
    public ArrayList<String> plus2SkillList=new ArrayList<String>();
    /**
     * Constracts a new feat with a chosen name.
     */
    public feat(String featName, String featDescription, String featPrerequisitesDescription, String prerequisiteFeats, String benefitDescription, int isFighterFeat
            , int minimumLevel, String abilityAtleast13, String abilityAtleast15, String abilityAtleast17, String abilityAtleast19, int minimumBaseAttackBonus, int minimumRideRank
            , int minimumFighterLevel, int minimumCasterLevel, int minimumWizardLevel, int abilityToTurn, int abilityToWildShape, int turningLevel, int hitPoints, String plus2Skill
            , String plus2Save, int dodgeBonus, int spellCheck, int initiative)
    {
        this.benefitDescription=benefitDescription;
        this.featName=featName;
        this.featDescription= featDescription;
        this.featPrerequisitesDescription=featPrerequisitesDescription;
        if (prerequisiteFeats!=null)
        {
            this.addPrerequisiteFeats(prerequisiteFeats);
        }
        if (isFighterFeat==1) this.isFighterFeat=true;
        this.minimumLevel=minimumLevel;
        if (abilityAtleast13!=null)
        {
            this.addAbilityAtleast13(abilityAtleast13);
        }
        if (abilityAtleast15!=null && !abilityAtleast15.isEmpty())
        {
            this.abilityAtleast15=abilityAtleast15;
        }
        if (abilityAtleast17!=null && !abilityAtleast17.isEmpty())
        {
            this.abilityAtleast17=abilityAtleast17;
        }
        if (abilityAtleast19!=null && !abilityAtleast19.isEmpty())
        {
            this.abilityAtleast19=abilityAtleast19;
        }
        this.minimumBaseAttackBonus=minimumBaseAttackBonus;
        this.minimumRideRank=minimumRideRank;
        this.minimumFighterLevel=minimumFighterLevel;
        this.minimumCasterLevel=minimumCasterLevel;
        this.minimumWizardLevel=minimumWizardLevel;
        this.abilityToTurn=abilityToTurn;
        this.abilityToWildShape=abilityToWildShape;
        benefitMap.put("turningLevel",turningLevel);
        benefitMap.put("hitPoints",hitPoints);
        if (plus2Skill!=null)
        {
            this.addPlus2Skill(plus2Skill);
        }
        if (plus2Save!=null)
        {
            benefitMap.put(plus2Save+"Save",2);
        }
        benefitMap.put("dodgeBonus",dodgeBonus);
        benefitMap.put("spellCheck",spellCheck);
        benefitMap.put("initiative",initiative);

    }

    /**
     * This method adds abbilities to a list array of abilities needed to be atleast 13.
     * @param     a String of prerequiste abilities (13 minimum) seperated by a comma (,).
     */
    public void addAbilityAtleast13(String abilityAtleast13)
    {
        ArrayList<String> abilityAtleast13ListUntrimmed;
        if (abilityAtleast13!=null && !abilityAtleast13.isEmpty())
        {
            abilityAtleast13ListUntrimmed= new ArrayList(Arrays.asList(abilityAtleast13.split(",")));
        }
        else
        {
            abilityAtleast13ListUntrimmed= new ArrayList();
        }
        for (String tempString:abilityAtleast13ListUntrimmed)
        {
            abilityAtleast13List.add(tempString.trim());
        }
    }

    /**
     * This method adds prerequisite feats to a list array of feats.
     * @param     a String of prerequiste feats seperated by a comma (,).
     */
    public void addPrerequisiteFeats(String prerequisiteFeats)
    {
        ArrayList<String> prerequisiteFeatListUntrimmed;
        if (prerequisiteFeats!=null && !prerequisiteFeats.isEmpty())
        {
            prerequisiteFeatListUntrimmed= new ArrayList(Arrays.asList(prerequisiteFeats.split(",")));
        }
        else
        {
            prerequisiteFeatListUntrimmed= new ArrayList();
        }
        for (String tempString:prerequisiteFeatListUntrimmed)
        {
            prerequisiteFeatList.add(tempString.trim());
        }
    }

    /**
     * This method adds +2 skill benefit from a feat (first into a Array List, and finaly into the benefit map).
     * @param     a String of +2 skill seperated by a comma (,).
     */
    public void addPlus2Skill(String plus2Skill)
    {
        ArrayList<String> plus2SkillListUntrimmed;
        if (plus2Skill!=null && !plus2Skill.isEmpty())
        {
            plus2SkillListUntrimmed= new ArrayList(Arrays.asList(plus2Skill.split(",")));
        }
        else
        {
            plus2SkillListUntrimmed= new ArrayList();
        }
        for (String tempString:plus2SkillListUntrimmed)
        {
            plus2SkillList.add(tempString.trim());
        }
        for (String tempString:plus2SkillList)
        {
            benefitMap.put(tempString,2);
        }

    }

    /**
     * This method prints out a feat's +2 skill benefit.
     */
    public void printPlus2Skill()
    {
        for (String tempString:plus2SkillList)
        {
            System.out.println(tempString+benefitMap.get(tempString));
        }

    }

    /**
     * This method returns weather or not this is a figher feat.
     * @return     true if its a fighter feat.
     */
    public boolean getIsFighterFeat()
    {
        return this.isFighterFeat;
    }

    /**
     * This method returns the minimum level of character prerequisite.
     * @return     minimum level, 0 if no prerequisite.
     */
    public int getMinimumLevel()
    {
        return this.minimumLevel;
    }

    /**
     * This method returns the minimum fighter level of character prerequisite.
     * @return     minimum level, 0 if no prerequisite.
     */
    public int getMinimumFighterLevel()
    {
        return this.minimumFighterLevel;
    }

    /**
     * This method returns the minimum caster level of character prerequisite.
     * @return     minimum level, 0 if no prerequisite.
     */
    public int getMinimumCasterLevel()
    {
        return this.minimumCasterLevel;
    }

    /**
     * This method returns the minimum wizard level of character prerequisite.
     * @return     minimum level, 0 if no prerequisite.
     */
    public int getMinimumWizardLevel()
    {
        return this.minimumWizardLevel;
    }

    /**
     * This method returns if the ability to turn or rebuke is a prerequisite.
     * @return     true if the ability to turn or rebuke is a prerequisite.
     */
    public int getAbilityToTurn()
    {
        return this.abilityToTurn;
    }

    /**
     * This method returns if the ability to wild shape is a prerequisite.
     * @return     true if the ability to wild shape is a prerequisite.
     */
    public int getAbilityToWildShape()
    {
        return this.abilityToWildShape;
    }

    /**
     * This method returns the list of ablities that need to be atleast 13 to select this feat.
     * @return     ArrayList of abilities that need to be atleast 13.
     */
    public ArrayList<String> getAbilityAtleast13()
    {
        return this.abilityAtleast13List;
    }

    /**
     * This method returns ability that need to be atleast 15 to select this feat.
     * @return     name of ability that need to be atleast 15.
     */
    public String getAbilityAtleast15()
    {
        return this.abilityAtleast15;
    }

    /**
     * This method returns ability that need to be atleast 17 to select this feat.
     * @return     name of ability that need to be atleast 17.
     */
    public String getAbilityAtleast17()
    {
        return this.abilityAtleast17;
    }

    /**
     * This method returns ability that need to be atleast 19 to select this feat.
     * @return     name of ability that need to be atleast 19.
     */
    public String getAbilityAtleast19()
    {
        return this.abilityAtleast19;
    }

    /**
     * This method returns the minimum Base Attack Bonus prerequisite.
     * @return     minimum Base Attack Bonus, 0 if no prerequisite.
     */
    public int getMinimumBaseAttackBonus()
    {
        return this.minimumBaseAttackBonus;
    }

    /**
     * This method returns the minimum Ride rank prerequisite.
     * @return     minimum Ride rank, 0 if no prerequisite.
     */
    public int getMinimumRideRank()
    {
        return this.minimumRideRank;
    }

    /**
     * This method returns the list of the feat's prerequisites feats.
     * @return     list of the feat's prerequisites feats.
     */
    public ArrayList getPrerequisiteFeatsList()
    {
        return this.prerequisiteFeatList;
    }

    /**
     * This method prints the list of the feat's prerequisites feats.
     */
    public void printPrerequisiteFeatsList()
    {
        for (String feat:prerequisiteFeatList)
        {
            System.out.println("*"+feat+"*");
        }
    }

    /**
     * This method prints the list of the feat's prerequisites abilities that need to be atleast 13.
     */
    public void printAbilityAtleast13()
    {
        for (String feat:abilityAtleast13List)
        {
            System.out.println("*"+feat+"*");
        }
    }

    /**
     * This method prints the feat's prerequisites abilities that need to be atleast 15.
     */
    public void printAbilityAtleast15()
    {
        System.out.println(abilityAtleast15);
    }

    /**
     * This method prints the feat's prerequisites abilities that need to be atleast 17.
     */
    public void printAbilityAtleast17()
    {
        System.out.println(abilityAtleast17);
    }

    /**
     * This method prints the feat's prerequisites abilities that need to be atleast 19.
     */
    public void printAbilityAtleast19()
    {
        System.out.println(abilityAtleast19);
    }

    /**
     * This method prints the feat's prerequisites minimum base attack bonus.
     */
    public void printMinimumBaseAttackBonus()
    {
        System.out.println(minimumBaseAttackBonus);
    }

    /**
     * This method returns the description of the feat's prerequisites.
     * @return     description of the feat's prerequisities.
     */
    public String getFeatPrerequisitesDescription()
    {
        // put your code here
        return this.featPrerequisitesDescription;
    }

    /**
     * This method returns the description of the feat.
     * @return     description of the feat.
     */
    public String getFeatDescription()
    {
        // put your code here
        return this.featDescription;
    }

    /**
     * This method returns the description of the feat.
     * @return     description of the feat.
     */
    public String getBenefitDescription()
    {
        // put your code here
        return this.benefitDescription;
    }

    /**
     * This method returns the name of the feat.
     * @return     name of the feat.
     */
    public String getFeatName()
    {
        // put your code here
        return featName;
    }
}
