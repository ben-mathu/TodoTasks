package com.example.ben.todotasksapp.data.task;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM task_details")
    Flowable<List<TaskDetails>> viewAll();

    @Query("SELECT * FROM task_details WHERE task_id =:taskId LIMIT 1")
    Flowable<TaskDetails> getTask(String taskId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(TaskDetails taskDetails);

    @Query("DELETE FROM task_details")
    void deleteAllTasks();

    @Delete
    void deleteTask(TaskDetails taskDetails);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(TaskDetails taskDetails);
}
