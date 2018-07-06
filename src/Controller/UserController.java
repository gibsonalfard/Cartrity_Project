/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelUser;
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
public class UserController extends ModelUser{
    static List<ModelUser> list = new ArrayList<>();
    
    public void getAllData() throws IOException{
        //this.list = new ArrayList<ModelKategori>();
        int i;
        
        try {
            FileInputStream excelFile = new FileInputStream(new File(super.FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet("User");
            Iterator<Row> iterator = sheet.iterator();
            iterator.next();
            
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                
                Cell UN = currentRow.getCell(0);
                Cell pswd = currentRow.getCell(1);
                Cell lLog = currentRow.getCell(2);
                
                ModelUser usr = new ModelUser();
                usr.setUsername(UN.getStringCellValue());
                usr.setPassword(pswd.getStringCellValue());
                usr.setUserID(lLog.getStringCellValue());
                
                this.list.add(usr);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ModelUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ModelUser> getList() throws IOException{
        if(this.list.isEmpty()){
            getAllData();
        }
        
        return list;
    }
    
    public ModelUser searchObject(String id) throws IOException{
        ModelUser usr = new ModelUser();
        
        if(this.list.isEmpty()){
            getAllData();
        }
        
        int i = 0;
        boolean ketemu = false;
        while(i<list.size() && !ketemu){
            String ID = list.get(i).getUsername();

            usr = list.get(i);

            if(ID.equals(id)){
                ketemu = true;
            }

            i += 1;
        }
        
        return usr;
    }
}
