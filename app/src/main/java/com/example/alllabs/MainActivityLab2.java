package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityLab2 extends AppCompatActivity {
    private TextView num;
    private int intNum = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab2);
        init();
    }

    private void init(){
        num = findViewById(R.id.text1);
        num.setText(Integer.toString(intNum));
    }

    public void onClickButton1(View view) {
        intNum += 1;
        num.setText(Integer.toString(intNum));
        System.out.println(intNum);
    }

    public void onClickLab2back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}