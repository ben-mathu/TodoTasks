package com.example.ben.todotasksapp.RoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Taskdetails.class},version = 1, exportSchema = false)
public abstract class Mydatabase extends RoomDatabase{
    public abstract MyDao myDao ();
}
