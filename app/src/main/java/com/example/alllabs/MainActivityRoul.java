package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivityRoul extends AppCompatActivity {
    private EditText bidArr[] = new EditText[6];
    private int bidInt[] = new int[6];
    private int scope = 1000;
    private TextView scopeText;
    private Dialog bidDialog;
    private TextView tvResult;
    private ImageView rul;
    private Random random;
    private int old_deegre = 0;
    private int deegre = 0;
    private float delta = 4.86f;
    private String[] numbers = {"32","15","19","4",
            "21","2","25","17", "34",
            "6","27","13","36","11","30",
            "8","23","10","5","24","16","33",
            "1","20","14","31","9","22","18",
            "29","7","28","12","35","3","26","0"};
    private String[] colors = {"RED","BLACK","RED","BLACK",
            "RED","BLACK","RED","BLACK", "RED",
            "BLACK","RED","BLACK","RED","BLACK","RED",
            "BLACK","RED","BLACK","RED","BLACK","RED","BLACK",
            "RED","BLACK","RED","BLACK","RED","BLACK","RED",
            "BLACK","RED","BLACK","RED","BLACK","RED","BLACK","ZERO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roul);
        tvResult = findViewById(R.id.tvResult);
        rul = findViewById(R.id.rul);
        scopeText = findViewById(R.id.scopeText);
        random = new Random();
    }

    public void onClickStart(View view)
    {
        old_deegre = deegre % 360;
        deegre = random.nextInt(3600) + 720;
        RotateAnimation rotate = new RotateAnimation(old_deegre,deegre,RotateAnimation.RELATIVE_TO_SELF,
                0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(3600);
        rotate.setFillAfter(true);
        rotate.setInterpolator(new DecelerateInterpolator());
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                tvResult.setText("");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                String text = "";
                int tmp = (int)(360 - deegre%360 + delta)*37/360 - 1;
                text = numbers[tmp] + " " + colors[tmp];
                tvResult.setText(text);

                if (colors[tmp].indexOf("RED") > -1)
                    scope += (36 / 18 - 1) * bidInt[0];
                else scope -= bidInt[0];
                if (colors[tmp].indexOf("BLACK") > -1)
                    scope += (36 / 18 - 1) * bidInt[1];
                else scope -= bidInt[1];
                if (Integer.parseInt(numbers[tmp])%2 == 0)
                    scope += (36/18-1)*bidInt[2];
                else scope -= bidInt[2];
                if (Integer.parseInt(numbers[tmp])%2 == 1)
                    scope += (36/18-1)*bidInt[3];
                else scope -= bidInt[3];
                if (Integer.parseInt(numbers[tmp]) == bidInt[4])
                    scope += 35*bidInt[5];
                else scope -= bidInt[5];

                scopeText.setText(Integer.toString(scope));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rul.startAnimation(rotate);
    }

    public void OnClickBidStart(View view){
        openDialog();
    }

    private void openDialog() {
        bidDialog = new Dialog(this, R.style.CustomDialogTheme);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View custom_dialog = layoutInflater.inflate(R.layout.bid_layout, null);

        bidArr[0] = custom_dialog.findViewById(R.id.redBid);
        bidArr[1] = custom_dialog.findViewById(R.id.blackBid);
        bidArr[2] = custom_dialog.findViewById(R.id.evenBid);
        bidArr[3] = custom_dialog.findViewById(R.id.oddBid);
        bidArr[4] = custom_dialog.findViewById(R.id.num);
        bidArr[5] = custom_dialog.findViewById(R.id.numBid);

        bidDialog.setContentView(custom_dialog);

        bidDialog.show();



    }

    public void OnClickDialogButton(View view){
        for(int i = 0; i < 6; i++){
            bidInt[i] = Integer.parseInt(bidArr[i].getText().toString());
            System.out.println(bidInt[i]);
        }
        bidDialog.dismiss();
    }
}
