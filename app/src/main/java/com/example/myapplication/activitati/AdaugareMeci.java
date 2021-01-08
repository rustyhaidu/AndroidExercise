package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.database.RoomDB;

import java.util.ArrayList;

public class AdaugareMeci extends AppCompatActivity {
    EditText echipa1;
    EditText echipa2;
    EditText stadion;
    EditText mDate;
    Button adaugaInDB;
    Button afiseazaMeciuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adauga_meci);

        echipa1 = findViewById(R.id.meciTeam1);
        echipa2 = findViewById(R.id.meciTeam2);
        mDate = findViewById(R.id.meciData);
        stadion = findViewById(R.id.meciStadion);
        adaugaInDB = findViewById(R.id.adaugaLaLista);
        afiseazaMeciuri = findViewById(R.id.afiseazaMeciuri);


        adaugaInDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String echipa1Text = echipa1.getText().toString();
                String echipa2Text = echipa2.getText().toString();
                String stadionText = stadion.getText().toString();
                String dataMeciText = mDate.getText().toString();

                if (echipa1Text.isEmpty() || echipa2Text.isEmpty() || stadionText.isEmpty() || dataMeciText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Compleaaza toate field-urile", Toast.LENGTH_SHORT).show();
                } else {

                    RoomDB database = RoomDB.getInstance(getApplicationContext());
                    GameDao gameDao = database.gameDao();

                    Game game = new Game();
                    game.setMdate(dataMeciText);
                    game.setStadium(stadionText);
                    game.setTeam1(echipa1Text);
                    game.setTeam2(echipa2Text);

                    gameDao.insert(game);

                }

            }
        });

        afiseazaMeciuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AfisareMeciuri.class);
                startActivity(intent);
            }
        });

    }
}