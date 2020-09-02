package com.example.progressbar2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    Button start;
    ProgressBar progressBar;
   private int counter=0;
   Timer t=new Timer();
    TimerTask tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarkismi();

    }
    public void progressBarkismi(){
        start=findViewById(R.id.button);
        progressBar=findViewById(R.id.progress_bar);

        start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, final MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                         t=new Timer();
                         tt=new TimerTask() {
                            @Override
                            public void run() {
                                counter++;
                                progressBar.setProgress(counter);
                                if(counter ==100)
                                    t.cancel();

                            }

                        };
                        t.schedule(tt,0,100);
                        progressBar.setVisibility(View.VISIBLE);
                        return true;
                        case MotionEvent.ACTION_UP:

                            t.cancel();
                            progressBar.setProgress(counter=0);

                            return true;
                }
                return false;
            }
        });

        }





    }

