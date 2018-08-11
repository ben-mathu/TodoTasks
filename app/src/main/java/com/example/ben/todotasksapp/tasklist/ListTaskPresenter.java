package com.example.ben.todotasksapp.tasklist;

import android.arch.lifecycle.LiveData;

import com.example.ben.todotasksapp.data.task.TaskRepository;
import com.example.ben.todotasksapp.data.task.model.Task;

import java.util.List;

import javax.inject.Inject;

public class ListTaskPresenter {
    private TaskRepository taskRepository;
    private LiveData<List<Task>> tasks;

    @Inject
    public ListTaskPresenter(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void initTasks() {
        if (tasks != null) {
            return;
        }
        tasks = taskRepository.getAll();
    }

    public LiveData<List<Task>> getTasks() {
        return tasks;
    }
}
