package com.example.ben.todotasksapp.data.user;

import java.util.List;

public class LocalUserDataSource implements UserDataSource{
    UserDao userDao;
    private User user;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user.getUserNum());
    }

    @Override
    public void insertOrUpdateUser(User user) {
        userDao.insertOrUpdateUser(user.getUserNum());
    }

    @Override
    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user.getUserNum());
    }
}
