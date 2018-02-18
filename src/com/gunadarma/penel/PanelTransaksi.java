/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.penel;

import com.gunadarma.dao.TransaksiDao;
import com.gunadarma.entity.LaporanTransaksi;
import com.gunadarma.entity.Transaksi;
import com.gunadarma.laporan.TampilkanLaporan;
import com.gunadarma.tabelmodel.TabelModelTransaksi;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author dickajava
 */
public class PanelTransaksi extends javax.swing.JPanel {

    private TransaksiDao transaksiDao;
    private TabelModelTransaksi tabelModelTransaksi;
    public PanelTransaksi() {
        initComponents();
        tabelModelTransaksi = new TabelModelTransaksi();
        transaksiDao = new TransaksiDao();
        txtKodeFaktur.setEnabled(false);
        loadData();
    }
    
    private void loadData(){
        List<Transaksi> transaksis = transaksiDao.dataTransaksi();
        tabelModelTransaksi.setListTransaksi(transaksis);
        tabel_transaksi.setModel(tabelModelTransaksi);
    }

    
    private boolean validasi(){
        boolean valid = false;
        if(txtKodeFaktur.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf kode faktur belum dipilih !");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAmbilFaktur = new javax.swing.JButton();
        btnCetakFaktur = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKodeFaktur = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Data Transaksi");
        jPanel1.add(jLabel1);

        jScrollPane1.setViewportView(tabel_transaksi);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAmbilFaktur.setText("Ambil No.Faktur");
        btnAmbilFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilFakturActionPerformed(evt);
            }
        });
        jPanel2.add(btnAmbilFaktur);

        btnCetakFaktur.setText("Cetak Faktur");
        btnCetakFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakFakturActionPerformed(evt);
            }
        });
        jPanel2.add(btnCetakFaktur);

        btnKembali.setText("Kembali");
        jPanel2.add(btnKembali);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Faktur"));

        jLabel2.setText("No.Faktur :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKodeFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKodeFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAmbilFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilFakturActionPerformed
        // ambil faktur
        try{
            
            int index = tabel_transaksi.getSelectedRow();
            if(index!=-1){
                Transaksi t = tabelModelTransaksi.getTransaksi(tabel_transaksi.convertRowIndexToModel(index));
                txtKodeFaktur.setText(t.getIdtransaksi());
            }else{
                JOptionPane.showMessageDialog(null, "Maaf pilih salah satu");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAmbilFakturActionPerformed

    private void btnCetakFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakFakturActionPerformed
        //cetak faktur
        try{
            if(validasi()==true){
             String kodeTransaksi = txtKodeFaktur.getText();
            List<LaporanTransaksi> listReportBerdasarkanById = transaksiDao.getLaporanTransaksiById(kodeTransaksi);
            
            //get jasper
            JasperPrint jp = JasperFillManager.fillReport(this.getClass()
                    .getClassLoader().getResourceAsStream("com/gunadarma/laporan/LaporanTransaksi.jasper"), null, 
                    new JRBeanCollectionDataSource(listReportBerdasarkanById));
            JRViewer jrv = new JRViewer(jp);
            JOptionPane.showMessageDialog(null, "Data berhasil dicetak !");
            txtKodeFaktur.setText("");
            TampilkanLaporan laporan = new TampilkanLaporan(jrv, "Laporan Berdasarkan Kode");   
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCetakFakturActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmbilFaktur;
    private javax.swing.JButton btnCetakFaktur;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JTextField txtKodeFaktur;
    // End of variables declaration//GEN-END:variables
}
