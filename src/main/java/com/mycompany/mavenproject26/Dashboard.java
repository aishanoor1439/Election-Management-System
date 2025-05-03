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

    public Dashboard() {
        initComponents();
        DisplayELections();
    }

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Ru = null;
    Statement St = null;
    ResultSet Rs = null;

    private void DisplayELections() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            Ru = St.executeQuery("Select * from election_tbl");
            ElectionsTable.setModel(DbUtils.resultSetToTableModel(Ru));
        } catch (SQLException Ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(242, 133, 0));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Election Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 133, 0));
        jLabel2.setText("Dashboard");

        BackBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(242, 133, 0));
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

        ElectionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ElectionsTable.setSelectionBackground(new java.awt.Color(242, 133, 0));
        ElectionsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElectionsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ElectionsTable);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 133, 0));
        jLabel8.setText("Winner");

        CandidatePictureLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidatePictureLb.setForeground(new java.awt.Color(242, 133, 0));

        CandidateNameLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidateNameLb.setForeground(new java.awt.Color(242, 133, 0));
        CandidateNameLb.setText("Name");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 133, 0));
        jLabel11.setText("Elections List");

        VotesLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        VotesLb.setForeground(new java.awt.Color(242, 133, 0));
        VotesLb.setText("Votes");

        PercentageLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        PercentageLb.setForeground(new java.awt.Color(242, 133, 0));
        PercentageLb.setText("Percentage");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VotesLb)
                        .addGap(18, 18, 18)
                        .addComponent(PercentageLb))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 400, Short.MAX_VALUE)
                        .addComponent(CandidatePictureLb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(400, 400, 400))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

    int WinnerID, Votes, Percentage;

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

    int TotalVotes;
    double WinPercentage;

    private void GetPercentage() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            String Query = "SELECT COUNT(*) FROM vote_tbl WHERE e_id = " + Key;
            Rs = St.executeQuery(Query);
            while (Rs.next()) {
                TotalVotes = Rs.getInt(1);
                JOptionPane.showMessageDialog(this, ""+TotalVotes);
                WinPercentage = (Votes/TotalVotes)*100;
                PercentageLb.setText(WinPercentage+"%");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "GetWinner error: " + e.getMessage());
        }
    }

    int Key = -1;
    
    private void ElectionsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElectionsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) ElectionsTable.getModel();
        int MyIndex = ElectionsTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        GetWinner();
        GetWinnerData();
        GetVotes();
        GetPercentage();
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
