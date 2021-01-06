package com.example.myapplication.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.myapplication.model.livescore.Game;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface GameDao {

    // insert query
    @Insert(onConflict = REPLACE)
    void insert(Game game);

    // delete
    @Delete
    void delete(Game game);

    @Delete
    void reset(List<Game> gameList);

    @Update
    void update(Game game);


}
