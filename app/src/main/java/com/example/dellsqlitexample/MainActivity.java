package com.example.dellsqlitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText loc;
    EditText desig;
    EditText delet;
    EditText sear;
    Button saveBtn,deletebtn,searchBtn,viewBtn;
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
     

       // Method to reset database passing variavel myname in to DeleteUser in DbHandler
         String myname = null;
        name.setText(myname);
        deletebtn = (Button)findViewById(R.id.deleteBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             dbHandler.DeleteUser(myname);

                                             Toast.makeText(MainActivity.this, "Deleted ", Toast.LENGTH_SHORT).show();
                                             Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                                             startActivity(i);
                                             delet.setText("");
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
                    return;
                }
                else {
                    dbHandler.insertUserDetails(username, location, designation);
                    intent = new Intent(MainActivity.this, DetailsActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    loc.setText(" ");
                    desig.setText("");

                }
            }
        });
        viewBtn = (Button)findViewById(R.id.ViewallBtn);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(MainActivity.this,DetailsActivity.class);
               startActivity(i);
            }
        });
    }
    
    
}



