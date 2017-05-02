package com.aec_developers.khurshid.aec_main.RegisterLoginPackage;

/**
 * Created by Khurshid on 5/1/2017.
 */

public class StudentUserPOJO {

    String name,username,password, rollno, branch, year, course, email, phoneno;


    //for prelogin activity
    public StudentUserPOJO(String rollno, String year, String course) {
        this.rollno = rollno;
        this.year = year;
        this.course = course;
    }
    //ends

    //for register activity
    public StudentUserPOJO(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //ends
}
