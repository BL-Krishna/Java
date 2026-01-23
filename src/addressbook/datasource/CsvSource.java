package addressbook.datasource;

import addressbook.io.CsvService;
import addressbook.model.Contact;
import java.util.List;

public class CsvSource implements DataSource {
    public void write(List<Contact> c) throws Exception {
        new CsvService().write(c,"contacts.csv");
    }
}
