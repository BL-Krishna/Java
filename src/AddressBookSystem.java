import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {
        addressBooks.putIfAbsent(name, new AddressBook(name));
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }
}
