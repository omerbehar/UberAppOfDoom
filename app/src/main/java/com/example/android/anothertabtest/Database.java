package com.example.android.anothertabtest;

/**
 * Created by Omer's on 3/10/2017.
 */

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import static android.R.attr.src;

/**
 * Loads up all data bases including feats, abilities, skills, equipment ect.
 *
 * @author (Omer Behar)
 * @version (1.0)
 */
public class Database
{
    public static CSVReader skillsReader;
    private ArrayList<ability> abilities=new ArrayList<ability>();
    private static final String FeatFile = "feats2.csv";
    private static final String SkillFile = "C:\\androidstudioprojects\\AnotherTabTest\\app\\src\\main\\res\\raw\\skills.csv";
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
            skillsMap.put(tempSkill.getSkillName(),tempSkill);
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
}
