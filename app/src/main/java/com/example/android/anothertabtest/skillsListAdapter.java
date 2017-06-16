package com.example.android.anothertabtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.toLowerCase;
import static com.example.android.anothertabtest.MainActivity.dubo;
import static com.example.android.anothertabtest.R.id.textView;

/**
 * Created by Omer's on 3/31/2017.
 */



public class skillsListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String>  values;
    private final ArrayList<String> values2;
    private final ArrayList<Boolean> addButtonEnable;
    private final ArrayList<Boolean> subButtonEnable;
    private final ArrayList<Integer> miscSkillMod;
    private final ArrayList<Integer> skillTotal;


    public skillsListAdapter(Context context, ArrayList<String> values, ArrayList<String> values2, ArrayList<Boolean> addButtonEnable, ArrayList<Boolean> subButtonEnable, ArrayList<Integer> miscSkillMod, ArrayList<Integer> skillTotal) {
        super(context, R.layout.skill_layout, values);
        this.context = context;
        this.values = values;
        this.values2 = values2;
        this.addButtonEnable = addButtonEnable;
        this.subButtonEnable = subButtonEnable;
        this.miscSkillMod = miscSkillMod;
        this.skillTotal = skillTotal;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.skill_layout, parent, false);
        TextView skillNameTextView = (TextView) rowView.findViewById(R.id.skill_name);
//        TextView skillAbilityTextView = (TextView) rowView.findViewById(R.id.skill_ability);
        final Button addSkillRankButton = (Button) rowView.findViewById(R.id.add_skill_rank_button);
        final Button subSkillRankButton = (Button) rowView.findViewById(R.id.sub_skill_rank_button);
        TextView miscSkillModTextView = (TextView) rowView.findViewById(R.id.misc_skill_mod);
        addSkillRankButton.setEnabled(addButtonEnable.get(position));
        subSkillRankButton.setEnabled(subButtonEnable.get(position));
        miscSkillModTextView.setText(""+miscSkillMod.get(position));
        final TextView skillTotalTextView = (TextView) rowView.findViewById(R.id.skill_total);
        TextView skillModTextView = (TextView) rowView.findViewById(R.id.skill_ability_mod);
        final TextView skillRankTextView = (TextView) rowView.findViewById(R.id.skill_ranks);
        if ((dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()*dubo.getCrossSkill(values.get(position).toLowerCase()) == Math.floor(dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()*dubo.getCrossSkill(values.get(position).toLowerCase()))) && !Double.isInfinite(dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()*dubo.getCrossSkill(values.get(position).toLowerCase()))){
            int cross=(int)(dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()*dubo.getCrossSkill(values.get(position).toLowerCase()));
            skillRankTextView.setText(""+cross);
        }
        else {
            skillRankTextView.setText(""+dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()*dubo.getCrossSkill(values.get(position).toLowerCase()));

        }
        skillNameTextView.setText(values.get(position));
//        skillAbilityTextView.setText(values2.get(position));
        int values4=0;
        skillTotalTextView.setText(""+skillTotal.get(position));
//        skillTotalTextView.setText(""+dubo.calculateSkillTotal(values.get(position).toLowerCase(),values2.get(position).toLowerCase()));
        if (dubo.initialCharactersAttributes.get(toLowerCase(values2.get(position))+"Bonus")!=null) {
            skillModTextView.setText(""+dubo.initialCharactersAttributes.get(toLowerCase(values2.get(position))+"Bonus"));
        }
        else {
            skillModTextView.setText("0");
        }
        addSkillRankButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dubo.increaseCharacterSkill(values.get(position).toLowerCase());
                skillRankTextView.setText(""+dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints());
                try {
                    Database.getInstance().setSubButtonEnable(position,true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dubo.calculateRemainingSkillPoints()<=0) {
                    try {
                        Database.getInstance().setAllAddButtonEnable(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()>=5){
                    dubo.setSkillSynergiesMod(values.get(position).toLowerCase(),true);
                }
                dubo.setMiscSkillMod();
                dubo.getSkillTotal();
                notifyDataSetChanged();
//                skillTotalTextView.setText(""+dubo.calculateSkillTotal(values.get(position).toLowerCase(),values2.get(position).toLowerCase()));
            }
        });
        subSkillRankButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dubo.decreaseCharacterSkill(values.get(position).toLowerCase());
                skillRankTextView.setText(""+dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints());
                if (dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()==0) {
                    try {
                        Database.getInstance().setSubButtonEnable(position,false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (dubo.calculateRemainingSkillPoints()>0) {
                    try {
                        Database.getInstance().setAllAddButtonEnable(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (dubo.getCharacterSkill(values.get(position).toLowerCase()).getPoints()<5){
                    dubo.setSkillSynergiesMod(values.get(position).toLowerCase(),false);
                }
                dubo.setMiscSkillMod();
                notifyDataSetChanged();
                skillTotalTextView.setText(""+dubo.calculateSkillTotal(values.get(position).toLowerCase(),values2.get(position).toLowerCase()));
            }
        });
        return rowView;
    }
}