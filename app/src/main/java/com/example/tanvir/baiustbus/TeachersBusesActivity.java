package com.example.tanvir.baiustbus;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class TeachersBusesActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_buses);
    }
    public void showPopup(View v ){
        PopupMenu popup=new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popmenu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent=new Intent(TeachersBusesActivity.this,TeacherDatabase2Activity.class);
                startActivity(intent);
                return false;

            case R.id.item2:
                Intent myintent=new Intent(TeachersBusesActivity.this,DownTeachersDatabase2.class);
                startActivity(myintent);
                return true;

            default:
                return false;
        }



    }
}
