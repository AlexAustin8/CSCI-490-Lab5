package entities;

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
}
