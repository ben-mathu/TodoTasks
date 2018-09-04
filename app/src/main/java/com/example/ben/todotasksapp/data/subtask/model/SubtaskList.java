package com.example.ben.todotasksapp.data.subtask.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubtaskList {
    private Subtask subtask;
    private List<Subtask> subtasks;

    public SubtaskList() {
        subtasks = new LinkedList<>();
    }

    public Subtask getSubtask() {
        return subtask;
    }

    public void setSubtask(String subtaskTitle, int position) {
        subtask = new Subtask(subtaskTitle);
        subtasks.set(position, subtask);
    }

    public void setSubtask(String subtaskTitle) {
        subtask = new Subtask(subtaskTitle);
        subtasks.add(subtask);
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }
}
