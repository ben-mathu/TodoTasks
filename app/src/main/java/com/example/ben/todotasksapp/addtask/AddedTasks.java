package com.example.ben.todotasksapp.addtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ben.todotasksapp.R;

import java.util.List;

public class AddedTasks extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_tasks);
        /*textView=findViewById(R.id.infoview);
        List<Taskdetails> viewall= AddTaskActivity.mydatabase.myDao().viewAll();
        String info="";
        for (Taskdetails taskdetails:viewall){
       String newtsk=taskdetails.getNewtask();
       String desc=taskdetails.getDescription();
       String date=taskdetails.getDate();
       info=info+"\n\n"+"\n TaskDetails name:"+newtsk+" \ndescription:"+desc+"\n date:"+date;
        }
        textView.setText(info);*/
    }

}
