/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dialog;

import com.gunadarma.dao.PenggunaDao;
import com.gunadarma.entity.Pengguna;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class SignUpPenggunaDialog extends javax.swing.JDialog {

   
    private PenggunaDao penggunaDao;
    Pengguna p ;
    public SignUpPenggunaDialog() {
        setModal(true);
        initComponents();
        penggunaDao = new PenggunaDao();
        p = new Pengguna();
        setLocationRelativeTo(null);
        novalid();
    }
    
    private void novalid(){
        txtKodePengguna.setEnabled(false);
        txtNama.setEnabled(false);
        txtPassword.setEnabled(false);
        txtUsername.setEnabled(false);
        btnSimpan1.setEnabled(false);
    }
    
    private void valid(){
        txtNama.setEnabled(true);
        txtPassword.setEnabled(true);
        txtUsername.setEnabled(true);
        btnSimpan1.setEnabled(true);
    }

    private void restForm(){
        txtKodePengguna.setText("");
        txtNama.setText("");
        txtPassword.setText("");
        txtUsername.setText("");
    }
    
    private boolean validasi(){
        boolean valid = false;
        if(txtKodePengguna.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode pengguna masih kosong");
        }else if(txtNama.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "nama masih kosong");
        }else if(txtPassword.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "password masih kosong");
        }else if(txtUsername.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "username masih kosong");
        }else{
            valid = true;
        }
        return valid;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodePengguna = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSimpan1 = new javax.swing.JButton();
        btnKembaliLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Sign Up Pengguna");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Sign Up"));

        jLabel2.setText("kd-pengguna:");

        jLabel3.setText("Nama:");

        jLabel4.setText("Username:");

        jLabel5.setText("Password :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodePengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodePengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel3.add(btnNew);

        btnSimpan1.setText("Simpan");
        btnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan1);

        btnKembaliLogin.setText("Kembali Ke Login");
        btnKembaliLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliLoginActionPerformed(evt);
            }
        });
        jPanel3.add(btnKembaliLogin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        //auto kode
        String kode = penggunaDao.kodePengguna();
        txtKodePengguna.setText(kode);
        valid();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnKembaliLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliLoginActionPerformed
 
        dispose();
        LoginPenggunaDialog dialog = new LoginPenggunaDialog(null, rootPaneCheckingEnabled);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnKembaliLoginActionPerformed

    private void btnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan1ActionPerformed
        // save
        try{
            Pengguna p = new Pengguna();
            String kodepengguna = txtKodePengguna.getText();
            String nama = txtNama.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            
            p.setIdpengguna(kodepengguna);
            p.setNama(nama);
            p.setMakedate(new Date());
            p.setPassword(password);
            p.setUsername(username);
            
            penggunaDao.signUpPengguna(p);
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            novalid();
            restForm();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpan1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembaliLogin;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSimpan1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtKodePengguna;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
