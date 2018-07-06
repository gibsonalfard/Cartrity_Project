/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Gibran
 */
public class ModelKeranjang {

    /**
     * @return the barang
     */
    public ModelBarang getBarang() {
        return barang;
    }

    /**
     * @param barang the barang to set
     */
    public void setBarang(ModelBarang barang) {
        this.barang = barang;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    private ModelBarang barang;
    private int qty;
    private double total;
}
