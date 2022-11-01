package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLab2(View view) {
        Intent intent = new Intent(this, MainActivityLab2.class);
        startActivity(intent);
    }

    public void onClickLab3part1(View view) {
        Intent intent = new Intent(this, MainActivityLab3Rect.class);
        startActivity(intent);
    }
    public void onClickLab3Sum(View view) {
        Intent intent = new Intent(this, MainActivityLab3Sum.class);
        startActivity(intent);
    }

    public void onClickLab4(View view) {
        Intent intent = new Intent(this, MainActivityLab4.class);
        startActivity(intent);
    }
    public void OnClickLab5(View view) {
        Intent intent = new Intent(this, MainActivityLab5Stack.class);
        startActivity(intent);
    }
    public void OnClickLab5TwoPage(View view) {
        Intent intent = new Intent(this, MainActivityLab5TwoClear.class);
        startActivity(intent);
    }
    public void OnClickLab5TaskList(View view) {
        Intent intent = new Intent(this, MainActivityLab5TaskList.class);
        startActivity(intent);
    }
    public void OnClickOpenDialogCounter(View view) {
        Intent intent = new Intent(this, MainActivityLab5DialogCounter.class);
        startActivity(intent);
    }
    public void OnClickRoul(View view) {
        Intent intent = new Intent(this, MainActivityRoul.class);
        startActivity(intent);
    }
}