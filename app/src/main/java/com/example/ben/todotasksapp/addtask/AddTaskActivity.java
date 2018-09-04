package com.example.ben.todotasksapp.addtask;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ben.todotasksapp.DatePickerFragment;
import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.TimePickerFragment;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;
import com.example.ben.todotasksapp.tasklist.ListTaskActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity implements AddTaskContract.View, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US);
    private Calendar calendar = Calendar.getInstance();

    private static final String TAG = "Message";
    private AddTaskPresenter addTaskPresenter;
    private AddSubtaskPresenter addSubtaskPresenter;

    private SubtaskAdapter subtaskAdapter;

    EditText edtTaskName, edtDescription;
    Button btnAddSubTask, btnContinue, viewAddedTask;
    private TextView txtSelectTime;
    private TextView txtSelectDate;
    private ListView listView;

    private List<Subtask> subtasks;
    private SubtaskList subtaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do_task);

        subtasks = new LinkedList<>();
        subtaskList = new SubtaskList();

        addTaskPresenter = new AddTaskPresenter(this, this);
        addSubtaskPresenter = new AddSubtaskPresenter(this, this, subtaskList);

        edtTaskName = findViewById(R.id.nameEditext);
        edtDescription = findViewById(R.id.descText);
        btnContinue = findViewById(R.id.btn_save);
        viewAddedTask = findViewById(R.id.viewAll);
        txtSelectDate = findViewById(R.id.textView_date_to_complete);
        txtSelectTime = findViewById(R.id.textView_time_to_complete);
        btnAddSubTask = findViewById(R.id.btn_add_subtask);
        listView = findViewById(R.id.listView_add_subtasks);

        btnAddSubTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSubtaskPresenter.addSubtask();
                addSubtaskPresenter.loadData();
            }
        });

        txtSelectDate.setOnClickListener (new View.OnClickListener () {
            @NonNull
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "Date picker");
            }
        });

        txtSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getSupportFragmentManager(), "Time picker");
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = edtTaskName.getText().toString();
                String description = edtDescription.getText().toString();
                String dueDate = txtSelectDate.getText().toString();
                String dueTime = txtSelectTime.getText().toString();

                Calendar c = Calendar.getInstance();

                try {
                    String strDate[] = dueDate.split("/");
                    int year = Integer.parseInt(strDate[2]);
                    int month = Integer.parseInt(strDate[1]);
                    int day = Integer.parseInt(strDate[0]);

                    String strTime[] = dueTime.split(":");
                    int hourOfDay = Integer.parseInt(strTime[0]);
                    int minute = Integer.parseInt(strTime[1]);

                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, month);
                    c.set(Calendar.DAY_OF_MONTH, day);
                    c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    c.set(Calendar.MINUTE, minute);
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    Toast.makeText(AddTaskActivity.this, "Choose a date and time", Toast.LENGTH_SHORT).show();
                }



                long mills = c.getTimeInMillis();

                Date date = new Date(mills);
                addTaskPresenter.saveData(taskName, description, date, subtaskList);

                /*Taskdetails taskdetails = new Taskdetails();
                taskdetails.setId(UUID.randomUUID().toString());
                taskdetails.setNewtask(tasnew);
                taskdetails.setDescription(description1);
                taskdetails.setDate(duedat);
                AddTaskActivity.mydatabase.myDao().addTask(taskdetails);
                Toast.makeText(AddTaskActivity.this, "data successfully added", Toast.LENGTH_SHORT).show();*/
            }
        });

        viewAddedTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTaskActivity.this, ListTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Throwable throwable = new Throwable();
        Log.d(TAG, message, throwable);
    }

    @Override
    public void showData(List<Subtask> subtasks) {
        this.subtasks = subtasks;
        subtaskAdapter = new SubtaskAdapter(AddTaskActivity.this, addSubtaskPresenter, subtaskList);
        listView.setAdapter(subtaskAdapter);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        String timeOfDay = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        txtSelectTime.setText(timeOfDay);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String strTodaysDate = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        txtSelectDate.setText(strTodaysDate);
    }
}
