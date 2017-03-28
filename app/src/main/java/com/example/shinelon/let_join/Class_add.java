package com.example.shinelon.let_join;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import course_dao.courseServie;
import course_model.course;

/**
 * Created by Shinelon on 2016/9/25.
 */
public class Class_add extends Activity {
    private Button button_done = null;
    private Button button_more = null;

    private TextView textView2;

    private EditText editText11;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private courseServie courseServie1;
    final String nameSpace="http://com";
    final String methodcourse_add="course_add";
    final String serverUrl="http://10.88.134.228:8080/android_join/services/Course";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    // private String k;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_add);

        textView2 = (TextView) findViewById(R.id.textView10);


        button_done = (Button) findViewById(R.id.button4);
        button_more = (Button) findViewById(R.id.button3);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        courseServie1 = new courseServie(getApplicationContext());


        button_done.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                new Thread(class_addNetworkTask).start();

//                List<course> list = courseServie1.selectcourse();
//                int size = list.size();
//                size++;
//                course course = new course();
//                course.setCourseID(size);
//                course.setCourseName(editText11.getText().toString());
//                course.setCourseDate(editText7.getText().toString());
//                course.setCourseTime(editText8.getText().toString());
//                course.setCoursePlace(editText9.getText().toString());
//                course.setCourseTeacher(editText10.getText().toString());
//                courseServie1.addcourse(course);
//
//
//                Intent intnt1 = getIntent();
//                String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
//                if (mee.equals("1"))
//                {
//                    Intent intent = new Intent();
//                    intent.setClass(Class_add.this, Register_successActivity.class);
//                    startActivity(intent);
//                }
//                else
//                {
//                    Intent intent = new Intent();
//                    intent.setClass(Class_add.this, ManagerActivity.class);
//                    startActivity(intent);
//                }
            }
        });
        button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(class_add_moreNetworkTask).start();

                //refresh();

//                List<course> list = courseServie1.selectcourse();
//                int size = list.size();
//                //              k=String.valueOf(size);
//
//
////                if(size>0)
////                {
//////                    textView2.setText(list.get(size-1).getCourseName());
////                    textView2.setText(k);
////                }
//                size++;
//                course course = new course();
//
//                course.setCourseID(size);
//                course.setCourseName(editText11.getText().toString());
//                course.setCourseDate(editText7.getText().toString());
//                course.setCourseTime(editText8.getText().toString());
//                course.setCoursePlace(editText9.getText().toString());
//                course.setCourseTeacher(editText10.getText().toString());
//                courseServie1.addcourse(course);
//                editText7.setText("");
//                editText8.setText("");
//                editText9.setText("");
//                editText10.setText("");
//                editText11.setText("");


//                Intent intent=new Intent();
//                intent.setClass(Class_add.this,Class_add.class);
//                startActivity(intent);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

//    public void refresh() {
//        onCreate(null);
//    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    public Action getIndexApiAction() {
//        Thing object = new Thing.Builder()
//                .setName("Class_add Page") // TODO: Define a title for the content shown.
//                // TODO: Make sure this auto-generated URL is correct.
//                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//                .build();
//        return new Action.Builder(Action.TYPE_VIEW)
//                .setObject(object)
//                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//                .build();
//    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
//    }
    Runnable class_addNetworkTask=new Runnable() {
        @Override
        public void run() {
            String courseName=editText11.getText().toString().replace(" ","");
            String courseDate=editText7.getText().toString().replace(" ","");
            String courseTime=editText8.getText().toString().replace(" ","");
            String coursePlace=editText9.getText().toString().replace(" ","");
            String courseTeacher=editText10.getText().toString().replace(" ","");
            if (!courseName.equals("")&&!courseDate.equals("")&&!courseTime.equals("")&&!coursePlace.equals("")&&!courseTeacher.equals(""))
            {
                HttpTransportSE transport=new HttpTransportSE(serverUrl);
                transport.debug=true;
                SoapObject rpc=new SoapObject(nameSpace,methodcourse_add);
                rpc.addProperty("coursename",courseName);
                rpc.addProperty("courseteacher",courseTeacher);
                rpc.addProperty("coursedate",courseDate);
                rpc.addProperty("coursetime",courseTime);
                rpc.addProperty("courseplace",coursePlace);
                SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER10);
                envelope.bodyOut=rpc;
                envelope.setOutputSoapObject(rpc);
                try {
                    transport.call(null,envelope);
                    Object object=  envelope.getResponse();
                    String object2String =object.toString();
                    // textView.setText(object2String);
                    if (object2String.equals("1"))
                    {
                        List<course> list = courseServie1.selectcourse();
                        int size = list.size();
                        size++;
                        course course = new course();
                        course.setCourseID(size);
                        course.setCourseName(editText11.getText().toString().replace(" ",""));
                        course.setCourseDate(editText7.getText().toString().replace(" ",""));
                        course.setCourseTime(editText8.getText().toString().replace(" ",""));
                        course.setCoursePlace(editText9.getText().toString().replace(" ",""));
                        course.setCourseTeacher(editText10.getText().toString().replace(" ",""));
                        courseServie1.addcourse(course);


                        Intent intnt1 = getIntent();
                        String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                        if (mee.equals("1"))
                        {
                            Intent intent = new Intent();
                            intent.setClass(Class_add.this, Register_successActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent();
                            intent.setClass(Class_add.this, ManagerActivity.class);
                            startActivity(intent);
                        }
                    }
                    else
                    {
                        Intent intnt1 = getIntent();
                        String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);




                        Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                        intent2.putExtra(RegisterActivity.EXTRA,mee);
                        startActivity(intent2);
                        System.out.println("333");
                    }

                } catch (IOException e) {
                    Intent intnt1 = getIntent();
                    String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                    System.out.println(e.toString());
                    Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                    intent2.putExtra(RegisterActivity.EXTRA,mee);
                    startActivity(intent2);
                } catch (XmlPullParserException e) {
                    Intent intnt1 = getIntent();
                    String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                    System.out.println("222");
                    Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                    intent2.putExtra(RegisterActivity.EXTRA,mee);
                    startActivity(intent2);
                }
            }
            else
            {
                Intent intnt1 = getIntent();
                String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);

                Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                intent2.putExtra(RegisterActivity.EXTRA,mee);
                startActivity(intent2);
            }
        }
    };
    Runnable class_add_moreNetworkTask=new Runnable() {
        @Override
        public void run() {
            String courseName=editText11.getText().toString().replace(" ","");
            String courseDate=editText7.getText().toString().replace(" ","");
            String courseTime=editText8.getText().toString().replace(" ","");
            String coursePlace=editText9.getText().toString().replace(" ","");
            String courseTeacher=editText10.getText().toString().replace(" ","");
            if (courseName.length()!=0&&courseDate.length()!=0&&courseTime.length()!=0&&coursePlace.length()!=0&&courseTeacher.length()!=0) {
                HttpTransportSE transport=new HttpTransportSE(serverUrl);
                transport.debug=true;
                SoapObject rpc=new SoapObject(nameSpace,methodcourse_add);
                rpc.addProperty("coursename",courseName);
                rpc.addProperty("courseteacher",courseTeacher);
                rpc.addProperty("coursedate",courseDate);
                rpc.addProperty("coursetime",courseTime);
                rpc.addProperty("courseplace",coursePlace);
                SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER10);
                envelope.bodyOut=rpc;
                envelope.setOutputSoapObject(rpc);
                try {
                    transport.call(null,envelope);
                    Object object=  envelope.getResponse();
                    String object2String =object.toString();
                    // textView.setText(object2String);
                    if (object2String.equals("1"))
                    {
                        List<course> list = courseServie1.selectcourse();
                        int size = list.size();
                        //              k=String.valueOf(size);


//                if(size>0)
//                {
////                    textView2.setText(list.get(size-1).getCourseName());
//                    textView2.setText(k);
//                }
                        size++;
                        course course = new course();

                        course.setCourseID(size);
                        course.setCourseName(editText11.getText().toString().replace(" ",""));
                        course.setCourseDate(editText7.getText().toString().replace(" ",""));
                        course.setCourseTime(editText8.getText().toString().replace(" ",""));
                        course.setCoursePlace(editText9.getText().toString().replace(" ",""));
                        course.setCourseTeacher(editText10.getText().toString().replace(" ",""));
                        courseServie1.addcourse(course);
                        setContentView(R.layout.class_add);
                        editText7.setText("");
                        editText8.setText("");
                        editText9.setText("");
                        editText10.setText("");
                        editText11.setText("");

                    }
                    else
                    {
                        Intent intnt1 = getIntent();
                        String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                        System.out.println("666");
                        Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                        intent2.putExtra(RegisterActivity.EXTRA,mee);
                        startActivity(intent2);
                    }

                } catch (IOException e) {
                    Intent intnt1 = getIntent();
                    String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                    System.out.println("444");
                    Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                    intent2.putExtra(RegisterActivity.EXTRA,mee);
                    startActivity(intent2);
                } catch (XmlPullParserException e) {
                    Intent intnt1 = getIntent();
                    String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                    System.out.println("555");
                    Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                    intent2.putExtra(RegisterActivity.EXTRA,mee);
                    startActivity(intent2);
                }
            }
            else
            {
                Intent intnt1 = getIntent();
                String mee = intnt1.getStringExtra(RegisterActivity.EXTRA);
                Intent intent2 = new Intent(Class_add.this, Add_errorActivity.class);
                intent2.putExtra(RegisterActivity.EXTRA,mee);
                startActivity(intent2);
            }
        }
    };
}
