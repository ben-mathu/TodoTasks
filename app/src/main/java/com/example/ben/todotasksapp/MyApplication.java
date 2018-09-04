package com.example.ben.todotasksapp;

import android.app.Application;

import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;

public class MyApplication extends Application {
    private TodoTaskAppDatabase todoTaskAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        todoTaskAppDatabase = TodoTaskAppDatabase.getTodoTaskAppDatabase(this);
    }
}

