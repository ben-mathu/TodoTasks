package com.example.ben.todotasksapp.data.user;

import java.util.List;

public interface UserDataSource {
    List<User> getUsers();
    User getUser(User user);
    void insertOrUpdateUser(User user);
    void deleteAllUsers();
    void deleteUser(User user);
}
