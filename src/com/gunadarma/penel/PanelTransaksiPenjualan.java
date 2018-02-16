/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.penel;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.dao.TransaksiDao;
import com.gunadarma.dialog.PilihBarangDialog;
import com.gunadarma.entity.PilihBarang;
import com.gunadarma.entity.TransaksiDetil;
import com.gunadarma.tabelmodel.TabelModelTransaksiDetils;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author dickajava
 */
public class PanelTransaksiPenjualan extends javax.swing.JPanel {

   
    private TabelModelTransaksiDetils tabelModelTransaksiDetils;
    private Date tanggalSekarang;
    private TransaksiDao transaksiDao;
    private PilihBarang pilihBarang;
    List<TransaksiDetil> transaksiDetils = new ArrayList<>();
    
    public PanelTransaksiPenjualan() {
        initComponents();
       transaksiDao = new TransaksiDao();
       tabelModelTransaksiDetils = new TabelModelTransaksiDetils();
       pilihBarang = new PilihBarang();
       txtKodePenjualan.setEnabled(false);
       txtTanggal.setEnabled(false);
       txtTotal.setEnabled(false);
       tanggalSekarang = new Date();
       btnSimpanPenjualan.setEnabled(false);
       btnCetakFakturPenjualan.setEnabled(false);
       btnCariBarang.setEnabled(false);
       txtTanggal.setDate(tanggalSekarang);
       loadTransaksiDetils();
    }

    
    //load transaksiDetils
    private void loadTransaksiDetils(){
        tabel_trandetil.setModel(tabelModelTransaksiDetils);
    }
    
    //validasi 
    private boolean validasiInput(){
        boolean valid = false;
        if(txtKodePenjualan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "kode transaksi masih kosong !");
        }else if(txtTanggal.getDate() == null){
            JOptionPane.showMessageDialog(null, "tanggal masih kosong !");
        }else if(txtTotal.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "total masih kosong !");
        }else if(tabel_trandetil.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "transaksi masih kosong !");
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
        txtKodePenjualan = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_trandetil = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnCariBarang = new javax.swing.JButton();
        btnSimpanPenjualan = new javax.swing.JButton();
        btnCetakFakturPenjualan = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("View Penjualan");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Transaksi Penjualan Form"));

        jLabel2.setText("kd-penjualan/faktur:");

        jLabel3.setText("Tanggal Penjualan:");

        jLabel4.setText("Total Keseluruhan :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKodePenjualan)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(txtTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodePenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jScrollPane1.setViewportView(tabel_trandetil);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel3.add(btnNew);

        btnCariBarang.setText("Cari Barang");
        btnCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariBarangActionPerformed(evt);
            }
        });
        jPanel3.add(btnCariBarang);

        btnSimpanPenjualan.setText("Simpan Penjualan");
        jPanel3.add(btnSimpanPenjualan);

        btnCetakFakturPenjualan.setText("Cetak Faktur Penjualan");
        jPanel3.add(btnCetakFakturPenjualan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariBarangActionPerformed
        //cari barang
        boolean valid = false;
        PilihBarangDialog dialog = new PilihBarangDialog();
        pilihBarang = dialog.ambilBarang();
        if(pilihBarang != null){
            List<PilihBarang> barangpilih = dialog.tabelModelPilihBarang.getPilihBarangCek();
            for(PilihBarang pb : barangpilih){
                TransaksiDetil detil = new TransaksiDetil();
                detil.setBarang(pb);
                detil.setJumlah(0);
                detil.setHarga(pb.getHarga());
                
                for(int i=0; i<tabel_trandetil.getRowCount(); i++){
                    TransaksiDetil td = tabelModelTransaksiDetils.getTransaksiDetils(i);
                    if(td.getBarang().getNama().equals(detil.getBarang().getNama())){
                        valid = true;
                    }
                }
                if(valid == false){
                    tabelModelTransaksiDetils.insertTransaksiDetiles(detil);
                    if(transaksiDetils != null){
                        btnSimpanPenjualan.setEnabled(true);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "maaf nama barang sudah ada");
                }
            }
        }
    }//GEN-LAST:event_btnCariBarangActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        //auto number
        String kode = transaksiDao.kodeTransaksi();
        txtKodePenjualan.setText(kode);
        btnCariBarang.setEnabled(true);
    }//GEN-LAST:event_btnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCariBarang;
    private javax.swing.JButton btnCetakFakturPenjualan;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSimpanPenjualan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_trandetil;
    private javax.swing.JTextField txtKodePenjualan;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
