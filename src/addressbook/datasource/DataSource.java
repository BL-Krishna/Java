package addressbook.datasource;

import addressbook.model.Contact;

import java.util.List;

public interface DataSource {
    void write(List<Contact> contacts) throws Exception;
}
