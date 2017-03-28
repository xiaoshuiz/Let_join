package com.example.shinelon.let_join;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import course_dao.studentServie;
import student_model.studentMessage;

/**
 * Created by Shinelon on 2016/10/24.
 */
public class RegisterActivity extends Activity {


    private Button button2;
    private EditText editText6;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText_study_ID;
    final String nameSpace="http://com";
    final String methodName_register="join_register";
    final String serverUrl="http://10.88.134.228:8080/android_join/services/Register";
//    private TextView textView;
//
//    private String m;
String mb="0";


    private studentServie studentServie;
    public  final  static String EXTRA="com.example.shinelon.let_join.MESSAGE";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        studentServie=new studentServie(getApplicationContext());
        setContentView(R.layout.register);
       // setContentView(R.layout.class_result);
        button2=(Button)findViewById(R.id.button2);
        editText6=(EditText)findViewById(R.id.editText_school);
        editText3=(EditText)findViewById(R.id.editText_name);
        editText4=(EditText)findViewById(R.id.editText_number);
        editText5=(EditText)findViewById(R.id.editText_qq);
        editText_study_ID=(EditText)findViewById(R.id.editText_study_ID);
//       textView=(TextView)findViewById(R.id.textView5);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(resigter_NetworkTask).start();
            }
        });
//        button2.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                try{
//
//                    studentMessage studentmessage = new studentMessage();
//
//                   studentmessage.setSchool(editText6.getText().toString());
//                    studentmessage.setSname(editText3.getText().toString());
//                    studentmessage.setPassword(editText4.getText().toString());
//                  studentmessage.setTelenumber(editText5.getText().toString());
//                    studentmessage.setsno(Integer.valueOf(editText_study_ID.getText().toString()));
//                    List<studentMessage> list =studentServie.selectstudentmessage();
//                    boolean x=true;
//                    int size =list.size();
//                    for(int i=0;i<size;i++)
//                    {
//                        if(studentmessage.getSname().equals(list.get(i).getSname()))
//                        {
//                            x=false;
//                        }
//                    }
//
////                    studentmessage.setSchool("sdfe");
////                    studentmessage.setSname("18487210122");
////                    studentmessage.setPassword("11223344");
////                    studentmessage.setTelenumber("2388034500");
////                    studentmessage.setsno("201411101133");
//                   // List<studentMessage> list=studentServie.selectstudentmessage();
//                    if(x==true) {
//                        studentServie.addstudentmessage(studentmessage);
//
////                   m=String.valueOf(studentServie.selectstudentmessage().size());
////                    textView.setText(m);
//                        Intent intent1 = new Intent(RegisterActivity.this, Class_add.class);
//                        mb="1";
//                        intent1.putExtra(EXTRA,mb);
//
//                        startActivity(intent1);
//                    }
//                    if(x==false)
//                    {
//                        Intent intent2=new Intent(RegisterActivity.this,Register_failActivity.class);
//                        startActivity(intent2);
//                    }
//
//            }
//                catch (Exception e){
//                    Intent intent2=new Intent(RegisterActivity.this,Register_failActivity.class);
//                    startActivity(intent2);
//                }
//
//            }
//        });

    }
    Runnable resigter_NetworkTask=new Runnable() {
        @Override
        public void run() {
            String Name=editText3.getText().toString();
            String Password=editText4.getText().toString();
            String sno=editText_study_ID.getText().toString();
            String school=editText6.getText().toString();
            String telnumber=editText5.getText().toString();
            HttpTransportSE transport=new HttpTransportSE(serverUrl);
            transport.debug=true;
            SoapObject rpc=new SoapObject(nameSpace,methodName_register);
            rpc.addProperty("sname",Name);
            rpc.addProperty("password",Password);
            rpc.addProperty("sno",sno);
            rpc.addProperty("school",school);
            rpc.addProperty("telnumber",telnumber);
            SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER10);
            envelope.bodyOut=rpc;
            envelope.setOutputSoapObject(rpc);
            try {
                transport.call(null,envelope);
                Object object=  envelope.getResponse();
                String object2String =object.toString();
                // textView.setText(object2String);
                if (object2String.equals("1")) {
                    Intent intent1 = new Intent(RegisterActivity.this, Class_add.class);
                    mb="1";
                    intent1.putExtra(EXTRA,mb);
                    startActivity(intent1);

                }
                else
                {
                    Intent intent2 = new Intent(RegisterActivity.this, Register_failActivity.class);
                    startActivity(intent2);
                    System.out.println("333");
                }

            } catch (IOException e) {
                System.out.println("111");
                Intent intent2 = new Intent(RegisterActivity.this, Register_failActivity.class);
                startActivity(intent2);
            } catch (XmlPullParserException e) {
                System.out.println("222");
                Intent intent2 = new Intent(RegisterActivity.this, Register_failActivity.class);
                startActivity(intent2);
            }
        }
    };
}


