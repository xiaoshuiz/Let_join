package com.example.shinelon.let_join;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

import course_dao.courseServie;
import course_dao.course_synService;
import course_model.course;



/**
 * Created by Shinelon on 2016/10/24.
 */

public class ManagerActivity extends Activity {
    private Button button_add;
    private Button button_syn;
//    private Button button_loc;
    private ExpandableListView expandableListView;

    private courseServie courseServie1;
    private course_synService course_synService1;
    String mc;
    final String nameSpace="http://com";
    final String method_syn="syn_course";
    final String serverUrl="http://10.88.134.228:8080/android_join/services/SYN";




    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_manager);

        button_add=(Button)findViewById(R.id.button6);
        button_syn= (Button) findViewById(R.id.button5);
//        button_loc= (Button) findViewById(R.id.button7);
        expandableListView=(ExpandableListView)findViewById(R.id.expandableListView);


        courseServie1=new courseServie(getApplicationContext());

        course_synService1=new course_synService(getApplicationContext());

//        List<course> synlist = course_synService1.selectcourse();
//        int syn_size= synlist.size();



        List<course> list=courseServie1.selectcourse();
        int size = list.size();




        final List<String> grouplist = new ArrayList<String>();
        final List<List<String>> childlist = new ArrayList<List<String>>();

        for(int i=0;i<size;i++)
        {
            grouplist.add(list.get(i).getCourseName().toString());
        }

        for(int j=0;j<size;j++)
        {
            List<String> childitem = new ArrayList<String>();
            childitem.add("日期："+list.get(j).getCourseDate().toString());
            childitem.add("地点："+list.get(j).getCoursePlace().toString());
            childitem.add("讲师："+list.get(j).getCourseTeacher().toString());
            childitem.add("时间："+list.get(j).getCourseTime().toString());


            childlist.add(childitem);

        }








//        final String[] grouplist = new String[]{};
//
//        for (int i = 0; i < size; i++) {
//
//            grouplist[i]=list.get(i).getCourseName().toString();
//        }
//        final String[][] childlist = new String[][]{};
//        for(int j=0; j < size; j++){
//            String teacher=list.get(j).getCourseTeacher().toString();
//            childlist[j][1]=teacher;
//            String place=list.get(j).getCoursePlace().toString();
//            childlist[j][2]=place;
//            String date=list.get(j).getCourseDate().toString();
//            childlist[j][3]=date;
//            String time=list.get(j).getCourseTime().toString();
//            childlist[j][4]=time;
//        }

        final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            @Override
            public int getGroupCount() {
                return grouplist.size();
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return childlist.get(groupPosition).size();
            }

            @Override
            public Object getGroup(int groupPosition) {
                return grouplist.get(groupPosition);
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return childlist.get(groupPosition).get(childPosition);
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() { return true; }
            private TextView getTextView(String s) {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, 40);

                TextView text = new TextView(ManagerActivity.this);
                text.setLayoutParams(lp);
                // Center the text vertically
                text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                // Set the text starting position
                text.setPadding(36, 0, 0, 0);

                text.setText(s);
                return text;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//
                /*LinearLayout ll = new LinearLayout(ManagerActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(ManagerActivity.this);
                logo.setImageResource(logos[groupPosition]);
                logo.setPadding(36, 15, 0, 0);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                textView.setPadding(10, 0, 0, 0);
                ll.addView(textView);
                return ll;*/
                String string = grouplist.get(groupPosition);
                return getTextView(string);
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

//                LinearLayout ll = new LinearLayout(
//                        ManagerActivity.this);
//                ll.setOrientation(LinearLayout.HORIZONTAL);
//               /*ImageView generallogo = new ImageView(
//                        ManagerActivity.this);
//                generallogo
//                        .setImageResource(generallogos[groupPosition][childPosition]);
//                ll.addView(generallogo);*/
//                TextView textView = getTextView();
//                textView.setText(getChild(groupPosition, childPosition)
//                        .toString());
//                ll.addView(textView);
//                return ll;
                /*LinearLayout ll = new LinearLayout(
                        ManagerActivity.this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
               ImageView generallogo = new ImageView(
                        ManagerActivity.this);
                generallogo
                        .setImageResource(generallogos[groupPosition][childPosition]);
                ll.addView(generallogo);
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition)
                        .toString());
                ll.addView(textView);
                return ll;*/
                String string = childlist.get(groupPosition).get(childPosition);
                return getTextView(string);
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };

        expandableListView.setAdapter(adapter);







        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent1 = new Intent(ManagerActivity.this, Class_add.class);
                mc="0";
                intent1.putExtra(RegisterActivity.EXTRA,mc);

                startActivity(intent1);
            }

        });

//        button_loc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                List<course> list=courseServie1.selectcourse();
//                int size = list.size();
//                final List<String> grouplist = new ArrayList<String>();
//                final List<List<String>> childlist = new ArrayList<List<String>>();
//                for(int i=0;i<size;i++)
//                {
//                    grouplist.add(list.get(i).getCourseName().toString());
//                }
//
//                for(int j=0;j<size;j++)
//                {
//                    List<String> childitem = new ArrayList<String>();
//                    childitem.add("日期："+list.get(j).getCourseDate().toString());
//                    childitem.add("地点："+list.get(j).getCoursePlace().toString());
//                    childitem.add("讲师："+list.get(j).getCourseTeacher().toString());
//                    childitem.add("时间："+list.get(j).getCourseTime().toString());
//
//
//                    childlist.add(childitem);
//
//                }
//                expandableListView.setAdapter(adapter);
//
//            }
//
//
//
//        });


        button_syn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Thread(syn_network).start();
                /*
                同步操作
                 */

//                List<course> synlist = course_synService1.selectcourse();
//
//
//
//                int syn_size= synlist.size();
//
//                final List<String> syngrouplist = new ArrayList<String>();
//                final List<List<String>> synchildlist = new ArrayList<List<String>>();
//
//                for(int n=0;n<syn_size;n++)
//                {
//                    syngrouplist.add(synlist.get(n).getCourseName().toString());
//                }
//
//                for(int j=0;j<syn_size;j++)
//                {
//                    List<String> childitem = new ArrayList<String>();
//                    childitem.add("日期："+synlist.get(j).getCourseDate().toString());
//                    childitem.add("地点："+synlist.get(j).getCoursePlace().toString());
//                    childitem.add("讲师："+synlist.get(j).getCourseTeacher().toString());
//                    childitem.add("时间："+synlist.get(j).getCourseTime().toString());
//
//
//                    synchildlist.add(childitem);
//
//                }
//                expandableListView.setAdapter(adapter);
            }
        });

    }

    Runnable syn_network=new Runnable() {
        @Override
        public void run() {
            HttpTransportSE transport;
            SoapObject rpc;

            SoapSerializationEnvelope envelope;

            int mmm=1;

            for(;mmm==1;){
                transport=new HttpTransportSE(serverUrl);
                rpc=new SoapObject(nameSpace,method_syn);
                transport.debug=true;
                envelope=new SoapSerializationEnvelope(SoapEnvelope.VER10);

                List<course> synlist = course_synService1.selectcourse();
                int syn_size = synlist.size();

                System.out.println(syn_size);


                rpc.addProperty("i", Integer.toString(syn_size+1));

                envelope.bodyOut = rpc;
                envelope.setOutputSoapObject(rpc);
                try {
                    transport.call(null, envelope);
                    Object object = envelope.getResponse();
                    String object2String = object.toString();
                    System.out.println(object2String);
                    System.out.println(object2String);
                    if(!object2String.equals("2"))
                    {
                        int length = object2String.length();

                        int[] a = new int[5];
                        int m = 0;

                        for (int i = 0; i < length; i++) {
                            if (object2String.charAt(i) == ' ') {
                                a[m] = i + 1;
                                m++;
                            }
                        }
                        m = object2String.length();
                        //System.out.println(m);
                        a[4] = m + 1;
                        m = 0;
                        for (int i = 0; i < a.length; i++) {
                            System.out.println("第" + i + "空格的位置" + a[i]);
                        }

                        int i = 0;
                        char testString;
                        String s = "";
                        String b1 = "", b2 = "", b3 = "", b4 = "", b5 = "";
                        for (int k = 0; k < a[0] - 1; k++) {   //输出第一个
                            testString = object2String.charAt(k);
                            s = s + testString;
                            b1 = s;

                        }
                        System.out.println(s);

                        s = "";
                        for (int k = a[i]; k <= a[i + 1] - 1; k++) {

                            testString = object2String.charAt(k);

                            s = s + testString;
                            if (i == 0) {
                                b2 = s;
                            }
                            if (i == 1) {
                                b3 = s;
                            }
                            if (i == 2) {
                                b4 = s;
                            }
                            //System.out.println(s);
                            if (k == a[i + 1] - 2) {
                                System.out.println(s);
                                i = i + 1;
                                s = "";
                                k++;
                                //System.out.println(i);
                            }
                            if (i == 3) {
                                break;
                            }

                        }
                        for (int k = a[3]; k < a[4] - 1; k++) {
                            testString = object2String.charAt(k);
                            s = s + testString;
                            b5 = s;
                        }
                        System.out.println(s);
                        System.out.println("b1是" + b1);
                        System.out.println("b2是" + b2);
                        System.out.println("b3是" + b3);
                        System.out.println("b4是" + b4);
                        System.out.println("b5是" + b5);

                        course syncourse = new course();

                        syncourse.setCourseID(syn_size + 1);
                        syncourse.setCoursePlace(b3);
                        syncourse.setCourseTime(b5);
                        syncourse.setCourseDate(b4);
                        syncourse.setCourseName(b1);
                        syncourse.setCourseTeacher(b2);

                        course_synService1.addcourse(syncourse);



                    }
                    else
                    {
                        mmm=2;
                    }


                } catch (Exception e) {
                    mmm=2;
                    System.out.println(e.toString());
//                textView.setText("用户名不存在或者密码错误\n               请重新输入");
                }
            }
            Intent intent =new Intent();
            intent.setClass(ManagerActivity.this,Manager_syn.class);
            startActivity(intent);

        }
    };
}
