package com.example.ben.todotasksapp.tasklist;

import android.arch.lifecycle.LiveData;

import com.example.ben.todotasksapp.data.task.model.Task;

public interface ListTaskView {
    LiveData<Task> getTask();
}
