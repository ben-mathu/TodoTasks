package com.example.ben.todotasksapp.data.task;

import android.content.Context;

import java.util.List;


public class LocalTaskDataSource implements TaskDataSource {

    private Task task;
    private TaskDao taskDao;

    public LocalTaskDataSource(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Task getTask() {
        return taskDao.getTask(task.getTaskNum());
    }

    @Override
    public List<Task> getTasks() {
        return taskDao.getTasks();
    }

    @Override
    public void insertOrUpdateTask(Task task){
        taskDao.insertTask(task.getTaskNum());
    }

    @Override
    public void deleteAllTasks() {
        taskDao.deleteAllTasks();
    }

    @Override
    public void deleteTask(Task task) {
        taskDao.deleteTask(task.getTaskNum());
    }
}
