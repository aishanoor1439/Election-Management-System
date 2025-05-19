package com.mycompany.mavenproject26;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CandidateLogic {

    private Connection Con;
    private Statement St;
    private ResultSet Rs;
    private PreparedStatement Pst;

    public CandidateLogic() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNextCandidateId() {
        int CId = 0;
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT MAX(c_id) FROM candidate_tbl");
            if (Rs.next()) {
                CId = Rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return CId;
    }

    public boolean addCandidate(String name, String gender, String society, String election, String imgPath) throws FileNotFoundException {
        try {
            int CId = getNextCandidateId();
            InputStream img = new FileInputStream(imgPath);
            Pst = Con.prepareStatement("INSERT INTO candidate_tbl (c_id, c_name, c_gen, c_society, c_election, c_photo) VALUES (?, ?, ?, ?, ?, ?)");
            Pst.setInt(1, CId);
            Pst.setString(2, name);
            Pst.setString(3, gender);
            Pst.setString(4, society);
            Pst.setString(5, election);
            Pst.setBlob(6, img);

            int row = Pst.executeUpdate();
            return row > 0;

        } catch (SQLException | FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet getCandidates() {
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM candidate_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Rs;
    }

    public byte[] getCandidatePhoto(int cId) {
        byte[] photo = null;
        try {
            Pst = Con.prepareStatement("SELECT c_photo FROM candidate_tbl WHERE c_id = ?");
            Pst.setInt(1, cId);
            Rs = Pst.executeQuery();
            if (Rs.next()) {
                photo = Rs.getBytes("c_photo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return photo;
    }

    public boolean deleteCandidate(int cId) {
        try {
            Pst = Con.prepareStatement("DELETE FROM candidate_tbl WHERE c_id = ?");
            Pst.setInt(1, cId);
            int rows = Pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCandidate(int cId, String name, String gender, String society, String election, Object imgPath) {
    try {
        if (imgPath == null) {
            System.out.println("Error: Image path is empty.");
            return false;
        }
        InputStream img = new FileInputStream((String) imgPath);
        PreparedStatement pst = Con.prepareStatement("UPDATE candidate_tbl SET c_name = ?, c_gen = ?, c_society = ?, c_election = ?, c_photo = ? WHERE c_id = ?");
        pst.setString(1, name);
        pst.setString(2, gender);
        pst.setString(3, society);
        pst.setString(4, election);
        pst.setBlob(5, img);
        pst.setInt(6, cId);
        int rows = pst.executeUpdate();
        return rows > 0;
    } catch (SQLException | FileNotFoundException e) {
        e.printStackTrace();
        return false;
    }
}

    
public byte[] fetchCandidatePhoto(int id) {
        String query = "SELECT c_photo FROM candidate_tbl WHERE c_id = " + id;
        try (Statement st = Con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                return rs.getBytes("c_photo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
