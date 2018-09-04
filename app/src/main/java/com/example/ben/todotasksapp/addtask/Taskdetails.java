package com.example.ben.todotasksapp.addtask;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "task_details")
public class Taskdetails {
    @PrimaryKey
    @NonNull
    private String Id;
    @ColumnInfo(name = "task_name")
    private String newtask;
    @ColumnInfo(name = "description")
    private  String Description;
    @ColumnInfo(name ="due_date")
    private String date;

    @Ignore
    public Taskdetails(String newtask, String description, String date) {
        Id = UUID.randomUUID().toString();
        this.newtask = newtask;
        Description = description;
        this.date = date;
    }

    public Taskdetails() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
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
