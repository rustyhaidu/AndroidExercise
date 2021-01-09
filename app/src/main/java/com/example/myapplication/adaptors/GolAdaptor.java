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
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Goal;

import java.util.List;

public class GolAdaptor extends ArrayAdapter<Goal> {

    private List<Goal> goals;
    Context mContext;

    public GolAdaptor(@NonNull Context context, int resource, @NonNull List<Goal> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.goals = objects;
    }


    private static class ViewHolder {
        TextView goalId;
        TextView matchId;
        TextView teamId;
        TextView player;
        TextView gtime;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Goal goal = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gol, parent, false);

            viewHolder.goalId = convertView.findViewById(R.id.golId);
            viewHolder.matchId = convertView.findViewById(R.id.meciGolid);
            viewHolder.teamId = convertView.findViewById(R.id.golTeamname);
            viewHolder.player = convertView.findViewById(R.id.golPlayer);
            viewHolder.gtime = convertView.findViewById(R.id.golMinute);


            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.goalId.setText(String.valueOf(goal.getId()));
        viewHolder.matchId.setText(String.valueOf(goal.getMatchId()));
        viewHolder.teamId.setText(goal.getTeamId());
        viewHolder.player.setText(goal.getPlayer());
        viewHolder.gtime.setText(goal.getGtime());

        return result;
    }
}
