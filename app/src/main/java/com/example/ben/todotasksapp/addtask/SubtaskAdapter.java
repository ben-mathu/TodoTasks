package com.example.ben.todotasksapp.addtask;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ben.todotasksapp.R;
import com.example.ben.todotasksapp.data.subtask.model.Subtask;
import com.example.ben.todotasksapp.data.subtask.model.SubtaskList;

import java.util.ArrayList;
import java.util.List;

public class SubtaskAdapter extends BaseAdapter {
    private AddSubtaskPresenter addSubtaskPresenter;

    private final Context context;
    private View view;

    private List<Subtask> subtasks;
    private Subtask subtask;
    private SubtaskList subtaskList;

    private boolean subtaskExist = false;

    public SubtaskAdapter(Context context, AddSubtaskPresenter addSubtaskPresenter, SubtaskList subtaskList) {
        this.context = context;
        this.addSubtaskPresenter = addSubtaskPresenter;
        this.subtasks = subtaskList.getSubtasks();
        this.subtaskList = subtaskList;
    }

    @Override
    public int getCount() {
        return subtasks.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        subtask = subtasks.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            view = new View(context);

            view = inflater.inflate(R.layout.subtasks_list, parent, false);

            RadioButton  radioButton = view.findViewById(R.id.subtask_radio);
            EditText edtSubtask = view.findViewById(R.id.editView_subtask);



            edtSubtask.setVisibility(View.INVISIBLE);
            radioButton.setText(subtasks.get(position).getSubtaskName());

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edtSubtask.setText(subtask.getSubtaskName());
                    radioButton.setText("");
                    edtSubtask.setVisibility(View.VISIBLE);
                    subtaskExist = true;
                }
            });


            edtSubtask.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                        edtSubtask.setVisibility(View.INVISIBLE);
                        radioButton.setText(edtSubtask.getText());
                        if (subtaskExist) {
                            addSubtaskPresenter.updateData(radioButton.getText().toString(), position);
                        } else {
                            addSubtaskPresenter.saveData(radioButton.getText().toString(), null, null, null);
                        }
                    }
                    return false;
                }
            });

            subtaskExist = false;
        }
        return view;
    }
}
