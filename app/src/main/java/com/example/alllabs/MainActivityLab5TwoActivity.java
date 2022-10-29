package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityLab5TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_two);
    }

    public void OnClickStartSecond(View view) {
        Intent intent = new Intent(this, MainActivityLab5Second.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void OnClickCloseSecond(View view){
        Intent intent = new Intent(this, MainActivityLab5TwoClear.class);
        startActivity(intent);
    }

    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}