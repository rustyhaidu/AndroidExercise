package com.example.myapplication.model.livescore;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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
    @PrimaryKey(autoGenerate = false)
    private int matchId;
    @ColumnInfo(name = "teamId")
    private String teamId;
    @ColumnInfo(name = "player")
    private String player;
    @ColumnInfo(name = "gtime")
    private String gtime;

    public Goal() {
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
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
