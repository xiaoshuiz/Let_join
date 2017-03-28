package com.example.shinelon.let_join;

/**
 * Created by Shinelon on 2016/10/24.
 */



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import java.util.Timer;
import java.util.TimerTask;


public class Register_failActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_fail);

        Timer time2=new Timer();
        TimerTask tk2=new TimerTask() {

            Intent intent2=new Intent(Register_failActivity.this,RegisterActivity.class);
            @Override
            public void run() {
                startActivity(intent2);
                finish();
            }
        };
        time2.schedule(tk2,4000);
    }
}


