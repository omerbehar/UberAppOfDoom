package com.example.android.anothertabtest;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.ListFragment;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.android.anothertabtest.MainActivity.dubo;


/**
 * Created by Omer's on 2/28/2017.
 */

public class Tab2Skills extends ListFragment {
    ArrayList<String> values =new ArrayList<String>();
    private ArrayList<String> values2= new ArrayList<>();
    private ArrayList<Boolean> addButtonEnable = new ArrayList<>();
    private ArrayList<Boolean> subButtonEnable = new ArrayList<>();
    private ArrayList<Integer> miscSkillMod = new ArrayList<>();
    private ArrayList<Integer> skillTotal = new ArrayList<>();
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab2skills, container, false);
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            try
            {
                values = Database.getInstance().getSkillsList();
                values2 = Database.getInstance().getSkillsAbilityList();
                addButtonEnable = Database.getInstance().getAddButtonEnable();
                subButtonEnable = Database.getInstance().getSubButtonEnable();
            }
            catch (Exception ex)
            {
                ex.printStackTrace(System.out);
            }
            miscSkillMod = dubo.getMiscSkillMod();
            skillTotal = dubo.getSkillTotal();
            skillsListAdapter adapter = new skillsListAdapter(getActivity(), values, values2, addButtonEnable, subButtonEnable, miscSkillMod, skillTotal);
            final Button addSkillGenButton = (Button)  rootView.findViewById(R.id.add_skill_rank_button);

            setListAdapter(adapter);
            getListAdapter().getCount();

//            private void SelectAll() {
//                // TODO Auto-generated method stub
//
//                int count = this.getListAdapter().getCount();
//
//                for (int i = 0; i < count; i++) {
//
//                    this.getListAdapter().
//                    this.getListAdapter().
//                    //setItemChecked(i, true);
//
//                }

//            }
        }
        else{
            // fragment is no longer visible
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object skillObject = this.getListAdapter().getItem(position);
        String skillName = skillObject.toString();
        Toast.makeText(getActivity(), "You have chosen: " + " " + skillName, Toast.LENGTH_LONG).show();
    }

}
