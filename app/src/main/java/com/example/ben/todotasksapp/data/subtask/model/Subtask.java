package com.example.ben.todotasksapp.data.subtask.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity
public class Subtask {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "subtask_id")
    private String subtaskId;
    @ColumnInfo(name = "task_id")
    private String taskId;
    @ColumnInfo(name = "subtask_name")
    private String subtaskName;

    public Subtask(String subtaskName) {
        this.subtaskId = UUID.randomUUID().toString();
        this.subtaskName = subtaskName;
    }

    public String getSubtaskId() {
        return subtaskId;
    }

    public void setSubtaskId(String subtaskId) {
        this.subtaskId = subtaskId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }
}
