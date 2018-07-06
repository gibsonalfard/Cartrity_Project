/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER Z3-451
 */
public class ModelPenyimpananReport {
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    public ModelPenyimpananReport() {
        tableModel.addColumn("Order ID");
        tableModel.addColumn("Order Date");
        tableModel.addColumn("Ship Date");
        tableModel.addColumn("Ship Mode");
        tableModel.addColumn("Customer Name");
        tableModel.addColumn("Postal Code");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Discount");
        tableModel.addColumn("Profit");
        tableModel.addColumn("Donation");
        tableModel.addColumn("Total");
    }
    
    public DefaultTableModel getTable() {
        return tableModel;
    }
    
    public void setTable (DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }
}