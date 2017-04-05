//package com.example.android.anothertabtest;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageButton;
//import android.widget.TextView;
//
///**
// * Created by Omer's on 3/25/2017.
// */
//
//public class skillListAdapter extends BaseAdapter {
//    private static ArrayList<ListviewContactItem> listContact;
//
//    private LayoutInflater mInflater;
//
//    public ListviewContactAdapter(Context photosFragment, ArrayList<ListviewContactItem> results){
//        listContact = results;
//        mInflater = LayoutInflater.from(photosFragment);
//    }
//
//    @Override
//    public int getCount() {
//        // TODO Auto-generated method stub
//        return listContact.size();
//    }
//
//    @Override
//    public Object getItem(int arg0) {
//        // TODO Auto-generated method stub
//        return listContact.get(arg0);
//    }
//
//    @Override
//    public long getItemId(int arg0) {
//        // TODO Auto-generated method stub
//        return arg0;
//    }
//
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // TODO Auto-generated method stub
//        ViewHolder holder;
//        if(convertView == null){
//            convertView = mInflater.inflate(R.layout.contact_item, null);
//            holder = new ViewHolder();
//            holder.txtname = (TextView) convertView.findViewById(R.id.lv_contact_item_name);
//            holder.txtphone = (TextView) convertView.findViewById(R.id.lv_contact_item_phone);
//
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        holder.txtname.setText(listContact.get(position).GetName());
//        holder.txtphone.setText(listContact.get(position).GetPhone());
//
//        return convertView;
//    }
//
//    static class ViewHolder{
//        TextView txtname, txtphone;
//    }
//}