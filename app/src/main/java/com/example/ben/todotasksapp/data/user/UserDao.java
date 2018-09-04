package com.example.ben.todotasksapp.data.user;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ben.todotasksapp.data.user.models.User;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    Flowable<List<User>> getUsers();

    @Query("SELECT * FROM users WHERE user_id = :userId LIMIT 1")
    Flowable<User> getUser(String userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("DELETE FROM users")
    void deleteAllUsers();

    @Delete
    void deleteUser(User user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);
}
