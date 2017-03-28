package com.example.shinelon.let_join;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Shinelon on 2016/9/25.
 */
public class Register_success extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_success);
        Timer time2=new Timer();
        TimerTask tk2=new TimerTask() {

            Intent intent2=new Intent(Register_success.this,Login.class);
            @Override
            public void run() {
                startActivity(intent2);
                finish();
            }
        };
        time2.schedule(tk2,3000);
    }
}
