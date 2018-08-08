package com.example.ben.todotasksapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CapturedDatiles extends AppCompatActivity {
    String valfrmact1,valfrmactvty1;
    //Date date;
    TextView txtviewt1, txtviewt2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_captured_datiles);


            txtviewt2=findViewById (R.id.txt2);
            txtviewt1=findViewById (R.id.tvte);
            valfrmact1=getIntent ().getExtras ().getString ("value");
            txtviewt1.setText ( valfrmact1);
            valfrmactvty1=getIntent ().getExtras ().getString ("value2");
        }
    }

