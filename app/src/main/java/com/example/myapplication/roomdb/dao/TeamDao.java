package com.example.myapplication.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Team;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TeamDao {

    // insert query
    @Insert(onConflict = REPLACE)
    void insert(Team team);

    // delete
    @Delete
    void delete(Team team);

    @Delete
    void reset(List<Team> teamList);

    @Update
    void update(Team team);

    @Query("Select * from team")
    public List<Team> getTeamList();

}
