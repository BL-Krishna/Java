import java.util.Objects;

public class ContactPerson {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;

    public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof ContactPerson)) return false;

        ContactPerson person=(ContactPerson) obj;

        return  firstName.equalsIgnoreCase(person.firstName) && lastName.equalsIgnoreCase(person.lastName);

    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName.toLowerCase(),lastName.toLowerCase());
    }

    @Override
    public String toString(){
        return firstName + " " +lastName + " | "+city +", "+state+" | "+phoneNumber;
    }
}
