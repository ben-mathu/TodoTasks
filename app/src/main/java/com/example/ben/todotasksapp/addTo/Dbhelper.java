package com.example.ben.todotasksapp.addTo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Switch;

public class Dbhelper extends SQLiteOpenHelper{
    private  static final String DATA_BASE_NAME="add_task";
private static final String TABLE_NAME="task_details";
private static final String col1="ID";
public static final String col2="TASK_NAME";
public  static final String col3="DESCRIPTION";
public static final String col4="STARTING_DATE";
    public static final String col5="DEADLINE";
//public static final Boolean col5= ;
    private static final String TASKSQL = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,TASK_NAME TEXT, DESCRIPTION TEXT,STARTING_DATE DATE,DEADLINE DATE)";
    Dbhelper (Context context){super(context ,TABLE_NAME, null,1);}
    @Override
    public void onCreate(SQLiteDatabase db){db.execSQL(TASKSQL);} {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
    boolean insertData(String taskname, String description, String startingDate, String deadline) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2,taskname);
        contentValues.put(col3, description);
        contentValues.put(col4, startingDate);
        contentValues.put(col5, deadline);
        Long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
//        return res;
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

}
