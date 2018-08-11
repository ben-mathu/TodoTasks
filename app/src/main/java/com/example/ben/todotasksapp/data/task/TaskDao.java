package com.example.ben.todotasksapp.data.task;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ben.todotasksapp.data.task.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM tasks")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM tasks WHERE task_id = :taskId LIMIT 1")
    LiveData<Task> getTask(String taskId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Task task);

    @Query("DELETE FROM tasks")
    void deleteAllTasks();

    @Delete
    void deleteTask(Task task);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Task task);
}
