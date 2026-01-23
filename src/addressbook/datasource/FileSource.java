package addressbook.datasource;

import addressbook.io.FileIOService;
import addressbook.model.Contact;
import java.util.List;

public class FileSource implements DataSource {
    public void write(List<Contact> c) throws Exception {
        new FileIOService().write(c,"contacts.txt");
    }
}
