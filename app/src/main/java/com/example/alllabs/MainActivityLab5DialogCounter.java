package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivityLab5DialogCounter extends AppCompatActivity {

    private Dialog counterDialog;
    private TextView counterText;
    private int intNum = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab5_dialog_counter);
    }

    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void OnClickDialogCounter(View view){
        openDialogCounter();
    }

    private void openDialogCounter() {
        counterDialog = new Dialog(this, R.style.CustomDialogTheme);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.counter_layout, null);
        counterText = custom_dialog.findViewById(R.id.DialogCounterText);
        counterText.setText(Integer.toString(intNum));

        counterDialog.setContentView(custom_dialog);
        counterDialog.show();
    }

    public void OnClickDialogSum(View view){
        intNum += 1;
        counterText.setText(Integer.toString(intNum));
    }

    public void OnClickClose(View view){
        counterDialog.dismiss();
    }
}