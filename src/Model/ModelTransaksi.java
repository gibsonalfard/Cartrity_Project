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
public class ModelTransaksi {

    /**
     * @param donation the donation to set
     */
    public void setDonation(Double donation) {
        this.donation = donation;
    }
    
    public Double getDonation(){
        return this.donation;
    }

    /**
     * @return the donation
     */
//    public ModelDonation getDonation() {
//        return donation;
//    }
//
//    /**
//     * @param donation the donation to set
//     */
//    public void setDonation(ModelDonation donation) {
//        this.setDonation(donation);
//    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the shipDate
     */
    public Date getShipDate() {
        return shipDate;
    }

    /**
     * @param shipDate the shipDate to set
     */
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * @return the shipMode
     */
    public ModelShipMode getShipMode() {
        return shipMode;
    }

    /**
     * @param shipMode the shipMode to set
     */
    public void setShipMode(ModelShipMode shipMode) {
        this.shipMode = shipMode;
    }

    /**
     * @return the pelanggan
     */
    public ModelPelanggan getPelanggan() {
        return pelanggan;
    }

    /**
     * @param pelanggan the pelanggan to set
     */
    public void setPelanggan(ModelPelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    /**
     * @return the postal
     */
    public ModelDaerah getPostal() {
        return postal;
    }

    /**
     * @param postal the postal to set
     */
    public void setPostal(ModelDaerah postal) {
        this.postal = postal;
    }

    /**
     * @return the product
     */
    public ModelBarang getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(ModelBarang product) {
        this.product = product;
    }

    /**
     * @return the sales
     */
    public double getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(double sales) {
        this.sales = sales;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the profit
     */
    public double getProfit() {
        return profit;
    }

    /**
     * @param profit the profit to set
     */
    public void setProfit(double profit) {
        this.profit = profit;
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
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String orderID;
    private Date orderDate;
    private Date shipDate;
    private ModelShipMode shipMode;
    private ModelPelanggan pelanggan;
    private ModelDaerah postal;
    private ModelBarang product;
    private double sales;
    private int quantity;
    private double discount;
    private double profit;
    //private ModelDonation donation;
    private Double donation;
    private double total;
}
