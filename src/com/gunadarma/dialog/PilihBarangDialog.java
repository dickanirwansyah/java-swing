/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dialog;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.dao.PilihBarangDao;
import com.gunadarma.entity.PilihBarang;
import com.gunadarma.tabelmodel.TabelModelPilihBarang;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class PilihBarangDialog extends javax.swing.JDialog {

    private Connection connection;
    private PilihBarang pb;
    private PilihBarangDao pilihBarangDao;
    private TabelModelPilihBarang tabelModelPilihBarang;
    
    public PilihBarangDialog() {
        initComponents();
        connection = DBConnection.getConnection();
        tabelModelPilihBarang = new TabelModelPilihBarang();
        pilihBarangDao = new PilihBarangDao();
        loadData();
    }

    private void loadData(){
        List<PilihBarang> pilihbarang = pilihBarangDao.tampilkanBarang();
        tabelModelPilihBarang.listPilihBarang(pilihbarang);
        tabel_pilih_barang.setModel(tabelModelPilihBarang);
        if(pilihbarang.isEmpty()){
            JOptionPane.showMessageDialog(null, "data barang tidak ada harap diisi dulu !");
        }
    }
   
    public PilihBarang ambilBarang(){
        setVisible(true);
        setLocationRelativeTo(null);
        return pb;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnPilih = new javax.swing.JButton();
        btnBatalkan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pilih_barang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Pilih Barang");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });
        jPanel2.add(btnPilih);

        btnBatalkan.setText("Batalkan");
        btnBatalkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalkanActionPerformed(evt);
            }
        });
        jPanel2.add(btnBatalkan);

        jScrollPane1.setViewportView(tabel_pilih_barang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // pilih barang
        try{
            int index = tabel_pilih_barang.getSelectedRow();
            if(index!=-1){
                pb = tabelModelPilihBarang.getPilihBarang(tabel_pilih_barang.convertRowIndexToModel(index));
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "barang belum dipilih !");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnBatalkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalkanActionPerformed
        // batalkan
        dispose();
    }//GEN-LAST:event_btnBatalkanActionPerformed

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatalkan;
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_pilih_barang;
    // End of variables declaration//GEN-END:variables
}
