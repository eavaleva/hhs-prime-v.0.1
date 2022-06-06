package com.example.hhs_prime_v01.models;

import static androidx.room.ForeignKey.SET_NULL;

import android.content.Context;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


import com.example.hhs_prime_v01.AppDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Character.class,
                parentColumns = "id",
                childColumns = "characterId",
                onDelete = SET_NULL)})
public class Show implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public Integer id;
    private String name;

    @ColumnInfo(name = "NumberOfSeasons") // alternative name
    private Integer seasons;


    private Integer characterId;


    @Ignore
    private Character mainCharacter;

    @Ignore
    private static ArrayList<Show> shows = new ArrayList<Show>() {{
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));
        add(new Show("Breaking Bad", 5, new Character("Mr. White")));
        add(new Show("Test movie", 8, new Character("Jane Doe")));

    }};


    public static List<Show> getAll(Context context) {
        List<Show> shows = AppDatabase.getDatabase(context).showDao().getAll();
       if (shows!=null){
            return shows;
      }

        for(Show show : shows){
            if(show.characterId != null){
                show.mainCharacter= AppDatabase.getDatabase(context).characterDao().getById(show.characterId);
            }
        }
        return shows;
    }

    public static void add(Show show, Context context) {
        AppDatabase.getDatabase(context).showDao().insert(show);
    }

    public static void delete(Show show, Context context){
        AppDatabase.getDatabase(context).showDao().delete(show);

    }


    public Show() {

    }

    public Show(String name, Integer seasons) {
        this.name = name;
        this.seasons = seasons;

    }

    public Show(String name, Integer seasons, Character mainCharacter) {
        this.name = name;
        this.seasons = seasons;
        this.mainCharacter = mainCharacter;

    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seasons=" + seasons +
                ", mainCharacter=" + mainCharacter +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public Character getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(Character mainCharacter) {
        this.mainCharacter = mainCharacter;
    }
}
