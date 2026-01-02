import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


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

    //uc-13 read contacts to file

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

    // UC-14: Write contacts to CSV using OpenCSV
    public void writeToCSV(String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {

            // Header
            String[] header = {"FirstName", "LastName", "Address", "City",
                    "State", "Zip", "Phone", "Email"};
            writer.writeNext(header);

            for (ContactPerson p : contactList) {
                String[] data = {
                        p.firstName, p.lastName, p.address,
                        p.city, p.state, p.zip,
                        p.phoneNumber, p.email
                };
                writer.writeNext(data);
            }
            System.out.println("Contacts written to CSV successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UC-14: Read contacts from CSV using OpenCSV
    public void readFromCSV(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

            String[] line;
            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                ContactPerson person = new ContactPerson(
                        line[0], line[1], line[2],
                        line[3], line[4], line[5],
                        line[6], line[7]
                );
                contactList.add(person);
            }
            System.out.println("Contacts read from CSV successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UC-15: Write contacts to JSON using GSON
    public void writeToJSON(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new Gson();
            gson.toJson(contactList, writer);
            System.out.println("Contacts written to JSON successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // UC-15: Read contacts from JSON using GSON
    public void readFromJSON(String fileName) {
        try (Reader reader = new FileReader(fileName)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<ContactPerson>>() {}.getType();
            List<ContactPerson> contacts = gson.fromJson(reader, listType);
            contactList.addAll(contacts);
            System.out.println("Contacts read from JSON successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
