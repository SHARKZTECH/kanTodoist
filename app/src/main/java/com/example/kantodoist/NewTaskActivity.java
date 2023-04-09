package com.example.kantodoist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class NewTaskActivity extends AppCompatActivity {
    ImageView dateBtn;
    TextView dateView;
    int year, month, day;
    DatePicker datePicker;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        dateBtn=findViewById(R.id.dateBtn);
        dateView=findViewById(R.id.dateView);

        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        showDate(day,month+1,year);

        dateBtn.setOnClickListener(view -> {
            showDialog(999);
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==999){
            return new DatePickerDialog(this,myDateListener,year,month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i,i1+1,12);
        }
    };

    private void showDate(int year,int month,int day){
        dateView.setText(new StringBuffer().append(day).append("/")
                .append(month).append("/").append(year));
    }
}