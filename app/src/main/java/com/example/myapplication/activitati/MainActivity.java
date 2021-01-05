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

public class MainActivity extends AppCompatActivity {
    Button pressMe;
    Button nextActivity;
    Button jsonActivity;
    TextView label;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pressMe = findViewById(R.id.button);
        label = findViewById(R.id.textView);
        nextActivity = findViewById(R.id.nextActivity);
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

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                intent.putExtra("cheie", text);
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