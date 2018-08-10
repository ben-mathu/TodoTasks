package com.example.ben.todotasksapp.addTo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.todotasksapp.R;

import java.util.Calendar;

public class AddToDoTask extends AppCompatActivity {
   Dbhelper dbhelper;
    EditText newtask, description;
    Switch aswitch;
    TextView startingDate, deadline;

    Button btnContinue, viewAddedTask;
    int day, month, year;

    private DatePickerDialog.OnDateSetListener dateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_to_do_task);
       // mpresenter=new CreateTodoPresenter(this);
        dbhelper=new Dbhelper(this);
        aswitch = findViewById (R.id.aswitchid);
        newtask = findViewById (R.id.nameEditext);
        description = findViewById (R.id.descText);
        startingDate = findViewById (R.id.textStartingDate);
        deadline = findViewById (R.id.textdeadline);
        btnContinue = findViewById (R.id.btncontinue);
        viewAddedTask=findViewById(R.id.viewAll);
        showMessage();
        //        btnContinue.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//                editnewtask = newtask.getText ().toString ().trim ();
//                edtextDescription = description.getText ().toString ().trim ();
                btnContinue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted =dbhelper.insertData(newtask.getText().toString(),description.getText().toString(),deadline.getText().toString(),startingDate.getText().toString());
                        if (isInserted) {
                            Toast.makeText( AddToDoTask.this, "data successfully inserted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText( AddToDoTask.this, "data not ineserted",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//                Intent intent = new Intent (AddToDoTask.this, CapturedDatiles.class);
//                intent.putExtra ("value", editnewtask);
//                intent.putExtra ("value2", edtextDescription);
//                startActivity (intent);intent
//                intent.putExtra("Date:", month +"/"+day+ "/"+ year+ "/");
//               intent.putExtra ("Task Name:", newtask);startActivity(intent);
//                finish ();
////        }



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
    public void showMessage(){
        viewAddedTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = dbhelper.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error!", "No content Recorded");
                    return;
                }
                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("id:").append(res.getString(0)).append("\n");
                    buffer.append("Task Name:").append(res.getString(1)).append("\n");
                    buffer.append("Description:").append(res.getString(2)).append("\n");
                    buffer.append("starting Date:").append(res.getString(3)).append("\n");
                    buffer.append("deadline:").append(res.getString(4)).append("\n");
                }
                //show all data
                showMessage("ALL Data",buffer.toString() );
            }
        });

    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        //
        builder.show();
    }




    }

