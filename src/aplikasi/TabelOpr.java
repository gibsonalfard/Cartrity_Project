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
import Model.ModelBarang;
import Model.ModelDaerah;
import Model.ModelPelanggan;
import Model.ModelTransaksi;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asus
 */
public class TabelOpr {
    
    private static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    DefaultTableModel A;
    JTextField dataType,type,size;
    
    public void selectRow(int rowIndex, JTextField f1, JTextField f2, JTextField f3){
        try{
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);
         
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateRow(int rowIndex,String dataType, String type, int size){
        try{
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Cell cell = null;
            
            cell = sheet.getRow(rowIndex).getCell(1);
            cell.setCellValue(dataType);
            cell = sheet.getRow(rowIndex).getCell(2);
            cell.setCellValue(type);
            cell = sheet.getRow(rowIndex).getCell(3);
            cell.setCellValue(size);
            
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteRow(int rowIndex){
        try{
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            
            int lastRowNum=sheet.getLastRowNum();
            
            if(rowIndex>=0&&rowIndex<lastRowNum){
                sheet.shiftRows(rowIndex+1,lastRowNum, -1);
            }
            if(rowIndex==lastRowNum){
                Row removingRow=sheet.getRow(rowIndex);
                if(removingRow!=null){
                    sheet.removeRow(removingRow);
                }
            }
            
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addRow(String dataType, String type, int size){
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            
            int rowNum = 0;

            while (iterator.hasNext()) {
                    rowNum++;
                    Row currentRow = iterator.next();
            }
            
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(1);
            cell.setCellValue(dataType);
            cell = row.createCell(2);
            cell.setCellValue(type);
            cell = row.createCell(3);
            cell.setCellValue(size);
            
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabelOpr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showTable(JTable table1, Object[] isi, int sheet){
        
//        A = new DefaultTableModel(null,isi);
//        table1.setModel(A);

        try {
        
            switch(sheet){
                case 1:
                    Object[] isi1 = {"Postal Code","Region","Country","City","State"};
                    A = new DefaultTableModel(null,isi1);
                    table1.setModel(A);
                    List<ModelDaerah> lis1 = new DaerahController().getList();
                    Iterator<ModelDaerah> iterator1 = lis1.iterator();
                        while (iterator1.hasNext()) 
                        {
                            ModelDaerah hsl = iterator1.next();
                            isi1[0] = hsl.getPostalCode();
                            isi1[1] = hsl.getRegion();
                            isi1[2] = hsl.getCountry();
                            isi1[3] = hsl.getCity();
                            isi1[4] = hsl.getState();
                            A.addRow(isi1);
                        }
                        break;
                
                case 2: Object[] isi2 = {"Customer ID","Name","Segment"};
                        A = new DefaultTableModel(null,isi2);
                        table1.setModel(A);
                        List<ModelPelanggan> lis2 = new PelangganController().getList();
                        Iterator<ModelPelanggan> iterator2 = lis2.iterator();
                        while (iterator2.hasNext()) 
                        {
                            ModelPelanggan hsl = iterator2.next();
                            isi2[0] = hsl.getCustomerID();
                            isi2[1] = hsl.getCustomerName();
                            isi2[2] = hsl.getSegment();
                            A.addRow(isi2);
                        }
                        break;
                        
                case 3: Object[] isi3 = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"};
                        A = new DefaultTableModel(null,isi3);
                        table1.setModel(A);
                        List<ModelTransaksi> lis3 = new TransaksiController().getList();
                        Iterator<ModelTransaksi> iterator3 = lis3.iterator();
                        while (iterator3.hasNext()) 
                        {
                            ModelTransaksi hsl = iterator3.next();
                            isi3[0] = hsl.getOrderID();
                            isi3[1] = hsl.getOrderDate();
                            isi3[2] = hsl.getShipDate();
                            isi3[3] = hsl.getShipMode().getShipMode();
                            isi3[4] = hsl.getPelanggan().getCustomerID();
                            isi3[5] = hsl.getPostal().getPostalCode();
                            isi3[6] = hsl.getProduct().getProductID();
                            isi3[7] = hsl.getSales();
                            isi3[8] = hsl.getQuantity();
                            isi3[9] = hsl.getDiscount();
                            isi3[10] = hsl.getProfit();
                            isi3[11] = hsl.getDonation();
                            isi3[12] = hsl.getTotal();
                            A.addRow(isi3);
                        }
                        break;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void search(JTable table1, int sheet, int cell, String searched) throws IOException{
//        Object[] isi = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit"};
        
        try {
        
            switch(sheet){
                case 1: Object[] isi1 = {"Postal Code","Region","Country","City","State"};
                        A = new DefaultTableModel(null,isi1);
                        table1.setModel(A);
                        List<ModelDaerah> lis1 = new DaerahController().getList();
                        Iterator<ModelDaerah> iterator1 = lis1.iterator();
                        while (iterator1.hasNext()) 
                        {
                            ModelDaerah hsl = iterator1.next();
                            isi1[0] = hsl.getPostalCode();
                            isi1[1] = hsl.getRegion();
                            isi1[2] = hsl.getCountry();
                            isi1[3] = hsl.getCity();
                            isi1[4] = hsl.getState();
                            if(isi1[cell].toString().contains(searched) ){
                                A.addRow(isi1);
                            }
                        }
                        break;
                
                case 2: Object[] isi2 = {"Customer ID","Name","Segment"};
                        A = new DefaultTableModel(null,isi2);
                        table1.setModel(A);
                        List<ModelPelanggan> lis2 = new PelangganController().getList();
                        Iterator<ModelPelanggan> iterator2 = lis2.iterator();
                        while (iterator2.hasNext()) 
                        {
                            ModelPelanggan hsl = iterator2.next();
                            isi2[0] = hsl.getCustomerID();
                            isi2[1] = hsl.getCustomerName();
                            isi2[2] = hsl.getSegment();
                            if(isi2[cell].toString().contains(searched) ){
                                A.addRow(isi2);
                            }
                        }
                        break;
                        
                case 3: Object[] isi3 = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"};
                        A = new DefaultTableModel(null,isi3);
                        table1.setModel(A);
                        List<ModelTransaksi> lis3 = new TransaksiController().getList();
                        Iterator<ModelTransaksi> iterator3 = lis3.iterator();
                        while (iterator3.hasNext()) 
                        {
                            ModelTransaksi hsl = iterator3.next();
                            isi3[0] = hsl.getOrderID();
                            isi3[1] = hsl.getOrderDate();
                            isi3[2] = hsl.getShipDate();
                            isi3[3] = hsl.getShipMode().getShipMode();
                            isi3[4] = hsl.getPelanggan().getCustomerID();
                            isi3[5] = hsl.getPostal().getPostalCode();
                            isi3[6] = hsl.getProduct().getProductID();
                            isi3[7] = hsl.getSales();
                            isi3[8] = hsl.getQuantity();
                            isi3[9] = hsl.getDiscount();
                            isi3[10] = hsl.getProfit();
                            isi3[11] = hsl.getDonation();
                            isi3[12] = hsl.getTotal();
                            if(isi3[cell].toString().contains(searched) ){
                                A.addRow(isi3);
                            }
                        }
                        break;
                 
                case 4: Object[] isi4 = {"Product ID","Category","Sub-Category","Product Name","Product Price"};
                        A = new DefaultTableModel(null,isi4);
                        table1.setModel(A);
                        List<ModelBarang> lis4 = new BarangController().getList();
                        Iterator<ModelBarang> iterator4 = lis4.iterator();
                        DecimalFormat decimalFormat = new DecimalFormat("#.00");
                        while (iterator4.hasNext()) 
                        {
                            ModelBarang hsl = iterator4.next();
                            isi4[0] = hsl.getProductID();
                            isi4[1] = hsl.getSubcategory().getKategori().getKategori();
                            isi4[2] = hsl.getSubcategory().getSubKategori();
                            isi4[3] = hsl.getProductName();
                            isi4[4] = "$" + decimalFormat.format(hsl.getPrice());
                            if(isi4[cell].toString().contains(searched) ){
                                A.addRow(isi4);
                            }
                        }
                        break;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void FilterTransaksi(JTable table1, Object[] isi, int awal, int akhir, String ShipMode, int donationMin, int donationMax, int totalMin, int totalMax) throws IOException, ParseException {
        //isi = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"};
        
        isi[0] = "Order ID";
        isi[1] = "Order Date";
        isi[2] = "Ship Date";
        isi[3] = "Ship Mode";
        isi[4] = "Customer ID";
        isi[5] = "Postal Code";
        isi[6] = "Product ID";
        isi[7] = "Sales";
        isi[8] = "Quantity";
        isi[9] = "Discount";
        isi[10] = "Profit";
        isi[11] = "Donation";
        isi[12] = "Total";
            
        boolean add;
        int compareTanggal;
        int compareDonasi;
        double total;
        double donation;
        String cmpShip = null;
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        
        A = new DefaultTableModel(null,isi);
        table1.setModel(A);
        
        List<ModelTransaksi> list = new TransaksiController().getList();
        Iterator<ModelTransaksi> iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            add = true;
            
            ModelTransaksi hsl = iterator.next();
            isi[0] = hsl.getOrderID();
            isi[1] = hsl.getOrderDate();
            isi[2] = hsl.getShipDate();
            isi[3] = hsl.getShipMode().getShipMode();
            isi[4] = hsl.getPelanggan().getCustomerID();
            isi[5] = hsl.getPostal().getPostalCode();
            isi[6] = hsl.getProduct().getProductID();
            isi[7] = (double) hsl.getSales();
            isi[8] = hsl.getQuantity();
            isi[9] = (double) hsl.getDiscount();
            isi[10] = hsl.getProfit();
            isi[11] = hsl.getDonation() != null? (double) hsl.getDonation() : (double) 0;
            isi[12] = (int) isi[8] * (double) isi[7] - ((int) isi[8] * (double) isi[7] * (double) isi[9]) + (double) isi[11];
            
            
            if(awal != 0) {
                compareTanggal = Integer.parseInt(dt1.format(isi[1]));
                if(compareTanggal < awal) {
                    add = false;
                }
            }

            if(akhir != 0) {
                compareTanggal = Integer.parseInt(dt1.format(isi[1]));
                if(compareTanggal > akhir) {
                    add = false;
                }
            }
            
            if(ShipMode != null) {
                cmpShip = (String) isi[3];
                if(!cmpShip.equals(ShipMode)) {
                    add = false;
                }
            }
            
            if(donationMin != -1) {
                donation = (double) isi[11];
                if(donation < donationMin) {
                    add = false;
                }
            }
            
            if(donationMax != -1) {
                donation = (double) isi[11];
                if(donation > donationMax) {
                    add = false;
                }
            }
            
            if(totalMin != -1) {
                total = (double) isi[12];
                if(total < totalMin) {
                    add = false;
                }
            }
            
            if(totalMax != -1) {
                total = (double) isi[12];
                if(total > totalMax) {
                    add = false;
                }
            }
            
            if(add) {
                A.addRow(isi);
            }
        }
    }

    public void FilterBarang(JTable table1, Object[] isi, String kategori, String subKategori) throws IOException {
        //isi = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"};
        
        isi[0] = "Product ID";
        isi[1] = "Category";
        isi[2] = "Sub-Category";
        isi[3] = "Product Name";
            
        boolean add;
        
        
        A = new DefaultTableModel(null,isi);
        table1.setModel(A);
        
        List<ModelBarang> list = new BarangController().getList();
        Iterator<ModelBarang> iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            add = true;
            
            ModelBarang hsl = iterator.next();
            isi[0] = hsl.getProductID();
            isi[1] = hsl.getSubcategory().getKategori().getKategori();
            isi[2] = hsl.getSubcategory().getSubKategori();
            isi[3] = hsl.getProductName();
            
            if(kategori != null) {
                if(!isi[1].equals(kategori)) {
                    add = false;
                }
            }
            
            if(subKategori != null) {
                if(!isi[2].equals(subKategori)) {
                    add = false;
                }
            }
            
            if(add) {
                A.addRow(isi);
            }
        }
    }
    
    public void FilterPelanggan(JTable table1, Object[] isi, String segment) throws IOException {
        //isi = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"};
        
        isi[0] = "Customer ID";
        isi[1] = "Name";
        isi[2] = "Segment";
            
        boolean add;
        
        A = new DefaultTableModel(null,isi);
        table1.setModel(A);
        
        List<ModelPelanggan> list = new PelangganController().getList();
        Iterator<ModelPelanggan> iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            add = true;
            
            ModelPelanggan hsl = iterator.next();
            isi[0] = hsl.getCustomerID();
            isi[1] = hsl.getCustomerName();
            isi[2] = hsl.getSegment();
            
            if(segment != null) {
                if(!isi[2].equals(segment)) {
                    add = false;
                }
            }
            
            if(add) {
                A.addRow(isi);
            }
        }
    }
    
    public void FilterLokasi(JTable table1, Object[] isi, String region, String city) throws IOException {
        //isi = {"Order ID","Order Date","Ship Date","Ship Mode","Customer ID","Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"};
        
        isi[0] = "Customer ID";
        isi[1] = "Name";
        isi[2] = "Segment";
            
        boolean add;
        
        A = new DefaultTableModel(null,isi);
        table1.setModel(A);
        
        List<ModelDaerah> list = new DaerahController().getList();
        Iterator<ModelDaerah> iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            add = true;
            
            ModelDaerah hsl = iterator.next();
            isi[0] = hsl.getPostalCode();
            isi[1] = hsl.getRegion();
            isi[2] = hsl.getCountry();
            isi[3] = hsl.getCity();
            isi[4] = hsl.getState();
            
            if(region != null) {
                if(!isi[1].equals(region)) {
                    add = false;
                }
            }
            
            if(city != null) {
                if(!isi[3].equals(city)) {
                    add = false;
                }
            }
            
            if(add) {
                A.addRow(isi);
            }
        }
    }
}