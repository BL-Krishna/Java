package com.JUnitTest.userValidation;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String Name_Regex="^[A-Z][a-z]{2,}$";
    private static final String Email_Regex="^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
    private static final String Mobile_Regex="^[6-9][0-9]{9}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%!]).{8,}$";


    public boolean isValid(User user)
    {
        if(user==null){
            throw new IllegalArgumentException("User cannot be null");
        }
        if(!Pattern.matches(Name_Regex,user.getFirstName())){
            throw new InvalidFirstNameException("Invalid First Name");
        }
        if(!Pattern.matches(Name_Regex,user.getLastName())){
            throw new InvalidLastNameException("Invalid Last Name");
        }
        if(!Pattern.matches(Email_Regex,user.getEmail())){
            throw new InvalidEmailException("Invalid Email");
        }
        if(!Pattern.matches(Mobile_Regex,user.getMobile())){
            throw new InvalidMobileNumberException("Invalid Mobile");
        }
        if(!Pattern.matches(PASSWORD_REGEX,user.getPassword())){
            throw new InvalidPasswordException("Invalid Password");
        }
    return true;
    }

}
