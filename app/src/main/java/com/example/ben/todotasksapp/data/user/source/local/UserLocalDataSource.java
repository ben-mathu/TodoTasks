package com.example.ben.todotasksapp.data.user.source.local;

import android.arch.lifecycle.LiveData;

import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;
import com.example.ben.todotasksapp.data.user.models.User;
import com.example.ben.todotasksapp.data.user.UserDao;
import com.example.ben.todotasksapp.data.user.source.UserDataSource;

import java.util.List;

public class UserLocalDataSource implements UserDataSource {

    private TodoTaskAppDatabase todoTaskAppDb;
    private UserDao userDao;

    public UserLocalDataSource(TodoTaskAppDatabase todoTaskAppDb) {
        this.userDao = todoTaskAppDb.userDao();
    }

    @Override
    public LiveData<List<User>> getAll() {
        return userDao.getUsers();
    }

    @Override
    public LiveData<User> getOne(String userId) {
        return userDao.getUser(userId);
    }

    @Override
    public void save(User user) {
        userDao.insert(user);
    }

    @Override
    public void delete(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAllUsers();
    }

    @Override
    public User getLastCreated() {
        return null;
    }
}
