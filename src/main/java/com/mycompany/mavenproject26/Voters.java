package com.mycompany.mavenproject26;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Voters extends javax.swing.JFrame {

    public Voters() {
        initComponents();
        GetElectionsAndSocieties();
        DisplayVoters();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EditBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        VotersTable = new javax.swing.JTable();
        VGenderCb = new javax.swing.JComboBox<>();
        VNameTb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        VSocietyCb = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        VPasswordTb = new javax.swing.JTextField();
        VElectionCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        jLabel2.setText("Voters");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 133, 0));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 133, 0));
        jLabel5.setText("Gender");

        EditBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(242, 133, 0));
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        AddBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(242, 133, 0));
        AddBtn.setText("Add");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(242, 133, 0));
        DeleteBtn.setText("Delete");
        DeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteBtnMouseClicked(evt);
            }
        });
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        BackBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(242, 133, 0));
        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        VotersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        VotersTable.setSelectionBackground(new java.awt.Color(242, 133, 0));
        VotersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VotersTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(VotersTable);

        VGenderCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        VGenderCb.setForeground(new java.awt.Color(242, 133, 0));
        VGenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        VGenderCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VGenderCbActionPerformed(evt);
            }
        });

        VNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VNameTbActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 133, 0));
        jLabel7.setText("Society");

        VSocietyCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        VSocietyCb.setForeground(new java.awt.Color(242, 133, 0));
        VSocietyCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSocietyCbActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 133, 0));
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 133, 0));
        jLabel9.setText("Election");

        VPasswordTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VPasswordTbActionPerformed(evt);
            }
        });

        VElectionCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        VElectionCb.setForeground(new java.awt.Color(242, 133, 0));
        VElectionCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VElectionCbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(VNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VGenderCb, 0, 175, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(VSocietyCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VElectionCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddBtn)
                        .addGap(18, 18, 18)
                        .addComponent(EditBtn)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBtn)
                        .addGap(18, 18, 18)
                        .addComponent(BackBtn))
                    .addComponent(VPasswordTb))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(410, 410, 410))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VGenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VSocietyCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VElectionCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VPasswordTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BackBtn)
                            .addComponent(DeleteBtn)
                            .addComponent(EditBtn)
                            .addComponent(AddBtn)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
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

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackBtnActionPerformed

    private void VGenderCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VGenderCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VGenderCbActionPerformed

    private void VNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VNameTbActionPerformed

    private void VSocietyCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VSocietyCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VSocietyCbActionPerformed

    private void VPasswordTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VPasswordTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VPasswordTbActionPerformed

    private void VElectionCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VElectionCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VElectionCbActionPerformed

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Ru = null;
    Statement St = null;

    private void GetElectionsAndSocieties() {
        try {
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            Statement St = Con.createStatement();

            // Load elections
            ResultSet rsElections = St.executeQuery("SELECT e_name FROM election_tbl");
            while (rsElections.next()) {
                VElectionCb.addItem(rsElections.getString("e_name"));
            }

            // Load societies
            ResultSet rsSocieties = St.executeQuery("SELECT society_name FROM society_tbl");
            while (rsSocieties.next()) {
                VSocietyCb.addItem(rsSocieties.getString("society_name"));
            }

            rsElections.close();
            rsSocieties.close();
            St.close();
            Con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DisplayVoters() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            Ru = St.executeQuery("Select * from voter_tbl");
            VotersTable.setModel(DbUtils.resultSetToTableModel(Ru));
        } catch (SQLException Ex) {

        }
    }

    int VId = 0;
    Statement St1 = null;
    ResultSet Rs1 = null;

    private void VCount() {
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select MAx(v_id) from voter_tbl");
            Rs1.next();
            VId = Rs1.getInt(1) + 1;
        } catch (Exception Ex) {

        }
    }

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        if (VNameTb.getText().isEmpty() || VPasswordTb.getText().isEmpty() || VGenderCb.getSelectedIndex() == -1 || VElectionCb.getSelectedIndex() == -1 || VSocietyCb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Missing Information!");
        } else {
            try {
                VCount();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
                PreparedStatement Add = Con.prepareStatement("INSERT INTO voter_tbl (v_id, v_name, v_gen, v_society, v_election, v_pass) VALUES (?, ?, ?, ?, ?, ?)");
                Add.setInt(1, VId);
                Add.setString(2, VNameTb.getText());
                Add.setString(3, VGenderCb.getSelectedItem().toString());
                Add.setString(4, VSocietyCb.getSelectedItem().toString());
                Add.setString(5, VElectionCb.getSelectedItem().toString());
                Add.setString(6, VPasswordTb.getText().toString());
                int row = Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Voter Registered Successfully!");
                Con.close();
                DisplayVoters();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        if (Key == -1) {
            JOptionPane.showMessageDialog(this, "Select The Voter To Be Deleted!");
        } else {
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
                String Query = "Delete from voter_tbl where v_id=" + Key;
                Statement Del = Con.createStatement();
                Del.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Voter Deleted Successfilly!");
                DisplayVoters();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    int Key = -1;
    private void VotersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VotersTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) VotersTable.getModel();
        int MyIndex = VotersTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        VNameTb.setText(model.getValueAt(MyIndex, 1).toString());
        VGenderCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        VSocietyCb.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
        VElectionCb.setSelectedItem(model.getValueAt(MyIndex, 4).toString());
        VPasswordTb.setText(model.getValueAt(MyIndex, 5).toString());
    }//GEN-LAST:event_VotersTableMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voters().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JComboBox<String> VElectionCb;
    private javax.swing.JComboBox<String> VGenderCb;
    private javax.swing.JTextField VNameTb;
    private javax.swing.JTextField VPasswordTb;
    private javax.swing.JComboBox<String> VSocietyCb;
    private javax.swing.JTable VotersTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
