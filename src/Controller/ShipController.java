/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelKategori;
import Model.ModelShipMode;
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
public class ShipController extends ModelShipMode{
    static List<ModelShipMode> list = new ArrayList<>();
    
    public void getAllData() throws IOException{
        //this.list = new ArrayList<>();
        KategoriController kat = new KategoriController();
        
        int i;
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(8);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                
                Cell idShip = currentRow.getCell(0);
                Cell shipMode = currentRow.getCell(1);
                Cell price = currentRow.getCell(2);
                
                ModelShipMode sh = new ModelShipMode();
                sh.setShipID(idShip.getStringCellValue());
                sh.setShipMode(shipMode.getStringCellValue());
                sh.setPrice(price.getNumericCellValue());
                
                this.list.add(sh);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ModelShipMode> getList() throws IOException{
        if(this.list.isEmpty()){
            getAllData();
        }
        return this.list;
    }
    
    public ModelShipMode searchObject(String id) throws IOException{
        ModelShipMode sh = new ModelShipMode();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getShipID();

            sh = list.get(i);

            if(ID.equals(id)){
                ketemu = true;
            }

            i += 1;
        }
        
        
        return sh;
    }
    
    public ModelShipMode searchRevObject(String shipMode) throws IOException{
        ModelShipMode sh = new ModelShipMode();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getShipMode();

            sh = list.get(i);

            if(ID.equals(shipMode)){
                ketemu = true;
            }

            i += 1;
        }
        
        
        return sh;
    }
}
