package course_dao;

import java.util.ArrayList;
import java.util.List;

import course_model.course;
import course_model.courseOther;
import course_model.courseOtherid;
import course_model.courseTime;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class courseServie {
	private DBOpenHelper dbOpenHelper;
	Context context;
	public courseServie(Context context) {
		super();
		this.context = context;
		dbOpenHelper =new DBOpenHelper(context);
	}
	
	//��ӿγ�
	public void addcourse(course course) {
		SQLiteDatabase db = null;
		try {			
			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values.put("courseid", course.getCourseID());
//			values .put("coursename", course.getCourseName());
//			values .put("courseteacher", course.getCourseTeacher());
//			values .put("courseplace", course.getCoursePlace());
//			values .put("coursedate", course.getCourseDate());
//			values .put("coursetime", course.getCourseTime());
//			db.insert("course", null, values);
			if (db.isOpen()) {
				int courseid = course.getCourseID();
				String coursename = course.getCourseName();

				String courseteacher=course.getCourseTeacher();
				String courseplace=course.getCoursePlace();
				String coursedate = course.getCourseDate();
				String coursetime=course.getCourseTime();




				db.execSQL("insert into course (courseid,coursename,courseteacher,courseplace,coursedate,coursetime) " +
						"values('" + courseid + "','" + coursename + "','" + courseteacher + "','" + courseplace + "','" + coursedate + "'" +
						",'" + coursetime + "')");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.close();
		}
	}
	
	//��ӿγ�������Ϣ
//	public void addcourseOther(courseOther courseOther) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values.put("otherid", courseOther.getOtherID());
//			values .put("courseplace", courseOther.getCoursePlace());
//			values .put("courseweek", courseOther.getCourseWeek());
//			values .put("courseqjieshu", courseOther.getCourseQieshu());
//			values .put("coursejieshu", courseOther.getCourseJieshu());
//			db.insert("courseother", null, values);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
	
	//��ӿγ�������Ϣid
//	public void addcourseOtherid(courseOtherid courseOtherid) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values.put("id",courseOtherid.getID());
//			values .put("courseid",courseOtherid.getCourseID());
//			values .put("otherid", courseOtherid.getOtherID());
//			db.insert("courseotherid", null, values);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
//	//��ӿγ�ʱ��
//	public void addcourseTime(courseTime courseTime) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values.put("jieshuid",courseTime.getJieShuID());
//			values .put("coursetime",courseTime.getCourseTime());
//			db.insert("coursetime", null, values);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
//
	
	//ɾ���γ�
	public void deletecourse(int id) {
		SQLiteDatabase db = null;
		try {			
			db=dbOpenHelper.getWritableDatabase();
			db.delete("course", "courseid="+id, null);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.close();
		}
	}
//	//ɾ���γ�������Ϣ
//	public void deletecourseOther(int id) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			db.delete("courseother", "otherid="+id, null);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
//
	//ɾ���γ�������Ϣid
//	public void deletecourseOtherid(int id) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			db.delete("courseotherid", "id="+id, null);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
	
	//ɾ���γ�ʱ��
//	public void deletecourseTime(int id) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			db.delete("coursetime", "jieshuid="+id, null);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
	//��ѯ�γ�
	public List<course> selectcourse() {
		List<course> list =new ArrayList<course>();
		SQLiteDatabase db = null;
		Cursor cursor =null;
		try {			
			db=dbOpenHelper.getWritableDatabase();
			cursor=db.query("course",null,null,null,null,null,null);
			course course=null;
			while (cursor.moveToNext()) {
				course =new course();
				course.setCourseID(cursor.getInt(cursor.getColumnIndex("courseid")));
				course.setCourseName(cursor.getString(cursor.getColumnIndex("coursename")));
				course.setCourseTeacher(cursor.getString(cursor.getColumnIndex("courseteacher")));
				course.setCoursePlace(cursor.getString(cursor.getColumnIndex("courseplace")));
				course.setCourseDate(cursor.getString(cursor.getColumnIndex("coursedate")));
				course.setCourseTime(cursor.getString(cursor.getColumnIndex("coursetime")));
				list.add(course);
			}			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{

			db.close();
		}
		return list;
	}
	//��ѯ�γ�������Ϣ
//	@SuppressWarnings("null")
//	public List<courseOther> selectcourseOther() {
//		List<courseOther> list =new ArrayList<courseOther>();
//		SQLiteDatabase db = null;
//		Cursor cursor =null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			cursor=db.query("course",null,null,null,null,null,null);
//			courseOther courseother=null;
//			while (cursor.moveToNext()) {
//				courseother.setOtherID(cursor.getInt(cursor.getColumnIndex("otherid")));
//				courseother.setCoursePlace(cursor.getString(cursor.getColumnIndex("courseplace")));
//				courseother.setCourseWeek(cursor.getString(cursor.getColumnIndex("courseweek")));
//				courseother.setCourseQieshu(cursor.getString(cursor.getColumnIndex("courseqjieshu")));
//				courseother.setCourseJieshu(cursor.getString(cursor.getColumnIndex("coursejieshu")));
//				list.add(courseother);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			cursor.close();
//			db.close();
//		}
//		return list;
//	}
	//��ѯ�γ�������Ϣid
//	@SuppressWarnings("null")
//	public List<courseOtherid> selectcourseOtherid() {
//		List<courseOtherid> list =new ArrayList<courseOtherid>();
//		SQLiteDatabase db = null;
//		Cursor cursor =null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			cursor=db.query("course",null,null,null,null,null,null);
//			courseOtherid courseotherid = null;
//			while (cursor.moveToNext()) {
//				courseotherid.setOtherID(cursor.getInt(cursor.getColumnIndex("id")));
//				courseotherid.setCourseID(cursor.getInt(cursor.getColumnIndex("courseid")));
//				courseotherid.setOtherID(cursor.getInt(cursor.getColumnIndex("otherid")));
//				list.add(courseotherid);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			cursor.close();
//			db.close();
//		}
//		return list;
//	}
	//��ѯ�γ�ʱ��
	@SuppressWarnings("null")
//	public List<courseTime> selectcourseTime() {
//		List<courseTime> list =new ArrayList<courseTime>();
//		SQLiteDatabase db = null;
//		Cursor cursor =null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			cursor=db.query("course",null,null,null,null,null,null);
//			courseTime coursetime=null;
//			while (cursor.moveToNext()) {
//				coursetime.setJieShuID(cursor.getInt(cursor.getColumnIndex("jieshuid")));
//				coursetime.setCourseTime(cursor.getString(cursor.getColumnIndex("coursetime")));
//				list.add(coursetime);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			cursor.close();
//			db.close();
//		}
//		return list;
//	}
	//���¿γ�
	public void updatecourse(int id,String courseName,String courseTeacher,String coursePlace,String courseDate,String courseTime) {
		SQLiteDatabase db = null;
		try {			
			db=dbOpenHelper.getWritableDatabase();
			ContentValues values = new ContentValues();
			values .put("coursename", courseName);
			values .put("courseteacher", courseTeacher);
			values .put("courseplace",coursePlace);
			values .put("coursedate",courseDate);
			values .put("coursetime",courseTime);
			db.update("course", values, "courseid="+id,null);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			db.close();
		}
	}
	//���¿γ�������Ϣ
//	public void updatecourseOther(int id,String coursePlace,String courseWeek,String courseQieshu,String courseJieshu) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values.put("courseplace",coursePlace);
//			values.put("courseweek", courseWeek);
//			values.put("courseqjieshu",courseQieshu);
//			values.put("coursejieshu",courseJieshu);
//			db.update("courseother", values, "otherid="+id,null);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
	//���¿γ�������Ϣid
//	public void updatecourseOtherid(int id,int courseID,int otherID) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values .put("courseid",courseID);
//			values .put("otherid", otherID);
//			db.update("courseotherid", values, "id="+id,null);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
	//���¿γ�ʱ��
//	public void updatecourseTime(int id,String courseTime) {
//		SQLiteDatabase db = null;
//		try {
//			db=dbOpenHelper.getWritableDatabase();
//			ContentValues values = new ContentValues();
//			values .put("coursetime", courseTime);
//			db.update("coursetime", values, "jieshuid="+id,null);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally{
//			db.close();
//		}
//	}
}
