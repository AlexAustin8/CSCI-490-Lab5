package data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import entities.Person;

/**
 * Created by alex on 3/15/18.
 */

    @Database(entities = {Person.class}, version = 1)
    public abstract class LabDatabase extends RoomDatabase {

        public abstract PersonDao personDao();
    }

