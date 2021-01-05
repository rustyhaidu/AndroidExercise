package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Scor;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    TextView textView;
    EditText echipa1;
    EditText echipa2;
    EditText scorul;
    Button adaugaLaLista;
    Button afiseazaMeciuri;

    static ArrayList<Scor> scoruri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        textView = findViewById(R.id.textView2);
        String text = getIntent().getExtras().getString("cheie");
        textView.setText(text);

        echipa1 = findViewById(R.id.echipa1);
        echipa2 = findViewById(R.id.echipa2);
        scorul = findViewById(R.id.scorul);
        adaugaLaLista = findViewById(R.id.adaugaLaLista);
        afiseazaMeciuri = findViewById(R.id.afiseazaMeciuri);

        adaugaLaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String echipa1Text = echipa1.getText().toString();
                String echipa2Text = echipa2.getText().toString();
                String scorText = scorul.getText().toString();

                Scor scor = new Scor(echipa1Text, echipa2Text, scorText);
                scoruri.add(scor);
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