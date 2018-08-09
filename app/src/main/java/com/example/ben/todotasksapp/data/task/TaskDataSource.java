package com.example.ben.todotasksapp.data.task;

import java.util.List;

public interface TaskDataSource {

    Task getTask();
    List<Task> getTasks();
    void insertOrUpdateTask(Task task);
    void deleteAllTasks();
    void deleteTask(Task task);
}
