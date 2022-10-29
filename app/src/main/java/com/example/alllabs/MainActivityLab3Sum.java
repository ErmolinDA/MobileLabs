package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityLab3Sum extends AppCompatActivity {
    private EditText sum1;
    private EditText sum2;
    private TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3_sum);
        sum1 = findViewById(R.id.textSum1);
        sum2 = findViewById(R.id.textSum2);
        res = findViewById(R.id.sumRes);
    }

    public void onClickLab3sum_back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onClickSumButton(View view) {
        Integer tmp = Integer.parseInt(sum1.getText().toString()) + Integer.parseInt(sum2.getText().toString());
        res.setText(Integer.toString(tmp));
        System.out.println(sum2.getText().toString());
        //System.out.println(sum1.getText().toString());

    }

}