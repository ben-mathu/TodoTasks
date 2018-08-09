package com.example.ben.todotasksapp.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Bernard on 8/3/2018.
 */

public class ItemsLab {
    private Context context;
    private List<Item> items;

    public ItemsLab(Context context) {
        items = new ArrayList<>();
        this.context = context;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems() {
        Item item = new Item();
        for (int i = 0; i < 100; i++) {
            item.setTaskName("Task ");
            item.setUuid(UUID.randomUUID());
            items.add(item);
        }
    }
}
