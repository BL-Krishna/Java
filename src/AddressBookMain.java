import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        system.addAddressBook("Default");
        AddressBook book = system.getAddressBook("Default");

        while (true) {
            System.out.println("\n1.Add\n 2.Edit\n 3.Delete\n 4.SortName\n 5.SortCity\n 6.Exit");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    System.out.print("City: ");
                    String city = sc.nextLine();
                    System.out.print("State: ");
                    String state = sc.nextLine();
                    System.out.print("Zip: ");
                    String zip = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    book.addContact(new ContactPerson(fn, ln, address, city, state, zip, phone, email));
                    break;

                case 2:
                    System.out.print("Enter Full Name: ");
                    book.editContact(sc.nextLine(), sc);
                    break;

                case 3:
                    System.out.print("Enter Full Name: ");
                    book.deleteContact(sc.nextLine());
                    break;

                case 4:
                    book.sortByName();
                    break;

                case 5:
                    book.sortByCityStateZip("city");
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
