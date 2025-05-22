package com.mycompany.mavenproject26;

import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DashboardLogic extends AbstractBUSPs{

    public DashboardLogic() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllElections() {
        try {
            St = Con.createStatement();
            return St.executeQuery("SELECT * FROM election_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getWinnerCandidateId(int electionId) {
        try {
           St = Con.createStatement();
            String query = "SELECT c_id, COUNT(c_id) AS total_votes FROM vote_tbl WHERE e_id = " + electionId +
                           " GROUP BY c_id ORDER BY total_votes DESC LIMIT 1";
            Rs = St.executeQuery(query);
            if (Rs.next()) {
                return Rs.getInt("c_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public WinnerData getWinnerData(int candidateId) {
        WinnerData data = new WinnerData();
        try {
            String query = "SELECT c_name, c_photo FROM candidate_tbl WHERE c_id = ?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setInt(1, candidateId);
            Rs = pst.executeQuery();
            if (Rs.next()) {
                data.name = Rs.getString("c_name");
                data.photoBytes = Rs.getBytes("c_photo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getCandidateVotes(int candidateId) {
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT COUNT(*) FROM vote_tbl WHERE c_id = " + candidateId);
            if (Rs.next()) {
                return Rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalVotesInElection(int electionId) {
        try {
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT COUNT(*) FROM vote_tbl WHERE e_id = " + electionId);
            if (Rs.next()) {
                return Rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ImageIcon resizePhoto(byte[] pic, JLabel label) {
        
        ImageIcon imageIcon = new ImageIcon(pic);
        Image img = imageIcon.getImage();
        Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
        
    }

    public static class WinnerData {
        public String name;
        public byte[] photoBytes;
    }
}