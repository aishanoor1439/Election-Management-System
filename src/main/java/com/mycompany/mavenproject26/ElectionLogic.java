package com.mycompany.mavenproject26;

import java.sql.*;

public class ElectionLogic {

    private Connection con;
    private Statement St;
    private ResultSet Rs;

    public ElectionLogic() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getNextElectionId() {
        int id = 0;
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT MAX(e_id) FROM election_tbl")) {
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public ResultSet getElections() {
        try {
            St = con.createStatement();
            Rs = St.executeQuery("SELECT * FROM election_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Rs;
    }

    public ResultSet getSocieties() {
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery("SELECT society_name FROM society_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addElection(int id, String name, String society, String date) throws SQLException {
        String query = "INSERT INTO election_tbl VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, society);
            pst.setString(4, date);
            pst.executeUpdate();
        }
    }

    public void updateElection(int id, String name, String society, String date) throws SQLException {
        String query = "UPDATE election_tbl SET e_name=?, e_society=?, e_date=? WHERE e_id=?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, society);
            pst.setString(3, date);
            pst.setInt(4, id);
            pst.executeUpdate();
        }
    }

    public void deleteElection(int id) throws SQLException {
        String query = "DELETE FROM election_tbl WHERE e_id=?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}
