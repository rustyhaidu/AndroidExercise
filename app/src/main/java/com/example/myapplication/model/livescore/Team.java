package com.example.myapplication.model.livescore;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "eteam")
public class Team {

    @PrimaryKey(autoGenerate = false)
    private String id;
    @ColumnInfo(name = "teamname")
    private String teamname;
    @ColumnInfo(name = "coach")
    private String coach;

    public Team() {
    }

    public Team(String id, String teamname, String coach) {
        this.id = id;
        this.teamname = teamname;
        this.coach = coach;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
