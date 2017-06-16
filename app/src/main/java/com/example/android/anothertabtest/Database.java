package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/10/2017.
 */

import android.widget.Switch;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static android.R.attr.src;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Loads up all data bases including feats, abilities, skills, equipment ect.
 *
 * @author (Omer Behar)
 * @version (1.0)
 */
public class Database
{
    public static CSVReader skillsReader;
    public static CSVReader crossSkillReader;
    private ArrayList<ability> abilities=new ArrayList<ability>();
    private static final String FeatFile = "feats2.csv";
//    private static final String SkillFile = "C:\\androidstudioprojects\\AnotherTabTest\\app\\src\\main\\res\\raw\\skills.csv";
//    private static final String crossSkillFile = "C:\\androidstudioprojects\\AnotherTabTest\\app\\src\\main\\res\\raw\\crossSkill.csv";
    private static final String ClassFile = "classes.csv";
    public ArrayList<feat> feats=new ArrayList<feat>();
    public Map<String,feat> featsMap=new HashMap<String,feat>();
    public ArrayList<Skill> skills=new ArrayList<Skill>();
    public Map<String,Skill> skillsMap=new HashMap<String,Skill>();
    public ArrayList<Class> classes=new ArrayList<Class>();
    public Map<String,Class> classesMap=new HashMap<String,Class>();
    private static Database _database;
    public static String gameType;
    private InputStream skillsCsv;
    private ArrayList<String> skillsList=new ArrayList<>();
    private ArrayList<String> skillsAbilityList=new ArrayList<>();
    private ArrayList<Boolean> addButtonEnableList= new ArrayList<>();
    private ArrayList<Boolean> subButtonEnableList= new ArrayList<>();
    private ArrayList<Integer> miscSkillMod= new ArrayList<>();
    private ArrayList<Integer> skillSynergiesMod= new ArrayList<>();
    public Map<String,Integer> barbarianCS=new HashMap<String,Integer>();
    public Map<String,Integer> bardCS=new HashMap<String,Integer>();
    public Map<String,Integer> clericCS=new HashMap<String,Integer>();
    public Map<String,Integer> druidCS=new HashMap<String,Integer>();
    public Map<String,Integer> fighterCS=new HashMap<String,Integer>();
    public Map<String,Integer> monkCS=new HashMap<String,Integer>();
    public Map<String,Integer> paladinCS=new HashMap<String,Integer>();
    public Map<String,Integer> rangerCS=new HashMap<String,Integer>();
    public Map<String,Integer> rogueCS=new HashMap<String,Integer>();
    public Map<String,Integer> sorcererCS=new HashMap<String,Integer>();
    public Map<String,Integer> wizardCS=new HashMap<String,Integer>();


    /**
     * this method returns the single instance of a database.
     *
     * @return     database instance
     */
    public static Database getInstance() throws Exception
    {
        if (_database==null)
        {
            if (gameType==null)
            {
                throw new Exception("you must initialize Database.gameType before using the database");
            }
            _database=new Database(gameType);
        }
        return _database;
    }

    /**
     * Constructs a database according to a selected game type.
     */
    private Database(String gameType)
    {
        //         public static dataBaseLoader;

        switch (gameType)
        {
            case "D20V3.5":
                try
                {
//                    this.loadFeatsD20V35();
                    this.loadSkillsD20V35();
                    this.loadClassesD20V35();
                }
                catch(IOException ioe)
                {
                }
                //this.loadSkillsD20V35();
                //this.loadAbilitiesD20V35();
                //loadEquipmentD20V35();
                break;
        }
    }


    /**
     * Loads D20V3.5 Feat list from a csv file into an ArrayList called feats and a Map called featsMap <key=feat name, value=feat object>
     *
     */
    public void loadFeatsD20V35() throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader(FeatFile));
        String[] nextLine=reader.readNext();
        while ((nextLine = reader.readNext()) != null)
        {
            String featName=nextLine[0].trim();
            String featDescription=nextLine[1];
            String featPrerequisitesDescription=nextLine[2];
            String prerequisiteFeats=nextLine[3].trim();
            String benefitDescription=nextLine[4];
            int isFighterFeat = Integer.parseInt(nextLine[5]);
            int minimumLevel = Integer.parseInt(nextLine[14]);
            String abilityAtleast13=nextLine[15].trim();
            String abilityAtleast15=nextLine[16].trim();
            String abilityAtleast17=nextLine[17].trim();
            String abilityAtleast19=nextLine[18].trim();
            int minimumBaseAttackBonus = Integer.parseInt(nextLine[19]);
            int minimumRideRank = Integer.parseInt(nextLine[20]);
            int minimumFighterLevel = Integer.parseInt(nextLine[21]);
            int minimumCasterLevel = Integer.parseInt(nextLine[22]);
            int minimumWizardLevel = Integer.parseInt(nextLine[23]);
            int abilityToTurn = Integer.parseInt(nextLine[24]);
            int abilityToWildShape = Integer.parseInt(nextLine[25]);
            int turningLevel=Integer.parseInt(nextLine[6]);
            int hitPoints=Integer.parseInt(nextLine[7]);
            String plus2Skill=nextLine[8].trim();
            String plus2Save=nextLine[10].trim();
            int dodgeBonus=Integer.parseInt(nextLine[11]);
            int spellCheck=Integer.parseInt(nextLine[12]);
            int initiative=Integer.parseInt(nextLine[13]);
            feats.add(new feat(featName, featDescription, featPrerequisitesDescription, prerequisiteFeats, benefitDescription, isFighterFeat, minimumLevel, abilityAtleast13
                    , abilityAtleast15, abilityAtleast17, abilityAtleast19, minimumBaseAttackBonus, minimumRideRank, minimumFighterLevel, minimumCasterLevel, minimumWizardLevel,
                    abilityToTurn, abilityToWildShape, turningLevel, hitPoints, plus2Skill, plus2Save, dodgeBonus, spellCheck, initiative));
        }
        for (feat tempFeat:feats)
        {
            featsMap.put(tempFeat.getFeatName(),tempFeat);
        }
    }
    /**
     * Loads D20V3.5 Skill list from a csv file into an ArrayList called skills and a Map called skillsMap <key=skill name, value=skill object>
     *
     */
    public void loadSkillsD20V35() throws IOException
    {
//        CSVReader reader = new CSVReader(new InputStreamReader(skillsCsv));
        String[] nextLine=skillsReader.readNext();
        while ((nextLine = skillsReader.readNext()) != null)
        {
            String skillName=nextLine[0].trim();
            String skillAbility=nextLine[1].trim();
            int untrained=Integer.parseInt(nextLine[2]);
            int armorCheckPenalty=Integer.parseInt(nextLine[3]);
            skills.add(new Skill(skillName, skillAbility, untrained, armorCheckPenalty));
        }
        for (Skill tempSkill:skills)
        {
            this.skillsList.add(tempSkill.getSkillName());
            this.skillsAbilityList.add(tempSkill.getSkillAbility());
            this.addButtonEnableList.add(true);
            this.subButtonEnableList.add(false);
            this.skillSynergiesMod.add(0);
            this.miscSkillMod.add(0);
            skillsMap.put(tempSkill.getSkillName(),tempSkill);
        }
        String[] nextLineCross=crossSkillReader.readNext();
        while ((nextLineCross = crossSkillReader.readNext()) != null)
        {
            String skillName=nextLineCross[0].trim().toLowerCase();
            barbarianCS.put(skillName,Integer.parseInt(nextLineCross[1]));
            bardCS.put(skillName,Integer.parseInt(nextLineCross[2]));
            clericCS.put(skillName,Integer.parseInt(nextLineCross[3]));
            druidCS.put(skillName,Integer.parseInt(nextLineCross[4]));
            fighterCS.put(skillName,Integer.parseInt(nextLineCross[5]));
            monkCS.put(skillName,Integer.parseInt(nextLineCross[6]));
            paladinCS.put(skillName,Integer.parseInt(nextLineCross[7]));
            rangerCS.put(skillName,Integer.parseInt(nextLineCross[8]));
            rogueCS.put(skillName,Integer.parseInt(nextLineCross[9]));
            sorcererCS.put(skillName,Integer.parseInt(nextLineCross[10]));
        }

    }

    /**
     * this method loads all of the abilities of the D20 V3.5 game
     *
     *
     *
     */
    public void loadAbilitiesD20V35()
    {

        ability strength=new ability("Strength");
        ability constitution=new ability("Constitution");
        ability dexterity=new ability("Dexterity");
        ability charisma=new ability("Charisma");
        ability inteligance=new ability("Inteligance");
        ability wisdom=new ability("Wisdom");
        abilities.add(strength);
        abilities.add(constitution);
        abilities.add(dexterity);
        abilities.add(charisma);
        abilities.add(inteligance);
        abilities.add(wisdom);
    }


    /**
     * this methods returns the list array of abilities
     *
     * @return     the list array of abilities.
     */
    public ArrayList<ability> getAbilitiesArrayList()
    {
        // put your code here
        return abilities;
    }

    /**
     * Loads D20V3.5 Class list from a csv file into an ArrayList called classes and a Map called classesMap <key=class name, value=class object>
     *
     */
    public void loadClassesD20V35() throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader(ClassFile));
        String[] nextLine=reader.readNext();
        while ((nextLine = reader.readNext()) != null)
        {
            String className=nextLine[0].trim();
            //             String keyStat=nextLine[1].trim();
            //             int untrained=Integer.parseInt(nextLine[2]);
            //             int armorCheckPenalty=Integer.parseInt(nextLine[3]);
            String LoadedClassFile = className+".csv";
            CSVReader reader2 = new CSVReader(new FileReader(LoadedClassFile));
            String[] nextLine2=reader2.readNext();
            ArrayList<Integer> classBaseAttackBonus = new ArrayList<Integer>();
            ArrayList<Integer> classSecondBaseAttackBonus = new ArrayList<Integer>();
            ArrayList<Integer> classThirdBaseAttackBonus = new ArrayList<Integer>();
            ArrayList<Integer> classFourthBaseAttackBonus = new ArrayList<Integer>();
            ArrayList<Integer> classFortitudeSave = new ArrayList<Integer>();
            ArrayList<Integer> classReflexSave = new ArrayList<Integer>();
            ArrayList<Integer> classWillSave = new ArrayList<Integer>();
            while ((nextLine2 = reader2.readNext()) != null)
            {
                classBaseAttackBonus.add(Integer.parseInt(nextLine2[1]));
                classSecondBaseAttackBonus.add(Integer.parseInt(nextLine2[2]));
                classThirdBaseAttackBonus.add(Integer.parseInt(nextLine2[3]));
                classFourthBaseAttackBonus.add(Integer.parseInt(nextLine2[4]));
                classFortitudeSave.add(Integer.parseInt(nextLine2[5]));
                classReflexSave.add(Integer.parseInt(nextLine2[6]));
                classWillSave.add(Integer.parseInt(nextLine2[7]));
            }
            classes.add(new Class(className, classBaseAttackBonus, classSecondBaseAttackBonus, classThirdBaseAttackBonus, classFourthBaseAttackBonus, classFortitudeSave
                    , classReflexSave, classWillSave));
        }
        for (Class tempClass:classes)
        {
            classesMap.put(tempClass.getClassName(),tempClass);
        }
    }

    public void setData(InputStream skillsCsv) {
        this.skillsCsv=skillsCsv;
    }


    public ArrayList<String> getSkillsList() {
        return this.skillsList;
    }

    public ArrayList<String> getSkillsAbilityList() {
        return skillsAbilityList;
    }

    public ArrayList<Boolean> getAddButtonEnable() { return addButtonEnableList;
    }
    public void setAddButtonEnable(int position, Boolean state) { addButtonEnableList.set(position,state);
    }
    public void setAllAddButtonEnable(Boolean state){
        for (int i=0; i<addButtonEnableList.size(); i++){
            addButtonEnableList.set(i,state);
        }
    }
    public ArrayList<Boolean> getSubButtonEnable() { return subButtonEnableList;
    }
    public void setSubButtonEnable(int position, Boolean state) { subButtonEnableList.set(position,state);
    }
    public void setAllSubButtonEnable(Boolean state){
        for (int i=0; i<subButtonEnableList.size(); i++){
            subButtonEnableList.set(i,state);
        }
    }

    public void setMiscSkillMod() {
        for (int i=0; i<miscSkillMod.size(); i++){
            miscSkillMod.set(i,skillSynergiesMod.get(i));
        }
    }
    public void setSkillSynergiesMod(String skill, boolean b) {
        if (b == true) {
            switch (skill) {
                case "bluff":
                    skillSynergiesMod.set(skillsList.indexOf("Diplomacy"), 2);
            }
        }
        else {
            switch (skill){
                case "bluff":
                    skillSynergiesMod.set(skillsList.indexOf("Diplomacy"), 0);
            }
        }
    }

    public ArrayList<Integer> getMiscSkillMod() {
        return miscSkillMod;
    }

    public Map<String, Integer> getCrossClassList(String characterClass) {
        Map<String, Integer> result=null;
        switch (characterClass.toLowerCase()){
            case "barbarian":
                result= barbarianCS;
                break;
            case "bard":
                result= bardCS;
                break;
            case "cleric":
                result= clericCS;
                break;
            case "druid":
                result= druidCS;
                break;
            case "fighter":
                result= fighterCS;
                break;
            case "monk":
                result= monkCS;
                break;
            case "paladin":
                result= paladinCS;
                break;
            case "ranger":
                result= rangerCS;
                break;
            case "rogue":
                result= rogueCS;
                break;
            case "sorcerer":
                result= sorcererCS;
                break;
            case "wizard":
                result= wizardCS;
                break;
        }
        return result;
    }
}
