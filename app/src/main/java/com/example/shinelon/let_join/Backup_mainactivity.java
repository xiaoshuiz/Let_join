package com.example.shinelon.let_join;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Backup_mainactivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.welcome);
        //Login login=new Login();

        Timer time = new Timer();
        TimerTask tk =new TimerTask() {

            Intent intent =new Intent(Backup_mainactivity.this,Login.class);
            @Override
            public void run() {
                ;startActivity(intent);
                finish();
            }
        };
        time.schedule(tk,2000);
    }
}
