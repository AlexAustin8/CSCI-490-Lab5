package data;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import entities.Person;

/**
 * Created by alex on 3/15/18.
 */

public interface PersonDao {

    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();

}
