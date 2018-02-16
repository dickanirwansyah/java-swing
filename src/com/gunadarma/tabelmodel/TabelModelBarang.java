/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.tabelmodel;

import com.gunadarma.entity.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dickajava
 */
public class TabelModelBarang extends AbstractTableModel{
    
    private List<Barang> listbarang = new ArrayList<Barang>();
    public TabelModelBarang(){
        
    }

    @Override
    public int getRowCount() {
     return listbarang.size();
    }

    @Override
    public int getColumnCount() {
      return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return listbarang.get(rowIndex).getIdbarang();
          case 1 : return listbarang.get(rowIndex).getNama();
          case 2 : return listbarang.get(rowIndex).getJumlah();
          case 3 : return listbarang.get(rowIndex).getHarga();
          default:return null;
      }
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0 : return "Kd-barang";
           case 1 : return "Nama";
           case 2 : return "Jumlah";
           case 3 : return "Harga";
           default:return null;
       }
    }
    
    public void inserBarang(Barang barang){
        this.listbarang.add(barang);
        fireTableDataChanged();
    }
    
    public void updateBarang(int index, Barang barang){
        this.listbarang.set(index, barang);
        fireTableDataChanged();
    }
    
    public void deleteBarang(int index){
        this.listbarang.remove(index);
        fireTableDataChanged();
    }
    
    public void listBarangs(List<Barang> listbarang){
        this.listbarang = listbarang;
        fireTableDataChanged();
    }
    
    public Barang getBarangById(int index){
        return listbarang.get(index);
    }
}
