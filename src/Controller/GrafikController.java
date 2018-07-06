/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ACER Z3-451
 */
public class GrafikController {

    BarangController bc = new BarangController();
    TransaksiController tc = new TransaksiController();

    public JPanel displayPieChart(DefaultPieDataset objDataset) {
//        DefaultPieDataset objDataset = new DefaultPieDataset();

        ChartPanel chartPanel = new ChartPanel(createPieChart(objDataset));
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        return chartPanel;
    }

    public JPanel displayLineChart(DefaultCategoryDataset dataset, int idx) {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        ChartPanel chartPanel = new ChartPanel(createLineChart(dataset, idx));
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        return chartPanel;
    }

    JFreeChart createPieChart(DefaultPieDataset objDataset) {
        objDataset = createPieDataset(objDataset);

        JFreeChart chart = ChartFactory.createPieChart("Sub-Category Available", objDataset);
        return chart;
    }

    JFreeChart createLineChart(DefaultCategoryDataset dataset, int idx) {
        String Thn = "";
        
        dataset = createLineDataset(dataset, idx);

        switch (idx) {
            case 0 : Thn = "2014"; break;
            case 1 : Thn = "2015"; break;
            case 2 : Thn = "2016"; break;
            case 3 : Thn = "2017"; break;
        }
        
        JFreeChart chart = ChartFactory.createLineChart("Transaction in "+Thn, "Month", "Quantity", dataset);
        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        plot.setRenderer(renderer);

        return chart;
    }

    DefaultPieDataset createPieDataset(DefaultPieDataset objDataset) {
        int size;
        int i = 0;
        int bo = 0, ch = 0, fu = 0, ta = 0;
        int ap = 0, ar = 0, bi = 0, en = 0, fa = 0, la = 0;
        int pa = 0, st = 0, su = 0, ac = 0, co = 0, ma = 0, ph = 0;
        
        try {
            size = bc.getList().size();
            System.err.println("Size Sub-Category : " + size);
            while (i < size) {
                String idSub = bc.getList().get(i).getSubcategory().getId_sub();
//                objDataset.setValue(bc.getList().get(i).getSubcategory().getSubKategori(), bo++);
                switch (idSub) {
                    case "BO":
//                        System.out.println("case");
                        bo++; break;
                    case "CH":
                        ch++; break;
                    case "FU":
                        fu++; break;
                    case "TA":
                        ta++; break;
                    case "AP":
                        ap++; break;
                    case "AR":
                        ar++; break;
                    case "BI":
                        bi++; break;
                    case "EN":
                        en++; break;
                    case "FA":
                        fa++; break;
                    case "LA":
                        la++; break;
                    case "PA":
                        pa++; break;
                    case "ST":
                        st++; break;
                    case "SU":
                        su++; break;
                    case "AC":
                        ac++; break;
                    case "CO":
                        co++; break;
                    case "MA":
                        ma++; break;
                    case "PH":
                        ph++; break;
                }
                i++;
            }
            objDataset.setValue("Bookcases"+" "+String.valueOf(bo), bo);
            objDataset.setValue("Chairs"+" "+String.valueOf(ch), ch);
            objDataset.setValue("Furnishings"+" "+String.valueOf(fu), fu);
            objDataset.setValue("Tables"+" "+String.valueOf(ta), ta);
            objDataset.setValue("Appliances"+" "+String.valueOf(ap), ap);
            objDataset.setValue("Art"+" "+String.valueOf(ar), ar);
            objDataset.setValue("Binders"+" "+String.valueOf(bi), bi);
            objDataset.setValue("Envelopes"+" "+String.valueOf(en), en);
            objDataset.setValue("Fasteners"+" "+String.valueOf(fa), fa);
            objDataset.setValue("Labels"+" "+String.valueOf(la), la);
            objDataset.setValue("Paper"+" "+String.valueOf(pa), pa);
            objDataset.setValue("Storage"+" "+String.valueOf(st), st);
            objDataset.setValue("Supplies"+" "+String.valueOf(su), su);
            objDataset.setValue("Accessories"+" "+String.valueOf(ac), ac);
            objDataset.setValue("Copiers"+" "+String.valueOf(co), co);
            objDataset.setValue("Machines"+" "+String.valueOf(ma), ma);
            objDataset.setValue("Phones"+" "+String.valueOf(ph), ph);
        } catch (IOException ex) {
            Logger.getLogger(GrafikController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objDataset;
    }

    DefaultCategoryDataset createLineDataset(DefaultCategoryDataset dataset, int idx) {
        int size;
        int i = 0;
        int bo = 0, ch = 0, fu = 0, ta = 0;
        int ap = 0, ar = 0, bi = 0, en = 0, fa = 0, la = 0;
        int pa = 0, st = 0, su = 0, ac = 0, co = 0, ma = 0, ph = 0;
        String blnTemp = "";
        String PilihThn = "";
        
        switch (idx) {
            case 0 : PilihThn = "2014"; break;
            case 1 : PilihThn = "2015"; break;
            case 2 : PilihThn = "2016"; break;
            case 3 : PilihThn = "2017"; break;
        }
        
        try {
            size = tc.getList().size();
            System.out.println("Size Transaction : " + size);

            SimpleDateFormat sdfYr = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfMt = new SimpleDateFormat("MMMM");

            while (i < size) {
                String idSub = tc.getList().get(i).getProduct().getSubcategory().getId_sub();
                String bln = sdfMt.format(tc.getList().get(i).getOrderDate()).substring(0, 3);
                String Thn = sdfYr.format(tc.getList().get(i).getOrderDate());

//                System.out.println("Tahun : " + Thn);
                if (!blnTemp.equals(bln)) {
                    blnTemp = bln;
                    bo = 0; ch = 0; fu = 0; ta = 0;
                    ap = 0; ar = 0; bi = 0; en = 0; fa = 0; la = 0;
                    pa = 0; st = 0; su = 0; ac = 0; co = 0; ma = 0; ph = 0;
                }
                if (Thn.equals(PilihThn)) {
//                objDataset.setValue(bc.getList().get(i).getSubcategory().getSubKategori(), bo++);
                    switch (idSub) {
                        case "BO":
//                        System.out.println("case");
                            dataset.addValue(bo++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "CH":
                            dataset.addValue(ch++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "FU":
                            dataset.addValue(fu++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "TA":
                            dataset.addValue(ta++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "AP":
                            dataset.addValue(ap++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "AR":
                            dataset.addValue(ar++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "BI":
                            dataset.addValue(bi++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "EN":
                            dataset.addValue(en++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "FA":
                            dataset.addValue(fa++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "LA":
                            dataset.addValue(la++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "PA":
                            dataset.addValue(pa++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "ST":
                            dataset.addValue(st++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "SU":
                            dataset.addValue(su++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "AC":
                            dataset.addValue(ac++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "CO":
                            dataset.addValue(co++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "MA":
                            dataset.addValue(ma++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                        case "PH":
                            dataset.addValue(ph++, tc.getList().get(i).getProduct().getSubcategory().getSubKategori(),
                                    bln.substring(0, 3));
//                            System.out.println("Sub Kategori : "
//                                    + tc.getList().get(i).getProduct().getSubcategory().getSubKategori()
//                                    + "\nBulan : " + bln.substring(0, 3));
                            break;
                    }
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(GrafikController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataset;
    }
}
