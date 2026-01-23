package addressbook.datasource;

import addressbook.io.JsonService;
import addressbook.model.Contact;
import java.util.List;

public class JsonSource implements DataSource {
    public void write(List<Contact> c) throws Exception {
        new JsonService().write(c,"contacts.json");
    }
}
