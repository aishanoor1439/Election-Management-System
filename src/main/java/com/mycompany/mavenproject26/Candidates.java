package com.mycompany.mavenproject26;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Candidates extends javax.swing.JFrame {

    public Candidates() {
        initComponents();
        GetElectionsAndSocieties();
        DisplayCandidates();
    }

    @SuppressWarnings("unchecked")
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
                CandElectionCb.addItem(rsElections.getString("e_name"));
            }

            // Load societies
            ResultSet rsSocieties = St.executeQuery("SELECT society_name FROM society_tbl");
            while (rsSocieties.next()) {
                CandSocietyCb.addItem(rsSocieties.getString("society_name"));
            }

            rsElections.close();
            rsSocieties.close();
            St.close();
            Con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


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
        CandidateTable = new javax.swing.JTable();
        CandGenderCb = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        CandNameTb = new javax.swing.JTextField();
        CandSocietyCb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CandElectionCb = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        CandPictureLb = new javax.swing.JLabel();
        BrowseBtn = new javax.swing.JButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel2.setText("Candidates");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 133, 0));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 133, 0));
        jLabel5.setText("Gender");

        EditBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(242, 133, 0));
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

        CandidateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Gender", "Photo", "Election"
            }
        ));
        CandidateTable.setSelectionBackground(new java.awt.Color(242, 133, 0));
        CandidateTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CandidateTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CandidateTable);

        CandGenderCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        CandGenderCb.setForeground(new java.awt.Color(242, 133, 0));
        CandGenderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        CandGenderCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CandGenderCbActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 133, 0));
        jLabel6.setText("Society");

        CandNameTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CandNameTbActionPerformed(evt);
            }
        });

        CandSocietyCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        CandSocietyCb.setForeground(new java.awt.Color(242, 133, 0));
        CandSocietyCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CandSocietyCbActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 133, 0));
        jLabel7.setText("Election");

        CandElectionCb.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        CandElectionCb.setForeground(new java.awt.Color(242, 133, 0));
        CandElectionCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CandElectionCbActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 133, 0));
        jLabel8.setText("Photo");

        CandPictureLb.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        CandPictureLb.setForeground(new java.awt.Color(242, 133, 0));

        BrowseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BrowseBtn.setForeground(new java.awt.Color(242, 133, 0));
        BrowseBtn.setText("Browse");
        BrowseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BrowseBtnMouseClicked(evt);
            }
        });
        BrowseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(CandNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(CandGenderCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel6)
                            .addComponent(CandSocietyCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(CandElectionCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CandPictureLb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(AddBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EditBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BackBtn))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BrowseBtn)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel2)
                        .addGap(199, 227, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CandGenderCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CandNameTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CandSocietyCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CandElectionCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CandPictureLb, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BrowseBtn)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddBtn)
                            .addComponent(EditBtn)
                            .addComponent(DeleteBtn)
                            .addComponent(BackBtn)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void CandGenderCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CandGenderCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CandGenderCbActionPerformed

    private void CandNameTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CandNameTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CandNameTbActionPerformed

    private void CandSocietyCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CandSocietyCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CandSocietyCbActionPerformed

    private void CandElectionCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CandElectionCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CandElectionCbActionPerformed

    private void BrowseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BrowseBtnActionPerformed

    String imgpath = null;

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


    private void BrowseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BrowseBtnMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png");
        chooser.addChoosableFileFilter(filter);
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            CandPictureLb.setIcon(ResizePhoto(path, null, CandPictureLb));
            imgpath = path;
        }
    }//GEN-LAST:event_BrowseBtnMouseClicked

    private void DisplayCandidates() {
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            Ru = St.executeQuery("Select * from candidate_tbl");
            CandidateTable.setModel(DbUtils.resultSetToTableModel(Ru));
        } catch (SQLException Ex) {

        }
    }

    int CId = 0;
    Statement St1 = null;
    ResultSet Rs1 = null;

    private void CandCount() {
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("select MAx(c_id) from candidate_tbl");
            Rs1.next();
            CId = Rs1.getInt(1) + 1;
        } catch (Exception Ex) {

        }
    }

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddBtnMouseClicked
        if (CandNameTb.getText().isEmpty() || CandGenderCb.getSelectedIndex() == -1 || CandSocietyCb.getSelectedIndex() == -1 || CandElectionCb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Missing Information!");
        } else {
            try {
                CandCount();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
                InputStream img = new FileInputStream(imgpath);
                PreparedStatement Add = Con.prepareStatement("INSERT INTO candidate_tbl (c_id, c_name, c_gen, c_society, c_election, c_photo) VALUES (?, ?, ?, ?, ?, ?)");
                Add.setInt(1, CId);
                Add.setString(2, CandNameTb.getText());
                Add.setString(3, CandGenderCb.getSelectedItem().toString());
                Add.setString(4, CandSocietyCb.getSelectedItem().toString());
                Add.setString(5, CandElectionCb.getSelectedItem().toString());
                Add.setBlob(6, img);
                int row = Add.executeUpdate();
                JOptionPane.showMessageDialog(this, "Candidate Registered Successfully!");
                Con.close();
                DisplayCandidates();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_AddBtnMouseClicked

    private void FetchPhoto() {
        String Query = "Select c_photo from candidate_tbl where c_id = " + Key;
        Statement St;
        ResultSet Rs;
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
            St = Con.createStatement();
            Rs = St.executeQuery(Query);
            if (Rs.next()) {
                CandPictureLb.setIcon(ResizePhoto(null, Rs.getBytes("c_photo"), CandPictureLb));

            }
        } catch (Exception e) {

        }
    }

    int Key = -1;
    private void CandidateTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CandidateTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) CandidateTable.getModel();
        int MyIndex = CandidateTable.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        CandNameTb.setText(model.getValueAt(MyIndex, 1).toString());
        CandGenderCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        CandSocietyCb.setSelectedItem(model.getValueAt(MyIndex, 3).toString());
        CandElectionCb.setSelectedItem(model.getValueAt(MyIndex, 4).toString());
        FetchPhoto();
    }//GEN-LAST:event_CandidateTableMouseClicked

    private void DeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteBtnMouseClicked
        if (Key == -1) {
            JOptionPane.showMessageDialog(this, "Select The Candidate To Be Deleted!");
        } else {
            try {
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
                String Query = "Delete from candidate_tbl where c_id=" + Key;
                Statement Del = Con.createStatement();
                Del.executeUpdate(Query);
                JOptionPane.showMessageDialog(this, "Candidate Deleted Successfilly!");
                DisplayCandidates();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_DeleteBtnMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
        if (Key == -1 || CandNameTb.getText().isEmpty() || CandGenderCb.getSelectedIndex() == -1 || CandSocietyCb.getSelectedIndex() == -1 || CandElectionCb.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Missing Information!");
        } else if (imgpath != null) {
            try {
                InputStream img = new FileInputStream(imgpath);
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/society_polls", "root", "");
                String Query = "Update candidate_tbl set c_name=?, c_gen=?, c_photo=?, c_society=?, c_election=? where c_id=?";
                PreparedStatement UpdateQuery = Con.prepareStatement(Query);
                UpdateQuery.setString(1, CandNameTb.getText());
                UpdateQuery.setString(2, CandGenderCb.getSelectedItem().toString());
                UpdateQuery.setBlob(3, img);
                UpdateQuery.setString(4, CandSocietyCb.getSelectedItem().toString());
                UpdateQuery.setString(5, CandElectionCb.getSelectedItem().toString());
                UpdateQuery.setInt(6, Key);
                if (UpdateQuery.executeUpdate() == 1) {
                    JOptionPane.showMessageDialog(this, "Candidate Updated Successfully!");
                    DisplayCandidates();
                } else {
                    JOptionPane.showMessageDialog(this, "Missing Information");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select Photo!");
            CandPictureLb.setIcon(null);
            CandPictureLb.setText("");
        }
        imgpath = null;
    }//GEN-LAST:event_EditBtnMouseClicked

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton BrowseBtn;
    private javax.swing.JComboBox<String> CandElectionCb;
    private javax.swing.JComboBox<String> CandGenderCb;
    private javax.swing.JTextField CandNameTb;
    private javax.swing.JLabel CandPictureLb;
    private javax.swing.JComboBox<String> CandSocietyCb;
    private javax.swing.JTable CandidateTable;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
