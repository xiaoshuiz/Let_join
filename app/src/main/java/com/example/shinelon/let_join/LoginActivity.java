package com.example.shinelon.let_join;

/**
 * Created by Shinelon on 2016/10/24.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Handler;

import course_dao.studentServie;
import student_model.studentMessage;
import course_dao.courseServie;
import course_model.course;

public class LoginActivity extends Activity {
    private Button button;
    private ImageButton imageButton;
    private studentServie studentServie1;
    private courseServie courseServie1;
    private EditText editText;
    private EditText editText2;
    private TextView textView;
    private TextView textView2;
    private TextView textview3;
    private String m;
    final String nameSpace="http://com";
    final String methodName_login="join_login";
    final String serverUrl="http://10.88.134.228:8080/android_join/services/Login";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        studentServie1=new studentServie(getApplicationContext());
        courseServie1=new courseServie(getApplicationContext());
        //元数据备份
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.login);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        textView=(TextView)findViewById(R.id.textView4);
        textView2=(TextView)findViewById(R.id.textView2);
        textview3=(TextView)findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        imageButton=(ImageButton)findViewById(R.id.imageButton_login);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(login_networkTask).start();
            }
        });





//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                   // studentMessage studentMessage1 = new studentMessage();
//                   List<studentMessage> list ;
//  //                  List<course> list1 ;
//                list = studentServie1.selectstudentmessage();
//  //                  list1 = courseServie1.selectcourse();
//                    int size = list.size();  //实验
//                   // m=String.valueOf(size);  //实验
//  //                  textView2.setText(list1.get(size-1).getCourseName().toString());
////                   textview3.setText(list.get(size-1).getPassword().toString());
////
////                    m=list.get(size-1).getSname();
////                    textView2.setText(m);  //实验
//
//
//                    int i;
//                    for (i = 0; i < size; i++) {
//                        System.out.println(list.get(i).getSname());
//                        if (editText.getText().toString() .equals( list.get(i).getSname())) {
//                            System.out.println(list.get(i).getSname());
//                            break;
//                        }
//                    }
//                    boolean x=true;
//                    if(i==size)
//                    {
//                        if(editText.getText().toString().equals(list.get(size).getSname()))
//                        {
//                            x=false;
//                        }
//                    }
//                    System.out.println(list.get(i).getPassword());
//                    if(x==true)
//                    {
//                        System.out.println(list.get(i).getPassword());
//                        if (editText2.getText().toString().equals(list.get(i).getPassword())) {
//                            //if (editText2.getText().toString().equals("forfree")) { //实验
//                              System.out.println(list.get(i).getPassword());
//                            Intent intent1 = new Intent(LoginActivity.this, ManagerActivity.class);
//                            startActivity(intent1);
//                        }
//                    }
//                }
//                catch(Exception e){
////                    textView=(TextView)findViewById(R.id.textView4);
////                    textView.setText(e.toString());
//                    textView.setText("用户名不存在或者密码错误\n               请重新输入");
//
//                }
//
//
//
//
//
//
//            }
//        });


    }
    Runnable login_networkTask=new Runnable() {
        @Override
        public void run() {
            String UserName=editText.getText().toString().replace(" ","");
            String UserPassword=editText2.getText().toString().replace(" ","");
            HttpTransportSE transport=new HttpTransportSE(serverUrl);
            transport.debug=true;
            SoapObject rpc=new SoapObject(nameSpace,methodName_login);
            rpc.addProperty("username",UserName);
            rpc.addProperty("userpassword",UserPassword);
            SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER10);
            envelope.bodyOut=rpc;
            envelope.setOutputSoapObject(rpc);
            try {
                transport.call(null,envelope);
                Object object=  envelope.getResponse();
                String object2String =object.toString();
               // textView.setText(object2String);
                if (object2String.equals("1")) {
                    Intent intent1 = new Intent(LoginActivity.this, ManagerActivity.class);
                    startActivity(intent1);

                }
                else
                {
                    textView=(TextView)findViewById(R.id.textView4);
                    textView.setText("用户名不存在或者密码错误\n               请重新输入");
                }

            }
            catch (Exception e) {
                textView=(TextView)findViewById(R.id.textView4);
                textView.setText("登陆失败或网络连接错误\n               请检查网络");
            }

        }
    };

}