package com.example.ben.todotasksapp.displaytask;

import android.content.Context;

import com.example.ben.todotasksapp.data.TodoTaskAppDatabase;
import com.example.ben.todotasksapp.data.task.TaskRepository;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class DisplayTaskPresenter implements DisplayTaskConstract.Presenter {
    private DisplayTaskConstract.View mView;
    private CompositeDisposable disposible;
    private TaskRepository taskRepository;
    private Context context;
    private String taskId;

    public DisplayTaskPresenter(Context context, DisplayTaskConstract.View view, String taskId) {
        this.context = context;
        this.mView = view;
        this.taskId = taskId;
        this.disposible = new CompositeDisposable();
        this.taskRepository = new TaskRepository(context);
    }

    @Override
    public void loadData() {
        mView.showProgress();

        disposible.add(taskRepository.getOne(taskId)
                .subscribe(taskDetails -> {
                    mView.showData(taskDetails.getTaskName(), taskDetails.getDesription(), taskDetails.getDueDate());
                },throwable -> mView.showMessage(throwable.getMessage())));
        mView.hideProgress();
    }
}
