package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityLab5Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_second);
    }

    public void OnClickBackFirstPage(View view){
        Intent intent = new Intent(this, MainActivityLab5TwoActivity.class);
        startActivity(intent);
    }
}