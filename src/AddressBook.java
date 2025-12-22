import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    String name;
    List<ContactPerson> contactList =new ArrayList<>();

    public AddressBook(String name){
        this.name=name;
    }
    //uc-1 and uc-6
    public void addContact(ContactPerson person){
        boolean isDuplicate=contactList.stream().anyMatch(p->p.equals(person));

        if(!isDuplicate){
            contactList.add(person);
            System.out.println("Contact added successfully");
        }
        else{
            System.out.println("Duplicate Contact Found");
        }
    }
    //uc-2
    public void editContact(String firstName,Scanner sc){
        contactList.stream().filter(p->p.firstName.equalsIgnoreCase(firstName))
                .findFirst()
                .ifPresent(p->{
                    System.out.print("Enter new city");
                    p.city=sc.next();
                    System.out.println("Contact updated");
                });
    }
    //uc-3
    public void deleteContact(String firstName){
        contactList.removeIf(p->p.firstName.equalsIgnoreCase(firstName));
        System.out.println("Contact deleted");
    }
    //uc-7
    public List<ContactPerson> searchByCityOrState(String value){
        return contactList.stream()
                .filter(p->p.city.equalsIgnoreCase(value)
                || p.state.equalsIgnoreCase(value))
                .collect(Collectors.toList());
    }
    //uc-9
    public long countByCity(String city){
        return contactList.stream()
                .filter(p->p.city.equalsIgnoreCase(city))
                .count();
    }
    public List<ContactPerson> getAllContacts(){
        return contactList;
    }

}
