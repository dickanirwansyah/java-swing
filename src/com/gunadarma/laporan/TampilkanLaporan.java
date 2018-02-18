/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.laporan;

import javax.swing.JDialog;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author dickajava
 */
public class TampilkanLaporan extends JDialog{
    
    private final JRViewer jRViewer;
    
    private final String title;
    
    public TampilkanLaporan(JRViewer jRViewer, String title){
        this.jRViewer = jRViewer;
        this.title = title;
        loadSetting();
    }
    
    private void loadSetting(){
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle(title);
        getContentPane().add(jRViewer);
        setVisible(true);
    }
}
