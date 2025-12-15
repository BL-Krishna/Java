import java.util.Scanner;

public class UserRegistrationMain {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter First Name");
        System.out.println(UserRegistrationValidator.validateFirstName(sc.nextLine())?"valid first name":"Invalid first name");

        System.out.println("Enter Last Name");
        System.out.println(UserRegistrationValidator.validateLastName(sc.nextLine())?"valid last name":"Invalid last name");

        System.out.println("Enter Email");
        System.out.println(UserRegistrationValidator.validateEmail(sc.nextLine())?"valid email":"Invalid email");

        System.out.println("Enter Mobile Number");
        System.out.println(UserRegistrationValidator.validateMobile(sc.nextLine())?"valid mobile number":"Invalid mobile number");

        System.out.println("Enter Password");
        System.out.println(UserRegistrationValidator.validatePassword(sc.nextLine())?"valid Password":"Invalid password");
    }
}
