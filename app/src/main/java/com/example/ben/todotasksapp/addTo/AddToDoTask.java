package com.example.ben.todotasksapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddToDoTask extends AppCompatActivity {
    EditText newtask, description;
    Switch aswitch;
    TextView startingDate, deadline;
    String editnewtask, edtextDescription;
    Button btnContinue;
    int day, month, year;

    private DatePickerDialog.OnDateSetListener dateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_to_do_task);
       // mpresenter=new CreateTodoPresenter(this);
        aswitch = findViewById (R.id.aswitchid);
        newtask = findViewById (R.id.nameEditext);
        description = findViewById (R.id.descText);
        startingDate = findViewById (R.id.textStartingDate);
        deadline = findViewById (R.id.textdeadline);
        btnContinue = findViewById (R.id.btncontinue);

        btnContinue.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                editnewtask = newtask.getText ().toString ().trim ();
                edtextDescription = description.getText ().toString ().trim ();
                Intent intent = new Intent (AddToDoTask.this, CapturedDatiles.class);
                intent.putExtra ("value", editnewtask);
                intent.putExtra ("value2", edtextDescription);
                startActivity (intent);
//                intent.putExtra("Date:", month +"/"+day+ "/"+ year+ "/");
//               intent.putExtra ("Task Name:", newtask);startActivity(intent);
//                finish ();
////        }


            }
        });
        startingDate.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance ();
                int year = cal.get (Calendar.YEAR);
                int month = cal.get (Calendar.MONTH);
                int day = cal.get (Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog (AddToDoTask.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        dateSetListener, year, month, day);
                dialog.getWindow ().setBackgroundDrawable (new ColorDrawable (Color.TRANSPARENT));
                dialog.show ();

            }
        });


        dateSetListener = new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                //  Log.d("on date set Date:mm/dd/yy" + month +"/"+ day ,"/"+ year);
            }
        };

        deadline.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance ();
                year = cal.get (Calendar.YEAR);
                month = cal.get (Calendar.MONTH);
                day = cal.get (Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog (AddToDoTask.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        dateSetListener, year, month, day);
                dialog.getWindow ().setBackgroundDrawable (new ColorDrawable (Color.TRANSPARENT));
                dialog.show ();

            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener () {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                // Log.d ("on date set Date:mm/dd/yy" + month + "/" + day, "/" + year);
                String date = month + "/" + day + "/" + year;
                startingDate.setText (date);
                deadline.setText (date);


            }
        };
    }

    public void onSwitchClick(View view) {
        if (aswitch.isChecked ())
            Toast.makeText (AddToDoTask.this, "high priority set", Toast.LENGTH_SHORT).show ();
        else
            Toast.makeText (AddToDoTask.this, "off", Toast.LENGTH_SHORT).show ();
    }


    public void cancel(View view) {

        System.exit (0);
    }



    }

