package com.example.tanvir.baiustbus;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class InterCampusDatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Bus5.db";
    public static final String Table_Name5="Bus_Table5";
    public static final String col_2="Time";
    public static final String col_3="FROME";
    public static final String col_4="VIA";
    public static final String col_5="TOO";
    public InterCampusDatabaseHelper(Context context) {
        super(context,Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_Name5+" (Time TEXT PRIMARY KEY, FROME TEXT, VIA TEXT , TOO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name5);
        onCreate(db);
    }

    public boolean InsertData(String Time,String FROME,String VIA,String TOO){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_2,Time);
        contentValues.put(col_3,FROME);
        contentValues.put(col_4,VIA);
        contentValues.put(col_5,TOO);
        long result=db.insert(Table_Name5,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select *from "+Table_Name5,null);
        return res;
    }
    public Integer deleteData(String Time){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Name5,"Time=?",new String[] {Time});
    }
}
