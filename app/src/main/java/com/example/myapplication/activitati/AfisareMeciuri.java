package com.example.myapplication.activitati;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.adaptors.MeciAdaptor;
import com.example.myapplication.model.example.Scor;

import java.util.ArrayList;

public class AfisareMeciuri extends AppCompatActivity {
    ListView listView;
    ArrayList<Scor> scorList = Activity2.scoruri;
    private static MeciAdaptor meciAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afisare_meciuri);

        listView = findViewById(R.id.listview);
        meciAdaptor = new MeciAdaptor(getApplicationContext(), R.layout.item, scorList);
        listView.setAdapter(meciAdaptor);
    }
}