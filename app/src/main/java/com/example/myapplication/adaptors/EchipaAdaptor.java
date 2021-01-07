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
import com.example.myapplication.model.livescore.Team;

import java.util.List;

public class EchipaAdaptor extends ArrayAdapter<Team> {

    private List<Team> teams;
    Context mContext;

    private static class ViewHolder {
        TextView acronimView;
        TextView teamnameView;
        TextView coachView;
    }


    public EchipaAdaptor(@NonNull Context context, int resource, @NonNull List<Team> objects) {
        super(context, resource, objects);
        this.teams = objects;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Team team = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_echipa, parent, false);

            viewHolder.acronimView = convertView.findViewById(R.id.idEchipa);
            viewHolder.teamnameView = convertView.findViewById(R.id.numeEchipa);
            viewHolder.coachView = convertView.findViewById(R.id.numeAntrenor);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.acronimView.setText(team.getId());
        viewHolder.teamnameView.setText(team.getTeamname());
        viewHolder.coachView.setText(team.getCoach());

        return result;
    }
}
