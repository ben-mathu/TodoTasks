package com.example.ben.todotasksapp.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void addTask(Taskdetails taskdetails);

    @Query("select*from task_details")

    public List<Taskdetails>viewAll();

}

