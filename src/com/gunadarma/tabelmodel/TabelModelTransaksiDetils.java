/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.tabelmodel;

import com.gunadarma.entity.TransaksiDetil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dickajava
 */
public class TabelModelTransaksiDetils extends AbstractTableModel{
    
    private List<TransaksiDetil> transaksiDetils = new ArrayList<TransaksiDetil>();
    public TabelModelTransaksiDetils(){
        
    }

    @Override
    public int getRowCount() {
      return transaksiDetils.size();
    }

    @Override
    public int getColumnCount() {
      return 3;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
  

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return transaksiDetils.get(rowIndex).getBarang();
          case 1 : return transaksiDetils.get(rowIndex).getJumlah();
          case 2 : return transaksiDetils.get(rowIndex).getHarga();
          default:return null;
      }
    }
    

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0 : return "Nama Barang";
          case 1 : return "Jumlah Beli";
          case 2 : return "Harga per-unit";
          default:return null;
      }
    }
   
    public void insertTransaksiDetiles(TransaksiDetil transaksiDetil){
        this.transaksiDetils.add(transaksiDetil);
        fireTableDataChanged();
    }
    
    public TransaksiDetil getTransaksiDetils(int index){
        return transaksiDetils.get(index);
    }
   
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 1 : return Integer.class;
            default:return Object.class;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     if(aValue!=null && aValue instanceof Integer&&columnIndex==1){
         int jumlah=(int) aValue;
         transaksiDetils.get(rowIndex).setJumlah(jumlah);
     }
    }
    
    public void clear(){
        transaksiDetils.clear();
        fireTableDataChanged();
    }
 
    
    
}
