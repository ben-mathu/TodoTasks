package com.example.ben.todotasksapp.data;

import android.content.Context;

import java.util.List;
import java.util.UUID;

/**
 * Created by Bernard on 8/3/2018.
 */

public class ItemsLab {
    private Context context;
    private List<Item> items;

    private Item item;
    public ItemsLab(Context context) {
        item = new Item();
        this.context = context;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        for (int i = 0; i < 100; i++) {
            item.setTaskName("Task" + i);
            item.setUuid(UUID.randomUUID());
            items.add(item);
        }
    }
}
