package com.example.kantodoist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.kantodoist.db.AppDb;
import com.example.kantodoist.db.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {
    ImageView dateBtn,timeBtn;
    EditText dateView,timeView;
    int year, month, day,hrs,min;
    DatePicker datePicker;
    Calendar calendar;
    FloatingActionButton fabAdd;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dateBtn=findViewById(R.id.dateBtn);
        timeBtn=findViewById(R.id.timeBtn);
        dateView=findViewById(R.id.dateView);
        timeView=findViewById(R.id.timeView);
        fabAdd=findViewById(R.id.fabSave);
        text=findViewById(R.id.task);

        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hrs=calendar.get(Calendar.HOUR_OF_DAY);
        min=calendar.get(Calendar.MINUTE);
//        showDate(day,month+1,year);

        dateBtn.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog=new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                           dateView.setText(i2+"-"+(i1+1)+"-"+i);
                        }
                    },year,month,day);
            datePickerDialog.show();
        });

        timeBtn.setOnClickListener(view -> {
            TimePickerDialog timePickerDialog=new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int i, int i1) {
                            timeView.setText(i+":"+i1);
                        }
                    },hrs,min,false);
            timePickerDialog.show();
        });

        fabAdd.setOnClickListener(view -> {
            String task=text.getText().toString();
            calendar.set(year,month-1,day,hrs,min);
            Date date=calendar.getTime();

            Toast.makeText(this, date.toString(), Toast.LENGTH_SHORT).show();

            AppDb db=AppDb.getINSTANCE(this);
            Task task1=new Task();
            task1.text=task;
            task1.isDone=false;

            db.taskDao().addTask(task1);
            Toast.makeText(this, "Created!", Toast.LENGTH_SHORT).show();
            finish();
        });

    }

//    @Override
//    protected Dialog onCreateDialog(int id) {
//        if(id==999){
//            return new DatePickerDialog(this,myDateListener,year,month,day);
//        }
//        return null;
//    }
//
//    private DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
//            showDate(i,i1+1,i2);
//            year=i;
//            month=i1+1;
//            day=i2;
//        }
//    };
//
//    private void showDate(int year,int month,int day){
//        dateView.setText(new StringBuffer().append(day).append("/")
//                .append(month).append("/").append(year));
//    }
}