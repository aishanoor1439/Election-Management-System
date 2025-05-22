package com.mycompany.mavenproject26;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Dashboard extends javax.swing.JFrame {

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Ru = null;
    Statement St = null;
    ResultSet Rs = null;
    private DashboardLogic logic;
    private int selectedElectionId = -1;
    int WinnerID, Votes, TotalVotes;
    double WinPercentage;
    int Key = -1;

    public Dashboard() {
        initComponents();
        logic = new DashboardLogic();
        displayElections();
    }

    private void displayElections() {
        ResultSet rs = logic.getAllElections();
        if (rs != null) {
            ElectionsTable.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ElectionsTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        CandidatePictureLb = new javax.swing.JLabel();
        CandidateNameLb = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        VotesLb = new javax.swing.JLabel();
        PercentageLb = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 31, 91));
        jLabel2.setText("Dashboard");

        BackBtn.setBackground(new java.awt.Color(42, 31, 91));
        BackBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(199, 226, 245));
        BackBtn.setText("Back");
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        ElectionsTable.setForeground(new java.awt.Color(42, 31, 91));
        ElectionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Society", "Date"
            }
        ));
        ElectionsTable.setSelectionBackground(new java.awt.Color(199, 226, 245));
        ElectionsTable.setSelectionForeground(new java.awt.Color(42, 31, 91));
        ElectionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElectionsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ElectionsTable);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(42, 31, 91));
        jLabel8.setText("Winner");

        CandidatePictureLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidatePictureLb.setForeground(new java.awt.Color(242, 133, 0));

        CandidateNameLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidateNameLb.setForeground(new java.awt.Color(42, 31, 91));
        CandidateNameLb.setText("Name");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(42, 31, 91));
        jLabel11.setText("Elections List");

        VotesLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        VotesLb.setForeground(new java.awt.Color(42, 31, 91));
        VotesLb.setText("Votes");

        PercentageLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        PercentageLb.setForeground(new java.awt.Color(42, 31, 91));
        PercentageLb.setText("Percentage");

        jPanel5.setBackground(new java.awt.Color(42, 31, 91));
        jPanel5.setForeground(new java.awt.Color(199, 226, 245));
        jPanel5.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(199, 226, 245));
        jLabel12.setText("Bahria University Society Polls");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel12)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(421, 421, 421)
                                .addComponent(CandidateNameLb)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VotesLb)
                .addGap(67, 67, 67)
                .addComponent(PercentageLb)
                .addGap(314, 314, 314))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(BackBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(CandidatePictureLb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CandidatePictureLb, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CandidateNameLb)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VotesLb)
                    .addComponent(PercentageLb))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BackBtn)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

    private void GetWinner() {
        
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            String Query = "SELECT c_id, COUNT(c_id) FROM vote_tbl WHERE e_id = " + Key + " GROUP BY c_id ORDER BY COUNT(c_id) DESC LIMIT 1";
            Rs = St.executeQuery(Query);
            if (Rs.next()) {
                WinnerID = Rs.getInt("c_id");
            } else {
                JOptionPane.showMessageDialog(this, "No votes found for this election.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "GetWinner error: " + e.getMessage());
        }
        
    }

    public ImageIcon ResizePhoto(String ImgPath, byte[] pic, javax.swing.JLabel label) {
        
        ImageIcon MyImage = null;

        if (ImgPath != null) {
            MyImage = new ImageIcon(ImgPath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
        
    }

    private void GetWinnerData() {
        
        if (WinnerID == -1) {
            JOptionPane.showMessageDialog(this, "Winner not determined yet.");
            return;
        }

        String Query = "SELECT c_name, c_photo FROM candidate_tbl WHERE c_id = " + WinnerID;
        
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            Statement St = Con.createStatement();
            ResultSet Rs = St.executeQuery(Query);
            if (Rs.next()) {
                CandidatePictureLb.setIcon(ResizePhoto(null, Rs.getBytes("c_photo"), CandidatePictureLb));
                CandidateNameLb.setText(Rs.getString("c_name"));
            } else {
                JOptionPane.showMessageDialog(this, "Winner data not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "GetWinnerData error: " + e.getMessage());
        }
        
    }

    private void GetVotes() {
        
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            String Query = "SELECT COUNT(c_id) FROM vote_tbl WHERE c_id = " + WinnerID;
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                Votes = Rs.getInt(1);
//                JOptionPane.showMessageDialog(this, ""+Votes);
                VotesLb.setText(Votes + "Votes");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "GetWinner error: " + e.getMessage());
        }
        
    }

    private void GetPercentage() {
        
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            String Query = "SELECT COUNT(*) FROM vote_tbl WHERE e_id = " + Key;
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                TotalVotes = Rs.getInt(1);
                JOptionPane.showMessageDialog(this, "" + TotalVotes);
                WinPercentage = (Votes / TotalVotes) * 100;
                PercentageLb.setText(WinPercentage + "%");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "GetWinner error: " + e.getMessage());
        }
        
    }

    private void ElectionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElectionsTableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel) ElectionsTable.getModel();
        int selectedRow = ElectionsTable.getSelectedRow();
        selectedElectionId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());

        int winnerId = logic.getWinnerCandidateId(selectedElectionId);
        if (winnerId == -1) {
            JOptionPane.showMessageDialog(this, "No winner found for this election.");
            return;
        }

        // Winner Data
        DashboardLogic.WinnerData winner = logic.getWinnerData(winnerId);
        if (winner != null) {
            CandidateNameLb.setText(winner.name);
            CandidatePictureLb.setIcon(logic.resizePhoto(winner.photoBytes, CandidatePictureLb));
        }

        // Votes
        int candidateVotes = logic.getCandidateVotes(winnerId);
        int totalVotes = logic.getTotalVotesInElection(selectedElectionId);
        double percentage = totalVotes > 0 ? ((double) candidateVotes / totalVotes) * 100 : 0;

        VotesLb.setText(candidateVotes + " Votes");
        PercentageLb.setText(String.format("%.2f", percentage) + " %");
        
    }//GEN-LAST:event_ElectionsTableMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel CandidateNameLb;
    private javax.swing.JLabel CandidatePictureLb;
    private javax.swing.JTable ElectionsTable;
    private javax.swing.JLabel PercentageLb;
    private javax.swing.JLabel VotesLb;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
