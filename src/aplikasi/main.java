/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import Controller.BarangController;
import Controller.DaerahController;
import Controller.PelangganController;
import Controller.TransaksiController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class main {
     public static void main(String[] args) throws IOException {
         try {
             Thread.sleep(0);
         } catch (InterruptedException ex) {
             Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
         }
       new TransaksiController().getAllData();
       new PelangganController().getAllData();
       new DaerahController().getAllData();
       new BarangController().getAllData();
       Dashboard a= new Dashboard();
       a.setVisible(true);

    }
}
