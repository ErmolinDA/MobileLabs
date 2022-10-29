package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivityLab4 extends AppCompatActivity {
    private Button dateButton;
    private Button touchButton;
    private Switch switchLab4;
    private TextView switchText;
    private SeekBar seekBar;
    private TextView seekBarText;
    private TextView dateText;
    private TextView timeText;
    private TextView touchButtonText;
    private TextView counterText;
    private int counter = 0;
    private  int day, month, year;
    private int hour, minute;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab4);
        dateButton = findViewById(R.id.dateButton);
        touchButton = findViewById(R.id.touchButton);
        switchLab4 = findViewById(R.id.switchLab4);
        seekBar = findViewById(R.id.seekBarLab4);
        seekBarText = findViewById(R.id.seekBarText);
        switchText = findViewById(R.id.switchText);
        dateText = findViewById(R.id.dateText);
        timeText = findViewById(R.id.timeText);
        touchButtonText = findViewById(R.id.touchText);
        counterText = findViewById(R.id.counter);

        touchButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int eventType = motionEvent.getActionMasked();

                switch (eventType){
                    case MotionEvent.ACTION_UP:
                        touchButtonText.setText("ОТПУЩЕНА");
                        touchButton.setText("Отпущена");
                        System.out.println(1);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        touchButtonText.setText("НАЖАТА");
                        touchButton.setText("Нажата");
                        counter += 1;
                        counterText.setText(Integer.toString(counter));
                        System.out.println(2);
                        break;

                }

                return true;
            }
        });

        switchLab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchLab4.isChecked())
                    switchText.setText("Включено");
                else
                    switchText.setText("Выключено");
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarText.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClickDate(View view) {


        DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yearT, int monthT, int dayT) {
                day = dayT;
                month = monthT + 1;
                year = yearT;
                dateText.setText(String.format("%02d.%02d.%d",day,month,year));
            }
        };

        DatePickerDialog datePicker = new DatePickerDialog(this, dateListener, year, month, day);
        datePicker.show();
    }

    public void onClickLab4back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void obClickTime(View view) {
        TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourT, int minuteT) {
                hour = hourT;
                minute = minuteT;
                timeText.setText(String.format("%02d.%02d",hour, minute));
            }
        };

        TimePickerDialog timePicker = new TimePickerDialog(this, timeListener, hour, minute, true);
        timePicker.show();
    }

}