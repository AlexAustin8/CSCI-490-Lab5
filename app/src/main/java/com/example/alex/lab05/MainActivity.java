package com.example.alex.lab05;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import data;


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
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();



    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        //First check to see if player is null, then do test cases for the other things
        public void onClick(View v){
            switch(v.getId()){
                case R.id.submit:
                    Toast.makeText(getApplicationContext(),e.getText(), Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
}
