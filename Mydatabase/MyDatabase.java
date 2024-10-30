package com.example.dbconnection;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;


public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(Context context){

        super(context,"Login.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table USERS(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME text,SURNAME text,MARKS INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS USERS");
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
       Cursor res=db.rawQuery("Select *from USERS",null);
        return res;
    }
      public Boolean insertdata(String userVal, Integer passVal, String surnameVal) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("NAME",userVal);
        cv.put("SURNAME",surnameVal);
        cv.put("MARKS",passVal);
        long result=db.insert("USERS",null,cv);
        db.close();
        return result != -1;

    }
    public int deletedata(String userVal){
        SQLiteDatabase db=this.getWritableDatabase();
        int i= db.delete("USERS","NAME=?",new String[]{userVal});
        db.close();
        return i;

    }
    public Boolean updateData(String userVal,Integer passVal,String surnameVal){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NAME",userVal);
        cv.put("SURNAME",surnameVal);
        cv.put("MARKS",passVal);
        int result=db.update("USERS",cv,"NAME=?",new String[]{userVal});
        if(result>0){
            return true;
        }
        else{
            return false;
        }
    }
}
