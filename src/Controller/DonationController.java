/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelDonation;
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
public class DonationController extends ModelDonation{
    static List<ModelDonation> list = new ArrayList<>();
    
    public void getAllData() throws IOException{
        //this.list = new ArrayList<>();
        PelangganController pel = new PelangganController();
        
        int i;
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(6);
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                
                Cell idDon = currentRow.getCell(0);
                Cell cus = currentRow.getCell(1);
                Cell jmlDon = currentRow.getCell(2);
                
                ModelDonation don = new ModelDonation();
                don.setDonationID(idDon.getStringCellValue());
                don.setPelanggan(pel.searchObject(idDon.toString()));
                don.setJmlDonasi(jmlDon.getNumericCellValue());
                
                this.list.add(don);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelDonation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ModelDonation> getList() throws IOException{
        if(this.list.isEmpty()){
            getAllData();
        }
        return this.list;
    }
    
    public ModelDonation searchObject(String id) throws IOException{
        ModelDonation don = new ModelDonation();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getDonationID();

            don = list.get(i);

            if(ID.equals(id)){
                ketemu = true;
            }

            i += 1;
        }
        
        
        return don;
    }
}
