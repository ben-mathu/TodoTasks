package com.example.ben.todotasksapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ben.todotasksapp.data.task.model.Task;
import com.example.ben.todotasksapp.data.task.TaskDao;
import com.example.ben.todotasksapp.data.user.models.User;
import com.example.ben.todotasksapp.data.user.UserDao;

@Database(entities = {Task.class, User.class}, version = 1, exportSchema = false)
public abstract class TodoTaskAppDatabase extends RoomDatabase {

    private static TodoTaskAppDatabase INSTANCE;

    public abstract TaskDao taskDao();

    public abstract UserDao userDao();
}
