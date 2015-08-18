package com.helloworldluciano.com.firstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;

/**
 * Created by pappa on 18/08/2015.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class Layout_Handler
    {
        TextView ID_NEWS,DATE_NEWS,NEWS;
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Layout_Handler layout_handler;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layout_handler = new Layout_Handler();
            layout_handler.ID_NEWS = (TextView)row.findViewById(R.id.text_id_news);
            layout_handler.DATE_NEWS = (TextView)row.findViewById(R.id.text_date_news);
            layout_handler.NEWS = (TextView)row.findViewById(R.id.text_news);
            row.setTag(layout_handler);
        }
        else
        {
            layout_handler = (Layout_Handler) row.getTag();
        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layout_handler.ID_NEWS.setText(dataProvider.getId_news());
        layout_handler.DATE_NEWS.setText(dataProvider.getDate_news());
        layout_handler.NEWS.setText(dataProvider.getNews());
        return row;
    }
}
