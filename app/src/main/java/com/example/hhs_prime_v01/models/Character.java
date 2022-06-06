package com.example.hhs_prime_v01.models;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.hhs_prime_v01.AppDatabase;
import com.example.hhs_prime_v01.Converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Character implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public Integer id;
    private String name;

    @TypeConverters({Converter.class})
    private Date dateOfBirth;

    @Ignore
    private  ArrayList<Show> shows = new ArrayList<>();

    private static ArrayList <Character> characters = new ArrayList<Character>(){{
        add(new Character("Ekaterini Snow"));
        add(new Character("Bass Doe"));
        add(new Character("Jane Birthday"));


    }};

//    public static List<Character> getAll(Context context){
//        return AppDatabase.getDatabase(context).characterDao().getAll();
//    }
//
//    public static void add(Character character, Context context){
//        AppDatabase.getDatabase(context).characterDao().insert(character);
//
//    }

    public static List<Character> getAll(){
        return characters;
    }

    public static void add(Character character){
        //if(character!=null){
            characters.add(character);
        //}

    }


    public Character(){

    }

    public Character(String name){
        this.name = name;
    }

    public Character(String name, Date dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Show> getAllShows() {
        return shows;
    }

    public Show getShow(int index){
        if(shows!=null && index >= 0 && index < shows.size()){
            return shows.get(index);
        }
        return null;
    }
}


