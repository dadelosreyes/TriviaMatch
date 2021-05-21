package com.example.triviamatch;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlay= findViewById(R.id.play);
        Button btnInstructions= findViewById(R.id.instructions);
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.up_scale);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.down_scale);

//        btnPlay.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_DOWN)
//                {
//                    btnPlay.startAnimation(scaleUp);
//                }
//                else if(event.getAction() == MotionEvent.ACTION_UP)
//                {
//                    btnPlay.startAnimation(scaleDown);
//                }
//                return false;
//            }
//        });
//        btnInstructions.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(event.getAction() == MotionEvent.ACTION_DOWN)
//                {
//                    btnInstructions.startAnimation(scaleUp);
//                }
//                else if(event.getAction() == MotionEvent.ACTION_UP)
//                {
//                    btnInstructions.startAnimation(scaleDown);
//                }
//                return false;
//            }
//        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainGame.class);
                startActivity(intent);
            }
        });
        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainGame.class);
                startActivity(intent);
            }
        });
    }
}