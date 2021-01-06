package com.example.myapplication.model.livescore;

import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "goal", foreignKeys = {
        @ForeignKey(
                entity = Team.class,
                parentColumns = "id",
                childColumns = "teamId",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Game.class,
                parentColumns = "id",
                childColumns = "matchId",
                onDelete = ForeignKey.CASCADE
        )
})

public class Goal {
    private String matchId;
    private String teamId;
    private String player;
    private String gtime;

    public Goal() {
    }

    public Goal(String matchId, String teamId, String player, String gtime) {
        this.matchId = matchId;
        this.teamId = teamId;
        this.player = player;
        this.gtime = gtime;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }
}
