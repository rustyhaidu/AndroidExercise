package com.example.myapplication.activitati;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.adaptors.GolAdaptor;
import com.example.myapplication.model.livescore.Goal;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class JsonActivity extends AppCompatActivity {
    ListView listView;
    private GolAdaptor golAdaptor;
    List<Goal> goals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        listView = findViewById(R.id.listViewGoluriJson);

        golAdaptor = new GolAdaptor(getApplicationContext(), R.layout.item_gol, goals);
        listView.setAdapter(golAdaptor);



        Gson gson = new Gson();

    }

}