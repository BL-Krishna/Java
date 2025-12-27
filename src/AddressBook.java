import java.io.*;
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
    //uc-10
    public List<ContactPerson> sortByName(){
        return  contactList.stream()
                .sorted(Comparator
                        .comparing((ContactPerson p) -> p.firstName.toLowerCase())
                        .thenComparing((ContactPerson p)-> p.lastName.toLowerCase()))
                .collect(Collectors.toList());
    }
    // uc-11: Sort by City
    public List<ContactPerson> sortByCity() {
        return contactList.stream()
                .sorted(Comparator.comparing(p -> p.city.toLowerCase()))
                .collect(Collectors.toList());
    }

    // uc-11: Sort by State
    public List<ContactPerson> sortByState() {
        return contactList.stream()
                .sorted(Comparator.comparing(p -> p.state.toLowerCase()))
                .collect(Collectors.toList());
    }

    // uc-11: Sort by Zip
    public List<ContactPerson> sortByZip() {
        return contactList.stream()
                .sorted(Comparator.comparing(p -> p.zip))
                .collect(Collectors.toList());
    }

    //uc -12 write contacts to file
    public void writeToFile(String fileName){
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            for(ContactPerson p:contactList){
                writer.write(p.firstName+","+p.lastName+","+p.state+","+p.city+","+p.address+","+p.phoneNumber+","+p.zip+","+p.email);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //uc-12 read contacts to file

    public  void readFromFile(String fileName) {
        try(BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            String line;
            while((line=reader.readLine())!=null){
                String data[]=line.split(",");

                ContactPerson person=new ContactPerson(
                        data[0], data[1], data[2],
                        data[3], data[4], data[5],
                        data[6], data[7]

                );
                contactList.add(person);
            }
            System.out.println("contacts read from file successfully");
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
