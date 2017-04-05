package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/11/2017.
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
/**
 * creates a d20 3.5 edition character
 * @author Omer Behar
 * @version 1.0 - 10.6.2016
 */
public class character
{
    private ArrayList<String> charactersSelectedFeats=new ArrayList<String>();
    private String charName;
    public Map<String,Integer> initialCharactersAttributes=new HashMap<String,Integer>();
    public Map<String,Integer> calculatedCharactersAttributes=new HashMap<String,Integer>();
    private ArrayList<ability> abilities=new ArrayList<ability>();
    public ArrayList<String> classList=new ArrayList<String>();
    private String charRace;
    ability strength=new ability("Strength");
    ability constitution=new ability("Constitution");
    ability dexterity=new ability("Dexterity");
    ability charisma=new ability("Charisma");
    ability intelligence=new ability("Intelligence");
    ability wisdom=new ability("Wisdom");
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    /**
     constracts a new character with a given name, according to a chosen data base, and an empty feat list.
     */
    public character(String charName)
    {
        this.charName = charName;
        initialCharactersAttributes.put("level",0);
        initialCharactersAttributes.put("fighterLevel",0);
        initialCharactersAttributes.put("casterLevel",0);
        initialCharactersAttributes.put("wizardLevel",0);
        initialCharactersAttributes.put("abilityToTurn",0);
        initialCharactersAttributes.put("abilityToWildShape",0);
        initialCharactersAttributes.put("baseAttackBonus",0);
        initialCharactersAttributes.put("secondBaseAttackBonus",0);
        initialCharactersAttributes.put("thirdBaseAttackBonus",0);
        initialCharactersAttributes.put("fourthBaseAttackBonus",0);
        initialCharactersAttributes.put("turningLevel",0);
        initialCharactersAttributes.put("hitPoints",0);
        initialCharactersAttributes.put("fortitudeSave",0);
        initialCharactersAttributes.put("willSave",0);
        initialCharactersAttributes.put("reflexSave",0);
        initialCharactersAttributes.put("dodgeBonus",0);
        initialCharactersAttributes.put("spellCheck",0);
        initialCharactersAttributes.put("initiative",0);
        initialCharactersAttributes.put("availableFeats",0);
        initialCharactersAttributes.put("availableFighterFeats",0);
        initialCharactersAttributes.put("rolledStrength",0);
        initialCharactersAttributes.put("rolledDexterity",0);
        initialCharactersAttributes.put("rolledConstitution",0);
        initialCharactersAttributes.put("rolledWisdom",0);
        initialCharactersAttributes.put("rolledIntelligence",0);
        initialCharactersAttributes.put("rolledCharisma",0);
        initialCharactersAttributes.put("raceStrength",0);
        initialCharactersAttributes.put("raceDexterity",0);
        initialCharactersAttributes.put("raceConstitution",0);
        initialCharactersAttributes.put("raceWisdom",0);
        initialCharactersAttributes.put("raceIntelligence",0);
        initialCharactersAttributes.put("raceCharisma",0);
        try
        {
            for (Skill tempSkill:Database.getInstance().skills)
            {
                initialCharactersAttributes.put(tempSkill.getSkillName().toLowerCase(),0);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace(System.out);
        }
        abilities.add(strength);
        abilities.add(constitution);
        abilities.add(dexterity);
        abilities.add(charisma);
        abilities.add(intelligence);
        abilities.add(wisdom);
    }

    /**
     * this method sets the character's class.
     * @param selected class name.
     */
    public void levelUp(int level)
    {
        try
        {
            switch (level) {
                case 1:
                    String className = this.classList.get(0);
                    switch (className) {
                        case "Fighter": {
                            initialCharactersAttributes.put("level", initialCharactersAttributes.get("level") + 1);
                            initialCharactersAttributes.put("fighterLevel", initialCharactersAttributes.get("fighterLevel") + 1);
                            this.classList.add("Fighter");
                            if (initialCharactersAttributes.get("level") == 1) {
                                initialCharactersAttributes.put("hitPoints", initialCharactersAttributes.get("hitPoints") + 10);
                                initialCharactersAttributes.put("availableFighterFeats", initialCharactersAttributes.get("availableFighterFeats") + 1);
                                initialCharactersAttributes.put("availableFeats", initialCharactersAttributes.get("availableFeats") + 1);
                            } else {
                                initialCharactersAttributes.put("hitPoints", initialCharactersAttributes.get("hitPoints") + rand.nextInt(10) + 1);
                            }
                            if (initialCharactersAttributes.get("fighterLevel") % 2 == 0) {
                                initialCharactersAttributes.put("availableFighterFeats", initialCharactersAttributes.get("availableFighterFeats") + 1);
                            }
                            if (initialCharactersAttributes.get("level") % 3 == 0) {
                                initialCharactersAttributes.put("availableFeats", initialCharactersAttributes.get("availableFeats") + 1);
                            }
                        }
                    }


                    initialCharactersAttributes.put("baseAttackBonus", initialCharactersAttributes.get("baseAttackBonus") + Database.getInstance().classesMap.
                            get(className).getClassBaseAttackBonus().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
                    initialCharactersAttributes.put("secondBaseAttackBonus", initialCharactersAttributes.get("secondBaseAttackBonus") + Database.getInstance().classesMap.
                            get(className).getClassSecondBaseAttackBonus().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
                    initialCharactersAttributes.put("thirdBaseAttackBonus", initialCharactersAttributes.get("thirdBaseAttackBonus") + Database.getInstance().classesMap.
                            get(className).getClassThirdBaseAttackBonus().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
                    initialCharactersAttributes.put("fourthBaseAttackBonus", initialCharactersAttributes.get("fourthBaseAttackBonus") + Database.getInstance().classesMap.
                            get(className).getClassFourthBaseAttackBonus().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
                    initialCharactersAttributes.put("fortitudeSave", initialCharactersAttributes.get("fortitudeSave") + Database.getInstance().classesMap.
                            get(className).getClassFortitudeSave().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
                    initialCharactersAttributes.put("reflexSave", initialCharactersAttributes.get("reflexSave") + Database.getInstance().classesMap.
                            get(className).getClassReflexSave().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
                    initialCharactersAttributes.put("willSave", initialCharactersAttributes.get("willSave") + Database.getInstance().classesMap.
                            get(className).getClassWillSave().get(initialCharactersAttributes.get(className.toLowerCase() + "Level") - 1));
            }
            }
        catch (Exception ex)
        {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * this method sets a random character's ability (Strength, Constitution, Dexterity, Charisma, Intelligence or Wisdom).
     */
    public void setCharName(String newCharName)
    {
        this.charName=newCharName;
    }

    public void setRandomAbility()
    {
        this.setRolledAbility("rolledStrength",(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1));
        this.setRolledAbility("rolledConstitution",(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1));
        this.setRolledAbility("rolledDexterity",(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1));
        this.setRolledAbility("rolledCharisma",(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1));
        this.setRolledAbility("rolledIntelligence",(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1));
        this.setRolledAbility("rolledWisdom",(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1)+(rand.nextInt(6) + 1));
        setFinalAbilities();
        setAbilitiesBonus();
    }

    /**
     * this method sets a character's ability (Strength, Constitution, Dexterity, Charisma, Intelligence or Wisdom).
     * @param ability the chosen ability to be set.
     * @param score the score to set to the ability.
     */
    public void setRolledAbility(String ability, int score)
    {
        this.initialCharactersAttributes.put(ability,score);
        setFinalAbilities();
        setAbilitiesBonus();
    }

    /**
     * this method starts the procedure of character feat selection accourding to the amount of available feats to be selected
     */
    public void featsSelection()
    {
        try
        {
            if (this.getCalculatedAttribute("availableFeats")==0&&this.getCalculatedAttribute("availableFighterFeats")==0)
            {
                System.out.println("You have no available feats to select");
            }
            else
            {
                while (this.getCalculatedAttribute("availableFeats")>0||this.getCalculatedAttribute("availableFighterFeats")>0)
                {
                    System.out.println("You have "+this.getCalculatedAttribute("availableFeats")+" regular feats, and "+
                            this.getCalculatedAttribute("availableFighterFeats")+" fighter feats available, please select a feat");
                    String selectedFeat=sc.nextLine();
                    if (Database.getInstance().featsMap.containsKey(selectedFeat))
                    {
                        if (!this.charactersSelectedFeats.contains(selectedFeat))
                        {
                            if (this.canAddFeat(selectedFeat))
                            {
                                if (!Database.getInstance().featsMap.get(selectedFeat).getIsFighterFeat()&&this.getCalculatedAttribute("availableFeats")<1)
                                {
                                    System.out.println("This feat cannot be added, you only have Fighter feats available");
                                }
                                else
                                {
                                    this.addFeat(selectedFeat);
                                    if (Database.getInstance().featsMap.get(selectedFeat).getIsFighterFeat()&&this.getCalculatedAttribute("availableFighterFeats")>0)
                                    {
                                        this.initialCharactersAttributes.put("availableFighterFeats",this.initialCharactersAttributes.get("availableFighterFeats")-1);
                                    }
                                    else
                                    {
                                        this.initialCharactersAttributes.put("availableFeats",this.initialCharactersAttributes.get("availableFeats")-1);
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("This feat cannot be added, feats prerequisites are: "+ Database.getInstance().featsMap.get(selectedFeat).getFeatPrerequisitesDescription());
                            }
                        }
                        else
                        {
                            System.out.println("You allready have the selected feat");
                        }
                    }
                    else
                    {
                        System.out.println("No such feat");
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * this method prints out the character's name.
     *
     */
    public void printCharacterName()
    {
        System.out.println("Character name:"+this.charName);
    }

    /**
     * this method adds a feat to the character.
     * @param  addedFeat The feat added to the character.
     */
    public void addFeat(String addedFeat)
    {
        charactersSelectedFeats.add(addedFeat);
    }

    public void canAddFeatList()
    {
        int counter=0;
        System.out.println("start");
        try
        {
            for (feat feat:Database.getInstance().feats)
                if (canAddFeat(feat.getFeatName()))
                {
                    counter=counter+1;
                    System.out.println(feat.getFeatName());
                }
        }
        catch (Exception ex)
        {
            ex.printStackTrace(System.out);
        }
        System.out.println(counter +"end");
    }

    /**
     * this method checks if a feat can be added.
     * @return  true if feat can be added.
     */
    public boolean canAddFeat(String featName)
    {
        try
        {
            feat testedFeat=Database.getInstance().featsMap.get(featName);
            for (String prerequisite:testedFeat.prerequisiteFeatList)
            {
                boolean result=false;
                for (String existing:this.charactersSelectedFeats)
                {
                    if (existing.equals(prerequisite))
                    {
                        result=true;
                        break;
                    }
                }
                if (result==false)
                {
                    return false;
                }
            }
            if (Database.getInstance().featsMap.get(featName).getMinimumLevel()>this.getCalculatedAttribute("level"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getAbilityAtleast13()!=null)
            {
                for (String ability:Database.getInstance().featsMap.get(featName).getAbilityAtleast13())
                {
                    if (this.getCalculatedAttribute(ability)<13)
                    {
                        return false;
                    }
                }
            }
            if (Database.getInstance().featsMap.get(featName).getAbilityAtleast15()!=null
                    && this.getCalculatedAttribute(Database.getInstance().featsMap.get(featName).getAbilityAtleast15())<15)
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getAbilityAtleast17()!=null
                    && this.getCalculatedAttribute(Database.getInstance().featsMap.get(featName).getAbilityAtleast17())<17)
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getAbilityAtleast19()!=null
                    && this.getCalculatedAttribute(Database.getInstance().featsMap.get(featName).getAbilityAtleast19())<19)
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getMinimumBaseAttackBonus()>this.getCalculatedAttribute("baseAttackBonus"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getMinimumRideRank()>this.getCalculatedAttribute("ride"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getMinimumFighterLevel()>this.getCalculatedAttribute("fighterLevel"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getMinimumCasterLevel()>this.getCalculatedAttribute("casterLevel"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getMinimumWizardLevel()>this.getCalculatedAttribute("wizardLevel"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getAbilityToTurn()!=this.getCalculatedAttribute("abilityToTurn"))
            {
                return false;
            }
            if (Database.getInstance().featsMap.get(featName).getAbilityToWildShape()!=this.getCalculatedAttribute("abilityToWildShape"))
            {
                return false;
            }
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    /**
     * this method returns a selected calculated attribute of the character (initial+feat bonuses+skill bonuses+equipment bonuses).
     * @param  attribute The selected attribute to return.
     * @return the calculated attribute.
     */
    public Integer getCalculatedAttribute(String attribute)
    {
        calculatedCharactersAttributes.put(attribute,initialCharactersAttributes.get(attribute)+featBenefits(attribute)+equipmentBenefits(attribute)+skillBenefits(attribute));
        return calculatedCharactersAttributes.get(attribute);
    }

    /**
     * this method returns the benefit to a selected attribute due to bonuses from the characters feat.
     * @param attribute The selected attribute to return.
     * @return  bonus due to feats.
     */
    public Integer featBenefits(String attribute)
    {
        Integer attributeBonus=0;
        try
        {

            for (String feat:charactersSelectedFeats)
            {
                if (Database.getInstance().featsMap.get(feat).benefitMap.get(attribute)!=null)
                {
                    attributeBonus=attributeBonus+Database.getInstance().featsMap.get(feat).benefitMap.get(attribute);
                }
            }
            return attributeBonus;
        }
        catch(Exception ex)
        {
            return attributeBonus;
        }
    }

    /**
     * this method returns the benefit to a selected attribute due to bonuses from the characters equipment.
     * @param attribute The selected attribute to return.
     * @return  bonus due to equipment.
     */
    public Integer equipmentBenefits(String attribute)
    {
        return 0; //needs to be completed
    }

    /**
     * this method returns the benefit to a selected attribute due to bonuses from the characters skills.
     * @param attribute The selected attribute to return.
     * @return  bonus due to skills.
     */
    public Integer skillBenefits(String attribute)
    {
        return 0; //needs to be completed
    }

    /**
     * this method removes a feat from the character.
     * @param  featToRemove The feat added to the character.
     */
    public void removeFeat(String featToRemove)
    {
        charactersSelectedFeats.remove(charactersSelectedFeats.indexOf(featToRemove));
    }

    /**
     * this method returns the list of feats this character has.
     * @return  a list of feats this character has.
     */
    public ArrayList getFeatList()
    {
        return charactersSelectedFeats;
    }

    /**
     * this method prints out the list of feats this character has.
     */
    public void printFeatList()
    {
        for (int i=0; i<charactersSelectedFeats.size(); i++)
        {
            System.out.println(charactersSelectedFeats.get(i));
        }
    }

    /**
     * this method returns the amount of feats this character has.
     * @return  the amount of feats this character has.
     */
    public int getFeatAmount()
    {
        return charactersSelectedFeats.size();
    }

    /**
     * this method prints out all this character's abilitys.
     */
    public void printAllAbility()
    {
        System.out.println("your Strength is: "+getCalculatedAttribute("strength"));
        System.out.println("your Constitution is: "+getCalculatedAttribute("constitution"));
        System.out.println("your Dexterity is: "+getCalculatedAttribute("dexterity"));
        System.out.println("your Charisma is: "+getCalculatedAttribute("charisma"));
        System.out.println("your Intelligence is: "+getCalculatedAttribute("intelligence"));
        System.out.println("your Wisdom is: "+getCalculatedAttribute("wisdom"));
    }

    public String getCharName() {
        return this.charName;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
        setRaceAbilities();
        setFinalAbilities();
        setAbilitiesBonus();
    }

    private void setAbilitiesBonus() {
        initialCharactersAttributes.put("strengthBonus",(initialCharactersAttributes.get("finalStrength")+30)/2-20);
        initialCharactersAttributes.put("constitutionBonus",(initialCharactersAttributes.get("finalConstitution")+30)/2-20);
        initialCharactersAttributes.put("dexterityBonus",(initialCharactersAttributes.get("finalDexterity")+30)/2-20);
        initialCharactersAttributes.put("intelligenceBonus",(initialCharactersAttributes.get("finalIntelligence")+30)/2-20);
        initialCharactersAttributes.put("wisdomBonus",(initialCharactersAttributes.get("finalWisdom")+30)/2-20);
        initialCharactersAttributes.put("charismaBonus",(initialCharactersAttributes.get("finalCharisma")+30)/2-20);

    }

    private void setRaceAbilities() {
        switch (this.charRace){
            case "Human":
                initialCharactersAttributes.put("raceStrength",0);
                initialCharactersAttributes.put("raceConstitution",0);
                initialCharactersAttributes.put("raceDexterity",0);
                initialCharactersAttributes.put("raceIntelligence",0);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",0);
                break;

            case "Dwarf":
                initialCharactersAttributes.put("raceStrength",0);
                initialCharactersAttributes.put("raceConstitution",2);
                initialCharactersAttributes.put("raceDexterity",0);
                initialCharactersAttributes.put("raceIntelligence",0);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",-2);
                break;
            case "Elf":
                initialCharactersAttributes.put("raceStrength",0);
                initialCharactersAttributes.put("raceConstitution",-2);
                initialCharactersAttributes.put("raceDexterity",2);
                initialCharactersAttributes.put("raceIntelligence",0);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",0);
                break;
            case "Half-Elf":
                initialCharactersAttributes.put("raceStrength",0);
                initialCharactersAttributes.put("raceConstitution",0);
                initialCharactersAttributes.put("raceDexterity",0);
                initialCharactersAttributes.put("raceIntelligence",0);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",0);
                break;
            case "Gnome":
                initialCharactersAttributes.put("raceStrength",-2);
                initialCharactersAttributes.put("raceConstitution",2);
                initialCharactersAttributes.put("raceDexterity",0);
                initialCharactersAttributes.put("raceIntelligence",0);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",0);
                break;
            case "Halfling":
                initialCharactersAttributes.put("raceStrength",-2);
                initialCharactersAttributes.put("raceConstitution",0);
                initialCharactersAttributes.put("raceDexterity",2);
                initialCharactersAttributes.put("raceIntelligence",0);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",0);
                break;
            case "Half-Orc":
                initialCharactersAttributes.put("raceStrength",2);
                initialCharactersAttributes.put("raceConstitution",0);
                initialCharactersAttributes.put("raceDexterity",0);
                initialCharactersAttributes.put("raceIntelligence",-2);
                initialCharactersAttributes.put("raceWisdom",0);
                initialCharactersAttributes.put("raceCharisma",-2);
                break;
        }
    }

    private void setFinalAbilities() {
        initialCharactersAttributes.put("finalStrength",initialCharactersAttributes.get("raceStrength")+initialCharactersAttributes.get("rolledStrength"));
        initialCharactersAttributes.put("finalConstitution",initialCharactersAttributes.get("raceConstitution")+initialCharactersAttributes.get("rolledConstitution"));
        initialCharactersAttributes.put("finalDexterity",initialCharactersAttributes.get("raceDexterity")+initialCharactersAttributes.get("rolledDexterity"));
        initialCharactersAttributes.put("finalIntelligence",initialCharactersAttributes.get("raceIntelligence")+initialCharactersAttributes.get("rolledIntelligence"));
        initialCharactersAttributes.put("finalWisdom",initialCharactersAttributes.get("raceWisdom")+initialCharactersAttributes.get("rolledWisdom"));
        initialCharactersAttributes.put("finalCharisma",initialCharactersAttributes.get("raceCharisma")+initialCharactersAttributes.get("rolledCharisma"));
    }

    public int getAbility(String ability) {
        return getCalculatedAttribute(ability);
    }
}
