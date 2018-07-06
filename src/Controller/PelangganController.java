/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelBarang;
import static Model.ModelBarang.FILE_NAME;
import Model.ModelKategori;
import Model.ModelPelanggan;
import static Model.ModelPelanggan.FILE_NAME;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class PelangganController extends ModelPelanggan{
    private static List<ModelPelanggan> list = new ArrayList<>();
    
    public void getAllData() throws IOException{
        //this.list = new ArrayList<>();
        KategoriController kat = new KategoriController();
        
        int i;
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(2);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                
                Cell cusId = currentRow.getCell(0);
                Cell cusName = currentRow.getCell(1);
                Cell seg = currentRow.getCell(2);
                
                ModelPelanggan pel = new ModelPelanggan();
                pel.setCustomerID(cusId.getStringCellValue());
                pel.setCustomerName(cusName.getStringCellValue());
                pel.setSegment(seg.getStringCellValue());
                
                this.list.add(pel);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ModelPelanggan> getList() throws IOException{
        if(this.list.isEmpty()){
            getAllData();
        }
        return this.list;
    }
    
    public ModelPelanggan searchObject(String id) throws IOException{
        ModelPelanggan cus = new ModelPelanggan();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getCustomerID();

            cus = list.get(i);

            if(ID.equals(id)){
                ketemu = true;
            }

            i += 1;
        }
        
        
        return cus;
    }
    
    public int searchObjectIndex(String id) throws IOException{
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getCustomerID();

            if(ID.equals(id)){
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
    
    public void add(ModelPelanggan newList) throws FileNotFoundException, IOException {
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheet("Pelanggan");
        
        Row row = sheet.createRow(sheet.getLastRowNum()+1);
        row.createCell(0).setCellValue(newList.getCustomerID());
        row.createCell(1).setCellValue(newList.getCustomerName());
        row.createCell(2).setCellValue(newList.getSegment());

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void edit(String ID, ModelPelanggan newList) {
        try {
            int index = searchObjectIndex(ID);
            editListatIndex(index, newList);
            editExcel(index, newList);
        } catch (IOException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editExcel(int index, ModelPelanggan newList) throws FileNotFoundException, IOException
    {
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(2);
        Row row = sheet.getRow(index+1);
        row.getCell(0).setCellValue(newList.getCustomerID());
        row.getCell(1).setCellValue(newList.getCustomerName());
        row.getCell(2).setCellValue(newList.getSegment());
        
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
    
    public void editListatIndex(int index, ModelPelanggan newList) {
        list.set(index, newList);
    }
    
    public void delete(String ID) throws IOException {
        this.deleteList(ID);
        this.deleteExcel(ID);
    }
    
    public void deleteList(String ID) throws IOException {
        list.remove(searchObjectIndex(ID));
    }
    
    public void deleteExcel(String ID) throws FileNotFoundException, IOException {
        
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(2);
        int lastRowNum = sheet.getLastRowNum();
        int rowIndex = 1;
        boolean ketemu = false;
        Iterator<Row> iterator = sheet.iterator();
        Row row = iterator.next();
        BarangController br = new BarangController();
        
        while(iterator.hasNext() && !ketemu) {
            row = iterator.next();
            if(row.getCell(0).getStringCellValue().equals(ID)){
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
        //{"Customer ID","Name","Segment"};
        List<ModelPelanggan> subList;
        DefaultTableModel A = new DefaultTableModel(null,isi);
        table1.setModel(A);
        
        subList = this.getList();
        
        if(!subList.isEmpty()){
            int size;
            
            size = subList.size();
            
            for(int i = 1;i < size;i++){
                isi[0] = subList.get(i).getCustomerID();
                isi[1] = subList.get(i).getCustomerName();
                isi[2] = subList.get(i).getSegment();
                        
                A.addRow(isi);
            }
        }
    }
    
}
