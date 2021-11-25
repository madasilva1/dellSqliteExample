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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DbHandler helper ;
        helper = new DbHandler(this);
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
                dbHandler.insertUserDetails(username,location,designation);
                intent = new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

  public void deleteBtn (View view) {

     String DeleteUser = delet.getText().toString();
     if(DeleteUser.isEmpty()){
         Toast.makeText(getApplicationContext(), "Delete unsuccessfully",Toast.LENGTH_SHORT).show();
     }
     else{

//traying fix push git

     }

    }

}

