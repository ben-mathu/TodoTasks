package com.example.ben.todotasksapp.addtask;

import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;

import java.util.Date;
import java.util.List;

public interface AddTaskContract {
    interface View {
        void showMessage(String message);

        void showData(List<Subtask> subtasks);
    }

    interface Presenter {
        void saveData(String taskName, String description, Date dueData, SubtaskList subtaskList);
        void loadData();
    }
}
