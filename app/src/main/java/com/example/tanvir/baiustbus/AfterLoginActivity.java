package com.example.tanvir.baiustbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AfterLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
    }
    public void TeacherBus1(View v){
        Intent intent=new Intent(AfterLoginActivity.this,AdminTeachersBusesActivity.class);
        startActivity(intent);
    }
    public void StudentBus1(View v){
        Intent intent=new Intent(AfterLoginActivity.this,DatabaseActivity.class);
        startActivity(intent);
    }
    public void InterCampusBus(View v){
        Intent intent=new Intent(AfterLoginActivity.this,InterCampusDatabaseActivity.class);
        startActivity(intent);
    }
}
