/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.repository;

import com.gunadarma.entity.PilihBarang;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface RepositoryPilihBarang {
    
    List<PilihBarang> tampilkanBarang();
    
    //mengurangi jumlah stock barang
    void kurangJumlahStokBarang(int jumlah, PilihBarang barang);
}
