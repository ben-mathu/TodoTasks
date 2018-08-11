package com.example.ben.todotasksapp.data.task.source.local;

import android.arch.lifecycle.LiveData;

import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;
import com.example.ben.todotasksapp.data.task.model.Task;
import com.example.ben.todotasksapp.data.task.TaskDao;
import com.example.ben.todotasksapp.data.task.source.TaskDataSource;

import java.util.List;


public class TaskLocalDataSource implements TaskDataSource {
    private TaskDao taskDao;

    public TaskLocalDataSource(TodoTaskAppDatabase todoTaskAppDatabase) {
        this.taskDao = todoTaskAppDatabase.taskDao();
    }

    @Override
    public LiveData<List<Task>> getAll() {
        return taskDao.getTasks();
    }

    @Override
    public LiveData<Task> getOne(String id) {
        return taskDao.getTask(id);
    }

    @Override
    public void save(Task task) {
        taskDao.insertTask(task);
    }

    @Override
    public void delete(Task task) {
        taskDao.deleteTask(task);
    }

    @Override
    public void update(Task task) {
        taskDao.update(task);
    }

    @Override
    public void deleteAll() {
        taskDao.deleteAllTasks();
    }

    @Override
    public Task getLastCreated() {
        return null;
    }
}
