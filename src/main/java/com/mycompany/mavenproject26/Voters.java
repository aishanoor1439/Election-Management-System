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

    private VoterLogic logic;

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Ru, Rs1, rsElections, rsSocieties = null;
    Statement St, St1 = null;
    private int selectedVoterId = -1;

    public Voters() {
        initComponents();
        logic = new VoterLogic();
        GetElectionsAndSocieties();
        displayVoters();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 31, 91));
        jLabel2.setText("Voters");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(42, 31, 91));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(42, 31, 91));
        jLabel5.setText("Gender");

        EditBtn.setBackground(new java.awt.Color(42, 31, 91));
        EditBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(199, 226, 245));
        EditBtn.setText("Edit");
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(42, 31, 91));
        AddBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(199, 226, 245));
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

        DeleteBtn.setBackground(new java.awt.Color(42, 31, 91));
        DeleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(199, 226, 245));
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

        VotersTable.setForeground(new java.awt.Color(42, 31, 91));
        VotersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Gender", "Society", "Election", "Password"
            }
        ));
        VotersTable.setSelectionBackground(new java.awt.Color(199, 226, 245));
        VotersTable.setSelectionForeground(new java.awt.Color(42, 31, 91));
        VotersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VotersTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(VotersTable);

        VGenderCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        VGenderCb.setForeground(new java.awt.Color(42, 31, 91));
        VGenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        VGenderCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VGenderCbActionPerformed(evt);
            }
        });

        VNameTb.setForeground(new java.awt.Color(42, 31, 91));
        VNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VNameTbActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(42, 31, 91));
        jLabel7.setText("Society");

        VSocietyCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        VSocietyCb.setForeground(new java.awt.Color(42, 31, 91));
        VSocietyCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSocietyCbActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(42, 31, 91));
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(42, 31, 91));
        jLabel9.setText("Election");

        VPasswordTb.setForeground(new java.awt.Color(42, 31, 91));
        VPasswordTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VPasswordTbActionPerformed(evt);
            }
        });

        VElectionCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        VElectionCb.setForeground(new java.awt.Color(42, 31, 91));
        VElectionCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VElectionCbActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(42, 31, 91));
        jPanel5.setForeground(new java.awt.Color(199, 226, 245));
        jPanel5.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(199, 226, 245));
        jLabel11.setText("Bahria University Society Polls");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(18, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(410, 410, 410))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VGenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void displayVoters() {

        try {
            ResultSet rs = logic.getVoters();
            DefaultTableModel model = (DefaultTableModel) VotersTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("v_id"),
                    rs.getString("v_name"),
                    rs.getString("v_gen"),
                    rs.getString("v_society"),
                    rs.getString("v_election"),
                    rs.getString("v_pass")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching voters.");
        }

    }

    private void GetElectionsAndSocieties() {

        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();

            // Load elections
            rsElections = St.executeQuery("SELECT e_name FROM election_tbl");
            while (rsElections.next()) {
                VElectionCb.addItem(rsElections.getString("e_name"));
            }

            // Load societies
            rsSocieties = St.executeQuery("SELECT society_name FROM society_tbl");
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

    private void VCount() {

        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select MAx(v_id) from voter_tbl");
            Rs1.next();
            int VId = Rs1.getInt(1) + 1;
        } catch (Exception Ex) {

        }

    }

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked

        if (VNameTb.getText().isEmpty() || VPasswordTb.getText().isEmpty() || VGenderCb.getSelectedIndex() == -1 || VElectionCb.getSelectedIndex() == -1 || VSocietyCb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Missing Information!");
        } else {
            boolean success = logic.addVoter(VNameTb.getText(), VGenderCb.getSelectedItem().toString(),
                    VSocietyCb.getSelectedItem().toString(), VElectionCb.getSelectedItem().toString(), VPasswordTb.getText());

            if (success) {
                JOptionPane.showMessageDialog(this, "Voter Registered Successfully!");
                displayVoters();
            } else {
                JOptionPane.showMessageDialog(this, "Error Registering Voter!");
            }
        }

    }//GEN-LAST:event_AddBtnMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked

        if (selectedVoterId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a voter to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this voter?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        boolean success = logic.deleteVoter(selectedVoterId);
        if (success) {
            JOptionPane.showMessageDialog(this, "Voter Deleted Successfully!");
            displayVoters();
        } else {
            JOptionPane.showMessageDialog(this, "Error Deleting Voter!");
        }
        
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void VotersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VotersTableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel) VotersTable.getModel();
        int row = VotersTable.getSelectedRow();
        selectedVoterId = Integer.parseInt(model.getValueAt(row, 0).toString());
        VNameTb.setText(model.getValueAt(row, 1).toString());
        VGenderCb.setSelectedItem(model.getValueAt(row, 2).toString());
        VSocietyCb.setSelectedItem(model.getValueAt(row, 3).toString());
        VElectionCb.setSelectedItem(model.getValueAt(row, 4).toString());
        VPasswordTb.setText(model.getValueAt(row, 5).toString());
        
    }//GEN-LAST:event_VotersTableMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
        
        if (selectedVoterId == -1 ||
        VNameTb.getText().isEmpty() ||
        VGenderCb.getSelectedIndex() == -1 ||
        VSocietyCb.getSelectedIndex() == -1 ||
        VElectionCb.getSelectedIndex() == -1 ||
        VPasswordTb.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Missing Information!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to update this voter's information?",
            "Confirm Edit",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    boolean success = logic.updateVoter(
            selectedVoterId,
            VNameTb.getText(),
            VGenderCb.getSelectedItem().toString(),
            VSocietyCb.getSelectedItem().toString(),
            VElectionCb.getSelectedItem().toString(),
            VPasswordTb.getText()
    );

    if (success) {
        JOptionPane.showMessageDialog(this, "Voter Updated Successfully!");
        displayVoters();
    } else {
        JOptionPane.showMessageDialog(this, "Error Updating Voter!");
    }
    
    }//GEN-LAST:event_EditBtnMouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
