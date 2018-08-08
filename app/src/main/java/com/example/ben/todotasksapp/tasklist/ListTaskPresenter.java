package com.example.ben.todotasksapp.tasklist;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.Item;
import com.example.ben.todotasksapp.data.ItemsLab;

import java.util.List;

public class ListTaskPresenter {
    private ListTaskView listTaskView;
    private ItemsLab itemsLab;

    private List<Item> itemList;

    public ListTaskPresenter(ListTaskView listTaskView) {
        this.listTaskView = listTaskView;
    }

    public List<Item> produceTaskItems() {
        return listTaskView.getTaskList();
    }
}
