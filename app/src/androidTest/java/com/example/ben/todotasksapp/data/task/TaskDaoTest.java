package com.example.ben.todotasksapp.data.task;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;

import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskDaoTest {
    private TodoTaskAppDatabase todoTaskAppDatabase;
    private Task task = new Task("Create a task");

    @Before
    public void initDb() throws Exception {
        todoTaskAppDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),TodoTaskAppDatabase.class).build();
    }

    @Test
    public void shouldInsertAndRetrieveTask() {
        //create a task
        todoTaskAppDatabase.taskDao().insertTask(1);

        //retrieve a task
        Task dbTask = todoTaskAppDatabase.taskDao().getTask(1);
        assertEquals(dbTask.getTaskName(), task.getTaskName());
    }

    @After
    public void closeDb() throws Exception {
        todoTaskAppDatabase.close();
    }
}