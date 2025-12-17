package com.JUnitTest.userValidation;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String Name_Regex="^[A-Z][a-z]{2,}$";
    private static final String Email_Regex="^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
    private static final String Mobile_Regex="^[6-9][0-9]{9}$";

    public boolean isValid(User user)
    {
        if(user==null){
            return false;
        }
        if(!Pattern.matches(Name_Regex,user.getFirstName())){
            return false;
        }
        if(!Pattern.matches(Name_Regex,user.getLastName())){
            return false;

        }
        if(!Pattern.matches(Email_Regex,user.getEmail())){
            return false;
        }
        if(!Pattern.matches(Mobile_Regex,user.getMobile())){
            return false;
        }
    return true;
    }

}
