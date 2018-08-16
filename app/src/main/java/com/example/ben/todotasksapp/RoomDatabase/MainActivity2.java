package com.example.ben.todotasksapp.RoomDatabase;
import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.todotasksapp.R;


import java.util.Calendar;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {
    public static Mydatabase mydatabase;
    EditText newtask, description;
    //Switch aswitch;
    TextView duedate;

    Button btnContinue, viewAddedTask;
    int day, month, year;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydatabase=Room.databaseBuilder(getApplicationContext(),Mydatabase.class,"RoomDb").allowMainThreadQueries().build();

        setContentView(R.layout.activity_main2);
        newtask=findViewById(R.id.nameEditext);
        description=findViewById(R.id.descText);
        btnContinue=findViewById(R.id.btncontinue);
        viewAddedTask=findViewById(R.id.viewAll);
        duedate=findViewById(R.id.dueDate);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tasnew = newtask.getText().toString();
                String description1 = description.getText().toString();
                String duedat = duedate.getText().toString();

                Taskdetails taskdetails = new Taskdetails();
                taskdetails.setId(UUID.randomUUID().toString());
                taskdetails.setNewtask(tasnew);
                taskdetails.setDescription(description1);
                taskdetails.setDate(duedat);
                MainActivity2.mydatabase.myDao().addTask(taskdetails);
                Toast.makeText(MainActivity2.this, "data successfully added", Toast.LENGTH_SHORT).show();
                newtask.setText("");
                description.setText("");
                duedate.setText("");
            }


        });
        duedate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance ();
                year = cal.get (Calendar.YEAR);
                month = cal.get (Calendar.MONTH);
                day = cal.get (Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog (MainActivity2.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        dateSetListener, year, month, day);
                dialog.getWindow ().setBackgroundDrawable (new ColorDrawable(Color.TRANSPARENT));
                dialog.show ();

            }
        });


        dateSetListener = new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                //month = month + 1;
                //  Log.d("on date set Date:mm/dd/yy" + month +"/"+ day ,"/"+ year);
            }
        };
        viewAddedTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(MainActivity2.this,AddedTasks.class) ;
                startActivity(intent);
            }
        });

    }

}
