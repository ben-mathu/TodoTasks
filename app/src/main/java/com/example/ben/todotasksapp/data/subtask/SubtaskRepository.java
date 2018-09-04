package com.example.ben.todotasksapp.data.subtask;

import android.content.Context;

import com.example.ben.todotasksapp.data.DataSource;
import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SubtaskRepository implements DataSource<Subtask, String> {
    private TodoTaskAppDatabase todoTaskAppDatabase;
    private SubtaskDao subtaskDao;

    public SubtaskRepository(Context context) {
        todoTaskAppDatabase = TodoTaskAppDatabase.getTodoTaskAppDatabase(context);
        this.subtaskDao = todoTaskAppDatabase.subtaskDao();
    }

    public Observable<List<Subtask>> getAllForTask(String id) {
        return subtaskDao.viewSubtaskOfTask(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();
    }

    @Override
    public Observable<List<Subtask>> getAll() {
        return subtaskDao.viewAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();
    }

    @Override
    public Observable<Subtask> getOne(String id) {
        return subtaskDao.getSubtask(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();
    }

    @Override
    public void delete(Subtask item) {
        subtaskDao.deleteSubtask(item);
    }

    @Override
    public void deleteAll() {
        subtaskDao.deleteAllSubtasks();
    }

    @Override
    public void update(Subtask item) {
        subtaskDao.update(item);
    }

    @Override
    public void save(Subtask item) {
        subtaskDao.insertTask(item);
    }
}
