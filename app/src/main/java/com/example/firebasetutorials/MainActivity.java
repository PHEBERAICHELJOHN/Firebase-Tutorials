package com.example.firebasetutorials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.SignInButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mfirebase_btn;

    // instance / reference to database

    private DatabaseReference mDatabase;

    private EditText mNameField;
    private EditText mMailField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfirebase_btn = (Button) findViewById(R.id.firebase_btn);

        //variable pointing to root directory
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //here we don't want to create the child User_01 in db. it will automatically create it.
        //mDatabase = FirebaseDatabase.getInstance().getReference().child("User_01");

        //going to child link
        // mDatabase = FirebaseDatabase.getInstance().getReference().child("registration");

        mNameField = (EditText) findViewById(R.id.name_field);
        mMailField = (EditText) findViewById(R.id.mail_field);


        mfirebase_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 1. Create child in its root
                // 2. Assign some value to child


             //   mDatabase.child("name").setValue("JESUS"); //directly add JESUS to db

                String name = mNameField.getText().toString().trim();
                String mail = mMailField.getText().toString().trim();

              //  mDatabase.child("name").setValue(name);

                //generating random keys for each insertion of user
                //push() generates random key each time


                //for inserting more than one value :
                // create Hashmap
                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name",name);
                dataMap.put("Email",mail);

                mDatabase.push().setValue(dataMap);



               // mDatabase.push().setValue(name);



            }
        });
    }
}
