package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adaptors.EchipaAdaptor;
import com.example.myapplication.model.livescore.Team;
import com.example.myapplication.roomdb.dao.TeamDao;
import com.example.myapplication.roomdb.database.RoomDB;

import java.util.List;

public class AfisareEchipePrezente extends AppCompatActivity {
    private ListView listView;
    private EchipaAdaptor echipaAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_echipe_prezente);

        RoomDB database = RoomDB.getInstance(getApplicationContext());
        TeamDao teamDao = database.teamDao();
        listView = findViewById(R.id.listViewEchipe);

        List<Team> teams = teamDao.getTeamList();
        echipaAdaptor = new EchipaAdaptor(getApplicationContext(), R.layout.item_echipa, teams);
        listView.setAdapter(echipaAdaptor);
    }
}