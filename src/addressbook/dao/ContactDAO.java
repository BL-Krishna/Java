package addressbook.dao;

import addressbook.model.Contact;
import addressbook.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    /* UC 1 – Add Contact */
    public void addContact(Contact c) throws SQLException {

        String sql = """
            INSERT INTO contact
            (first_name, last_name, address, city, state, zip, phone, email)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.firstName);
            ps.setString(2, c.lastName);
            ps.setString(3, c.address);
            ps.setString(4, c.city);
            ps.setString(5, c.state);
            ps.setString(6, c.zip);
            ps.setString(7, c.phone);
            ps.setString(8, c.email);

            ps.executeUpdate();
        }
    }

    /* UC 2 – Edit Contact */
    public void updateContact(String firstName, Contact c) throws SQLException {

        String sql = """
            UPDATE contact SET
            last_name=?, address=?, city=?, state=?, zip=?, phone=?, email=?
            WHERE first_name=?
        """;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.lastName);
            ps.setString(2, c.address);
            ps.setString(3, c.city);
            ps.setString(4, c.state);
            ps.setString(5, c.zip);
            ps.setString(6, c.phone);
            ps.setString(7, c.email);
            ps.setString(8, firstName);

            ps.executeUpdate();
        }
    }

    /* UC 3 – Delete Contact */
    public void deleteContact(String firstName) throws SQLException {

        String sql = "DELETE FROM contact WHERE first_name=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.executeUpdate();
        }
    }

    /* UC 4 – Read All Contacts */
    public List<Contact> getAllContacts() throws SQLException {

        List<Contact> list = new ArrayList<>();
        String sql = "SELECT * FROM contact";

        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Contact(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email")
                ));
            }
        }
        return list;
    }

    /* UC 6 – Duplicate Check */
    public boolean isDuplicate(String first, String last) throws SQLException {

        String sql =
                "SELECT 1 FROM contact WHERE first_name=? AND last_name=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, first);
            ps.setString(2, last);
            return ps.executeQuery().next();
        }
    }
}
