package com.example.ben.todotasksapp.tasklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;

import java.util.List;

class SubtaskAdapter extends BaseAdapter {
    private Subtask subtask;
    private List<Subtask> subtasks;
    private Context context;
    private View view;

    public SubtaskAdapter(Context context, List<Subtask> subtasks) {
        this.subtasks = subtasks;
        this.context = context;
    }

    @Override
    public int getCount() {
        return subtasks.size();
    }

    @Override
    public Object getItem(int position) {
        return subtasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(subtasks.get(position).getSubtaskId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RadioButton radioButton;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        subtask = subtasks.get(position);

        if (convertView == null) {
            view = new View(context);
            view = inflater.inflate(R.layout.subtasks_list, parent, false);
            radioButton = view.findViewById(R.id.subtask_radio);
            radioButton.setActivated(true);
            radioButton.setText(subtask.getSubtaskName());
        }
        return view;
    }
}
