package com.example.android.anothertabtest;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;

import static com.example.android.anothertabtest.MainActivity.dubo;
import static com.example.android.anothertabtest.R.id.tester;

/**
 * Created by Omer's on 2/28/2017.
 */

public class Tab1Main extends Fragment {
     View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
         rootView = inflater.inflate(R.layout.tab1main, container, false);
//            final TabHost mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
        Spinner classSpinner = (Spinner)rootView.findViewById(R.id.class_spinner);

            final TextView skillPointsTextView = (TextView) rootView.findViewById(R.id.skill_points);
        ArrayAdapter<CharSequence> classSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.class_array, android.R.layout.simple_spinner_item);
        classSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classSpinnerAdapter);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Spinner characterClassSpinner = (Spinner) rootView.findViewById(R.id.class_spinner);
                String characterClass = characterClassSpinner.getSelectedItem().toString();
                if (dubo.classList.size()==0){
                    dubo.classList.add(characterClass);
                    skillPointsTextView.setText(""+dubo.calculateRemainingSkillPoints());
                    ((MainActivity)getActivity()).changeSkillTabTitle(dubo.calculateRemainingSkillPoints());
                    dubo.setClassList(characterClass);
//                    for (int i=0; i<Database.getInstance().getSkillsList().size();i++){
//                        dubo.crossClassList.put()
//                    }
                }
                else {
                    dubo.classList.set(0, characterClass);
                    skillPointsTextView.setText(""+dubo.calculateRemainingSkillPoints());
                    ((MainActivity)getActivity()).changeSkillTabTitle(dubo.calculateRemainingSkillPoints());
                    dubo.setClassList(characterClass);
                }
                tester(dubo.classList.get(0));
            }

                private void tester(String s) {
                    TextView testerTextView = (TextView) rootView.findViewById(R.id.tester);
                    testerTextView.setText(s);
                }
                @Override
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });
            final EditText charName = (EditText)rootView.findViewById(R.id.char_name_box);

            charName.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String charName1 = charName.getText().toString();
                    dubo.setCharName(charName1);
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });
            Spinner raceSpinner = (Spinner)rootView.findViewById(R.id.race_spinner);
            ArrayAdapter<CharSequence> raceSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.race_array, android.R.layout.simple_spinner_item);
            raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            raceSpinner.setAdapter(raceSpinnerAdapter);
            raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    Spinner characterRaceSpinner = (Spinner) rootView.findViewById(R.id.race_spinner);
                    String characterRace = characterRaceSpinner.getSelectedItem().toString();
                    dubo.setCharRace(characterRace);
                    ((MainActivity)getActivity()).changeSkillTabTitle(dubo.calculateRemainingSkillPoints());
                    TextView raceConText = (TextView) rootView.findViewById(R.id.constitution_race);
                    raceConText.setText(""+dubo.initialCharactersAttributes.get("raceConstitution"));
                    TextView raceStrText = (TextView) rootView.findViewById(R.id.strength_race);
                    raceStrText.setText(""+dubo.initialCharactersAttributes.get("raceStrength"));
                    TextView raceDexText = (TextView) rootView.findViewById(R.id.dexterity_race);
                    raceDexText.setText(""+dubo.initialCharactersAttributes.get("raceDexterity"));
                    TextView raceIntText = (TextView) rootView.findViewById(R.id.intelligence_race);
                    raceIntText.setText(""+dubo.initialCharactersAttributes.get("raceIntelligence"));
                    TextView raceWisText = (TextView) rootView.findViewById(R.id.wisdom_race);
                    raceWisText.setText(""+dubo.initialCharactersAttributes.get("raceWisdom"));
                    TextView raceChaText = (TextView) rootView.findViewById(R.id.charisma_race);
                    raceChaText.setText(""+dubo.initialCharactersAttributes.get("raceCharisma"));
                    TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
                    finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
                    TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
                    finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
                    TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
                    finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
                    TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
                    finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
                    TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
                    finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
                    TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
                    finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));

                }

                private void tester(String s) {
                    TextView testerTextView = (TextView) rootView.findViewById(R.id.tester);
                    testerTextView.setText(s);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {}
            });
            final EditText strengthScore = (EditText)rootView.findViewById(R.id.strength_score);

            strengthScore.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String strengthScoreString = strengthScore.getText().toString();
                    if (strengthScoreString.matches("")){
                        dubo.setRolledAbility("rolledStrength",0);
                        TextView strengthBonus = (TextView) rootView.findViewById(R.id.strength_bonus);
                        strengthBonus.setText(""+dubo.initialCharactersAttributes.get("strengthBonus"));
                        TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
                        finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
                    }
                    else {
                        int strengthScoreInt = Integer.parseInt(strengthScoreString);
                        dubo.setRolledAbility("rolledStrength",strengthScoreInt);
                        TextView strengthBonus = (TextView) rootView.findViewById(R.id.strength_bonus);
                        strengthBonus.setText(""+dubo.initialCharactersAttributes.get("strengthBonus"));
                        TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
                        finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });
            final EditText dexterityScore = (EditText)rootView.findViewById(R.id.dexterity_score);

            dexterityScore.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String dexterityScoreString = dexterityScore.getText().toString();
                    if (dexterityScoreString.matches("")){
                        dubo.setRolledAbility("rolledDexterity",0);
                        TextView dexterityBonus = (TextView) rootView.findViewById(R.id.dexterity_bonus);
                        dexterityBonus.setText(""+dubo.initialCharactersAttributes.get("dexterityBonus"));
                        TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
                        finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
                    }
                    else {
                        int dexterityScoreInt = Integer.parseInt(dexterityScoreString);
                        dubo.setRolledAbility("rolledDexterity",dexterityScoreInt);
                        TextView dexterityBonus = (TextView) rootView.findViewById(R.id.dexterity_bonus);
                        dexterityBonus.setText(""+dubo.initialCharactersAttributes.get("dexterityBonus"));
                        TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
                        finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });
            final EditText constitutionScore = (EditText)rootView.findViewById(R.id.constitution_score);

            constitutionScore.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String constitutionScoreString = constitutionScore.getText().toString();
                    if (constitutionScoreString.matches("")){
                        dubo.setRolledAbility("rolledConstitution",0);
                        TextView constitutionBonus = (TextView) rootView.findViewById(R.id.constitution_bonus);
                        constitutionBonus.setText(""+dubo.initialCharactersAttributes.get("constitutionBonus"));
                        TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
                        finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
                    }
                    else {
                        int constitutionScoreInt = Integer.parseInt(constitutionScoreString);
                        dubo.setRolledAbility("rolledConstitution",constitutionScoreInt);
                        TextView constitutionBonus = (TextView) rootView.findViewById(R.id.constitution_bonus);
                        constitutionBonus.setText(""+dubo.initialCharactersAttributes.get("constitutionBonus"));
                        TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
                        finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });
            final EditText intelligenceScore = (EditText)rootView.findViewById(R.id.intelligence_score);

            intelligenceScore.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String intelligenceScoreString = intelligenceScore.getText().toString();
                    if (intelligenceScoreString.matches("")){
                        dubo.setRolledAbility("rolledIntelligence",0);
                        TextView intelligenceBonus = (TextView) rootView.findViewById(R.id.intelligence_bonus);
                        intelligenceBonus.setText(""+dubo.initialCharactersAttributes.get("intelligenceBonus"));
                        TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
                        finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
                    }
                    else {
                        int intelligenceScoreInt = Integer.parseInt(intelligenceScoreString);
                        dubo.setRolledAbility("rolledIntelligence",intelligenceScoreInt);
                        TextView intelligenceBonus = (TextView) rootView.findViewById(R.id.intelligence_bonus);
                        intelligenceBonus.setText(""+dubo.initialCharactersAttributes.get("intelligenceBonus"));
                        TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
                        finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });
            final EditText wisdomScore = (EditText)rootView.findViewById(R.id.wisdom_score);

            wisdomScore.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String wisdomScoreString = wisdomScore.getText().toString();
                    if (wisdomScoreString.matches("")){
                        dubo.setRolledAbility("rolledWisdom",0);
                        TextView wisdomBonus = (TextView) rootView.findViewById(R.id.wisdom_bonus);
                        wisdomBonus.setText(""+dubo.initialCharactersAttributes.get("wisdomBonus"));
                        TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
                        finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
                    }
                    else {
                        int wisdomScoreInt = Integer.parseInt(wisdomScoreString);
                        dubo.setRolledAbility("wisdom",wisdomScoreInt);
                        TextView wisdomBonus = (TextView) rootView.findViewById(R.id.wisdom_bonus);
                        wisdomBonus.setText(""+dubo.initialCharactersAttributes.get("wisdomBonus"));
                        TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
                        finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });

            Button setRandomAbilities = (Button)rootView.findViewById(R.id.set_random_abilities);
            setRandomAbilities.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    dubo.setRandomAbility();
                    TextView strengthScore = (TextView) rootView.findViewById(R.id.strength_score);
                    strengthScore.setText(""+dubo.initialCharactersAttributes.get("rolledStrength"));
                    TextView dexterityScore = (TextView) rootView.findViewById(R.id.dexterity_score);
                    dexterityScore.setText(""+dubo.initialCharactersAttributes.get("rolledDexterity"));
                    TextView constitutionScore = (TextView) rootView.findViewById(R.id.constitution_score);
                    constitutionScore.setText(""+dubo.initialCharactersAttributes.get("rolledConstitution"));
                    TextView intelligenceScore = (TextView) rootView.findViewById(R.id.intelligence_score);
                    intelligenceScore.setText(""+dubo.initialCharactersAttributes.get("rolledIntelligence"));
                    TextView wisdomScore = (TextView) rootView.findViewById(R.id.wisdom_score);
                    wisdomScore.setText(""+dubo.initialCharactersAttributes.get("rolledWisdom"));
                    TextView charismaScore = (TextView) rootView.findViewById(R.id.charisma_score);
                    charismaScore.setText(""+dubo.initialCharactersAttributes.get("rolledCharisma"));
                    TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
                    finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
                    TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
                    finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
                    TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
                    finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
                    TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
                    finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
                    TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
                    finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
                    TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
                    finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
                }
            });

            final EditText charismaScore = (EditText)rootView.findViewById(R.id.charisma_score);

            charismaScore.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {
                    String charismaScoreString = charismaScore.getText().toString();
                    if (charismaScoreString.matches("")){
                        dubo.setRolledAbility("rolledCharisma",0);
                        TextView charismaBonus = (TextView) rootView.findViewById(R.id.charisma_bonus);
                        charismaBonus.setText(""+dubo.initialCharactersAttributes.get("charismaBonus"));
                        TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
                        finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
                    }
                    else {
                        int charismaScoreInt = Integer.parseInt(charismaScoreString);
                        dubo.setRolledAbility("rolledCharisma",charismaScoreInt);
                        TextView charismaBonus = (TextView) rootView.findViewById(R.id.charisma_bonus);
                        charismaBonus.setText(""+dubo.initialCharactersAttributes.get("charismaBonus"));
                        TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
                        finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
                    }
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start,
                                              int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start,
                                          int before, int count) {
                }
            });

        return rootView;
    }
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser&&rootView!=null) {
////            ((MainActivity)getActivity()).changeTabTitle(1,1);
//
////            TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
////
////            tabLayout.getTabAt(0).setText("test");
////            final TabHost mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
//            Spinner classSpinner = (Spinner)rootView.findViewById(R.id.class_spinner);
//            final TextView skillPointsTextView = (TextView) rootView.findViewById(R.id.skill_points);
////            TabLayout.Tab tab = tabLayout.getTabAt(0);
////            tab.setText("title");
////            mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
////            TextView skillTabTextView = (TextView)
//            ArrayAdapter<CharSequence> classSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
//                    R.array.class_array, android.R.layout.simple_spinner_item);
//            classSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            classSpinner.setAdapter(classSpinnerAdapter);
//            classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//            {
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//                {
//                    Spinner characterClassSpinner = (Spinner) rootView.findViewById(R.id.class_spinner);
//                    String characterClass = characterClassSpinner.getSelectedItem().toString();
//                    if (dubo.classList.size()==0){
//                        dubo.classList.add(characterClass);
//                        skillPointsTextView.setText(""+dubo.calculateMaxSkillPoints());
//
////                    ((TextView)mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title)).setText("SKILLS ("+dubo.calculateMaxSkillPoints()+")");
//                    }
//                    else {
//                        dubo.classList.set(0, characterClass);
//                        skillPointsTextView.setText(""+dubo.calculateMaxSkillPoints());
////                    ((TextView)mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title)).setText("SKILLS ("+dubo.calculateMaxSkillPoints()+")");
//                    }
//                    tester(dubo.classList.get(0));
//                }
//
//                private void tester(String s) {
//                    TextView testerTextView = (TextView) rootView.findViewById(R.id.tester);
//                    testerTextView.setText(s);
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent)
//                {}
//            });
//            final EditText charName = (EditText)rootView.findViewById(R.id.char_name_box);
//
//            charName.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String charName1 = charName.getText().toString();
//                    dubo.setCharName(charName1);
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
//            Spinner raceSpinner = (Spinner)rootView.findViewById(R.id.race_spinner);
//            ArrayAdapter<CharSequence> raceSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(),
//                    R.array.race_array, android.R.layout.simple_spinner_item);
//            raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            raceSpinner.setAdapter(raceSpinnerAdapter);
//            raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//            {
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//                {
//                    Spinner characterRaceSpinner = (Spinner) rootView.findViewById(R.id.race_spinner);
//                    String characterRace = characterRaceSpinner.getSelectedItem().toString();
//                    dubo.setCharRace(characterRace);
//                    TextView raceConText = (TextView) rootView.findViewById(R.id.constitution_race);
//                    raceConText.setText(""+dubo.initialCharactersAttributes.get("raceConstitution"));
//                    TextView raceStrText = (TextView) rootView.findViewById(R.id.strength_race);
//                    raceStrText.setText(""+dubo.initialCharactersAttributes.get("raceStrength"));
//                    TextView raceDexText = (TextView) rootView.findViewById(R.id.dexterity_race);
//                    raceDexText.setText(""+dubo.initialCharactersAttributes.get("raceDexterity"));
//                    TextView raceIntText = (TextView) rootView.findViewById(R.id.intelligence_race);
//                    raceIntText.setText(""+dubo.initialCharactersAttributes.get("raceIntelligence"));
//                    TextView raceWisText = (TextView) rootView.findViewById(R.id.wisdom_race);
//                    raceWisText.setText(""+dubo.initialCharactersAttributes.get("raceWisdom"));
//                    TextView raceChaText = (TextView) rootView.findViewById(R.id.charisma_race);
//                    raceChaText.setText(""+dubo.initialCharactersAttributes.get("raceCharisma"));
//                    TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
//                    finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
//                    TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
//                    finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
//                    TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
//                    finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
//                    TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
//                    finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
//                    TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
//                    finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
//                    TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
//                    finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
//
//                }
//
//                private void tester(String s) {
//                    TextView testerTextView = (TextView) rootView.findViewById(R.id.tester);
//                    testerTextView.setText(s);
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent)
//                {}
//            });
//            final EditText strengthScore = (EditText)rootView.findViewById(R.id.strength_score);
//
//            strengthScore.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String strengthScoreString = strengthScore.getText().toString();
//                    if (strengthScoreString.matches("")){
//                        dubo.setRolledAbility("rolledStrength",0);
//                        TextView strengthBonus = (TextView) rootView.findViewById(R.id.strength_bonus);
//                        strengthBonus.setText(""+dubo.initialCharactersAttributes.get("strengthBonus"));
//                        TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
//                        finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
//                    }
//                    else {
//                        int strengthScoreInt = Integer.parseInt(strengthScoreString);
//                        dubo.setRolledAbility("rolledStrength",strengthScoreInt);
//                        TextView strengthBonus = (TextView) rootView.findViewById(R.id.strength_bonus);
//                        strengthBonus.setText(""+dubo.initialCharactersAttributes.get("strengthBonus"));
//                        TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
//                        finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
//                    }
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
//            final EditText dexterityScore = (EditText)rootView.findViewById(R.id.dexterity_score);
//
//            dexterityScore.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String dexterityScoreString = dexterityScore.getText().toString();
//                    if (dexterityScoreString.matches("")){
//                        dubo.setRolledAbility("rolledDexterity",0);
//                        TextView dexterityBonus = (TextView) rootView.findViewById(R.id.dexterity_bonus);
//                        dexterityBonus.setText(""+dubo.initialCharactersAttributes.get("dexterityBonus"));
//                        TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
//                        finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
//                    }
//                    else {
//                        int dexterityScoreInt = Integer.parseInt(dexterityScoreString);
//                        dubo.setRolledAbility("rolledDexterity",dexterityScoreInt);
//                        TextView dexterityBonus = (TextView) rootView.findViewById(R.id.dexterity_bonus);
//                        dexterityBonus.setText(""+dubo.initialCharactersAttributes.get("dexterityBonus"));
//                        TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
//                        finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
//                    }
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
//            final EditText constitutionScore = (EditText)rootView.findViewById(R.id.constitution_score);
//
//            constitutionScore.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String constitutionScoreString = constitutionScore.getText().toString();
//                    if (constitutionScoreString.matches("")){
//                        dubo.setRolledAbility("rolledConstitution",0);
//                        TextView constitutionBonus = (TextView) rootView.findViewById(R.id.constitution_bonus);
//                        constitutionBonus.setText(""+dubo.initialCharactersAttributes.get("constitutionBonus"));
//                        TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
//                        finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
//                    }
//                    else {
//                        int constitutionScoreInt = Integer.parseInt(constitutionScoreString);
//                        dubo.setRolledAbility("rolledConstitution",constitutionScoreInt);
//                        TextView constitutionBonus = (TextView) rootView.findViewById(R.id.constitution_bonus);
//                        constitutionBonus.setText(""+dubo.initialCharactersAttributes.get("constitutionBonus"));
//                        TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
//                        finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
//                    }
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
//            final EditText intelligenceScore = (EditText)rootView.findViewById(R.id.intelligence_score);
//
//            intelligenceScore.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String intelligenceScoreString = intelligenceScore.getText().toString();
//                    if (intelligenceScoreString.matches("")){
//                        dubo.setRolledAbility("rolledIntelligence",0);
//                        TextView intelligenceBonus = (TextView) rootView.findViewById(R.id.intelligence_bonus);
//                        intelligenceBonus.setText(""+dubo.initialCharactersAttributes.get("intelligenceBonus"));
//                        TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
//                        finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
//                    }
//                    else {
//                        int intelligenceScoreInt = Integer.parseInt(intelligenceScoreString);
//                        dubo.setRolledAbility("rolledIntelligence",intelligenceScoreInt);
//                        TextView intelligenceBonus = (TextView) rootView.findViewById(R.id.intelligence_bonus);
//                        intelligenceBonus.setText(""+dubo.initialCharactersAttributes.get("intelligenceBonus"));
//                        TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
//                        finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
//                    }
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
//            final EditText wisdomScore = (EditText)rootView.findViewById(R.id.wisdom_score);
//
//            wisdomScore.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String wisdomScoreString = wisdomScore.getText().toString();
//                    if (wisdomScoreString.matches("")){
//                        dubo.setRolledAbility("rolledWisdom",0);
//                        TextView wisdomBonus = (TextView) rootView.findViewById(R.id.wisdom_bonus);
//                        wisdomBonus.setText(""+dubo.initialCharactersAttributes.get("wisdomBonus"));
//                        TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
//                        finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
//                    }
//                    else {
//                        int wisdomScoreInt = Integer.parseInt(wisdomScoreString);
//                        dubo.setRolledAbility("wisdom",wisdomScoreInt);
//                        TextView wisdomBonus = (TextView) rootView.findViewById(R.id.wisdom_bonus);
//                        wisdomBonus.setText(""+dubo.initialCharactersAttributes.get("wisdomBonus"));
//                        TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
//                        finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
//                    }
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
//
//            Button setRandomAbilities = (Button)rootView.findViewById(R.id.set_random_abilities);
//            setRandomAbilities.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v)
//                {
//                    dubo.setRandomAbility();
//                    TextView strengthScore = (TextView) rootView.findViewById(R.id.strength_score);
//                    strengthScore.setText(""+dubo.initialCharactersAttributes.get("rolledStrength"));
//                    TextView dexterityScore = (TextView) rootView.findViewById(R.id.dexterity_score);
//                    dexterityScore.setText(""+dubo.initialCharactersAttributes.get("rolledDexterity"));
//                    TextView constitutionScore = (TextView) rootView.findViewById(R.id.constitution_score);
//                    constitutionScore.setText(""+dubo.initialCharactersAttributes.get("rolledConstitution"));
//                    TextView intelligenceScore = (TextView) rootView.findViewById(R.id.intelligence_score);
//                    intelligenceScore.setText(""+dubo.initialCharactersAttributes.get("rolledIntelligence"));
//                    TextView wisdomScore = (TextView) rootView.findViewById(R.id.wisdom_score);
//                    wisdomScore.setText(""+dubo.initialCharactersAttributes.get("rolledWisdom"));
//                    TextView charismaScore = (TextView) rootView.findViewById(R.id.charisma_score);
//                    charismaScore.setText(""+dubo.initialCharactersAttributes.get("rolledCharisma"));
//                    TextView finalConText = (TextView) rootView.findViewById(R.id.constitution_final);
//                    finalConText.setText(""+dubo.initialCharactersAttributes.get("finalConstitution"));
//                    TextView finalStrText = (TextView) rootView.findViewById(R.id.strength_final);
//                    finalStrText.setText(""+dubo.initialCharactersAttributes.get("finalStrength"));
//                    TextView finalDexText = (TextView) rootView.findViewById(R.id.dexterity_final);
//                    finalDexText.setText(""+dubo.initialCharactersAttributes.get("finalDexterity"));
//                    TextView finalIntText = (TextView) rootView.findViewById(R.id.intelligence_final);
//                    finalIntText.setText(""+dubo.initialCharactersAttributes.get("finalIntelligence"));
//                    TextView finalWisText = (TextView) rootView.findViewById(R.id.wisdom_final);
//                    finalWisText.setText(""+dubo.initialCharactersAttributes.get("finalWisdom"));
//                    TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
//                    finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
//                }
//            });
//
//            final EditText charismaScore = (EditText)rootView.findViewById(R.id.charisma_score);
//
//            charismaScore.addTextChangedListener(new TextWatcher() {
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    String charismaScoreString = charismaScore.getText().toString();
//                    if (charismaScoreString.matches("")){
//                        dubo.setRolledAbility("rolledCharisma",0);
//                        TextView charismaBonus = (TextView) rootView.findViewById(R.id.charisma_bonus);
//                        charismaBonus.setText(""+dubo.initialCharactersAttributes.get("charismaBonus"));
//                        TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
//                        finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
//                    }
//                    else {
//                        int charismaScoreInt = Integer.parseInt(charismaScoreString);
//                        dubo.setRolledAbility("rolledCharisma",charismaScoreInt);
//                        TextView charismaBonus = (TextView) rootView.findViewById(R.id.charisma_bonus);
//                        charismaBonus.setText(""+dubo.initialCharactersAttributes.get("charismaBonus"));
//                        TextView finalChaText = (TextView) rootView.findViewById(R.id.charisma_final);
//                        finalChaText.setText(""+dubo.initialCharactersAttributes.get("finalCharisma"));
//                    }
//                }
//
//                @Override
//                public void beforeTextChanged(CharSequence s, int start,
//                                              int count, int after) {
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start,
//                                          int before, int count) {
//                }
//            });
////            TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
//
//        }
//        else{
//            // fragment is no longer visible
//        }
//        }


}
