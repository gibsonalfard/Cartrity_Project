/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelKategori;
import Model.ModelTransaksi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Gibran
 */
public class TransaksiController extends ModelTransaksi{
    static List<ModelTransaksi> list = new ArrayList<>();
    
    public void getAllData() throws IOException{
        //this.list = new ArrayList<>();
        BarangController brg = new BarangController();
        ShipController sh = new ShipController();
        PelangganController cus = new PelangganController();
        DaerahController loc = new DaerahController();
        DonationController don = new DonationController();
        
        int i;
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(3);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                
                Cell ordID = currentRow.getCell(1);
                Cell ordDate = currentRow.getCell(2);
                Cell shipDate = currentRow.getCell(3);
                Cell smode = currentRow.getCell(4);
                Cell cusID = currentRow.getCell(5);
                Cell pos = currentRow.getCell(6);
                Cell product = currentRow.getCell(7);
                Cell harga = currentRow.getCell(8);
                Cell qty = currentRow.getCell(9);
                Cell dic = currentRow.getCell(10);
                Cell profit = currentRow.getCell(11);
                Cell donID = currentRow.getCell(12);
                Cell tot = currentRow.getCell(13);
                
                ModelTransaksi trs = new ModelTransaksi();
                trs.setOrderID(ordID.getStringCellValue());
                trs.setOrderDate(ordDate.getDateCellValue());
                trs.setShipDate(shipDate.getDateCellValue());
                trs.setShipMode(sh.searchObject(smode.toString()));
                trs.setPelanggan(cus.searchObject(cusID.toString()));
                
                String id = pos.toString();
                int x = (int) Double.parseDouble(id);
                id = String.valueOf(x);
                
                trs.setPostal(loc.searchObject(id));
                trs.setProduct(brg.searchObject(product.toString()));
                trs.setSales(harga.getNumericCellValue());
                trs.setQuantity((int) qty.getNumericCellValue());
                trs.setDiscount(dic.getNumericCellValue());
                trs.setProfit(profit.getNumericCellValue());
                if(donID != null){
                    trs.setDonation(donID.getNumericCellValue());
                } else {
                    trs.setDonation(0.0);
                }
                trs.setTotal(tot.getNumericCellValue());
                
                this.list.add(trs);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ModelTransaksi> getList() throws IOException{
        if(this.list.isEmpty()){
            getAllData();
        }
        return this.list;
    }
    
    public ModelTransaksi searchObject(String id, String produkName) throws IOException{
        ModelTransaksi trs = new ModelTransaksi();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getOrderID();
            String Name = list.get(i).getProduct().getProductName();

            trs = list.get(i);

            if(ID.equals(id) && Name.equals(produkName)){
                ketemu = true;
            }

            i += 1;
        
        }
        
        return trs;
    }
    
    public int searchObjectIndex(String id, String produkName) throws IOException{
        
        if(this.list.isEmpty()){
            getAllData();
        }
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getOrderID();
            String Name = list.get(i).getProduct().getProductName();

            if(ID.equals(id) && Name.equals(produkName)){
                ketemu = true;
            }

            i += 1;
        
        }
        
        if(ketemu){
            return (i-1);
        }else{
            return -1;
        }
    }
    
    public void edit(String orderID, String Proname, ModelTransaksi newList) {
        try {
            int index = searchObjectIndex(orderID, Proname);
            System.out.println("index = "+index);
            editListatIndex(index, newList);
            editExcel(index, newList);
        } catch (IOException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editExcel(int index, ModelTransaksi newList) throws FileNotFoundException, IOException
    {
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(3);
        Row row = sheet.getRow(index+1);
        row.getCell(1).setCellValue(newList.getOrderID());
        row.getCell(1).setCellValue(newList.getOrderID());
        
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
    
    public void editListatIndex(int index, ModelTransaksi newList) {
        this.list.set(index, newList);
    }
    
    public void delete(String orderId, String Proname) throws IOException {
        this.deleteList(orderId, Proname);
        this.deleteExcel(orderId, Proname);
    }
    
    public void deleteList(String OrderId, String ProName) throws IOException {
        list.remove(searchObjectIndex(OrderId, ProName));
    }
    
    public void deleteExcel(String OrderId, String ProName) throws FileNotFoundException, IOException {
        
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(3);
        int lastRowNum = sheet.getLastRowNum();
        int rowIndex = 1;
        boolean ketemu = false;
        Iterator<Row> iterator = sheet.iterator();
        Row row = iterator.next();
        BarangController br = new BarangController();
        
        while(iterator.hasNext() && !ketemu) {
            row = iterator.next();
            if(row.getCell(1).getStringCellValue().equals(OrderId) && br.searchObject(row.getCell(7).toString()).getProductName().equals(ProName)){
                ketemu = true;
            }else{
                rowIndex++;
            }
        }
        
        if(rowIndex >= 0 && rowIndex < lastRowNum){
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
        }else if(rowIndex == lastRowNum){
            Row removingRow = sheet.getRow(rowIndex);
            if(removingRow != null){
                sheet.removeRow(removingRow);
            }
        }
        
        FileOutputStream outputStream = new FileOutputStream(super.FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
    
    public void showTable(JTable table1, Object[] isi) throws IOException{
        //{"Order ID","Order Date","Ship Date","Ship Mode","Customer ID",
        //"Postal Code","Product ID","Sales","Quantity","Discount","Profit", "Donation", "Total"}
        List<ModelTransaksi> subList;
        DefaultTableModel A = new DefaultTableModel(null,isi);
        table1.setModel(A);
        
        subList = this.getList();
        
        if(!subList.isEmpty()){
            int size;
            
            size = subList.size();
            
            //A.addRow(isi);
            
            for(int i = 0;i < size;i++){
                isi[0] = subList.get(i).getOrderID();
//                Date d = new Date(bebas.format(subList.get(i).getOrderDate()));
//                isi[1] = d;
                isi[1] = subList.get(i).getOrderDate();
                isi[2] = subList.get(i).getShipDate();
                isi[3] = subList.get(i).getShipMode().getShipMode();
                isi[4] = subList.get(i).getPelanggan().getCustomerName();
                isi[5] = subList.get(i).getPostal().getPostalCode();
                isi[6] = subList.get(i).getProduct().getProductName();
                isi[7] = (double) subList.get(i).getSales();
                isi[8] = subList.get(i).getQuantity();
                isi[9] = (double) subList.get(i).getDiscount();
                isi[10] = subList.get(i).getProfit();
                isi[11] = subList.get(i).getDonation() != null ? (double) subList.get(i).getDonation() : (double) 0;
                isi[12] = (int) isi[8] * (double) isi[7] - ((int) isi[8] * (double) isi[7] * (double) isi[9]) + (double) isi[11];
                
                A.addRow(isi);
            }
        }
    }
    
}
