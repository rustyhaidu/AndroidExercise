package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class TransferValoare extends AppCompatActivity {
    TextView receivedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_valoare);

        Bundle extras = getIntent().getExtras();
        String received = extras.getString("key");

        receivedTextView = findViewById(R.id.receivedValueTv);
        receivedTextView.setText(received);
    }
}