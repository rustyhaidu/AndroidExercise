package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adaptors.GolAdaptor;
import com.example.myapplication.adaptors.MeciAdaptor;
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Goal;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.dao.GoalDao;
import com.example.myapplication.roomdb.database.RoomDB;

import java.util.List;

public class AfisareGoluri extends AppCompatActivity {
    private ListView listView;
    private GolAdaptor golAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_goluri);

        RoomDB database = RoomDB.getInstance(getApplicationContext());
        GoalDao goalDao = database.goalDao();
        listView = findViewById(R.id.listViewGoluri);

        List<Goal> goals = goalDao.getGoalList();
        golAdaptor = new GolAdaptor(getApplicationContext(), R.layout.item_gol, goals);
        listView.setAdapter(golAdaptor);
    }
}