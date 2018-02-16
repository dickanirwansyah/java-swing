/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.repository;

import com.gunadarma.entity.Barang;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface RepositoryBarang {
    
    List<Barang> tampilkanListBarang();
    
    boolean simpanBarang(Barang barang);
    
    boolean updateBarang(Barang barang);
    
    boolean deleteBarang(Barang barang);
    
    Barang cariBarangById(String idbarang);
    
    String kodeBarang();
    
    
}
