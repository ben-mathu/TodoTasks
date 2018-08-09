package com.example.ben.todotasksapp.data.user;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getUsers();

    @Query("SELECT * FROM users WHERE user_num = :userNum LIMIT 1")
    User getUser(int userNum);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdateUser(int userNum);

    @Query("DELETE FROM users")
    void deleteAllUsers();

    @Query("DELETE FROM users WHERE user_num = :userNum")
    void deleteUser(int userNum);
}
