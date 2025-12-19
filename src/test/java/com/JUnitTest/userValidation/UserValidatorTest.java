package com.JUnitTest.userValidation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {

    private final UserValidator validator=new UserValidator();

    @Test
    void shouldReturnTrueForValidUser() {
        User user = new User("John", "Doe", "john.doe@gmail.com", "9876543210", "Password@1");
        assertTrue(validator.isValid(user));
    }

    @Test
    void shouldThrowExceptionForInvalidFirstName() {
        User user = new User("jo", "Doe", "john.doe@gmail.com", "9876543210", "Password@1");
        assertThrows(InvalidFirstNameException.class, () -> validator.isValid(user));
    }

    @Test
    void shouldThrowExceptionForInvalidLastName() {
        User user = new User("John", "doe", "john.doe@gmail.com", "9876543210", "Password@1");
        assertThrows(InvalidLastNameException.class, () -> validator.isValid(user));
    }

    @Test
    void shouldThrowExceptionForInvalidEmail() {
        User user = new User("John", "Doe", "johndoe.com", "9876543210", "Password@1");
        assertThrows(InvalidEmailException.class, () -> validator.isValid(user));
    }

    @Test
    void shouldThrowExceptionForInvalidMobile() {
        User user = new User("John", "Doe", "john.doe@gmail.com", "1234567890", "Password@1");
        assertThrows(InvalidMobileNumberException.class, () -> validator.isValid(user));
    }

    @Test
    void shouldThrowExceptionForInvalidPassword() {
        User user = new User("John", "Doe", "john.doe@gmail.com", "9876543210", "pass");
        assertThrows(InvalidPasswordException.class, () -> validator.isValid(user));
    }

    @Test
    void shouldThrowExceptionForNullUser() {
        assertThrows(IllegalArgumentException.class, () -> validator.isValid(null));
    }

}
