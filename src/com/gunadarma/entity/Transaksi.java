/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class Transaksi {
    
    private String idtransaksi;
    private Date tanggalTransaksi;
    private int total;
    private List<TransaksiDetil> transaksiDetils;
    
    public String getIdtransaksi(){
        return idtransaksi;
    }
    
    public void setIdTransaksi(String idtransaksi){
        this.idtransaksi = idtransaksi;
    }
    
    public Date getTanggalTransaksi(){
        return tanggalTransaksi;
    }
    
    public void setTanggalTransaksi(Date tanggalTransaksi){
        this.tanggalTransaksi = tanggalTransaksi;
    }
    
    public int getTotal(){
        return total;
    }
    
    public void setTotal(int total){
        this.total = total;
    }
    
    public List<TransaksiDetil> getTransaksiDetils(){
        return transaksiDetils;
    }
    
    public void setTransaksiDetils(List<TransaksiDetil>transaksiDetils){
        this.transaksiDetils = transaksiDetils;
    }
}
