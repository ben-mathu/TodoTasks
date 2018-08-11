package com.example.ben.todotasksapp.data.user;

import android.arch.lifecycle.LiveData;

import com.example.ben.todotasksapp.data.user.models.User;
import com.example.ben.todotasksapp.data.user.source.UserDataSource;
import com.example.ben.todotasksapp.data.user.source.local.UserLocalDataSource;

import java.util.List;
import java.util.concurrent.Executor;

public class UserRepository implements UserDataSource {

    private final Executor executor;
    private final UserLocalDataSource userLocalDataSource;

    public UserRepository(UserLocalDataSource userLocalDataSource, Executor executor) {
        this.userLocalDataSource = userLocalDataSource;
        this.executor = executor;
    }

    @Override
    public LiveData<List<User>> getAll() {
        // TODO : create a method to update local repository
        return userLocalDataSource.getAll();
    }

    @Override
    public LiveData<User> getOne(String id) {
        return userLocalDataSource.getOne(id);
    }

    @Override
    public void save(User user) {
        userLocalDataSource.save(user);
    }

    @Override
    public void delete(User user) {
        userLocalDataSource.delete(user);
    }

    @Override
    public void update(User user) {
        userLocalDataSource.update(user);
    }

    @Override
    public void deleteAll() {
        userLocalDataSource.deleteAll();
    }

    @Override
    public User getLastCreated() {
        return null;
    }
}
