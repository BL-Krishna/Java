package addressbook.io;

import addressbook.model.Contact;
import java.io.*;
import java.util.List;

public class FileIOService {

    public void write(List<Contact> list, String file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Contact c : list) {
                bw.write(c.toString());
                bw.newLine();
            }
        }
    }
}
