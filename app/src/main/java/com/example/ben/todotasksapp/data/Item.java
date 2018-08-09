package com.example.ben.todotasksapp.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Bernard on 8/3/2018.
 */

public class Item {
    private String taskName;
    private UUID uuid;

    // sets the properties of a task
    public Item() {

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
