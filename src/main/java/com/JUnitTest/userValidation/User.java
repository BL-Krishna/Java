package com.JUnitTest.userValidation;

public class User {
   private String firstName;
   private String lastName;
   private String email;
   private String mobile;
   private String password;

    public User(String firstName, String lastName, String email, String mobile,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.password=password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
    public String getPassword(){
        return password;
    }
}
