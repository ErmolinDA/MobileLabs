package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityLab5TaskList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_task_list);
    }

    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}