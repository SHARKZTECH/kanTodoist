package com.example.kantodoist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class NewTaskActivity extends AppCompatActivity {
    ImageView dateBtn;
    TextView dateView;
    int year, month, day;
    DatePicker datePicker;
    Calendar calendar;
    FloatingActionButton fabAdd;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        dateBtn=findViewById(R.id.dateBtn);
        dateView=findViewById(R.id.dateView);
        fabAdd=findViewById(R.id.fabSave);
        text=findViewById(R.id.task);

        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        showDate(day,month+1,year);

        dateBtn.setOnClickListener(view -> {
            showDialog(999);
        });

        fabAdd.setOnClickListener(view -> {
            String task=text.getText().toString();

            Toast.makeText(this, task, Toast.LENGTH_SHORT).show();

            text.setText("");
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
            Toast.makeText(NewTaskActivity.this, "date set", Toast.LENGTH_SHORT).show();
        }
    };

    private void showDate(int year,int month,int day){
        dateView.setText(new StringBuffer().append(day).append("/")
                .append(month).append("/").append(year));
    }
}