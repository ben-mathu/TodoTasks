//package com.example.ben.todotasksapp.tasklist;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.ben.todotasksapp.R;
//import com.example.ben.todotasksapp.data.task.model.TaskDetails;
//import com.example.ben.todotasksapp.displaytask.DisplayTaskActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.inject.Inject;
//
//public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskHolder>{
//    private List<TaskDetails> data;
//    private Context context;
//
//    public ListTaskAdapter(Context context) {
//        this.context = context;
//        data = new ArrayList<>();
//    }
//
//    @NonNull
//    @Override
//    public ListTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view;
//        LayoutInflater inflater = LayoutInflater.from(context);
//        view = inflater.inflate(R.layout.task_list_item, parent, false);
//
//        return new ListTaskHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ListTaskHolder holder, int position) {
//        holder.itemView
//        holder.txtDescription.setText(data.get(position).getDesription());
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//
//
//    public void setData(List<TaskDetails> data) {
//        this.data.addAll(data);
//        notifyDataSetChanged();
//    }
//}
//
//
//
