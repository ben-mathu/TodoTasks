package com.example.ben.todotasksapp.displaytask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.task.TaskRepository;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayTaskActivity extends AppCompatActivity implements DisplayTaskConstract.View {
    private static final String TASK_ID = "taskId";
    private static final String TAG = "messageTask";

    private ProgressBar progressBar;
    private TextView txtTaskName, txtDescription, txtDueDate;

    private DisplayTaskPresenter displayTaskPresenter;

    private String taskId;
    private String taskName, description;
    private Date dueDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_task);

        taskId = getIntent().getStringExtra(TASK_ID);


        progressBar = findViewById(R.id.progressbar_display);
        txtTaskName = findViewById(R.id.textView_display_task_name);
        txtDescription = findViewById(R.id.textView_display_task_description);
        txtDueDate = findViewById(R.id.textView_display_due_date);

        displayTaskPresenter = new DisplayTaskPresenter(this, this, taskId);

        displayTaskPresenter.loadData();

        txtTaskName.setText(taskName);
        txtDescription.setText(description);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss'Z'", Locale.US);
                Date date = Calendar.getInstance().getTime();
                long millis = dueDate.getTime() - date.getTime();

                Date remainingTime = new Date(millis);

                txtDueDate.setText(format.format(remainingTime));
            }
        }, 1000);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showData(String taskName, String description, Date dueDate) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public void showMessage(String message) {
        Log.d(TAG, message);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
