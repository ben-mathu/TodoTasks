package com.example.ben.todotasksapp.addTo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.widget.Switch;

import java.util.Date;

public class Dbhelper extends SQLiteOpenHelper{
    private  static final String DATABASE_NAME = "add_task";
    private static final String TABLE_NAME = "task_details";
    private static final String ID_TASK ="ID";
    public static final String col2="TASK_NAME";
    public  static final String col3="DESCRIPTION";
    public static final String DATE = "create_timestamp";
    //public static final String COLUMN_TIME_STAMP = "TIMESTAMP";


   // public static final String col5="DEADLINE";
//public static final Boolean col5= ;
    private static final String TASKSQL = "CREATE TABLE " +
           TABLE_NAME + "(" +
           ID_TASK + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
           col2 +" TEXT," +
           col3 +" TEXT,"+
           DATE+" DATETIME DEFAULT CURRENT_TIMESTAMP)";
    Dbhelper (Context context){super(context ,TABLE_NAME, null,1);}
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TASKSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    boolean insertData(String taskname, String description,String duedate  ) {
        //long dudate = new Date().getTime();//to pass data to save time
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,taskname);
        contentValues.put(col3, description);
//        contentValues.put(DATE, duedate);


        Long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;


    }

    Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
//     Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
//    return res;
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

    }

}
