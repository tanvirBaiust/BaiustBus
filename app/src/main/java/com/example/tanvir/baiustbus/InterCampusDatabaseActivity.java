package com.example.tanvir.baiustbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InterCampusDatabaseActivity extends AppCompatActivity {
    InterCampusDatabaseHelper myDb;
    EditText editText1, editText2, editText3,editText4;
    Button button;
    Button btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_campus_database);
        myDb = new InterCampusDatabaseHelper(this);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);
        btndelete=(Button) findViewById(R.id.btn_delete);
        AddData();
        DeleteData();
    }
    public void DeleteData(){
        btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer DeleteRows=myDb.deleteData(editText1.getText().toString());

                        if(DeleteRows>0)
                            Toast.makeText(InterCampusDatabaseActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(InterCampusDatabaseActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }


    public void AddData()

    {
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted= myDb.InsertData(editText1.getText().toString(),
                                editText2.getText().toString(),
                                editText3.getText().toString(),
                                editText4.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(InterCampusDatabaseActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(InterCampusDatabaseActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
    public void goToTheSecond(View view){
        Intent intent=new Intent(getApplicationContext(),InterCampusDatabase2Activity.class);
        startActivity(intent);

    }


}