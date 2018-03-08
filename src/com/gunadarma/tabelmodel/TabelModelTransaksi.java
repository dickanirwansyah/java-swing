/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.tabelmodel;

import com.gunadarma.entity.Transaksi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dickajava
 */
public class TabelModelTransaksi extends AbstractTableModel{
    
    private List<Transaksi> listTransaksi = new ArrayList<>();
    
    public TabelModelTransaksi(){
        
    }

    @Override
    public int getRowCount() {
      return listTransaksi.size();
    }

    @Override
    public int getColumnCount() {
      return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return listTransaksi.get(rowIndex).getIdtransaksi();
          case 1 : return listTransaksi.get(rowIndex).getTanggalTransaksi();
          case 2 : return listTransaksi.get(rowIndex).getNama();
          case 3 : return listTransaksi.get(rowIndex).getNotelp();
          case 4 : return listTransaksi.get(rowIndex).getAlamat();
          case 5 : return listTransaksi.get(rowIndex).getTotal();
          default:return null;
      }
    }

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0 : return "kd-transaksi";
          case 1 : return "Tanggal";
          case 2 : return "Nama Pembeli";
          case 3 : return "Telepon";
          case 4 : return "Alamat";
          case 5 : return "Total Transaksi";
          default:return null;
      }
    }
    
    public Transaksi getTransaksi(int index){
        return listTransaksi.get(index);
    }
    
    public void setListTransaksi(List<Transaksi> lisTransaksi){
        this.listTransaksi = lisTransaksi;
        fireTableDataChanged();
    }
}
