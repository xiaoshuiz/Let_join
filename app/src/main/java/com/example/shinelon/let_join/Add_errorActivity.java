package com.example.shinelon.let_join;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Shinelon on 2017/3/22.
 */

public class Add_errorActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_error);
        Intent intnt1 = getIntent();
        String medd = intnt1.getStringExtra(RegisterActivity.EXTRA);
        if (medd.equals("1")) {
            Timer time2=new Timer();
            TimerTask tk2=new TimerTask() {

                Intent intent2=new Intent(Add_errorActivity.this,Class_add.class);
                @Override
                public void run() {
                    startActivity(intent2);
                    finish();
                }
            };
            time2.schedule(tk2,4000);
        }
        else
        {
            Timer time2=new Timer();
            TimerTask tk2=new TimerTask() {

                Intent intent2=new Intent(Add_errorActivity.this,ManagerActivity.class);
                @Override
                public void run() {
                    startActivity(intent2);
                    finish();
                }
            };
            time2.schedule(tk2,4000);
        }


    }
}
