package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityLab6List extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> taskList;
    private ArrayAdapter adapter;
    private EditText taskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab6_list);
        listView = findViewById(R.id.listView);
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivityLab6List.this,
                android.R.layout.simple_expandable_list_item_1,taskList);
        listView.setAdapter(adapter);
        taskText = findViewById(R.id.taskText);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                taskList.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }


    public void OnClickAddTask(View view) {
        taskList.add(taskText.getText().toString());
        adapter.notifyDataSetChanged();
    }


    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}