package com.example.android.anothertabtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
//    private final ArrayList<Integer> values3;

    public skillsListAdapter(Context context, ArrayList<String> values, ArrayList<String> values2) {
        super(context, R.layout.skill_layout, values);
        this.context = context;
        this.values = values;
        this.values2 = values2;
//        this.values3 = values3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.skill_layout, parent, false);
        TextView skillNameTextView = (TextView) rowView.findViewById(R.id.skill_name);
        TextView skillAbilityTextView = (TextView) rowView.findViewById(R.id.skill_ability);
        TextView skillTotalTextView = (TextView) rowView.findViewById(R.id.skill_total);
        TextView skillAbilityModTextView = (TextView) rowView.findViewById(R.id.skill_ability_mod);

//        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        skillNameTextView.setText(values.get(position));
        skillAbilityTextView.setText(values2.get(position));
        int values3=0;
        int values4=0;
        if (dubo.calculatedCharactersAttributes.get(values.get(position))!=null) {
            values3=dubo.calculatedCharactersAttributes.get(values.get(position));
        }
        else {
            values3=0;
        }

//        skillTotalTextView.setText(((if (dubo.calculatedCharactersAttributes.get(values.get(position))!=null) {} else {values.get(position)}));
        skillTotalTextView.setText(Integer.toString(values3));
        if (dubo.initialCharactersAttributes.get(toLowerCase(values2.get(position))+"Bonus")!=null) {
            values4=dubo.initialCharactersAttributes.get(toLowerCase(values2.get(position))+"Bonus");
        }
        else {
            values4=0;
        }
        skillAbilityModTextView.setText(Integer.toString(values4));

        // Change the icon for Windows and iPhone
//        String s = values[position];
//        if (s.startsWith("Windows7") || s.startsWith("iPhone")
//                || s.startsWith("Solaris")) {
//            imageView.setImageResource(R.drawable.no);
//        } else {
//            imageView.setImageResource(R.drawable.ok);
//        }

        return rowView;
    }
}