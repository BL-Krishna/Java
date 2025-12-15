import java.util.regex.Pattern;

public class UserRegistrationValidator {

    //first name validator
    private static final String FIRST_NAME_REGEX="^[A-Z][a-z]{2,}$";
    //last name validator
    private static final String LAST_NAME_REGEX="^[A-Z][a-z]{2,}$";

    //email validator

    private static final String EMAIL_VALIDATOR_REGEX="^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@" + "[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}+$)";

    private static final String  MOBILE_REGEX="^[0-9]{2} [0-9]{10}$";

    //Password validator
    // At least 8 chars
    // At least 1 uppercase
    // At least 1 digit
    // Exactly 1 special character
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$).{8,}$";


    public static boolean validateFirstName(String firstName){
        return Pattern.matches(FIRST_NAME_REGEX,firstName);

    }
    public static boolean validateLastName(String lastName){
        return Pattern.matches(LAST_NAME_REGEX,lastName);

    }
    public static boolean validateEmail(String email){
        return Pattern.matches(EMAIL_VALIDATOR_REGEX,email);

    }
    public static boolean validateMobile(String mobile){
        return Pattern.matches(MOBILE_REGEX,mobile);

    }
    public static boolean validatePassword(String password){
        return Pattern.matches(PASSWORD_REGEX,password);

    }
}
