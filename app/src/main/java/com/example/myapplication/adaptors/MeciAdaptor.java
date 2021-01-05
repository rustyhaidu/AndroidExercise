package com.example.myapplication.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.Scor;

import java.util.ArrayList;

public class MeciAdaptor extends ArrayAdapter<Scor> {

    private ArrayList<Scor> scoruri;
    Context mContext;

    private static class ViewHolder {
        TextView echipa1;
        TextView echipa2;
        TextView scor;
    }


    public MeciAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<Scor> objects) {
        super(context, resource, objects);
        this.scoruri = objects;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Scor scor = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);

            viewHolder.echipa1 = convertView.findViewById(R.id.echipa1Item);
            viewHolder.echipa2 = convertView.findViewById(R.id.echipa2Item);
            viewHolder.scor = convertView.findViewById(R.id.scorItem);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.echipa1.setText(scor.getEchipa1());
        viewHolder.echipa2.setText(scor.getEchipa2());
        viewHolder.scor.setText(scor.getScor());

        return result;
    }
}
