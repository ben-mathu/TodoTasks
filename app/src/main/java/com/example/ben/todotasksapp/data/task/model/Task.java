package com.example.ben.todotasksapp.data.task.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey
    @ColumnInfo(name = "task_num")
    private int taskNum;
    @ColumnInfo(name = "task_id")
    private String taskId;
    @ColumnInfo(name = "name_task")
    private String taskName;
    @ColumnInfo(name = "task_list_timestamp")
    private String date;

    @Ignore
    public Task(String taskName) {
        this.taskId = UUID.randomUUID().toString();
        this.taskName = taskName;
        this.date = new SimpleDateFormat("YY-MM-DD").format(new Date());
    }

    public Task(String taskId, String taskName, String date) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.date = date;
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
