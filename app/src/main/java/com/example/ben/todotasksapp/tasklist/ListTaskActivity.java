package com.example.ben.todotasksapp.tasklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.example.ben.todotasksapp.R;

import java.util.List;


/**
 * Created by Bernard on 8/1/2018.
 */

public class ListTaskActivity extends FragmentActivity {
    private TextView txtErrorMessage;

    private ListTaskPresenter listTaskPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        txtErrorMessage = findViewById(R.id.textView_error);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new ListTaskListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
