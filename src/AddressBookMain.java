import java.util.*;
 public class AddressBookMain {
     static Map<String,AddressBook> addressBookSystem=new HashMap<>();

     public static void main(String [] args){
         System.out.println("Welcome to Address Book Program");
         Scanner sc=new Scanner(System.in);

         System.out.println("Enter Address Book Name: ");
         String bookName=sc.nextLine();

         AddressBook addressBook=new AddressBook(bookName);
         addressBookSystem.put(bookName,addressBook);

         ContactPerson p1=new ContactPerson(
                 "krishna","ch","Street1",
                 "Vijayawada","AP","520015",
                 "9014302544","krishna@gmail.com");
         ContactPerson p2=new ContactPerson(
                 "Naga","Ch","Street1",
                 "Vijayawada","AP","520015",
                 "9014302544","naga@gmail.com");

         addressBook.addContact(p1);
         addressBook.addContact((p2));

         //uc-7
         System.out.println("\nPersons in Vijayawada :");
         addressBook.searchByCityOrState("Vijayawada")
        .forEach(System.out::println);
         //uc-9

         System.out.println("\nCount in Vijayawada : "+
         addressBook.countByCity("Vijayawada"));

         System.out.println("\nSorted By Name:");
         addressBook.sortByName().forEach(System.out::println);

         System.out.println("\nSorted By City:");
         addressBook.sortByCity().forEach(System.out::println);

         System.out.println("\nSorted By State:");
         addressBook.sortByState().forEach(System.out::println);

         System.out.println("\nSorted By Zip:");
         addressBook.sortByZip().forEach(System.out::println);

         addressBook.writeToFile("addressbook.txt");

         addressBook.getAllContacts().clear();
         addressBook.readFromFile("addressbook.txt");

         System.out.println("\nContacts After Reading From File:");
         addressBook.getAllContacts().forEach(System.out::println);

         // UC-14 CSV
         addressBook.writeToCSV("addressbook.csv");
         addressBook.getAllContacts().clear();
         addressBook.readFromCSV("addressbook.csv");

         System.out.println("\nContacts After Reading From CSV:");
         addressBook.getAllContacts().forEach(System.out::println);

        // UC-15 JSON
         addressBook.writeToJSON("addressbook.json");
         addressBook.getAllContacts().clear();
         addressBook.readFromJSON("addressbook.json");

         System.out.println("\nContacts After Reading From JSON:");
         addressBook.getAllContacts().forEach(System.out::println);


     }
}