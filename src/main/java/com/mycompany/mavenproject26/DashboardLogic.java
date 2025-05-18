package com.mycompany.mavenproject26;

import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DashboardLogic {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DashboardLogic() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllElections() {
        try {
            st = con.createStatement();
            return st.executeQuery("SELECT * FROM election_tbl");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getWinnerCandidateId(int electionId) {
        try {
            st = con.createStatement();
            String query = "SELECT c_id, COUNT(c_id) AS total_votes FROM vote_tbl WHERE e_id = " + electionId +
                           " GROUP BY c_id ORDER BY total_votes DESC LIMIT 1";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("c_id");
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
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, candidateId);
            rs = pst.executeQuery();
            if (rs.next()) {
                data.name = rs.getString("c_name");
                data.photoBytes = rs.getBytes("c_photo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getCandidateVotes(int candidateId) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM vote_tbl WHERE c_id = " + candidateId);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalVotesInElection(int electionId) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM vote_tbl WHERE e_id = " + electionId);
            if (rs.next()) {
                return rs.getInt(1);
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