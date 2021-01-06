package com.example.myapplication.roomdb.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.model.livescore.Game;
import com.example.myapplication.model.livescore.Goal;
import com.example.myapplication.model.livescore.Team;

@Database(entities = {Game.class, Goal.class, Team.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    // Create database instance
    private static RoomDB database;

    // Define database name
    private static String DATABASE_NAME = "livescore";

    public synchronized static RoomDB getInstance(Context context) {
        // check if database is null
        if (database == null) {
            // When database is null we initialize it
            database = Room.databaseBuilder(context.getApplicationContext()
                    , RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
}
