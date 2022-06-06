package com.example.hhs_prime_v01.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hhs_prime_v01.models.Character;


import java.util.List;

@Dao
public interface CharacterDao {
    @Query("SELECT * FROM character")
    List<Character> getAll();

    @Query("SELECT * FROM character WHERE  id = :id")
    Character getById(int id);

    @Insert
    void insert (Character character);

    @Update
    void update (Character character);

    @Delete
    void delete(Character character);
}
