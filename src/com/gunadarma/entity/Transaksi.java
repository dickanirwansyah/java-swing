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
    private String nama;
    private String notelp;
    private String alamat;
    private int total;
    private List<TransaksiDetil> transaksiDetils;
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama=nama;
    }
    
    public String getNotelp(){
        return notelp;
    }
    
    public void setNotelp(String notelp){
        this.notelp = notelp;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
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
