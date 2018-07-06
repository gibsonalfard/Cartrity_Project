/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelKategori;
import Model.ModelSubKategori;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Gibran
 */
public class SubKategoriController extends ModelSubKategori{
    private static List<ModelSubKategori> list = new ArrayList<>();
    
    public void getAllData() throws IOException{
        //this.list = new ArrayList<>();
        KategoriController kat = new KategoriController();
        
        int i;
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(5);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                
                Cell idsub = currentRow.getCell(0);
                Cell cat = currentRow.getCell(1);
                Cell subcat = currentRow.getCell(2);
                Cell image = currentRow.getCell(3);
                
                ModelSubKategori sub = new ModelSubKategori();
                sub.setId_sub(idsub.toString());
                sub.setKategori(kat.searchObject(cat.toString()));
                sub.setSubKategori(subcat.toString());
                sub.setImageSource(image.toString());
                
                this.list.add(sub);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ModelSubKategori> getList() throws IOException{
        if(this.list.isEmpty()){
            getAllData();
        }
        return this.list;
    }
    
    public ModelSubKategori searchObject(String id) throws IOException{
        ModelSubKategori kat = new ModelSubKategori();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getId_sub();

            kat = list.get(i);

            if(ID.equals(id)){
                ketemu = true;
            }

            i += 1;
        }
        
        
        return kat;
    }
    
    public String getID(String kategori) throws IOException {
        
        String id = null;
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String kat = list.get(i).getSubKategori();

            id = list.get(i).getId_sub();

            if(kat.equals(kategori)){
                ketemu = true;
            }

            i += 1;
        }
        
        return id;
    }
}
