package com.example.myapplication.activitati;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Goal;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.dao.GoalDao;
import com.example.myapplication.roomdb.database.RoomDB;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Comparator;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        RoomDB database = RoomDB.getInstance(getApplicationContext());
        GameDao gameDao = database.gameDao();
        GoalDao goalDao = database.goalDao();

        List<Goal> goals = goalDao.getGoalList();
        goals.sort(new Comparator<Goal>() {
            @Override
            public int compare(Goal goal, Goal t1) {
                int minut1 = Integer.parseInt(goal.getGtime());
                int minut2 = Integer.parseInt(t1.getGtime());
                return Integer.compare(minut1, minut2);
            }
        });

        double y, x;
        x = 0;

        GraphView graphView = findViewById(R.id.graph);
        series = new LineGraphSeries<>();

        for (int i = 0; i < goals.size(); i++) {
            x = Double.parseDouble(goals.get(i).getGtime());
            y = (double) goals.get(i).getMatchId();
            series.appendData(new DataPoint(x, y), true, goals.size());
        }

        graphView.addSeries(series);
    }
}