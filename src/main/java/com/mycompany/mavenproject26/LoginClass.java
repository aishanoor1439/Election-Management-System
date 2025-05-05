 
package com.mycompany.mavenproject26;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginClass {
  

    public boolean validateAdmin(String username, String password) {
        return username.equals("Admin") && password.equals("Password");
    }

    public int validateVoter(String username, String password) {
        int voterId = -1;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            String query = "SELECT * FROM voter_tbl WHERE v_name=? AND v_pass=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                voterId = rs.getInt(1); // Return voter's ID
            }
            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voterId;
    }
}

