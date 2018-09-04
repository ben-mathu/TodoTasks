package com.example.ben.todotasksapp.tasklist;

import android.content.Context;

import com.example.ben.todotasksapp.addtask.AddTaskContract;
import com.example.ben.todotasksapp.data.ApiEndPointInterface;
import com.example.ben.todotasksapp.data.subtask.SubtaskRepository;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;
import com.example.ben.todotasksapp.data.task.TaskRepository;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class ListTaskPresenter implements ListTaskContract.Presenter {
    private TaskRepository taskRepository;
    private SubtaskRepository subtaskRepository;

    private SubtaskList subtaskList;

    ApiEndPointInterface apiEndPointInterface;
    ListTaskContract.View mView;
    private Context context;
    private CompositeDisposable disposable;

    public ListTaskPresenter(ListTaskContract.View mView, Context context) {
        this.apiEndPointInterface = apiEndPointInterface;
        this.mView = mView;
        this.context = context;
        this.disposable = new CompositeDisposable();
        taskRepository = new TaskRepository(context);
        subtaskRepository = new SubtaskRepository(context);
        subtaskList = new SubtaskList();
    }

    @Override
    public void loadData() {
        mView.showProgress();

        disposable.add(taskRepository.getAll()
                .subscribe(taskDetails -> {
                    mView.showData(taskDetails);
                },throwable -> mView.showMessage(throwable.getMessage())));

        mView.hideProgress();
    }

    public void loadSubtask(String id) {
        mView.showProgress();

        disposable.add(subtaskRepository.getAllForTask(id)
                .subscribe(subtasks -> {
                    subtaskList.setSubtasks(subtasks);
                    mView.showSubtasks(subtaskList);
                }, throwable -> mView.showMessage(throwable.getMessage())));
        mView.hideProgress();
    }

    @Override
    public void unSubscribe() {
        disposable.dispose();
    }
}
