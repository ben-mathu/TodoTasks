package com.example.ben.todotasksapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.ben.todotasksapp.data.task.Task;
import com.example.ben.todotasksapp.data.task.TaskDao;
import com.example.ben.todotasksapp.data.user.User;

@Database(entities = {Task.class, User.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class TodoTaskAppDatabase extends RoomDatabase {

    private static TodoTaskAppDatabase INSTANCE;

    public abstract TaskDao taskDao();
}
