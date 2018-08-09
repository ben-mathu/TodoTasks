package com.example.ben.todotasksapp.tasklist;

import com.example.ben.todotasksapp.data.Item;
import com.example.ben.todotasksapp.data.ItemsLab;

import java.util.List;

public interface ListTaskView {
    List<Item> getTaskList();

    void showErrorMassage(int resId);
}
