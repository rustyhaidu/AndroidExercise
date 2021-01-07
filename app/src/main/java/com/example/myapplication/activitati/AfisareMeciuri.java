package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adaptors.ScorAdaptor;
import com.example.myapplication.model.example.Scor;
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.database.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class AfisareMeciuri extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Scor> scorList = AdaugareMeci.scoruri;
    private ScorAdaptor meciAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_meciuri);

        RoomDB database = RoomDB.getInstance(getApplicationContext());
        GameDao gameDao = database.gameDao();
        listView = findViewById(R.id.listViewMeciuri);

        List<Game> games = gameDao.getGameList();
       // meciAdaptor = new ScorAdaptor(getApplicationContext(), R.layout.item_meci, games);
        listView.setAdapter(meciAdaptor);
    }
}