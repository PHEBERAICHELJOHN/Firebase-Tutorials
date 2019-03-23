package com.example.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mfirebase_btn;

    // instance / reference to database

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfirebase_btn = (Button) findViewById(R.id.firebase_btn);

        //variable pointing to root directory

        mDatabase = FirebaseDatabase.getInstance().getReference();


        mfirebase_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 1. Create child in its root
                // 2. Assign some value to child

           //     mDatabase.child("name").setValue("JESUS");

            }
        });
    }
}
