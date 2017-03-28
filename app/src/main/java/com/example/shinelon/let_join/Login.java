package com.example.shinelon.let_join;

import android.content.Intent;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;





public class Login extends AppCompatActivity{
    private Button button=null;


    @Override
   // public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    //    super.onCreate(savedInstanceState, persistentState);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Login.this,Register.class);
                startActivity(intent);
            }
        });






    }
}

