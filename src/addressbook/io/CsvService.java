package addressbook.io;

import addressbook.model.Contact;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.List;

public class CsvService {

    public void write(List<Contact> list, String file) throws Exception {
        try (CSVWriter w = new CSVWriter(new FileWriter(file))) {
            for (Contact c : list) {
                w.writeNext(new String[]{
                        c.firstName, c.lastName, c.city,
                        c.state, c.zip, c.phone, c.email
                });
            }
        }
    }
}
