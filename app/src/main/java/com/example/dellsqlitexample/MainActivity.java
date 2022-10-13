package com.example.dellsqlitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, loc, desig,delet,sear;
    Button saveBtn,deletebtn,searchBtn;
    Intent intent;
    DetailsActivity detailsActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DbHandler dbHandler;
        dbHandler = new DbHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delet = (EditText)findViewById(R.id.delete);
        name = (EditText)findViewById(R.id.txtName);
        loc = (EditText)findViewById(R.id.txtLocation);
        desig = (EditText)findViewById(R.id.txtDesignation);
        sear = (EditText)findViewById(R.id.search);
        searchBtn = (Button)findViewById(R.id.searchBtn);
        deletebtn = (Button)findViewById(R.id.deleteBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbHandler.DeleteUser();
                Toast.makeText(MainActivity.this, "Deleted ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(i);

            }
        });

        saveBtn = (Button)findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener()

        {


            @Override
            public void onClick(View v) {
                String username = name.getText().toString()+"\n";
                String location = loc.getText().toString();
                String designation = desig.getText().toString();
                DbHandler dbHandler = new DbHandler(MainActivity.this);
                if(username.isEmpty() || location.isEmpty() || designation.isEmpty()){
                    Toast.makeText(MainActivity.this,"Not Saved, enter all Data",Toast.LENGTH_LONG).show();
                }
                else {
                    dbHandler.insertUserDetails(username, location, designation);
                    intent = new Intent(MainActivity.this, DetailsActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    }



