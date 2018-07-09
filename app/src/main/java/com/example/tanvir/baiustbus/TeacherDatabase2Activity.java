package com.example.tanvir.baiustbus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class TeacherDatabase2Activity extends AppCompatActivity {
    ListView listview;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    TeacherDatabaseHelper databaseHelper;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_database2);
        listview = (ListView) findViewById(R.id.list_view);
        databaseHelper = new TeacherDatabaseHelper(getApplicationContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        cursor = databaseHelper.getAllData();
        listAdapter = new ListAdapter(getApplicationContext(), R.layout.row_layout);
        listview.setAdapter(listAdapter);


        if (cursor.moveToFirst()) {


            do {
                String time, from,via,to;
                time = cursor.getString(0);
                from = cursor.getString(1);
                via = cursor.getString(2);
                to = cursor.getString(3);
                DataProvider dataProvider = new DataProvider( time, from, via, to );
                listAdapter.add(dataProvider);


            } while (cursor.moveToNext());


        }
    }

    public void goToTheMap(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }
}