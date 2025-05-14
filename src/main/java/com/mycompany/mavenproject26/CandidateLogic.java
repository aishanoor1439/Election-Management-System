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

    // Constructor to initialize database connection
    public CandidateLogic() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get the next candidate ID
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

    // Method to add a new candidate
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

    // Method to fetch all candidates
    public ResultSet getCandidates() {
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM candidate_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Rs;
    }

    // Method to fetch photo of a specific candidate
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

    // Method to delete a candidate
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

    // Method to update a candidate's data
    public boolean updateCandidate(int cId, String name, String gender, String society, String election, String imgPath) {
        try {
            InputStream img = new FileInputStream(imgPath);
            Pst = Con.prepareStatement("UPDATE candidate_tbl SET c_name = ?, c_gen = ?, c_society = ?, c_election = ?, c_photo = ? WHERE c_id = ?");
            Pst.setString(1, name);
            Pst.setString(2, gender);
            Pst.setString(3, society);
            Pst.setString(4, election);
            Pst.setBlob(5, img);
            Pst.setInt(6, cId);
            int rows = Pst.executeUpdate();
            return rows > 0;
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

}
