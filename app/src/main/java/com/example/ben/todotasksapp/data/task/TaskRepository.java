package com.example.ben.todotasksapp.data.task;

import android.arch.lifecycle.LiveData;

import com.example.ben.todotasksapp.data.task.model.Task;
import com.example.ben.todotasksapp.data.task.source.TaskDataSource;
import com.example.ben.todotasksapp.data.task.source.local.TaskLocalDataSource;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskRepository implements TaskDataSource {
    private final TaskLocalDataSource taskLocalDataSource;
    private final Executor executor;

    public TaskRepository(TaskLocalDataSource taskLocalDataSource, Executor executor) {
        this.taskLocalDataSource = taskLocalDataSource;
        this.executor = executor;
    }

    @Override
    public LiveData<List<Task>> getAll() {
        // TODO : create a method that updates local repository
        return taskLocalDataSource.getAll();
    }

    @Override
    public LiveData<Task> getOne(String id) {
        return taskLocalDataSource.getOne(id);
    }

    @Override
    public void save(Task task) {
        taskLocalDataSource.save(task);
    }

    @Override
    public void delete(Task task) {
        taskLocalDataSource.delete(task);
    }

    @Override
    public void update(Task task) {
        taskLocalDataSource.update(task);
    }

    @Override
    public void deleteAll() {
        taskLocalDataSource.deleteAll();
    }

    @Override
    public Task getLastCreated() {
        return null;
    }
}
