package com.example.myapplication.activitati;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.adaptors.GolAdaptor;
import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Goal;
import com.example.myapplication.model.livescore.Team;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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

        OkHttpClient client = new OkHttpClient();
        String url = "https://run.mocky.io/v3/4d18d98b-8102-43bc-984f-19da26bb8de5";


        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    String myResponse = response.body().string();

                    try {
                        JSONArray jsonArray = new JSONArray(myResponse);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonGoal = jsonArray.getJSONObject(i);

                            Goal goal = new Goal();
                            goal.setTeamId(jsonGoal.getString("team"));
                            goal.setPlayer(jsonGoal.getString("player"));
                            goal.setGtime(jsonGoal.getString("gtime"));

                            JSONObject jsonGame = jsonGoal.getJSONObject("game");
                            goal.setMatchId(Integer.parseInt(jsonGame.getString("matchId")));

                            Game game = new Game();
                            game.setMatchId(jsonGame.getInt("matchId"));
                            game.setStadium(jsonGame.getString("stadion"));

                            JSONObject jsonTeam1 = jsonGame.getJSONObject("team1");
                            Team team1 = new Team();

                            team1.setId(jsonTeam1.getString("teamid"));
                            team1.setTeamname(jsonTeam1.getString("teamname"));
                            team1.setCoach(jsonTeam1.getString("coach"));

                            JSONObject jsonTeam2 = jsonGame.getJSONObject("team2");
                            Team team2 = new Team();

                            team2.setId(jsonTeam2.getString("teamid"));
                            team2.setTeamname(jsonTeam2.getString("teamname"));
                            team2.setCoach(jsonTeam2.getString("coach"));

                            goals.add(goal);
                        }

                        JsonActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                golAdaptor = new GolAdaptor(getApplicationContext(), R.layout.item_gol, goals);
                                listView.setAdapter(golAdaptor);
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

}