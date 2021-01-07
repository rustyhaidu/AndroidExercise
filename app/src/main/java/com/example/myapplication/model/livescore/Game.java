package com.example.myapplication.model.livescore;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "game", foreignKeys = {
        @ForeignKey(
                entity = Team.class,
                parentColumns = "id",
                childColumns = "team1",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Team.class,
                parentColumns = "id",
                childColumns = "team2",
                onDelete = ForeignKey.CASCADE
        )
})
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "mdate")
    private String mdate;
    @ColumnInfo(name = "stadium")
    private String stadium;

    @ColumnInfo(name = "team1")
    private String team1;
    @ColumnInfo(name = "team2")
    private String team2;

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}
