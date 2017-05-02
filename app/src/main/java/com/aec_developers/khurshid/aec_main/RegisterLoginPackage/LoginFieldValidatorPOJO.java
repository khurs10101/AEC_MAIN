package com.aec_developers.khurshid.aec_main.RegisterLoginPackage;

/**
 * Created by Khurshid on 5/1/2017.
 */

public class LoginFieldValidatorPOJO {
    public boolean validateRollNo(String passedRollNo)
    {
        //Regex to check that rollno must be in the format cse/13/367
        String rollNoPattern="[A-Za-z]+/[0-9]+/[0-9]+";
        if(passedRollNo.matches(rollNoPattern) && passedRollNo.length()>0)
            return true;
        else
            return false;
    }

    public boolean validateLoginDetails(String passedUserName, String passedPassword)
    {
        return false;
    }

    public boolean validateRegisterDetails(String passedUserName,String passedEmail,String passedPassword, String passedRetypePassword)
    {
        return false;
    }
}
