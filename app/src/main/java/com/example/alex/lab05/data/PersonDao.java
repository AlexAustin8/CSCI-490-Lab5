package com.example.alex.lab05.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import com.example.alex.lab05.entities.Person;

/**
 * Created by alex on 3/15/18.
 */
@Dao
public interface PersonDao {

    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();

}
