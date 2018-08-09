package com.example.ben.todotasksapp.data.task;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM tasks")
    List<Task> getTasks();

    @Query("SELECT * FROM tasks WHERE task_num = :taskNum LIMIT 1")
    Task getTask(int taskNum);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(int taskNum);

    @Query("DELETE FROM tasks")
    void deleteAllTasks();

    @Query("DELETE FROM tasks WHERE task_num = :taskNum LIMIT 1")
    void deleteTask(int taskNum);
}
