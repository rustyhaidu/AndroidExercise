package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.model.livescore.Goal;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.dao.GoalDao;
import com.example.myapplication.roomdb.database.RoomDB;

public class AdaugareGolActivity extends AppCompatActivity {
    EditText matchId;
    EditText teamname;
    EditText player;
    EditText gtime;
    Button saveGol;
    Button afiseazaGoluri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_gol);

        matchId = findViewById(R.id.idMeciGoal);
        teamname = findViewById(R.id.goalTeamname);
        player = findViewById(R.id.numeJucatorMarcant);
        gtime = findViewById(R.id.minutulInscrierii);
        saveGol = findViewById(R.id.salvareGol);
        afiseazaGoluri = findViewById(R.id.afiseazaGoluri);

        saveGol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String meciId = matchId.getText().toString();
                String numeEchipa = teamname.getText().toString();
                String numeJucator = player.getText().toString();
                String minutInscriere = gtime.getText().toString();

                RoomDB database = RoomDB.getInstance(getApplicationContext());
                GoalDao gameDao = database.goalDao();

                Goal goal = new Goal();
                goal.setMatchId(Integer.parseInt(meciId));
                goal.setTeamId(numeEchipa);
                goal.setPlayer(numeJucator);
                goal.setGtime(minutInscriere);

                gameDao.insert(goal);
            }
        });

        afiseazaGoluri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AfisareGoluri.class);
                startActivity(intent);
            }
        });

    }
}