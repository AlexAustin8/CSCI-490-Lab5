package com.example.alex.lab05.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by alex on 3/15/18.
 */

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
