package com.example.ben.todotasksapp.tasklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.Item;
import com.example.ben.todotasksapp.data.ItemsLab;

import java.util.List;


/**
 * Created by Bernard on 8/1/2018.
 */

public class ListTaskActivity extends FragmentActivity implements ListTaskView {
    private TextView txtErrorMessage;

    private ListTaskPresenter listTaskPresenter;
    private List<Item> itemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        txtErrorMessage = findViewById(R.id.textView_error);

        listTaskPresenter = new ListTaskPresenter(this);
        itemList = listTaskPresenter.produceTaskItems();

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new ListTaskListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public List<Item> getTaskList() {
        return itemList;
    }

    @Override
    public void showErrorMassage(int resId) {
        txtErrorMessage.setVisibility(View.VISIBLE);
        txtErrorMessage.setError(getString(R.string.error_list_task));
    }
}
