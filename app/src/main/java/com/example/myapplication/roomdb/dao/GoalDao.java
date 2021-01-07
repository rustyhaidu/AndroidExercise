package com.example.myapplication.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Goal;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface GoalDao {

    // insert query
    @Insert(onConflict = REPLACE)
    void insert(Goal goal);

    // delete
    @Delete
    void delete(Goal goal);

    @Delete
    void reset(List<Goal> goalList);

    @Update
    void update(Goal goal);

    /*@Query("Select * from goal")
    public List<Game> getGoalList();*/

}
