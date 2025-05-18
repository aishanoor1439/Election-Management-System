package com.mycompany.mavenproject26;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class VoterLogic {

    Connection Con;
    Statement St, St1;
    PreparedStatement pst;
    ResultSet Rs, Ru, Rs1;

    public VoterLogic() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void GetElectionsAndSocieties(JComboBox<String> VElectionCb, JComboBox<String> VSocietyCb) {
        try {
            Statement St = Con.createStatement();

            ResultSet rsElections = St.executeQuery("SELECT e_name FROM election_tbl");
            while (rsElections.next()) {
                VElectionCb.addItem(rsElections.getString("e_name"));
            }

            ResultSet rsSocieties = St.executeQuery("SELECT society_name FROM society_tbl");
            while (rsSocieties.next()) {
                VSocietyCb.addItem(rsSocieties.getString("society_name"));
            }

            rsElections.close();
            rsSocieties.close();
            St.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getVoters() {
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM voter_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Rs;
    }

    public int GetNextVoterId() {
        int VId = 0;
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("SELECT MAX(v_id) FROM voter_tbl");
            if (Rs1.next()) {
                VId = Rs1.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return VId;
    }

    public boolean addVoter(String name, String gender, String society, String election, String password) {
        try {
            PreparedStatement Add = Con.prepareStatement("INSERT INTO voter_tbl (v_name, v_gen, v_society, v_election, v_pass) VALUES (?, ?, ?, ?, ?)");
            Add.setString(1, name);
            Add.setString(2, gender);
            Add.setString(3, society);
            Add.setString(4, election);
            Add.setString(5, password);
            Add.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }

    public boolean deleteVoter(int VoterId) {
        try {
            String Query = "DELETE FROM voter_tbl WHERE v_id=" + VoterId;
            Statement Del = Con.createStatement();
            Del.executeUpdate(Query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }

    public boolean updateVoter(int VoterId, String name, String gender, String society, String election, String password) {
        try {
            String Query = "UPDATE voter_tbl SET v_name=?, v_gen=?, v_society=?, v_election=?, v_pass=? WHERE v_id=?";
            PreparedStatement UpdateQuery = Con.prepareStatement(Query);
            UpdateQuery.setString(1, name);
            UpdateQuery.setString(2, gender);
            UpdateQuery.setString(3, society);
            UpdateQuery.setString(4, election);
            UpdateQuery.setString(5, password);
            UpdateQuery.setInt(6, VoterId);
            UpdateQuery.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return true;
    }
}