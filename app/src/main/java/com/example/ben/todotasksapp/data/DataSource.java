package com.example.ben.todotasksapp.data;

import android.arch.lifecycle.LiveData;
import android.database.Observable;

import java.util.List;

public interface DataSource<T, E> {

    /*
    * Observable are used for event handling
    *   -declarative, ie methods defined for publishing values
    *   -are not executed until a user(consumer) subscribes to it.
    * T - represents a class to observe
    * E - represents a parameter to indicate an instance of the class T.
    *
    * <key, value> pairs
    * */
    LiveData<List<T>> getAll();
    LiveData<T> getOne(E id);

    void save(T item);
    void delete(T item);
    void update(T item);
    void deleteAll();
    T getLastCreated();
}
