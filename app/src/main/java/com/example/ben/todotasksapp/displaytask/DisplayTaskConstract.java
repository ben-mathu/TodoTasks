package com.example.ben.todotasksapp.displaytask;

import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.Date;
import java.util.List;

public interface DisplayTaskConstract {
    interface View {
        void showProgress();

        void showData(String taskName, String descrition, Date dueDate);

        void showMessage(String message);

        void hideProgress();
    }
    interface Presenter {
        void loadData();
    }
}
