package com.example.ben.todotasksapp.addtask;

import android.content.Context;
import android.os.AsyncTask;

import com.example.ben.todotasksapp.data.subtask.SubtaskRepository;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;
import com.example.ben.todotasksapp.data.task.TaskRepository;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class AddTaskPresenter implements AddTaskContract.Presenter{

    private TaskDetails taskDetails;
    private List<Subtask> subtasks;
    private SubtaskList subtaskList;

    private AddTaskContract.View mView;
    public Context context;

    public AddTaskPresenter(AddTaskContract.View mView, Context context) {
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void saveData(String taskName, String description, Date dueData, SubtaskList subtaskList) {
        this.subtaskList = subtaskList;
        if (taskName != null && description != null && dueData != null) {
            taskDetails = new TaskDetails(taskName, description, dueData);
            new TaskAsyncTask(context, taskDetails, subtasks, subtaskList).execute();
            mView.showMessage("Successfully saved task");
        } else {
            mView.showMessage("Some fields are empty!");
        }
    }

    @Override
    public void loadData() {
    }

    private static class TaskAsyncTask extends AsyncTask<Void, Void, Void> {
        TaskRepository taskRepository;
        SubtaskRepository subtaskRepository;
        private TaskDetails value_1;
        private List<Subtask> subtasks;
        private SubtaskList subtaskList;

        public TaskAsyncTask(Context context, TaskDetails value_1, List<Subtask> subtasks, SubtaskList subtaskList) {
            taskRepository = new TaskRepository(context);
            subtaskRepository = new SubtaskRepository(context);
            this.value_1 = value_1;
            this.subtasks = subtasks;
            this.subtaskList = subtaskList;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (Subtask subtask : subtaskList.getSubtasks()) {
                subtask.setTaskId(value_1.getTaskId());
                subtaskRepository.save(subtask);
            }
            taskRepository.save(value_1);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
