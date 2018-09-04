package com.example.ben.todotasksapp.tasklist;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.addtask.AddTaskActivity;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;

import java.util.List;


/**
 * Created by Bernard on 8/1/2018.
 */

public class ListTaskActivity extends FragmentActivity {
    private Button btnAddTask;

    private ListTaskPresenter listTaskPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);



        btnAddTask = findViewById(R.id.button_add_task);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTaskActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new ListTaskFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
