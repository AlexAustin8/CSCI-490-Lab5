package com.example.alex.lab05;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alex.lab05.data.LabDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 3/15/18.
 */

public class PersonsActivity extends AppCompatActivity {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);

        listView = findViewById(R.id.personList);

        ArrayList<String> i = (ArrayList) this.getIntent().getExtras().get("Persons");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i);

        listView.setAdapter(adapter);



    }

}
