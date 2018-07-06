/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelBarang;
import Model.ModelKeranjang;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gibran
 */
public class KeranjangController {
    
    private static List<ModelKeranjang> shoppingCart = new ArrayList<ModelKeranjang>();
    private static double total;
//    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    /**
     * @return the total
     */
    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public List<ModelKeranjang> getList(){
        return shoppingCart;
    }
    
    public void tambahBarang(String ID_Barang, int Jumlah) {
        boolean ketemu = false;
        int i = 0;

        try {
            BarangController bc = new BarangController();
            ModelBarang b = bc.searchObject(ID_Barang);

            if (shoppingCart.isEmpty()) {
                ModelKeranjang cart = new ModelKeranjang();

                cart.setTotal(Jumlah * b.getPrice());
                cart.setQty(Jumlah);
                cart.setBarang(b);
                this.setTotal(cart.getTotal());

                shoppingCart.add(cart);
            } else {
                while (!ketemu && i < shoppingCart.size()) {
                    if (shoppingCart.get(i).getBarang().getProductID().equals(b.getProductID())) {
                        ModelKeranjang cart = new ModelKeranjang();

                        cart.setTotal(shoppingCart.get(i).getTotal()
                                + (Jumlah * shoppingCart.get(i).getBarang().getPrice()));
                        cart.setQty(shoppingCart.get(i).getQty() + Jumlah);
                        cart.setBarang(b);
                        this.setTotal(this.getTotal() + cart.getTotal());

                        shoppingCart.set(i, cart);
                        ketemu = true;
                    }
                    i += 1;
                }

                if (!ketemu) {
                    ModelKeranjang cart = new ModelKeranjang();

                    cart.setTotal(Jumlah * b.getPrice());
                    cart.setQty(Jumlah);
                    cart.setBarang(b);
                    this.setTotal(this.getTotal() + cart.getTotal());

                    shoppingCart.add(cart);
                }
                
//                System.out.println("Total : Rp"+getTotal());
            }
        } catch (IOException ex) {
            Logger.getLogger(KeranjangController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
