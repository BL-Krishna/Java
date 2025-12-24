

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private String name;
    private List<ContactPerson> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public boolean addContact(ContactPerson person) {
        if (contacts.contains(person)) {
            System.out.println("Duplicate contact not allowed.");
            return false;
        }
        contacts.add(person);
        return true;
    }

    public void editContact(String fullName, Scanner sc) {
        contacts.stream()
                .filter(p -> p.getFullName().equalsIgnoreCase(fullName))
                .findFirst()
                .ifPresentOrElse(person -> {
                    System.out.print("Enter new Address: ");
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
                    person.updateDetails(address, city, state, zip, phone, email);
                }, () -> System.out.println("Contact not found."));
    }

    public void deleteContact(String fullName) {
        boolean removed = contacts.removeIf(p -> p.getFullName().equalsIgnoreCase(fullName));
        System.out.println(removed ? "Contact deleted." : "Contact not found.");
    }

    public List<ContactPerson> searchByCityOrState(String value) {
        return contacts.stream()
                .filter(p -> p.getCity().equalsIgnoreCase(value)
                        || p.getState().equalsIgnoreCase(value))
                .collect(Collectors.toList());
    }

    public Map<String, Long> countByCity() {
        return contacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getCity, Collectors.counting()));
    }

    public Map<String, Long> countByState() {
        return contacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getState, Collectors.counting()));
    }

    public void sortByName() {
        contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getFullName))
                .forEach(System.out::println);
    }

    public void sortByCityStateZip(String field) {
        Comparator<ContactPerson> comparator;
        switch (field.toLowerCase()) {
            case "city":
                comparator = Comparator.comparing(ContactPerson::getCity);
                break;
            case "state":
                comparator = Comparator.comparing(ContactPerson::getState);
                break;
            case "zip":
                comparator = Comparator.comparing(ContactPerson::getZip);
                break;
            default:
                return;
        }
        contacts.stream().sorted(comparator).forEach(System.out::println);
    }
}
