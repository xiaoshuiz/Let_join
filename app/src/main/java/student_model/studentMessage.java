package student_model;


public class studentMessage {
    private int sno;
    private String sname;
   // private String daytime;
    private String password;
    private String telenumber;
    private String school;

    public int getSno() {return sno;}
    public void setsno(int sno) {this.sno = sno;}

    public String getSname(){return  sname;}
    public void setSname(String sname)
    {this.sname=sname;
//     System.out.println(sname);
    }

//    public String getDaytime(){return  daytime;}
//    public void setDaytime(String daytime){this.daytime=daytime;}

    public String getPassword(){return  password;}
    public void setPassword(String password){this.password=password;}


    public  String getTelenumber(){return  telenumber;}
    public  void setTelenumber(String telenumber){this.telenumber=telenumber;}

    public  String getSchool(){return  school;}
    public  void setSchool(String school){this.school=school;}

}
