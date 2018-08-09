package com.example.ben.todotasksapp.data.user;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;

import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class UserDaoTest {

    private TodoTaskAppDatabase todoTaskDb;

    @Before
    public void initDb() throws Exception {
        todoTaskDb = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), TodoTaskAppDatabase.class).build();
    }

    @After
    public void closeDb() throws Exception {
        todoTaskDb.close();
    }
}