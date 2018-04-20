package com.mr_abdali.linearprogressdialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.setIndeterminate(false); // linear "true"

        dialog.setTitle("Linear Progress dialog");
        dialog.setMessage("Please Wait...");
        dialog.show();

        dialog.setProgress(0);
        dialog.setMax(100);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                //
                i = i+5;
                if (i <= 100){
                    //
                    dialog.setProgress(i);
                } else {
                    //
                    timer.cancel();
                    i=0;
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //
                handler.post(runnable);
            }
        },8000,500);
    }
}
