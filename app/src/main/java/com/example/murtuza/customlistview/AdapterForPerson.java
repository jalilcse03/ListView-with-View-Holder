package com.example.murtuza.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Murtuza on 3/5/2016.
 */
public class AdapterForPerson extends ArrayAdapter<PersonModel>{
    ArrayList<PersonModel>personModelArrayList;
    private Context context;

    public AdapterForPerson(Context context, ArrayList<PersonModel>personModelArrayList) {
        super(context,R.layout.custom_row,personModelArrayList);
        this.context=context;
        this.personModelArrayList=personModelArrayList;
    }

    static class ViewHolder{
        TextView nameTv;
        TextView locationTv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder viewHolder;

        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.custom_row,null);

            viewHolder=new ViewHolder();

            viewHolder.nameTv=(TextView)convertView.findViewById(R.id.nameTv);
            viewHolder.locationTv=(TextView)convertView.findViewById(R.id.addressTv);

            convertView.setTag(viewHolder);// view ta save thak be
        }
        else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        viewHolder.nameTv.setText(personModelArrayList.get(position).getName());
        viewHolder.locationTv.setText(personModelArrayList.get(position).getAddress());

        return convertView;
    }
}
