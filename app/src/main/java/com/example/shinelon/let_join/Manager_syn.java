package com.example.shinelon.let_join;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import course_dao.courseServie;
import course_dao.course_synService;
import course_model.course;

/**
 * Created by Shinelon on 2017/3/25.
 */

public class Manager_syn extends Activity{
    private Button button_return;
    private ExpandableListView ListView_syn;
    private course_synService courseServie_syn;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_syn);
        button_return= (Button) findViewById(R.id.button_return);
        ListView_syn= (ExpandableListView) findViewById(R.id.expandableListView_syn);





        courseServie_syn=new course_synService(getApplicationContext());



//        List<course> synlist = course_synService1.selectcourse();
//        int syn_size= synlist.size();



        List<course> list=courseServie_syn.selectcourse();
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

                TextView text = new TextView(Manager_syn.this);
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

        ListView_syn.setAdapter(adapter);


















        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent();
                intent1.setClass(Manager_syn.this,ManagerActivity.class);
                startActivity(intent1);

            }
        });
    }
}
