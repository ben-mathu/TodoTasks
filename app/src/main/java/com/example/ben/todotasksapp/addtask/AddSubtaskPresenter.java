package com.example.ben.todotasksapp.addtask;

import android.content.Context;
import android.os.AsyncTask;

import com.example.ben.todotasksapp.data.subtask.SubtaskRepository;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;

import java.util.Date;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class AddSubtaskPresenter implements AddTaskContract.Presenter {

    private Subtask subtask;
    private AddTaskContract.View mView;
    private Context context;
    private SubtaskList subtaskList;

    public AddSubtaskPresenter(AddTaskContract.View mView, Context context, SubtaskList subtaskList) {
        this.mView = mView;
        this.context = context;
        this.subtaskList = subtaskList;
    }

    @Override
    public void saveData(String taskName, String description, Date dueData, SubtaskList subtaskList) {
        if (taskName != null) {
            subtaskList.setSubtask(taskName);
            mView.showMessage("Saved subtask");
        } else {
            mView.showMessage("Field is empty");
        }
    }

    @Override
    public void loadData() {
        mView.showData(subtaskList.getSubtasks());
    }

    public void updateData(String subtaskName, int position) {
        subtaskList.setSubtask(subtaskName, position);
        mView.showMessage("Subtask updated.");
    }

    public void addSubtask() {
        subtaskList.setSubtask("Add a subtask");
    }
}
