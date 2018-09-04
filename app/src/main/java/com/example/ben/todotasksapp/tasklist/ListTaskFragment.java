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
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.addtask.AddTaskActivity;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;
import com.example.ben.todotasksapp.data.task.model.TaskDetails;
import com.example.ben.todotasksapp.displaytask.DisplayTaskActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Bernard on 8/3/2018.
 */

public class ListTaskFragment extends Fragment implements ListTaskContract.View {
    private static final String TASK_NAME = "task_name";
    private static final String TAG = "message_tag";


    private TextView txtMessage;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public ListTaskAdapter listTaskAdapter;

    ListTaskPresenter listTaskPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listTaskPresenter = new ListTaskPresenter(this, getActivity());
        View view;
        view = inflater.inflate(R.layout.fragment_list_task_items, container, false);


        txtMessage = view.findViewById(R.id.textView_message);
        progressBar = view.findViewById(R.id.progressbar);
        recyclerView = view.findViewById(R.id.recyclerView_task_list);
        listTaskAdapter = new ListTaskAdapter(getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(listTaskAdapter);

        listTaskPresenter.loadData();

        return view;
    }

    private class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ListTaskHolder>{
        private List<TaskDetails> data;
        private SubtaskList subtaskList;
        private Context context;
        private String strDueDate;

        public ListTaskAdapter(Context context) {
            this.context = context;
            data = new ArrayList<>();
            subtaskList = new SubtaskList();
        }

        @NonNull
        @Override
        public ListTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.task_list_item, parent, false);

            if (data.isEmpty()){
                txtMessage.setText("No Task, click on add button to add task");
            } else {
                txtMessage.setVisibility(View.GONE);
            }

            return new ListTaskHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ListTaskHolder holder, int position) {
            listTaskPresenter.loadSubtask(data.get(position).getTaskId());

            holder.txtTaskName.setText(data.get(position).getTaskName());
            holder.txtContributors.setText("Benard");
            Date date = Calendar.getInstance().getTime();
            Date dueDate = data.get(position).getDueDate();
            long millis = dueDate.getTime() - date.getTime();
            strDueDate = DateFormat.format("yyyy-MM-dd", new Date(millis)).toString();
            new CountDownTimer(millis, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    holder.txtUtilizedTime.setText("" + millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    Toast.makeText(getActivity(), "Time has run out", Toast.LENGTH_SHORT).show();
                }
            }.start();
            holder.listViewSubtask.setAdapter(new SubtaskAdapter(getActivity(), subtaskList.getSubtasks()));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        class ListTaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private static final String TASK_ID = "taskId";
            private TextView txtTaskName;
            private TextView txtUtilizedTime;
            private TextView txtContributors;
            private ListView listViewSubtask;

            public ListTaskHolder(View itemView) {
                super(itemView);
                txtTaskName = itemView.findViewById(R.id.textView_task_name);
                txtUtilizedTime = itemView.findViewById(R.id.textView_list_task_time);
                txtContributors = itemView.findViewById(R.id.textView_contributors_tags);
                listViewSubtask = itemView.findViewById(R.id.listView_subtask);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DisplayTaskActivity.class);
                intent.putExtra(TASK_ID, data.get(getAdapterPosition()).getTaskId());
                startActivity(intent);
            }
        }

        public void setData(List<TaskDetails> data) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

        public void setSubtasks(SubtaskList subtaskList) {
            this.subtaskList = subtaskList;
            notifyDataSetChanged();
        }
    }

    @Override
    public void showData(List<TaskDetails> data) {
        listTaskAdapter.setData(data);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }

    @Override
    public void showSubtasks(SubtaskList subtaskList) {
        listTaskAdapter.setSubtasks(subtaskList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listTaskPresenter.unSubscribe();
    }
}

