/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.entity;

import java.util.Date;

/**
 *
 * @author dickajava
 */
public class Pengguna {
    
    private String idpengguna;
    private String nama;
    private Date makedate;
    
    public Pengguna(){}
    
    public Pengguna(String idpengguna, String nama, Date makedate){
        this.idpengguna = idpengguna;
        this.nama = nama;
        this.makedate = makedate;
    }
    
    public String getIdpengguna(){
        return idpengguna;
    }
    
    public void setIdpengguna(String idpengguna){
        this.idpengguna = idpengguna;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public Date getMakedate(){
        return makedate;
    }
    
    public void setMakedate(Date makedate){
        this.makedate = makedate;
    }
}
