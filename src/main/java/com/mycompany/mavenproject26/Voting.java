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

    public Voting() {
        initComponents();
        DisplayCandidates();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CandidatesTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        CandidatePictureLb = new javax.swing.JLabel();
        VoteBtn = new javax.swing.JButton();
        CandidateNameLb = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addContainerGap(275, Short.MAX_VALUE))
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
        jLabel2.setText("Vote");

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(242, 133, 0));
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        CandidatesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        CandidatesTable.setSelectionBackground(new java.awt.Color(242, 133, 0));
        CandidatesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CandidatesTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CandidatesTable);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 133, 0));
        jLabel8.setText("Your Candidate");

        CandidatePictureLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandidatePictureLb.setForeground(new java.awt.Color(242, 133, 0));

        VoteBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VoteBtn.setForeground(new java.awt.Color(242, 133, 0));
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
        CandidateNameLb.setForeground(new java.awt.Color(242, 133, 0));
        CandidateNameLb.setText("Name");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 133, 0));
        jLabel11.setText("Candidate List");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 372, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VoteBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CandidatePictureLb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(378, 378, 378))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(417, 417, 417)
                        .addComponent(jLabel2)
                        .addGap(0, 421, Short.MAX_VALUE))
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
                    .addComponent(jButton6)
                    .addComponent(VoteBtn))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Ru = null;
    Statement St = null;

    private void DisplayCandidates() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            Ru = St.executeQuery("Select * from candidate_tbl");
            CandidatesTable.setModel(DbUtils.resultSetToTableModel(Ru));
        } catch (SQLException Ex) {

        }
    }

    private void VoteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VoteBtnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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

    int Key = -1;
    int ElecId;
    int SocId;
    private void CandidatesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidatesTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) CandidatesTable.getModel();
        int MyIndex = CandidatesTable.getSelectedRow();

        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());

        FetchPhoto();
    }//GEN-LAST:event_CandidatesTableMouseClicked

    int VId = 0;
    Statement St1 = null;
    ResultSet Rs1 = null;

    private void VCount() {
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select MAx(e_id) from election_tbl");
            Rs1.next();
            VId = Rs1.getInt(1) + 1;
        } catch (Exception Ex) {

        }
    }

    private void VoteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VoteBtnMouseClicked
        if (Key == -1) {
            JOptionPane.showMessageDialog(this, "Select your Candidate!");
        } else {
            try {
                VCount();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
                PreparedStatement Add = Con.prepareStatement("Insert into vote_tbl (vote_id, e_id, c_id, society_id) values (?,?,?,?)");
                Add.setInt(1, VId);
                Add.setInt(2, ElecId);
                Add.setInt(3, Key);
                Add.setInt(4, SocId);
                int row = Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Vote Counted!");
                Con.close();
                DisplayCandidates();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You have already voted in this election!", "Duplicate Vote", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_VoteBtnMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CandidateNameLb;
    private javax.swing.JLabel CandidatePictureLb;
    private javax.swing.JTable CandidatesTable;
    private javax.swing.JButton VoteBtn;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
