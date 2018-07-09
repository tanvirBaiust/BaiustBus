package com.example.tanvir.baiustbus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanvir on 6/11/2018.
 */

public class ListAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);

    }
    static class LayoutHandler{
        TextView Time,From,Via,To;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.Time=(TextView)row.findViewById(R.id.time);
            layoutHandler.From=(TextView)row.findViewById(R.id.from);
            layoutHandler.Via=(TextView)row.findViewById(R.id.via);
            layoutHandler.To=(TextView)row.findViewById(R.id.to);
            row.setTag(layoutHandler);
        }else{
            layoutHandler=(LayoutHandler)row.getTag();
        }
        DataProvider dataProvider=(DataProvider)this.getItem(position);
        layoutHandler.Time.setText(dataProvider.getTime());
        layoutHandler.From.setText(dataProvider.getFrom());
        layoutHandler.Via.setText(dataProvider.getVia());
        layoutHandler.To.setText(dataProvider.getTo());
        return row;
    }
}
