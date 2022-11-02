package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivityLab7 extends AppCompatActivity {
    private CountDownTimer countDownTimertimer;
    private long second = 0;
    private ImageView red;
    private ImageView yellow;
    private ImageView green;
    private ImageView move;
    private TextView textHello;
    private TextView timerText;
    private Button textMove;
    private Random random;
    private Button start;
    private int sem = 1;
    private boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab7);
        red = findViewById(R.id.red);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        move = findViewById(R.id.move);
        textMove = findViewById(R.id.textMove);
        textHello = findViewById(R.id.textHello);
        timerText = findViewById(R.id.timerText);
        start = findViewById(R.id.startTimer);
        random = new Random();
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = (int) second/3600;
                int minutes = (int) (second%3600)/60;
                int sec = (int) second%60;
                timerText.setText(String.format("%d:%02d:%02d",hour,minutes,sec));
                if(running){second++;}
                handler.postDelayed(this,1000);
            }
        });
        countDownTimertimer = new CountDownTimer(9000, 3000) {
            @Override
            public void onTick(long l) {
                switch (sem){
                    case 1:
                        red.setImageResource(R.drawable.red);
                        green.setImageResource(R.drawable.gray);
                        sem = 2;
                        break;
                    case 2:
                        red.setImageResource(R.drawable.gray);
                        yellow.setImageResource(R.drawable.yellow);
                        sem = 3;
                        break;
                    case 3:
                        yellow.setImageResource(R.drawable.gray);
                        green.setImageResource(R.drawable.green);
                        sem = 1;
                        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.move_right);
                        move.startAnimation(anim);
                        break;
                }
            }

            @Override
            public void onFinish() {
                if(countDownTimertimer != null)
                    countDownTimertimer.start();
            }
        };
        if(countDownTimertimer != null)
            countDownTimertimer.start();



        textMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int eventType = motionEvent.getActionMasked();

                switch (eventType){
                    case MotionEvent.ACTION_UP:
                        textHello.clearAnimation();
                        break;

                    case MotionEvent.ACTION_DOWN:
                        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                                R.anim.move_text);
                        textHello.startAnimation(anim);
                        textHello.setTextColor(Color.rgb(random.nextInt(255),
                                random.nextInt(255),random.nextInt(255)));
                        break;

                    case MotionEvent.ACTION_CANCEL:
                        textHello.clearAnimation();
                        break;

                }
                return false;
            }
        });
    }

    public void StartTimer(View view){
        running = !running;
    }

    public void StopTimer(View view){
        running = false;
        second = 0;
        start.setText("Старт ");
    }

    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}