/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.tabelmodel;

import com.gunadarma.entity.PilihBarang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dickajava
 */
public class TabelModelPilihBarang extends AbstractTableModel{
    
    public TabelModelPilihBarang(){
        
    }
    private List<PilihBarang> pilihBarangs = new ArrayList<PilihBarang>();

    @Override
    public int getRowCount() {
       return pilihBarangs.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      switch(columnIndex){
          case 0 : return pilihBarangs.get(rowIndex).getIdbarang();
          case 1 : return pilihBarangs.get(rowIndex).getNama();
          case 2 : return pilihBarangs.get(rowIndex).getJumlah();
          case 3 : return pilihBarangs.get(rowIndex).getHarga();
          case 4 : return pilihBarangs.get(rowIndex).isPilih();
          default:return null;
      }
    }

    @Override
    public String getColumnName(int column) {
      switch(column){
          case 0 : return "idbarang";
          case 1 : return "nama";
          case 2 : return "jumlah";
          case 3 : return "harga";
          case 4 : return "#";
          default:return null;
      }
    }
    
    public void listPilihBarang(List<PilihBarang> pilihBarangs){
        this.pilihBarangs = pilihBarangs;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      if(columnIndex == 4){
          return Boolean.class;
      }else{
          return super.getColumnClass(columnIndex);
      }
      
    }
   
    public PilihBarang getPilihBarang(int index){
        return pilihBarangs.get(index);
    }
    
    public boolean pilihBarangCekbox(boolean cek){
        return pilihBarangs.equals(cek);
    }
    
    
    public List<PilihBarang> getPilihBarangCek(){
        List ls=new ArrayList();
        for(PilihBarang pb : pilihBarangs){
            if(pb.isPilih()){
                ls.add(pb);
            }
        }
        return ls;
    }
    
   
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue!=null && aValue instanceof Boolean && columnIndex == 4){
            Boolean pilih = (Boolean) aValue;
            pilihBarangs.get(rowIndex).setPilih(pilih);
        }
    }
   
}
