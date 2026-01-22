package addressbook.service;

import addressbook.dao.ContactDAO;
import addressbook.model.Contact;

import java.sql.SQLException;
import java.util.Scanner;

public class AddressBookSystem {

    private final Scanner scanner = new Scanner(System.in);
    private final ContactDAO dao = new ContactDAO();

    public void start() {

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> addContact();
                    case 2 -> editContact();
                    case 3 -> deleteContact();
                    case 4 -> dao.getAllContacts()
                            .forEach(System.out::println);
                    case 0 -> System.exit(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    private void showMenu() {
        System.out.println("""
            1. Add Contact
            2. Edit Contact
            3. Delete Contact
            4. View All
            0. Exit
        """);
    }

    private void addContact() throws SQLException {

        Contact c = readContact();

        if (dao.isDuplicate(c.firstName, c.lastName)) {
            System.out.println("Duplicate contact not allowed");
            return;
        }

        dao.addContact(c);
        System.out.println("Contact added");
    }

    private void editContact() throws SQLException {
        System.out.print("Enter First Name to Edit: ");
        String name = scanner.nextLine();
        Contact c = readContact();
        dao.updateContact(name, c);
    }

    private void deleteContact() throws SQLException {
        System.out.print("Enter First Name to Delete: ");
        dao.deleteContact(scanner.nextLine());
    }

    private Contact readContact() {
        System.out.print("First Name: "); String f = scanner.nextLine();
        System.out.print("Last Name: ");  String l = scanner.nextLine();
        System.out.print("Address: ");    String a = scanner.nextLine();
        System.out.print("City: ");       String c = scanner.nextLine();
        System.out.print("State: ");      String s = scanner.nextLine();
        System.out.print("Zip: ");        String z = scanner.nextLine();
        System.out.print("Phone: ");      String p = scanner.nextLine();
        System.out.print("Email: ");      String e = scanner.nextLine();

        return new Contact(f, l, a, c, s, z, p, e);
    }
}
