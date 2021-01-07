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

import java.util.List;

public class MeciAdaptor extends ArrayAdapter<Game> {

    private List<Game> games;
    Context mContext;

    public MeciAdaptor(@NonNull Context context, int resource, @NonNull List<Game> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.games = objects;
    }


    private static class ViewHolder {
        TextView gameId;
        TextView mdate;
        TextView team1;
        TextView team2;
        TextView stadium;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Game game = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_meci, parent, false);

            viewHolder.gameId = convertView.findViewById(R.id.idMeci);
            viewHolder.mdate = convertView.findViewById(R.id.numeEchipa);
            viewHolder.team1 = convertView.findViewById(R.id.team1);
            viewHolder.team2 = convertView.findViewById(R.id.team2);
            viewHolder.stadium = convertView.findViewById(R.id.numeAntrenor);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.gameId.setText(game.getId());
        viewHolder.mdate.setText(game.getMdate());
        viewHolder.team1.setText(game.getTeam1());
        viewHolder.team2.setText(game.getTeam2());
        viewHolder.stadium.setText(game.getStadium());

        return result;
    }
}
