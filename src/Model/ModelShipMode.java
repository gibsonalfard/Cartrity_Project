/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gibran
 */
public class ModelShipMode {

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the shipID
     */
    public String getShipID() {
        return shipID;
    }

    /**
     * @param shipID the shipID to set
     */
    public void setShipID(String shipID) {
        this.shipID = shipID;
    }

    /**
     * @return the shipMode
     */
    public String getShipMode() {
        return shipMode;
    }

    /**
     * @param shipMode the shipMode to set
     */
    public void setShipMode(String shipMode) {
        this.shipMode = shipMode;
    }
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String shipID;
    private String shipMode;
    private double price;
}
