package addressbook;

import addressbook.service.AddressBookSystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Service ");

        AddressBookSystem addressBookSystem=new AddressBookSystem();
        new AddressBookSystem().start();
    }
}
