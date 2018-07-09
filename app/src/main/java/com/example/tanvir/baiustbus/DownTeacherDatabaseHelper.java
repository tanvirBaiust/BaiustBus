package com.example.tanvir.baiustbus;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class DownTeacherDatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Busdown.db";
    public static final String Table_Name_down="Bus_Tabledown";
    public static final String col_2="Time";
    public static final String col_3="FROME";
    public static final String col_4="VIA";
    public static final String col_5="TOO";
    public DownTeacherDatabaseHelper(Context context) {
        super(context,Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_Name_down+" (Time TEXT PRIMARY KEY, FROME TEXT, VIA TEXT , TOO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name_down);
        onCreate(db);
    }

    public boolean InsertData(String Time,String FROME,String VIA,String TOO){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(col_2,Time);
        contentValues.put(col_3,FROME);
        contentValues.put(col_4,VIA);
        contentValues.put(col_5,TOO);
        long result=db.insert(Table_Name_down,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select *from "+Table_Name_down,null);
        return res;
    }
    public Integer deleteData(String Time){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Name_down,"Time=?",new String[] {Time});
    }
}
