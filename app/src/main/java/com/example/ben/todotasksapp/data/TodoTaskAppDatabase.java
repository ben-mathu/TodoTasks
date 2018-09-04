package com.example.ben.todotasksapp.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ben.todotasksapp.data.subtask.SubtaskDao;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;
import com.example.ben.todotasksapp.data.task.TaskDao;
import com.example.ben.todotasksapp.data.user.models.User;
import com.example.ben.todotasksapp.data.user.UserDao;

@Database(entities = {TaskDetails.class, User.class, Subtask.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)
public abstract class TodoTaskAppDatabase extends RoomDatabase {
    private static final String DB_NAME = "todoTaskAppDb.db";
    private static TodoTaskAppDatabase INSTANCE;

    public static TodoTaskAppDatabase getTodoTaskAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (TodoTaskAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, TodoTaskAppDatabase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d(DB_NAME, "Creating database, getting database.");
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract TaskDao taskDao();

    public abstract UserDao userDao();

    public abstract SubtaskDao subtaskDao();
}
