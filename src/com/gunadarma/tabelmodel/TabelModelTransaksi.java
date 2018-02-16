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
      return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return listTransaksi.get(rowIndex).getIdtransaksi();
          case 1 : return listTransaksi.get(rowIndex).getTanggalTransaksi();
          case 2 : return listTransaksi.get(rowIndex).getTotal();
          default:return null;
      }
    }

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0: return "kdtransaksi";
          case 1: return "tanggal";
          case 2: return "total transaksi";
          default:return null;
      }
    }
    
    public void setListTransaksi(List<Transaksi> lisTransaksi){
        this.listTransaksi = lisTransaksi;
        fireTableDataChanged();
    }
}