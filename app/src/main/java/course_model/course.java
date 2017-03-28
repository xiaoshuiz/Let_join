package course_model;

public class course {
	private int  courseID;
	private String courseName;
	private String courseTeacher;
	private String coursePlace;
	private String courseDate;
	private String courseTime;


	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTeacher() {return courseTeacher;}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getCoursePlace() {return coursePlace;}
	public void setCoursePlace(String coursePlace) {
		this.coursePlace = coursePlace;
	}
	public String getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}



}

