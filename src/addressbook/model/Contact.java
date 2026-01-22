package addressbook.model;

import java.util.Objects;

public class Contact {

    public int id;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phone;
    public String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    // For JUnit DB comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact c = (Contact) o;
        return firstName.equalsIgnoreCase(c.firstName)
                && lastName.equalsIgnoreCase(c.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " +
                city + ", " + state + " | " +
                phone + " | " + email;
    }
}
