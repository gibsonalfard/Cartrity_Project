/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ACER Z3-451
 */
public class ReportController {

//    TransaksiController tc = new TransaksiController();

    public void setReportExcel(String month, String year, TransaksiController tc, JProgressBar progBar) {
        try {
            FileOutputStream excelFile = new FileOutputStream(new File("src/Excel/Report_" + year + "_" + month + ".xlsx"));
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(month + " Report");
//            Iterator<Row> iterator = sheet.iterator();
//            iterator.next();
            int i = 0, idRow = 0, idCell;
            boolean finish = false;
            int size = tc.getList().size();
            int interval = size/100;
            
            CellStyle styleDate = workbook.createCellStyle();
            CreationHelper createHelper = workbook.getCreationHelper();
            styleDate.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));

            System.out.println("\nTest Excel :\n");

            Row currentRow = sheet.createRow(idRow++);
            idCell = 0;

            Cell ordID = currentRow.createCell(idCell++);
            Cell ordDate = currentRow.createCell(idCell++);
            ordDate.setCellStyle(styleDate);
            Cell shipDate = currentRow.createCell(idCell++);
            shipDate.setCellStyle(styleDate);
            Cell sMode = currentRow.createCell(idCell++);
            Cell cusName = currentRow.createCell(idCell++);
            Cell posCode = currentRow.createCell(idCell++);
            Cell productName = currentRow.createCell(idCell++);
            Cell harga = currentRow.createCell(idCell++);
            Cell qty = currentRow.createCell(idCell++);
            Cell dic = currentRow.createCell(idCell++);
            Cell profit = currentRow.createCell(idCell++);
            Cell don = currentRow.createCell(idCell++);
            Cell tot = currentRow.createCell(idCell++);

            ordID.setCellValue("Order ID");
            ordDate.setCellValue("Order Date");
            shipDate.setCellValue("Ship Date");
            sMode.setCellValue("Ship Mode");
            cusName.setCellValue("Customer Name");
            posCode.setCellValue("Postal Code");
            productName.setCellValue("Product Name");
            harga.setCellValue("Price");
            qty.setCellValue("Quantity");
            dic.setCellValue("Discount");
            profit.setCellValue("Profit");
            don.setCellValue("Donation");
            tot.setCellValue("Total");

            while (i < size) {
                SimpleDateFormat sdfMt = new SimpleDateFormat("MMMM");
                SimpleDateFormat sdfYr = new SimpleDateFormat("yyyy");

                String bln = sdfMt.format(tc.getList().get(i).getOrderDate());
                String thn = sdfYr.format(tc.getList().get(i).getOrderDate());
                System.out.println(bln + " " + thn);
                
                if(i%interval == 0){
                    progBar.removeAll();
                    progBar.setValue(progBar.getValue() + 1);
                    progBar.setVisible(true);
                }
                
                if (bln.equals(month) && thn.equals(year)) {
                    currentRow = sheet.createRow(idRow++);
                    idCell = 0;

                    ordID = currentRow.createCell(idCell++);
                    ordDate = currentRow.createCell(idCell++);
                    ordDate.setCellStyle(styleDate);
                    shipDate = currentRow.createCell(idCell++);
                    shipDate.setCellStyle(styleDate);
                    sMode = currentRow.createCell(idCell++);
                    cusName = currentRow.createCell(idCell++);
                    posCode = currentRow.createCell(idCell++);
                    productName = currentRow.createCell(idCell++);
                    harga = currentRow.createCell(idCell++);
                    qty = currentRow.createCell(idCell++);
                    dic = currentRow.createCell(idCell++);
                    profit = currentRow.createCell(idCell++);
                    don = currentRow.createCell(idCell++);
                    tot = currentRow.createCell(idCell++);

//                    sMode.setCellValue("Apa aja");
//                    productName.setCellValue("Heloo");
//                    ordID.setCellValue("Apa aja ADANYA");
//                    cusName.setCellValue("Heloo SEMUA");
                    ordID.setCellValue(tc.getList().get(i).getOrderID());
                    ordDate.setCellValue(tc.getList().get(i).getOrderDate());
                    shipDate.setCellValue(tc.getList().get(i).getShipDate());
                    sMode.setCellValue(tc.getList().get(i).getShipMode().getShipMode());
                    cusName.setCellValue(tc.getList().get(i).getPelanggan().getCustomerName());
                    posCode.setCellValue(tc.getList().get(i).getPostal().getRegion());
                    productName.setCellValue(tc.getList().get(i).getProduct().getProductName());
                    harga.setCellValue(tc.getList().get(i).getSales());
                    qty.setCellValue(tc.getList().get(i).getQuantity());
                    dic.setCellValue(tc.getList().get(i).getDiscount());
                    profit.setCellValue(tc.getList().get(i).getProfit());
                    don.setCellValue(tc.getList().get(i).getDonation());
                    tot.setCellValue(tc.getList().get(i).getTotal());

                    System.out.println(tc.getList().get(i).getOrderID());
                    System.out.println(tc.getList().get(i).getOrderDate());
                }
                i++;
            }

            for (i = 0; i < 13; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(excelFile);
            workbook.close();
            Desktop.getDesktop().open(new File("src/Excel/Report_" + year + "_" + month + ".xlsx"));
            System.err.println("Finish");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
