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
import com.example.myapplication.model.example.Scor;
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.roomdb.dao.GameDao;
import com.example.myapplication.roomdb.database.RoomDB;

import java.util.ArrayList;

public class AdaugareMeci extends AppCompatActivity {
    TextView textView;
    EditText echipa1;
    EditText echipa2;
    EditText scorul;
    Button adaugaInDB;
    Button afiseazaMeciuri;

    static ArrayList<Scor> scoruri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adauga_meci);

        textView = findViewById(R.id.textView2);
        String text = getIntent().getExtras().getString("cheie");
        textView.setText(text);

        echipa1 = findViewById(R.id.meciData);
        echipa2 = findViewById(R.id.meciStadion);
        scorul = findViewById(R.id.meciTeam1);
        adaugaInDB = findViewById(R.id.adaugaLaLista);
        afiseazaMeciuri = findViewById(R.id.afiseazaMeciuri);

        adaugaInDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String echipa1Text = echipa1.getText().toString();
                String echipa2Text = echipa2.getText().toString();
                String scorText = scorul.getText().toString();

                if (echipa1Text.isEmpty() || echipa2Text.isEmpty() || scorText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Compleaaza toate field-urile", Toast.LENGTH_SHORT).show();
                } else {
                    Scor scor = new Scor(echipa1Text, echipa2Text, scorText);
                    // scoruri.add(scor);

                    RoomDB database = RoomDB.getInstance(getApplicationContext());
                    GameDao gameDao = database.gameDao();

                    Game game = new Game();
                    game.setMdate("2020-01-10");
                    game.setStadium("Barca");
                    game.setTeam1("ROM");
                    game.setTeam2("PLK");

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