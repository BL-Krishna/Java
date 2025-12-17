package com.JunitTest.userValidation;

import com.JUnitTest.userValidation.User;
import com.JUnitTest.userValidation.UserValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private final UserValidator validator=new UserValidator();

    @Test
    void shouldReturnTrueForValidUser(){
        User user =new User("John","Doe","john.deo@gmail.com","9876543210");
        assertTrue(validator.isValid(user));
    }

    @Test
    void shouldFailForInvalidFirstName() {
        User user = new User("jo", "Doe", "john.doe@gmail.com", "9876543210");
        assertFalse(validator.isValid(user));

    }
    @Test
    void shouldFailForInvalidLastName() {
        User user = new User("John", "doe", "john.doe@gmail.com", "9876543210");
        assertFalse(validator.isValid(user));
    }

    @Test
    void shouldFailForInvalidEmail() {
        User user = new User("John", "Doe", "johndoe.com", "9876543210");
        assertFalse(validator.isValid(user));
    }

    @Test
    void shouldFailForInvalidMobile() {
        User user = new User("John", "Doe", "john.doe@gmail.com", "1234567890");
        assertFalse(validator.isValid(user));
    }

    @Test
    void shouldFailForNullUser() {
        assertFalse(validator.isValid(null));
    }


}
