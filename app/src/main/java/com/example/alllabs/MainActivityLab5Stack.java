package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityLab5Stack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5);
    }

    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void OnClickStartStack(View view) {
        Intent intent = new Intent(this, MainActivityLab5StackActivity.class);
        intent.putExtra("hello", 1);
        startActivity(intent);
        //System.out.println(123);
    }
}