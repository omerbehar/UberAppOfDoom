package com.example.android.anothertabtest;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.opencsv.CSVReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static com.example.android.anothertabtest.R.raw.crossskill;
import static com.example.android.anothertabtest.R.raw.skills;

public class MainActivity extends AppCompatActivity implements characterChangeListener {



    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public static Character dubo;// = new Character("");
    private ArrayList<Skill> skillsArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this.getApplicationContext());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(1);

        Database.gameType = "D20V3.5";
        CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(skills)));
        Database.skillsReader = reader;
        CSVReader crossSkillReader = new CSVReader(new InputStreamReader(getResources().openRawResource(crossskill)));
        Database.crossSkillReader = crossSkillReader;
//        InputStream skillsCsv = getResources().openRawResource(skills);
//        try {
//            Database.getInstance().setData(skillsCsv);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        dubo = new Character(this);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu_gallery);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_menu_manage);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_menu_send);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_equipment);
//        mViewPager.setOnPageChangeListener(new ViewPager.onPageChangeListener());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//        CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(skills)));
//        try {
//            String[] nextLine=reader.readNext();
//            while ((nextLine = reader.readNext()) != null)
//            {
//                String skillName=nextLine[0].trim();
//                String keyStat=nextLine[1].trim();
//                int untrained=Integer.parseInt(nextLine[2]);
//                int armorCheckPenalty=Integer.parseInt(nextLine[3]);
//
//                skillsArray.add(new Skill(skillName, keyStat, untrained, armorCheckPenalty));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void changeSkillTabTitle(int number){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (number==0) tabLayout.getTabAt(1).setText("SKILLS");
        else tabLayout.getTabAt(1).setText("SKILLS ("+number+")");
    }
    public void testButton(View view) {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.getTabAt(3).setText("test");
        TextView characterNameTextView = (TextView) findViewById(R.id.char_name_box);
        String characterName = characterNameTextView.getText().toString();
        Spinner characterClassSpinner = (Spinner) findViewById(R.id.class_spinner);
        String characterClass = characterClassSpinner.getSelectedItem().toString();
        String test=characterName+" "+ characterClass;
        tester(test);
        Scanner sc = new Scanner(System.in);
        dubo.setRandomAbility();
        dubo.levelUp(1);
        System.out.println(dubo.getCalculatedAttribute("hitPoints"));

        System.out.println(dubo.getCalculatedAttribute("hitPoints"));
        for (Map.Entry<String, Integer> entry : dubo.calculatedCharactersAttributes.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        dubo.printCharacterName();
        for (Map.Entry<String, Integer> entry : dubo.initialCharactersAttributes.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    private void tester(String a) {

        TextView testerTextView = (TextView) findViewById(R.id.tester);
        testerTextView.setText(a);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void handleCharacterChange(com.example.android.anothertabtest.Character Character) {
        changeSkillTabTitle(Character.calculateRemainingSkillPoints());
        dubo.getSkillTotal();
        if (dubo.calculateRemainingSkillPoints()>0) {
            try {
                Database.getInstance().setAllAddButtonEnable(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Database.getInstance().setAllAddButtonEnable(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public void set_random_abilities(View view) {
//        dubo.setRandomAbility();
//        Tab1Main.setRandomAbility();
////        final EditText charName = (EditText)Tab1Main.findViewById(R.id.char_name_box);
//
//    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private Map<Integer, String> mFragmentTags;
        private FragmentManager mFragmentManager;
        private Context mContext;
        public SectionsPagerAdapter(FragmentManager fm, Context context) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Tab1Main tab1 = new Tab1Main();

                    return tab1;
                case 1:
                    Tab2Skills tab2 = new Tab2Skills();
                    return tab2;
                case 2:
                    Tab3Features tab3 = new Tab3Features();
                    return tab3;
                case 3:
                    Tab4Equipment tab4 = new Tab4Equipment();
                    return tab4;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.d("SAMPLE","Title Getting called for "+position);
            switch (position) {
                case 0:
                    return "Main";
                case 1:
                    return "Skills ("+dubo.calculateMaxSkillPoints()+")";
                case 2:
                    return "Feats";
                case 3:
                    return "Equipment";
            }
            return null;
        }
    }
}
