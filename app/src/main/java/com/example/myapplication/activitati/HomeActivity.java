package com.example.myapplication.activitati;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {
    Button adaugaMeci;
    Button adaugaEchipa;
    Button jsonActivity;
    Button adaugaGol;
    Button displayImages;
    Button transferValueBt;
    EditText transferET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaugaMeci = findViewById(R.id.adaugaMeci);
        adaugaEchipa = findViewById(R.id.adaugaEchipa);
        jsonActivity = findViewById(R.id.jsonButton);
        displayImages = findViewById(R.id.images);
        transferValueBt = findViewById(R.id.transferValueButton);
        transferET = findViewById(R.id.transferValue);

        transferValueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToTransfer = transferET.getText().toString();
                Intent intent = new Intent(getApplicationContext(), TransferValoare.class);
                intent.putExtra("key", textToTransfer);
                startActivity(intent);
            }
        });


        adaugaMeci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugareMeci.class);
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

        adaugaGol = findViewById(R.id.adaugaGol);
        adaugaGol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugareGolActivity.class);
                startActivity(intent);
            }
        });

        displayImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                startActivity(intent);
            }
        });


    }
}