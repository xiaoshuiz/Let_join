package course_dao;

import android.content.ContentValues;

import android.content.Context;

import student_model.studentMessage;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


public class studentServie {
    private DBOpenHelper dbOpenHelper;
    Context context;
    public studentServie(Context context) {
        super();
        this.context = context;
        dbOpenHelper = new DBOpenHelper(context);
    }

    public void addstudentmessage(studentMessage studentMessage){

        SQLiteDatabase db = null;
        try {
            db=dbOpenHelper.getWritableDatabase();
//            ContentValues values = new ContentValues();
//            values.put("sno", studentMessage.getSno());
//            values .put("sname", studentMessage.getSname());
//            values .put("school", studentMessage.getSchool());
//            values .put("password", studentMessage.getPassword());
//            values .put("telenumber", studentMessage.getTelenumber());
//            db.insert("studentMessage", null, values);
            if (db.isOpen()) {
                String sname = studentMessage.getSname();
                int sno = studentMessage.getSno();
                String school = studentMessage.getSchool();
                String password = studentMessage.getPassword();
                String telenumber = studentMessage.getTelenumber();




                db.execSQL("insert into studentMessage (sname,sno,school,password,telenumber) " +
                        "values('" + sname + "','" + sno + "','" + school + "','" + password + "'" +
                        ",'" + telenumber + "')");
            }
           // System.out.println(studentMessage.getSname());
           // System.out.print(sno);

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            db.close();
        }

    }
    public  void deletestudentmessage(String sname){
       SQLiteDatabase db=null;
        try{
            db=dbOpenHelper.getWritableDatabase();
            db.delete("studentMessage", "sname=" + sname, null);
        }
        catch (Exception e) {
            // TODO: handle exception
        }finally{
            db.close();
        }
    }

    public List<studentMessage> selectstudentmessage(){
        List<studentMessage> list=new ArrayList<studentMessage>();
        SQLiteDatabase db = null;
        Cursor cursor =null;
        try {
            db=dbOpenHelper.getWritableDatabase();
            cursor=db.query("studentMessage", null, null, null, null, null, null);
//            studentMessage studentmessage=new studentMessage();
            studentMessage studentmessage=null;
            while (cursor.moveToNext()) {
              studentmessage =new studentMessage();
//                System.out.println("sdasdas");
//                System.out.println(cursor.getString(cursor.getColumnIndex("sname")));
               studentmessage.setSname(cursor.getString(cursor.getColumnIndex("sname")));
              //  studentmessage.setSname("asdasd");
               // System.out.println("sdasdas");

                studentmessage.setsno(Integer.valueOf(cursor.getString(cursor.getColumnIndex("sno"))));

                studentmessage.setSchool(cursor.getString(cursor.getColumnIndex("school")));
                studentmessage.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                studentmessage.setTelenumber(cursor.getString(cursor.getColumnIndex("telenumber")));

                list.add(studentmessage);

                //System.out.println(list.get(list.size()-1).getSname().toString());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            cursor.close();
            db.close();
        }
        return list;

    }
    public void updatestudentMessage(String Sname,String Sno,String School,String Telenumber,String Password) {
        SQLiteDatabase db = null;
        try {
            db=dbOpenHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values .put("sname", Sname);
            values .put("sno", Sno);
            values .put("school",School);
            values .put("telenumber",Telenumber);
            values.put("password",Password);
            db.update("studentMessage", values, "sname="+Sname,null);

        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            db.close();
        }
    }
}
