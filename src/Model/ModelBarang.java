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
public class ModelBarang {

    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the subcategory
     */
    public ModelSubKategori getSubcategory() {
        return subcategory;
    }

    /**
     * @param subcategory the subcategory to set
     */
    public void setSubcategory(ModelSubKategori subcategory) {
        this.subcategory = subcategory;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

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
     * @return the imageSource
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * @param imageSource the imageSource to set
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
    
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String productID;
    private ModelSubKategori subcategory;
    private String productName;
    private double price;
    private String imageSource;
}
