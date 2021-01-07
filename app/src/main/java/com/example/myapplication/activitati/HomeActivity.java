package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {
    Button pressMe;
    Button adaugaMeci;
    Button adaugaEchipa;
    Button jsonActivity;
    TextView label;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressMe = findViewById(R.id.button);
        label = findViewById(R.id.textView);
        adaugaMeci = findViewById(R.id.adaugaMeci);
        adaugaEchipa = findViewById(R.id.adaugaEchipa);
        editText = findViewById(R.id.editText);
        jsonActivity = findViewById(R.id.jsonButton);



        pressMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int nrRandom = random.nextInt(1000);
                label.setText("Numar: " + nrRandom);


            }
        });

        adaugaMeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), AdaugareMeci.class);
                intent.putExtra("cheie", text);
                startActivity(intent);
            }
        });

        adaugaEchipa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugareEchipa.class);
                startActivity(intent);
            }
        });

        jsonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JsonActivity.class);
                startActivity(intent);
            }
        });


    }
}