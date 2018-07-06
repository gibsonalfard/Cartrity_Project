 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelBarang;
import static Model.ModelBarang.FILE_NAME;
import Model.ModelKategori;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
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
public class BarangController extends ModelBarang {

    private static List<ModelBarang> list = new ArrayList<>();

    public void getAllData() throws IOException {
        //this.list = new ArrayList<>();
        SubKategoriController data = new SubKategoriController();

        int i;

        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();

                Cell id = currentRow.getCell(0);
                Cell cat = currentRow.getCell(1);
                Cell name = currentRow.getCell(2);
                Cell price = currentRow.getCell(3);
                Cell image = currentRow.getCell(4);

                ModelBarang brg = new ModelBarang();

                brg.setProductID(id.toString());
                brg.setSubcategory(data.searchObject(cat.toString()));
                brg.setProductName(name.toString());
                brg.setPrice(price.getNumericCellValue());
                brg.setImageSource(image.toString());

                this.list.add(brg);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ModelBarang> getList() throws IOException {
        if (this.list.isEmpty()) {
            getAllData();
        }
        return this.list;
    }
    
    public void setList(List<ModelBarang> e) {
        this.list = e;
    }

    public ModelBarang searchObject(String id) throws IOException {
        ModelBarang brg = new ModelBarang();

        if (this.list.isEmpty()) {
            getAllData();
        }
        int i = 0;
        boolean ketemu = false;
        while (i < list.size() && !ketemu) {
            String ID = list.get(i).getProductID();

            brg = list.get(i);

            if (ID.equals(id)) {
                ketemu = true;
            }

            i += 1;

        }

        return brg;
    }
    
    public int searchObjectIndex(String id) throws IOException{
        
        if(this.list.isEmpty()){
            getAllData();
        }
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getProductID();

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
    
    public void add(ModelBarang newList, boolean newCat) throws FileNotFoundException, IOException {
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        
        Row row = sheet.createRow(sheet.getLastRowNum()+1);
        row.createCell(0).setCellValue(newList.getProductID().toString());
        row.createCell(1).setCellValue(newList.getSubcategory().getId_sub());
        row.createCell(2).setCellValue(newList.getProductName());
        row.createCell(3).setCellValue(newList.getPrice());
        
        if(newCat){
            sheet = workbook.getSheet("Subkategori");
            row = sheet.createRow(sheet.getLastRowNum()+1);
            row.createCell(0).setCellValue(newList.getSubcategory().getId_sub());
            row.createCell(1).setCellValue(newList.getSubcategory().getKategori().getId_kategori());
            row.createCell(2).setCellValue(newList.getSubcategory().getSubKategori());
            sheet = workbook.getSheet("Kategori");
            row = sheet.createRow(sheet.getLastRowNum()+1);
            row.createCell(0).setCellValue(newList.getSubcategory().getKategori().getId_kategori());
            row.createCell(1).setCellValue(newList.getSubcategory().getKategori().getKategori());
        }

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
    
    public void edit(String ID, ModelBarang newList) {
        try {
            int index = searchObjectIndex(ID);
            editListatIndex(index, newList);
            editExcel(index, newList);
        } catch (IOException ex) {
            Logger.getLogger(TransaksiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editExcel(int index, ModelBarang newList) throws FileNotFoundException, IOException
    {
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(index+1);
        row.getCell(0).setCellValue(newList.getProductID());
        row.getCell(1).setCellValue(newList.getSubcategory().getId_sub());
        row.getCell(2).setCellValue(newList.getProductName());
        row.getCell(3).setCellValue(newList.getPrice());
        
        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
    
    public void editListatIndex(int index, ModelBarang newList) {
        this.list.set(index, newList);
    }
    
    public void delete(String Id) throws IOException {
        this.deleteList(Id);
        this.deleteExcel(Id);
    }
    
    public void deleteList(String Id) throws IOException {
        list.remove(searchObjectIndex(Id));
    }
    
    public void deleteExcel(String Id) throws FileNotFoundException, IOException {
        
        FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        int rowIndex = 1;
        boolean ketemu = false;
        Iterator<Row> iterator = sheet.iterator();
        Row row = iterator.next();
        BarangController br = new BarangController();
        
        while(iterator.hasNext() && !ketemu) {
            row = iterator.next();
            if(row.getCell(0).getStringCellValue().equals(Id)){
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

    public void showTable(JTable table1, Object[] isi) throws IOException {
        BarangController sub = new BarangController();
        List<ModelBarang> subList;
        DefaultTableModel A = new DefaultTableModel(null, isi);
        table1.setModel(A);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        subList = sub.getList();

        if (!subList.isEmpty()) {
            int size;

            size = subList.size();

//            A.addRow(isi);

            for (int i = 0; i < size; i++) {
                isi[0] = subList.get(i).getProductID();
                isi[1] = subList.get(i).getSubcategory().getKategori().getKategori();
                isi[2] = subList.get(i).getSubcategory().getSubKategori();
                isi[3] = subList.get(i).getProductName();
                isi[4] = "$" + decimalFormat.format(subList.get(i).getPrice());

                A.addRow(isi);
            }
        }
    }
}
