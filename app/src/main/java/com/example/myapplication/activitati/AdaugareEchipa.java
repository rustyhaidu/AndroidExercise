package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.model.livescore.Team;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.dao.TeamDao;
import com.example.myapplication.roomdb.database.RoomDB;

public class AdaugareEchipa extends AppCompatActivity {
    EditText acronimEchipa;
    EditText numeEchipa;
    EditText numeAntrenor;
    Button adaugaEchipa;
    Button afisareEchipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_echipa);

        acronimEchipa = findViewById(R.id.acronimEchipa);
        numeEchipa = findViewById(R.id.teamname);
        numeAntrenor = findViewById(R.id.coachName);
        adaugaEchipa = findViewById(R.id.adaugaEchipaLaDB);

        adaugaEchipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomDB database = RoomDB.getInstance(getApplicationContext());
                TeamDao teamDao = database.teamDao();

                Team team = new Team();
                team.setId(acronimEchipa.getText().toString());
                team.setTeamname(numeEchipa.getText().toString());
                team.setCoach(numeAntrenor.getText().toString());

                teamDao.insert(team);
            }
        });

        afisareEchipe = findViewById(R.id.afisareEchipePrezente);
        afisareEchipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AfisareEchipePrezente.class);
                startActivity(intent);
            }
        });
    }
}