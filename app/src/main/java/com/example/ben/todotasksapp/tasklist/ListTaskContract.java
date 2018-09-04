package com.example.ben.todotasksapp.tasklist;

import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;

public interface ListTaskContract {
    interface View {
        void showData(List<TaskDetails> data);

        void showProgress();

        void showComplete();

        void hideProgress();

        void showMessage(String message);

        void showSubtasks(SubtaskList subtaskList);
    }

    interface Presenter {
        void loadData();
        void unSubscribe();
    }
}
