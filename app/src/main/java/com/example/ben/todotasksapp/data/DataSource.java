package com.example.ben.todotasksapp.data;

import java.util.List;

import io.reactivex.Observable;

public interface DataSource<T, E> {
    Observable<List<T>> getAll();
    Observable<T> getOne(E id);

    void delete(T item);
    void deleteAll();
    void update(T item);
    void save(T item);
}
