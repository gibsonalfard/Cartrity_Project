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
public class ModelPelanggan {

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID the customerID to set
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the segment
     */
    public String getSegment() {
        return segment;
    }

    /**
     * @param segment the segment to set
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }
    
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String customerID;
    private String customerName;
    private String segment;
}
