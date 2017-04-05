package com.example.android.anothertabtest;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.ListFragment;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import static com.example.android.anothertabtest.MainActivity.dubo;
import static com.example.android.anothertabtest.R.id.container;

/**
 * Created by Omer's on 2/28/2017.
 */

public class Tab2Skills extends ListFragment {
    ArrayList<String> values =new ArrayList<String>();
    private ArrayList<String> values2= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2skills, container, false);
//        
        return rootView;
    }
    boolean _areLecturesLoaded = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
//            View rootView = inflater.inflate(R.layout.tab2skills, container, false);
            try
            {
                values = Database.getInstance().getSkillsList();
                values2 = Database.getInstance().getSkillsAbilityList();
            }
            catch (Exception ex)
            {
                ex.printStackTrace(System.out);
            }
            skillsListAdapter adapter = new skillsListAdapter(getActivity(), values, values2);
            setListAdapter(adapter);
//            return rootView;
        }
        else{
            // fragment is no longer visible
        }
    }
    @Override
    public void onStart(){
        super.onStart();
    }
}
