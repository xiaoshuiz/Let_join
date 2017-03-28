package course_dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context) {

		super(context,"Course.db", null, 1);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �Զ����ɵķ������
		//�γ̱�
		db.execSQL("create table course(courseid integer primary key autoincrement," +
				" coursename varchar(50)," +
				" courseteacher varchar(50)," +
				" courseplace  varchar(50)," +
				" coursedate  varchar(50)," +
				" coursetime  varchar(50))");
//		//�γ�������Ϣ��
		db.execSQL("create table course_syn(courseid integer primary key autoincrement," +
				" coursename varchar(50)," +
				" courseteacher varchar(50)," +
				" courseplace  varchar(50)," +
				" coursedate  varchar(50)," +
				" coursetime  varchar(50))");
//		db.execSQL("create table courseother(otherid integer primary key autoincrement," +
//				"courseplace varchar(50)," +
//				"courseweek varchar(50)," +
//				"courseqjieshu varchar(50)," +
//				"coursejieshu varchar(50))");
//		//�γ�������Ϣid��
//		db.execSQL("create table courseotherid(id integer primary key autoincrement," +
//				"courseid integer" +
//				"otherid integer)");
//		//�γ�ʱ���
//		db.execSQL("create table coursetime(jieshuid integer primary key autoincrement," +
//				"coursetime varchar(50))");
		db.execSQL("create table studentMessage(sno integer primary key autoincrement," +
		          " sname varchar(50)," +
		           " school varchar(50)," +
		           " password varchar(50)," +
		            " telenumber varchar(50))");
//		db.execSQL("create table xuanke(sno integer primary key autoincrement," +
//				"sname varchar(50)," +
//				"courseID varchar(50)," +
//				"courseName varchar(50))"
//				);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO �Զ����ɵķ������

	}

}
