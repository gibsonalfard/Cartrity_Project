/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import Controller.BarangController;
import Controller.KeranjangController;
import Model.ModelBarang;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Gibran
 */
public class Frame_Grid_Barang extends javax.swing.JInternalFrame {

    KeranjangController cart = new KeranjangController();
    static List<ModelBarang> spareList;
    static List<ModelBarang> list;

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }
    
    private int start = 0;
    private int end = 15;
    private int max = 0;
    int jml;

    /**
     * Creates new form Frame_Grid_Barang
     */
    public Frame_Grid_Barang() {
        try {
            initComponents();
            this.list = new BarangController().getList();
            this.showGrid(start, end);
            this.hideFilterLabel();
            this.hideSearchLabel();
        } catch (IOException ex) {
            Logger.getLogger(Frame_Grid_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Frame_Grid_Barang(int mulai, int akhir) {
        try {
            initComponents();
            this.list = new BarangController().getList();
            this.showGrid(mulai, akhir);
            this.hideFilterLabel();
            this.hideSearchLabel();
        } catch (IOException ex) {
            Logger.getLogger(Frame_Grid_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Frame_Grid_Barang(String searched) {
        try {
            initComponents();
            this.list = new BarangController().getList();
            this.makeSearchedList(searched);
            this.showGrid(start, end);
            this.hideFilterLabel();
            this.setSearchLabel(searched);
        } catch (IOException ex) {
            Logger.getLogger(Frame_Grid_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Frame_Grid_Barang(String category, String subCategory) {
        try {
            initComponents();
            this.list = new BarangController().getList();
            this.makeFilteredList(category, subCategory);
            this.showGrid(start, end);
            this.hideFilterLabel();
            this.setFilterLabel(category, subCategory);
        } catch (IOException ex) {
            Logger.getLogger(Frame_Grid_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void hideSearchLabel() {
        this.jLabelSearch.setVisible(false);
        this.jLabelSearchItem.setVisible(false);
    }
    
    private void hideFilterLabel() {
        this.jLabelFilter.setVisible(false);
        this.jLabelFilterItem.setVisible(false);
    }
    
    private void setFilterLabel(String category, String subCategory) {
        if(subCategory != null) {
            jLabelSearchItem.setText(subCategory + " in " + category);
        } else if(category != null) {
            jLabelSearchItem.setText(category);
        }
    }
    
    private void setSearchLabel(String searched) {
        if(searched != null) {
            jLabelSearchItem.setText(searched);
        }
    }
    
//    private void hideSearchLabel() {
//        this.jLabelSearch.setVisible(false);
//        this.jLabelSearchItem.setVisible(false);
//    }
//    
//    private void hideFilterLabel() {
//        this.jLabelFilter.setVisible(false);
//        this.jLabelFilterItem.setVisible(false);
//    }
//    
//    private void setFilterLabel(String category, String subCategory) {
//        if(subCategory != null) {
//            jLabelFilterItem.setText(subCategory + " in " + category);
//            jLabelFilter.setVisible(true);
//            jLabelFilterItem.setVisible(true);
//        } else if(category != null) {
//            jLabelFilterItem.setText(category);
//            jLabelFilter.setVisible(true);
//            jLabelFilterItem.setVisible(true);
//        }
//    }
//    
//    private void setSearchLabel(String searched) {
//        if(searched != null) {
//            jLabelSearchItem.setText(searched);
//            jLabelSearch.setVisible(true);
//            jLabelSearchItem.setVisible(true);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jLabelSearch = new javax.swing.JLabel();
        jLabelFilter = new javax.swing.JLabel();
        jLabelSearchItem = new javax.swing.JLabel();
        jLabelFilterItem = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1220, 717));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(1200, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(1200, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(1200, 600));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(218, 238, 224));

        btnPrev.setText("Previous");
        btnPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrevMouseClicked(evt);
            }
        });
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });

        jLabelSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSearch.setText("In Search for");

        jLabelFilter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFilter.setText("In Filter for");

        jLabelSearchItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSearchItem.setText("Empty");

        jLabelFilterItem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFilterItem.setText("Empty");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFilterItem))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSearchItem)))
                .addGap(387, 387, 387)
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(564, 564, 564))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrev)
                        .addComponent(btnNext))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSearch)
                            .addComponent(jLabelSearchItem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFilter)
                            .addComponent(jLabelFilterItem))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrevMouseClicked
        if (this.start - 15 >= 0) {

            this.end = this.start;
            this.start = this.start - 15 < 0 ? 0 : this.start - 15;

            Frame_Grid_Barang grid = new Frame_Grid_Barang(start, end);
            
            jPanel2.removeAll();
            jPanel2.setLayout(new GridLayout(1, 3));
            jPanel2.add(grid.jPanel2);
            
            jPanel2.setVisible(false);
            jPanel2.setVisible(true);
            grid.jPanel2.setVisible(true);
            btnNext.setEnabled(true);
            btnPrev.setEnabled(this.start > 0);
        } else {
            btnPrev.setEnabled(false);
        }
    }//GEN-LAST:event_btnPrevMouseClicked

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        if (this.end + 15 <= this.max) {

            this.start = this.end;
            this.end = this.end + 15 > this.max ? this.max : this.end + 15;

            Frame_Grid_Barang grid = new Frame_Grid_Barang(start, end);

            jPanel2.removeAll();
            jPanel2.setLayout(new GridLayout(1, 3));
            jPanel2.add(grid.jPanel2);

            jPanel2.setVisible(false);
            jPanel2.setVisible(true);
            grid.setVisible(true);
            btnNext.setEnabled(this.end < this.max);
            btnPrev.setEnabled(true);
        } else {
            btnNext.setEnabled(false);
        }
        
        System.out.println("Beres " + start + " " + end);
    }//GEN-LAST:event_btnNextMouseClicked

    public void showGrid(int start, int end) throws IOException {
//        BarangController sub = new BarangController();
        List<ModelBarang> subList;
        
        jPanel2.setLayout(new GridLayout(5, 3));
        jPanel2.setSize(1200,600);
        
//        subList = sub.getList();
        subList = this.list;
        this.setMax(this.getMax() == 0 ? subList.size() : this.getMax());
        int i = start;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        
        while (i < end && i < subList.size()) {
            Grid panel = new Grid(); 
            panel.getjLabelNama().setText(subList.get(i).getProductName());
//            panel.getjLabelHarga().setText("Rp.");
            panel.getjLabelKategori().setText(subList.get(i).getSubcategory().getKategori().getKategori());
            panel.getjLabelHarga().setText("$" + decimalFormat.format(subList.get(i).getPrice()));
            ImageIcon icon = new ImageIcon(subList.get(i).getSubcategory().getImageSource());
//            ImageIcon icon = new ImageIcon(".\\src\\image\\product.png");
            panel.getjLabelImage().setIcon(new ImageIcon(icon.getImage()));
            panel.getjButtonAdd().addActionListener(new MyActionListener(subList.get(i).getProductID(),panel));
            panel.getJSpinnerJml().setValue(new Integer(1));
            panel.getJSpinnerJml().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSpinner s = (JSpinner) e.getSource();
                    int val = (int) s.getValue();
                    if (val < 1) {
                        s.setValue(1);
                    }
                    jml = val;
                }
            });
            
            jPanel2.add(panel);
            i++;
        }
        
    }
    
    public void makeSearchedList(String searched) {
        this.spareList = this.list;
        this.list = new ArrayList<>();
        for(ModelBarang e : spareList) {
            if(e.getProductName().contains(searched)) {
                this.list.add(e);
            }
        }
    }
    
    public void makeFilteredList(String category, String subCategory) {
        this.spareList = this.list;
        this.list = new ArrayList<>();
        for(ModelBarang e : spareList) {
            
            boolean add = true;
            if(category != null) {
//                System.out.println("Cat OK");
                if(!(e.getSubcategory().getKategori().getKategori().equals(category))) {
                    add = false;
//                    System.out.println("Dont add cat");
                }
            }
            
            if(subCategory != null) {
//                System.out.println("Sub Cat OK");
                if(!(e.getSubcategory().getSubKategori().equals(subCategory))) {
                    add = false;
//                    System.out.println("Dont add Sub cat");
                }
            }
            
            if(add) {
                this.list.add(e);
//                System.out.println("add");
            }
        }
    }
    
//    public void showSearchedGrid(int start, int end, String searched) throws IOException {
//        BarangController sub = new BarangController();
//        List<ModelBarang> subList = new ArrayList<>();
//        
//        for(ModelBarang temp : sub.getList()) {
//            if(temp.getProductName().contains(searched)) {
//                subList.add(temp);
//            }
//        }
//        
//        jPanel2.setLayout(new GridLayout(5, 3));
//        jPanel2.setSize(1200,600);
//        
//        this.setMax(this.getMax() == 0 ? subList.size() : this.getMax());
//        int i = start;
//        DecimalFormat decimalFormat = new DecimalFormat("#.00");
//        
//        while (i < end) {
//            Grid panel = new Grid(); 
//            panel.getjLabelNama().setText(subList.get(i).getProductName());
////            panel.getjLabelHarga().setText("Rp.");
//            panel.getjLabelKategori().setText(subList.get(i).getSubcategory().getKategori().getKategori());
//            panel.getjLabelHarga().setText("$" + decimalFormat.format(subList.get(i).getPrice()));
//            ImageIcon icon = new ImageIcon(subList.get(i).getSubcategory().getImageSource());
////            ImageIcon icon = new ImageIcon(".\\src\\image\\product.png");
//            panel.getjLabelImage().setIcon(new ImageIcon(icon.getImage()));
//            panel.getjButtonAdd().addActionListener(new MyActionListener(subList.get(i).getProductID(),panel));
//            panel.getJSpinnerJml().addChangeListener(new ChangeListener() {
//                @Override
//                public void stateChanged(ChangeEvent e) {
//                    JSpinner s = (JSpinner) e.getSource();
//                    int val = (int) s.getValue();
//                    if (val < 1) {
//                        s.setValue(1);
//                    }
//                    jml = val;
//                }
//            });
//            
//            jPanel2.add(panel);
//            i++;
//        }
//    }
    
    private class MyActionListener implements ActionListener {
        String text;
        Grid g;
        
        public MyActionListener(String text, Grid panel) {
            this.text = text;
            g = panel;
        }
        
        public void actionPerformed(ActionEvent e) {
            if(jml < 1){
                jml = 1;
            }
            cart.tambahBarang(text, jml);
            System.out.println("Total : " + cart.getTotal());
            g.getJSpinnerJml().setValue(new Integer(1));
            JOptionPane.showMessageDialog(null, "Pesanan anda sudah masuk ke keranjang belanjaan :D");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JLabel jLabelFilter;
    private javax.swing.JLabel jLabelFilterItem;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSearchItem;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
