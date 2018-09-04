package com.example.ben.todotasksapp.data.subtask;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ben.todotasksapp.data.subtask.model.Subtask;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface SubtaskDao {
    @Query("SELECT * FROM subtask")
    Flowable<List<Subtask>> viewAll();

    @Query("SELECT * FROM subtask WHERE task_id = :taskId")
    Flowable<List<Subtask>> viewSubtaskOfTask(String taskId);

    @Query("SELECT * FROM subtask WHERE subtask_id = :subtaskId LIMIT 1")
    Flowable<Subtask> getSubtask(String subtaskId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Subtask subtask);

    @Query("DELETE FROM subtask")
    void deleteAllSubtasks();

    @Delete
    void deleteSubtask(Subtask subtask);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Subtask subtask);
}
