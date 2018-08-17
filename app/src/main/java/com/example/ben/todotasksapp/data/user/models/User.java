package com.example.ben.todotasksapp.data.user.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "users")
public class User {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private String userId;
    @ColumnInfo(name = "task_id")
    private String taskId;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "first_name")
    private String fname;
    @ColumnInfo(name = "last_name")
    private String lname;
    @ColumnInfo(name = "date_timestamp")
    private String date;

    public User(@NonNull String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Ignore
    public User(String userName, String fname, String lname) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.fname = fname;
        this.lname = lname;
        this.date = new SimpleDateFormat("yyyy-MM-DD").format(new Date());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
