package com.example.hhs_prime_v01;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hhs_prime_v01.daos.CharacterDao;
import com.example.hhs_prime_v01.daos.ShowDao;
import com.example.hhs_prime_v01.models.Character;
import com.example.hhs_prime_v01.models.Show;

@Database(entities = {Character.class, Show.class}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();
    public abstract ShowDao showDao();

    public static AppDatabase getDatabase(Context context){
        AppDatabase database;

        synchronized (AppDatabase.class) {
            database = Room.databaseBuilder(context, AppDatabase.class, "database")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }
}
