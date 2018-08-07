package com.example.ben.todotasksapp.tasklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.Item;
import com.example.ben.todotasksapp.data.ItemsLab;
import com.example.ben.todotasksapp.displaytask.DisplayTaskActivity;
import com.example.ben.todotasksapp.displaytask.DisplayTaskFragment;

import java.util.List;

/**
 * Created by Bernard on 8/3/2018.
 */

public class ListTaskListFragment extends Fragment {
    private RecyclerView recyclerViewTaskList;

    private ListTasksAdapter listTasksAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_list_task_items, container, false);
        recyclerViewTaskList = view.findViewById(R.id.recyclerView_task_list);
        recyclerViewTaskList.setLayoutManager(new LinearLayoutManager(getActivity()));

//        updateUi();
        
        listTasksAdapter = new ListTasksAdapter(getActivity());
        recyclerViewTaskList.setAdapter(listTasksAdapter);

        return view;
    }

    /*
     * this function updates the UI
     * whenever the user scrolls through the list
     */
    /*private void updateUi() {
        listTasksAdapter = new ListTasksAdapter(getActivity());
        recyclerViewTaskList.setAdapter(listTasksAdapter);
    }*/

    private class ListTasksHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTaskName, txtTime, txtDescription, txtContributors;

        public ListTasksHolder(View itemView) {
            super(itemView);

            txtContributors = itemView.findViewById(R.id.textView_contributors_tags);
            txtDescription = itemView.findViewById(R.id.textView_task_description);
            txtTaskName = itemView.findViewById(R.id.textView_task_name);
            txtTime = itemView.findViewById(R.id.textView_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), DisplayTaskActivity.class);
            startActivity(intent);
        }
    }

    private class ListTasksAdapter extends RecyclerView.Adapter<ListTasksHolder> {
        private ItemsLab itemsLab;
        private List<Item> itemTasks;
        private Context context;

        public ListTasksAdapter(Context context) {
            this.context = context;
            itemsLab = new ItemsLab(context);
            itemsLab.setItems();
            itemTasks = itemsLab.getItems();
        }

        @NonNull
        @Override
        public ListTasksHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.task_list_item, parent, false);
            return new ListTasksHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ListTasksHolder holder, int position) {
            holder.txtTaskName.setText(itemTasks.get(position).getTaskName().toString());
            holder.txtDescription.setText("Hey I need a description");
            holder.txtContributors.setText("benard");
            new CountDownTimer(30000, 1000) {

                @Override
                public void onTick(long l) {
                    holder.txtTime.setText(String.valueOf(l/1000));
                }

                @Override
                public void onFinish() {
                    holder.txtTime.setText("Done!");
                }
            }.start();
        }

        @Override
        public int getItemCount() {
            return itemTasks.size();
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }
    }
}

