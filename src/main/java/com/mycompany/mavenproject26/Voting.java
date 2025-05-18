package com.mycompany.mavenproject26;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
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

public class Voting extends javax.swing.JFrame {

    private VotingLogic logic;
    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Ru = null;
    Statement St = null;
    Statement St1 = null;
    ResultSet Rs1 = null;
    int VotingId;
    int ElecId;
    int SocId;
    int VId;
    int Key = -1;

    public Voting() {
        initComponents();
        this.logic = new VotingLogic();
        displayCandidates();
    }

    public Voting(int voterId) {
        initComponents();
        this.logic = new VotingLogic();
        this.VotingId = voterId;
        displayCandidates();
    }

    private void displayCandidates() {
        try {
            ResultSet rs = logic.getCandidates();
            DefaultTableModel model = (DefaultTableModel) CandidatesTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("c_id"),
                    rs.getString("c_name"),
                    rs.getString("c_gen"),
                    rs.getString("c_society"),
                    rs.getString("c_election"),
                    rs.getString("c_photo")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching candidates.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CandidatesTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        CandidatePictureLb = new javax.swing.JLabel();
        VoteBtn = new javax.swing.JButton();
        CandidateNameLb = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 31, 91));
        jLabel2.setText("Vote");

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

        CandidatesTable.setForeground(new java.awt.Color(42, 31, 91));
        CandidatesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Gender", "Society", "Election", "Photo"
            }
        ));
        CandidatesTable.setSelectionBackground(new java.awt.Color(199, 226, 245));
        CandidatesTable.setSelectionForeground(new java.awt.Color(42, 31, 91));
        CandidatesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CandidatesTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CandidatesTable);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(42, 31, 91));
        jLabel8.setText("Your Candidate");

        CandidatePictureLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidatePictureLb.setForeground(new java.awt.Color(242, 133, 0));

        VoteBtn.setBackground(new java.awt.Color(42, 31, 91));
        VoteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VoteBtn.setForeground(new java.awt.Color(199, 226, 245));
        VoteBtn.setText("Vote");
        VoteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoteBtnMouseClicked(evt);
            }
        });
        VoteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoteBtnActionPerformed(evt);
            }
        });

        CandidateNameLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidateNameLb.setForeground(new java.awt.Color(42, 31, 91));
        CandidateNameLb.setText("Name");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(42, 31, 91));
        jLabel11.setText("Candidates List");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 372, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CandidatePictureLb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(378, 378, 378))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(417, 417, 417)
                                .addComponent(jLabel2))
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
                        .addGap(413, 413, 413)
                        .addComponent(VoteBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(VoteBtn)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BackBtn)
                .addContainerGap(57, Short.MAX_VALUE))
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

    private void VoteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VoteBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

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

    private void FetchPhoto() {
        String Query = "Select c_photo from candidate_tbl where c_id = " + Key;
        Statement St;
        ResultSet Rs;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery(Query);
            if (Rs.next()) {
                CandidatePictureLb.setIcon(ResizePhoto(null, Rs.getBytes("c_photo"), CandidatePictureLb));

            }
        } catch (Exception e) {

        }
    }

    private void CandidatesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidatesTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) CandidatesTable.getModel();
        int MyIndex = CandidatesTable.getSelectedRow();

        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        String societyName = model.getValueAt(MyIndex, 3).toString();
        String electionName = model.getValueAt(MyIndex, 4).toString();

        SocId = logic.getSocietyIdByName(societyName);
        ElecId = logic.getElectionIdByName(electionName);
        CandidatePictureLb.setIcon(logic.fetchPhoto(Key, CandidatePictureLb));
    }//GEN-LAST:event_CandidatesTableMouseClicked

    private int getSocietyIdByName(String name) {
        int id = -1;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            pst = Con.prepareStatement("SELECT society_id FROM society_tbl WHERE society_name = ?");
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

    private int getElectionIdByName(String name) {
        int id = -1;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");

            pst = Con.prepareStatement("SELECT e_id FROM election_tbl WHERE e_name = ?");
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

    private void VCount() {
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select MAx(vote_id) from vote_tbl");
            Rs1.next();
            VId = Rs1.getInt(1) + 1;
        } catch (Exception Ex) {

        }
    }

    private void VoteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoteBtnMouseClicked
        if (Key == -1) {
            JOptionPane.showMessageDialog(this, "Select your Candidate!");
        } else if (logic.hasAlreadyVoted(VotingId, ElecId)) {
            JOptionPane.showMessageDialog(this, "You have already voted in this election!");
        } else {
            VId = logic.getNextVoteId();
            boolean voted = logic.vote(VId, ElecId, Key, VotingId, SocId);
            if (voted) {
                JOptionPane.showMessageDialog(this, "Vote Counted!");
                displayCandidates();
                VoteBtn.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Voting failed!");
            }
        }
    }//GEN-LAST:event_VoteBtnMouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JLabel CandidateNameLb;
    private javax.swing.JLabel CandidatePictureLb;
    private javax.swing.JTable CandidatesTable;
    private javax.swing.JButton VoteBtn;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
