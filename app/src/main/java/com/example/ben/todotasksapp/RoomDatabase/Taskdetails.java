package com.example.ben.todotasksapp.RoomDatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "task_details")
public class Taskdetails {
   @PrimaryKey
    private  int Id;
    @ColumnInfo(name = "task_name")
    private String newtask;
    @ColumnInfo(name = "description")
    private  String Description;
    @ColumnInfo(name ="due_date")
    private String date;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNewtask() {
        return newtask;
    }

    public void setNewtask(String newtask) {
        this.newtask = newtask;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
