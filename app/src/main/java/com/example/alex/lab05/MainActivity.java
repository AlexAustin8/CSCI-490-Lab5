package com.example.alex.lab05;


import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import com.example.alex.lab05.data.*;
import com.example.alex.lab05.entities.*;

import java.util.ArrayList;
import java.util.List;

//Move the packages around so that they are all in the com.example.alex.lab05 folder

public class MainActivity extends AppCompatActivity {
    private Button b1, b2;
    private EditText e;
    private LabDatabase labDB;
    private final String DATABASE_NAME = "person_db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = this.findViewById(R.id.submit);
        b2 = this.findViewById(R.id.list);
        e = this.findViewById(R.id.name_entry);
        b1.setOnClickListener(buttonListener);
        b2.setOnClickListener(buttonListener);

        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();



    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        //First check to see if player is null, then do test cases for the other things
        public void onClick(View v){
            switch(v.getId()){
                case R.id.submit:
                    Person p = new Person();
                    p.setName(e.getText().toString());
                    insertPerson i = new insertPerson();
                    i.execute(p);

                    break;
                case R.id.list:
                    loadPersonList l = new loadPersonList(labDB, getApplicationContext());
                    l.execute();
            }
        }
    };

    private class insertPerson extends AsyncTask<Person, Integer, Person>{
        @Override
        protected Person doInBackground(Person...p){
            Person person = p[0];
            labDB.personDao().insertPerson(person);
            return person;
        }
    }

    public class loadPersonList extends AsyncTask <Void, Void, ArrayList<Person>>{
        LabDatabase labDB;
        Context context;

        public loadPersonList(LabDatabase personDB, Context context) {
            this.labDB = personDB;
            this.context = context;
        }


        @Override
        protected ArrayList<Person> doInBackground(Void... voids) {
            ArrayList<Person> persons = (ArrayList) labDB.personDao().getAllPersons();


            return persons;
        }

        @Override
        protected void onPostExecute(ArrayList<Person> persons) {
            super.onPostExecute(persons);

            ArrayList<String> personNames = new ArrayList<>();
            for(Person p: persons) {
                personNames.add(p.getName());
            }

            Intent i = new Intent(context, PersonsActivity.class);
            i.putExtra("Persons", personNames);
            context.startActivity(i);
        }


    }
}
