package com.victoriyiola.cgpacalculator.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.victoriyiola.cgpacalculator.R;


public class DrawerAdapter extends ArrayAdapter {


    public DrawerAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
        super(context, resource, textViewResourceId, objects);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.custom_row, parent, false);

        String[] listItem = view.getResources().getStringArray(R.array.nav_list_items);

        TextView text = (TextView) view.findViewById(R.id.list_text);
        ImageView image = (ImageView) view.findViewById(R.id.list_icon);

        text.setText(listItem[position]);

        // use appropriate images
        switch (listItem[position]) {
            case "Saved GPAs":
                image.setImageResource(android.R.drawable.ic_menu_save);
                break;
            case "Saved CGPAs":
                image.setImageResource(android.R.drawable.ic_menu_save);
                break;
            case "About":
                image.setImageResource(android.R.drawable.ic_dialog_info);
                break;
        }
        return view;
    }
}
