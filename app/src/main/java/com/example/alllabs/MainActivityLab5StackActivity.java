package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityLab5StackActivity extends AppCompatActivity {
    private TextView numActivity;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_stack);

        Bundle arguments = getIntent().getExtras();
        num = arguments.getInt("hello");
        numActivity = findViewById(R.id.numAvtivity);
        numActivity.setText(Integer.toString(num));
    }

    public void OnClickNextAvtivity(View view){
        Intent intent = new Intent(this, MainActivityLab5StackActivity.class);
        intent.putExtra("hello", num+1);
        startActivity(intent);
    }
    public void OnClickCloseActivity(View view){
        this.finish();
    }
}