package com.mycompany.mavenproject26;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginClass extends AbstractBUSPs {

    public boolean validateAdmin(String username, String password) {

        return username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("Password");

    }

    public int validateVoter(String username, String password) {

        int voterId = -1;

        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            String query = "SELECT * FROM voter_tbl WHERE LOWER(v_name) = LOWER(?) AND LOWER(v_pass) = LOWER(?)";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                voterId = rs.getInt(1);
            }
            rs.close();
            pst.close();
            Con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return voterId;

    }

}
