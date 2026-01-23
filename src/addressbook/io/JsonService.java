package addressbook.io;

import addressbook.model.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class JsonService {

    public void write(List<Contact> list, String file) throws Exception {
        new ObjectMapper().writeValue(new File(file), list);
    }
}
