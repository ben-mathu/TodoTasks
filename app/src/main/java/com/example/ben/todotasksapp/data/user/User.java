package com.example.ben.todotasksapp.data.user;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "user_num")
    private int userNum;
    @ColumnInfo(name = "user_id")
    private String userId;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "date_timestamp")
    private Date date;

    public User(int userNum, String userId, String userName) {
        this.userNum = userNum;
        this.userId = userId;
        this.userName = userName;
    }

    @Ignore
    public User(int userNum, String userId, String userName, Date date) {
        this.userNum = userNum;
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.date = new Date(date.getTime());
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
