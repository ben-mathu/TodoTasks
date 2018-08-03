package com.example.ben.todotasksapp.data;

import java.util.List;
import java.util.UUID;

/**
 * Created by Bernard on 8/3/2018.
 */

public class Item {
    private List<String> taskName;
    private List<UUID> uuid;

    // sets the properties of a task
    public Item() {

    }

    public List<String> getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName.add(taskName);
    }

    public List<UUID> getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid.add(uuid);
    }
}
