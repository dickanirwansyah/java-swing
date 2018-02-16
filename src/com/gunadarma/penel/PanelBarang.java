/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.penel;

import com.gunadarma.dao.BarangDao;
import com.gunadarma.entity.Barang;
import com.gunadarma.tabelmodel.TabelModelBarang;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class PanelBarang extends javax.swing.JPanel {

    
    private BarangDao barangDao;
    private TabelModelBarang tabelModelBarang;
    
    public PanelBarang() {
        initComponents();
        barangDao = new BarangDao();
        
        //Component element swing
        txtKodeBarang.setEnabled(false);
        txtNama.setEnabled(false);
        txtHarga.setEnabled(false);
        txtJumlah.setEnabled(false);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnSimpan.setEnabled(false);
        
        
        tabelModelBarang = new TabelModelBarang();
        loadDataBarang();
    }
    
    private void loadDataBarang(){
        List<Barang> barangs = barangDao.tampilkanListBarang();
        tabelModelBarang.listBarangs(barangs);
        tabel_barang.setModel(tabelModelBarang);
        if(barangs.isEmpty()){
            JOptionPane.showMessageDialog(null, "data barang masih kosong");
        }
        System.out.println("load data dari database");
    }
    
 
    
    //validasi
    private boolean validasiInput(){
        boolean valid = false;
        if(txtKodeBarang.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf kode barang masih kosong !");
        }else if(txtNama.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf nama barang masih kosong !");
        }else if(txtJumlah.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf jumlah barang masih kosong !");
        }else if(txtHarga.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf harga barang masih kosong !");
        }else{
            valid = true;
        }
        System.out.println("Validasi input");
        return valid;
    }
    
    //valid
    private void setValid(){
        txtNama.setEnabled(true);
        txtHarga.setEnabled(true);
        txtJumlah.setEnabled(true);
        //btnEdit.setEnabled(true);
        //btnHapus.setEnabled(true);
        btnSimpan.setEnabled(true);
        System.out.println("set valid");
    }
    
    //novalid
    private void setNoValid(){
        txtNama.setEnabled(false);
        txtHarga.setEnabled(false);
        txtJumlah.setEnabled(false);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnSimpan.setEnabled(false);
        System.out.println("set no valid");
    }
    
    //reset form
    private void resetFieldForm(){
        txtHarga.setText("");
        txtNama.setText("");
        txtJumlah.setText("");
        txtKodeBarang.setText("");
        System.out.println("reset form");
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
        txtKodeBarang = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnAmbil = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Data Barang");
        jPanel1.add(jLabel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Barang"));

        jLabel2.setText("id-barang:");

        jLabel3.setText("Nama:");

        jLabel4.setText("Jumlah:");

        jLabel5.setText("Harga:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(txtNama)
                    .addComponent(txtJumlah)
                    .addComponent(txtHarga))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(tabel_barang);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel3.add(btnNew);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSimpan);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus);

        btnAmbil.setText("Ambil");
        btnAmbil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilActionPerformed(evt);
            }
        });
        jPanel3.add(btnAmbil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // auto number
        String kodebarang = barangDao.kodeBarang();
        txtKodeBarang.setText(kodebarang);
        System.out.println("kode barang auto");
        setValid();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // proses simpan
        if(validasiInput() == true){
            
            String idbarang = txtKodeBarang.getText();
            String nama = txtNama.getText();
            int jumlah = Integer.valueOf(txtJumlah.getText());
            int harga = Integer.valueOf(txtHarga.getText());
            
            Barang b = new Barang();
            b.setHarga(harga);
            b.setJumlah(jumlah);
            b.setNama(nama);
            b.setIdbarang(idbarang);
            
            barangDao.simpanBarang(b);
            tabelModelBarang.inserBarang(b);
            resetFieldForm();
            setNoValid();
            System.out.println("insert data");
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan !");
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnAmbilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilActionPerformed
        // ambil barang
        try{
            int index = tabel_barang.getSelectedRow();
            if(index!=-1){
                Barang b = tabelModelBarang.getBarangById(tabel_barang.convertColumnIndexToModel(index));
                txtHarga.setText(String.valueOf(b.getHarga()));
                txtNama.setText(String.valueOf(b.getNama()));
                txtJumlah.setText(String.valueOf(b.getJumlah()));
                txtKodeBarang.setText(String.valueOf(b.getIdbarang()));
                setValid();
                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
                btnSimpan.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "Seleksi salah satu baris !");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAmbilActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // update proses
        int index = tabel_barang.getSelectedRow();
        if(index!=-1){
            Barang b = tabelModelBarang.getBarangById(tabel_barang.convertColumnIndexToModel(index));
            if(validasiInput()== true){
                String idbarang = txtKodeBarang.getText();
                String nama = txtNama.getText();
                int jumlah = Integer.valueOf(txtJumlah.getText());
                int harga = Integer.valueOf(txtHarga.getText());
                
                b.setIdbarang(idbarang);
                b.setNama(nama);
                b.setJumlah(jumlah);
                b.setHarga(harga);
                
                barangDao.updateBarang(b);
                tabelModelBarang.updateBarang(index, b);
                JOptionPane.showMessageDialog(null, "data berhasil di edit !");
                setNoValid();
                System.out.println("data berhasil di update");
                resetFieldForm();
            }
        }else{
            JOptionPane.showMessageDialog(null, "ambil data terlebih dahulu");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // hapus barang
       try{
           int index=tabel_barang.getSelectedRow();
           Barang b = tabelModelBarang.getBarangById(tabel_barang.convertColumnIndexToModel(index));
           if(JOptionPane.showConfirmDialog(null, "yakin ingin hapus data ini?", null,
                   JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
               barangDao.deleteBarang(b);
               tabelModelBarang.deleteBarang(index);
               setNoValid();
               System.out.println("data berhasil dihapus");
               resetFieldForm();
               JOptionPane.showMessageDialog(null, "data berhasil dihapus !");
           }else{
               JOptionPane.showMessageDialog(null, "seleksi salah satu baris ");
           }
       }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_btnHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmbil;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
