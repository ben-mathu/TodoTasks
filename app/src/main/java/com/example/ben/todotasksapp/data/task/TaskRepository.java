package com.example.ben.todotasksapp.data.task;

import android.content.Context;

import com.example.ben.todotasksapp.data.DataSource;
import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TaskRepository implements DataSource<TaskDetails, String> {
    private TodoTaskAppDatabase todoTaskAppDatabase;

    private TaskDao taskDao;

    public TaskRepository(Context context) {
        todoTaskAppDatabase = TodoTaskAppDatabase.getTodoTaskAppDatabase(context);
        this.taskDao = todoTaskAppDatabase.taskDao();
    }

    @Override
    public Observable<List<TaskDetails>> getAll() {
        return taskDao.viewAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();
    }

    @Override
    public Observable<TaskDetails> getOne(String id) {
        return taskDao.getTask(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable();
    }

    @Override
    public void delete(TaskDetails item) {
        taskDao.deleteTask(item);
    }

    @Override
    public void deleteAll() {
        taskDao.deleteAllTasks();
    }

    @Override
    public void update(TaskDetails item) {
        taskDao.update(item);
    }

    @Override
    public void save(TaskDetails item) {
        taskDao.insertTask(item);
    }
}
