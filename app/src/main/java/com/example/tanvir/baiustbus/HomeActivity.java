package com.example.tanvir.baiustbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;



public class HomeActivity extends AppCompatActivity {


    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int images[]={R.drawable.buspic1,R.drawable.buspic2,R.drawable.buspic3,R.drawable.buspic4,R.drawable.buspic5};
        v_flipper = findViewById(R.id.v_flipper);

        for(int i=0;i<images.length;i++){
            flipperImages(images[i]);
        }

        for(int image:images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
    public void goBusesActivity(View v){
        Intent intent=new Intent(HomeActivity.this,BusesActivity.class);
        startActivity(intent);
    }
    public void dataBuseActivity(View v){
        Intent intent=new Intent(HomeActivity.this,loginActivity.class);
        startActivity(intent);
    }
    public void TeacherBusesActivity(View v){
        Intent intent=new Intent(HomeActivity.this,TeachersBusesActivity.class);
        startActivity(intent);
    }
    public void InterCampus(View v){
        Intent intent=new Intent(HomeActivity.this,InterCampusBusesActivity.class);
        startActivity(intent);
    }

}

