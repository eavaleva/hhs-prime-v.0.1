package com.example.hhs_prime_v01.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hhs_prime_v01.models.Character;
import com.example.hhs_prime_v01.models.Show;

import java.util.List;

@Dao
public interface ShowDao {
    @Query("SELECT * FROM show")
    List<Show> getAll();

    @Query("SELECT * FROM show WHERE  id = :id")
    Show getById(int id);


    @Insert
    void insert (Show show);

    @Update
    void update (Show show);

    @Delete
    void delete(Show show);
}
