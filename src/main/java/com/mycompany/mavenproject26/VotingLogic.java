package com.mycompany.mavenproject26;

import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class VotingLogic {
    private Connection con;
    private Statement St;
    private ResultSet Rs;

    public VotingLogic() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage());
        }
    }

    public ResultSet getCandidates() {
        try {
            St = con.createStatement();
            Rs = St.executeQuery("SELECT * FROM candidate_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Rs;
    }

    public ImageIcon fetchPhoto(int candidateId, JLabel label) {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT c_photo FROM candidate_tbl WHERE c_id = " + candidateId);
            if (rs.next()) {
                return resizePhoto(null, rs.getBytes("c_photo"), label);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getSocietyIdByName(String name) {
        int id = -1;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT society_id FROM society_tbl WHERE society_name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("society_id");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public int getElectionIdByName(String name) {
        int id = -1;
        try {
            PreparedStatement pst = con.prepareStatement("SELECT e_id FROM election_tbl WHERE e_name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("e_id");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean hasAlreadyVoted(int voterId, int electionId) {
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM vote_tbl WHERE v_id = ? AND e_id = ?");
            pst.setInt(1, voterId);
            pst.setInt(2, electionId);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public int getNextVoteId() {
        int id = 1;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(vote_id) FROM vote_tbl");
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean vote(int voteId, int electionId, int candidateId, int voterId, int societyId) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO vote_tbl (vote_id, e_id, c_id, v_id, society_id) VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, voteId);
            pst.setInt(2, electionId);
            pst.setInt(3, candidateId);
            pst.setInt(4, voterId);
            pst.setInt(5, societyId);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ImageIcon resizePhoto(String ImgPath, byte[] pic, JLabel label) {
        ImageIcon MyImage = (ImgPath != null) ? new ImageIcon(ImgPath) : new ImageIcon(pic);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}