package com.example.ben.todotasksapp.data.task.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "task_details")
public class TaskDetails {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "task_id")
    public String taskId;
    @ColumnInfo(name = "task_name")
    private String taskName;
    @ColumnInfo(name = "task_description")
    private String desription;
    @ColumnInfo(name = "due_date")
    private Date dueDate;
    @ColumnInfo(name = "task_list_timestamp")
    private Date date;
    @ColumnInfo(name = "subtask")
    private String subtask;

    @Ignore
    public TaskDetails(String taskName, String description, Date dueDate) {
        this.taskName = taskName;
        this.desription = description;
        this.dueDate = dueDate;
        this.taskId = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public TaskDetails() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtask) {
        this.subtask = subtask;
    }
}
