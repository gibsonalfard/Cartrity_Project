/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import Controller.DaerahController;
import Controller.ShipController;
import Controller.UserController;
import Model.ModelDaerah;
import Model.ModelKeranjang;
import Model.ModelShipMode;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.NumberFormatException;

/**
 *
 * @author ACER
 */
public class Frame_Transaksi_User extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frame_Transaksi_User
     */
    public Frame_Transaksi_User() {
        initComponents();
    }

    public Frame_Transaksi_User(List<ModelKeranjang> shopCart, int start, int end, String username, int shipMode, Dash_User dashUser) throws IOException {
        initComponents();
        this.keranjang = shopCart;
        this.dashUser = dashUser;
        this.user = username;
        this.showGrid(shopCart, start, end);
        this.showShipmode();
        this.jComboBoxShipping.setSelectedIndex(shipMode);
        this.jComboBoxShipping.setEnabled(false);
        this.showRegion();
        this.jTextFieldDonasi.setText("0");
    }

    public Frame_Transaksi_User(List<ModelKeranjang> shopCart, int start, int end, int shipMode, Dash_User dashUser) throws IOException {
        initComponents();
        this.keranjang = shopCart;
        this.dashUser = dashUser;
        this.showGrid(shopCart, start, end);
        this.showShipmode();
        this.jComboBoxShipping.setSelectedIndex(shipMode);
        this.jComboBoxShipping.setEnabled(false);
        this.showRegion();
        this.jTextFieldDonasi.setText("0");
    }
    
    private void showShipmode() {
        try {
            list = ship.getList();
            int i = 0;

            this.jComboBoxShipping.removeAllItems();

            while (i < list.size()) {
                this.jComboBoxShipping.addItem(list.get(i).getShipMode());
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Frame_Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    List<ModelKeranjang> keranjang;
    ShipController ship = new ShipController();
    List<ModelShipMode> list;
    String user;
    Dash_User dashUser;
    private int start = 0;
    private int end = 5;
    private int max = 0;
    
    private void showGrid(List<ModelKeranjang> shopCart, int start, int end) {
        int i = start - 1;
        int j = 0;
        double jml = 0;
        int inCart = 0;

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        jPanel2.setLayout(new GridLayout(5, 1));
        this.setMax(this.getMax() == 0 ? shopCart.size() : this.getMax());
        
        while(j < shopCart.size()){
            jml += shopCart.get(j).getTotal();
            inCart += shopCart.get(j).getQty();
            
            j++;
        }
        
        while (i < shopCart.size() && i < end) {
            Grid_Transaksi grid = new Grid_Transaksi();

//            jml += shopCart.get(i).getTotal();
//            inCart += shopCart.get(i).getQty();
            grid.getLabelHarga().setText("$" + shopCart.get(i).getBarang().getPrice());
            grid.getLabelKategori().setText(shopCart.get(i).getBarang().getSubcategory().getKategori().getKategori());
            grid.getLabelNama().setText(shopCart.get(i).getBarang().getProductName());
            grid.getLabelSubKategori().setText(shopCart.get(i).getBarang().getSubcategory().getSubKategori());
            grid.getLabelTotal().setText("$" + shopCart.get(i).getTotal());
            String qty = String.valueOf(shopCart.get(i).getQty());
            grid.getLabelQty().setText(qty);

            ImageIcon icon = new ImageIcon(shopCart.get(i).getBarang().getSubcategory().getImageSource());
            grid.getLabelImage().setIcon(icon);

            jPanel2.add(grid);
            jButtonNext.setEnabled(this.getMax() > 5);
            jButtonPrev.setEnabled(this.getStart() - 5 >= 0);

            i++;
        }

        jLabelQty1.setText("(" + String.valueOf(inCart) + " Item)");
        jLabelQty2.setText(String.valueOf(inCart));
        jLabelSubTotal.setText("$" + String.valueOf(jml));
        jLabelTotal.setText("$" + String.valueOf(jml));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jButtonPrev = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelSubTotal = new javax.swing.JLabel();
        jLabelQty1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxShipping = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabelShipping = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabelQty2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBoxRegion = new javax.swing.JComboBox<>();
        jComboBoxCountry = new javax.swing.JComboBox<>();
        jComboBoxCity = new javax.swing.JComboBox<>();
        jComboBoxState = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabelPostalCode = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jTextFieldDonasi = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelJumlahBayar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 717));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 600));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Your Cart");

        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonPrev.setText("<");
        jButtonPrev.setEnabled(false);
        jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Ringkasan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Sub Total");

        jLabelSubTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSubTotal.setText("Rp. 1.000.000");

        jLabelQty1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelQty1.setText("( XX Iitem )");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Shipping Method");

        jComboBoxShipping.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxShipping.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxShippingItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Biaya Shipping");

        jLabelShipping.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelShipping.setText("Rp. 1.000.000");

        jLabel10.setText("_____________________________________");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("TOTAL");

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTotal.setText("Rp. 1.000.000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTotal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabelQty1)
                                    .addComponent(jLabel8))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSubTotal)
                                    .addComponent(jComboBoxShipping, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelShipping)))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(jLabelQty1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxShipping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelShipping, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelQty2.setText("Jmlh");

        jLabel2.setText("Jumlah Item : ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Alamat Pengiriman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Region");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Country");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("City");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("State");

        jComboBoxRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxRegion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRegionItemStateChanged(evt);
            }
        });

        jComboBoxCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCountryItemStateChanged(evt);
            }
        });

        jComboBoxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCity.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCityItemStateChanged(evt);
            }
        });

        jComboBoxState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxStateItemStateChanged(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Postal Code");

        jLabelPostalCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPostalCode.setText("POSTALCODENYA");

        jLabel14.setText(":");

        jLabel15.setText(":");

        jLabel16.setText(":");

        jLabel17.setText(":");

        jLabel18.setText(":");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBoxRegion, javax.swing.GroupLayout.Alignment.TRAILING, 0, 130, Short.MAX_VALUE)
                        .addComponent(jComboBoxCountry, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxCity, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxState, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelPostalCode))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxCountry)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxCity)
                        .addComponent(jLabel16))
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxState)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabelPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pembayaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("Sumbangan");

        jTextFieldDonasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDonasiActionPerformed(evt);
            }
        });
        jTextFieldDonasi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldDonasiPropertyChange(evt);
            }
        });
        jTextFieldDonasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDonasiKeyReleased(evt);
            }
        });

        jLabel42.setText(":");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setText("$");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel47.setText("Jumlah Bayar");

        jLabel43.setText(":");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel48.setText("$");

        jButton1.setText("PAY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelJumlahBayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelJumlahBayar.setText("TOTAL BAYAR");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel48))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel46)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jTextFieldDonasi, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelJumlahBayar)))
                        .addGap(11, 11, 11))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldDonasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelJumlahBayar)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelQty2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jButtonPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNext))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabelQty2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonPrev))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:                                           
        if (this.getMax() > getEnd()) {

            this.setStart(this.getEnd()+1);
            this.setEnd(this.getEnd() + 5 >= this.getMax() ? this.getMax() : this.getEnd() + 5);

            this.jPanel2.removeAll();
            this.showGrid(this.keranjang, getStart(), getEnd());
            this.setVisible(false);
            this.setVisible(true);
            jButtonNext.setEnabled(this.end < this.getMax());
            jButtonPrev.setEnabled(true);
        } else {
            jButtonNext.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevActionPerformed
        // TODO add your handling code here:                                            
        if (this.getStart() - 5 >= 0) {

            this.setEnd(this.getStart()-1);
            this.setStart(this.getStart()-5 < 1 ? 1 : this.getStart()-5);

            this.jPanel2.removeAll();
            this.showGrid(this.keranjang, getStart(), getEnd());
            this.setVisible(false);
            this.setVisible(true);
            jButtonNext.setEnabled(true);
            jButtonPrev.setEnabled(this.getStart() > 0);
        } else {
            jButtonPrev.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonPrevActionPerformed

    private void jTextFieldDonasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDonasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDonasiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            this.addLog();
            Dash_User DU = new Dash_User(this.user);
            DU.setVisible(true);
            this.dashUser.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Frame_Transaksi_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addLog() throws IOException {
        FileInputStream excelFile = new FileInputStream(new File("*/../src/Excel/DataTransaksi.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheet("Transaksi");
        
        CreationHelper createHelp = workbook.getCreationHelper();
        XSSFCellStyle cellType = (XSSFCellStyle) workbook.createCellStyle();
        cellType.setDataFormat(createHelp.createDataFormat().getFormat(("MMMM d, yyyy")));
        
        Random rn = new Random();
        String random = "" + rn.nextInt(10) + rn.nextInt(10) + rn.nextInt(10) + rn.nextInt(10) + rn.nextInt(10) + rn.nextInt(10);
        String orderID = null;
        
            Date date = new Date();
            Date orderDate = date;
            Date shipDate = addDays(orderDate, 3);
            
        switch((String)this.jComboBoxCountry.getSelectedItem()) {
            case "United States" : orderID = "US-2018" + "-" + random; break;
            case "Canada" : orderID = "CA-2018" + "-" + random; break;
        }
        
        String userID = new UserController().searchObject(this.user).getUserID();
        String shipMode = new ShipController().searchRevObject((String) this.jComboBoxShipping.getSelectedItem()).getShipID();
        String postalCode = jLabelPostalCode.getText();
        
        for(ModelKeranjang temp : this.keranjang) {
//            sheet.createRow(sheet.getLastRowNum() + 1);
            Row currentRow = sheet.createRow(sheet.getLastRowNum() + 1);
            for(int i = 0; i < 14; i++) {
                currentRow.createCell(i);
            }
            
            currentRow.getCell(0).setCellValue(sheet.getLastRowNum());
            currentRow.getCell(1).setCellValue(orderID);
            currentRow.getCell(2).setCellValue(orderDate);
            currentRow.getCell(3).setCellValue(shipDate);
            
            currentRow.getCell(2).setCellStyle(cellType);
            currentRow.getCell(3).setCellStyle(cellType);
            
            currentRow.getCell(4).setCellValue(shipMode);
            currentRow.getCell(5).setCellValue(userID);
            currentRow.getCell(6).setCellValue(Integer.parseInt(postalCode));
            currentRow.getCell(7).setCellValue(temp.getBarang().getProductID());
            currentRow.getCell(8).setCellValue((double) temp.getBarang().getPrice());
            currentRow.getCell(9).setCellValue(temp.getQty());
            currentRow.getCell(10).setCellValue((double) 0);
            currentRow.getCell(11).setCellValue((double) 0);
            currentRow.getCell(12).setCellValue(Double.parseDouble(this.jTextFieldDonasi.getText()));
            currentRow.getCell(13).setCellValue((double) temp.getTotal());
            
            System.out.println("All Done");
        }
        
        FileOutputStream fileOut = new FileOutputStream("*/../src/Excel/DataTransaksi.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
    
    private void jComboBoxShippingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxShippingItemStateChanged
        // TODO add your handling code here:
        if (jComboBoxShipping.getSelectedIndex() >= 0) {
            int id = jComboBoxShipping.getSelectedIndex();
            double subtotal = Double.parseDouble(this.jLabelSubTotal.getText().substring(1));
            double shipping = list.get(id).getPrice();
            double total = subtotal + shipping;

            this.jLabelShipping.setText("$" + shipping);
            this.jLabelTotal.setText("$" + total);
        }
    }//GEN-LAST:event_jComboBoxShippingItemStateChanged

    private void showRegion() throws IOException {
        TreeSet<String> list = new TreeSet<>();
        
        for(ModelDaerah temp : new DaerahController().getList()) {
            list.add(temp.getRegion());
        }
        
        this.jComboBoxRegion.removeAllItems();
        for(String temp : list) {
            this.jComboBoxRegion.addItem(temp);
        }
    }
    
    private void jComboBoxRegionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRegionItemStateChanged
        try {
            // TODO add your handling code here:
            TreeSet<String> list = new TreeSet<>();
            String searched = (String) jComboBoxRegion.getSelectedItem();
            
            for(ModelDaerah temp : new DaerahController().getList()) {
                if(temp.getRegion() == searched) {
                    list.add(temp.getCountry());
                }
            }
            
            jComboBoxCountry.removeAllItems();
            for(String temp : list) {
                this.jComboBoxCountry.addItem(temp);
            }
        } catch (IOException ex) {
            Logger.getLogger(Frame_Transaksi_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxRegionItemStateChanged

    private void jComboBoxCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCountryItemStateChanged
        try {
            // TODO add your handling code here:
            TreeSet<String> list = new TreeSet<>();
            String searched = (String) jComboBoxCountry.getSelectedItem();
            
            for(ModelDaerah temp : new DaerahController().getList()) {
                if(temp.getCountry()== searched) {
                    list.add(temp.getCity());
                }
            }
            
            jComboBoxCity.removeAllItems();
            for(String temp : list) {
                this.jComboBoxCity.addItem(temp);
            }
        } catch (IOException ex) {
            Logger.getLogger(Frame_Transaksi_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxCountryItemStateChanged

    private void jComboBoxCityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCityItemStateChanged
        try {
            // TODO add your handling code here:
            TreeSet<String> list = new TreeSet<>();
            String searched = (String) jComboBoxCity.getSelectedItem();
            
            for(ModelDaerah temp : new DaerahController().getList()) {
                if(temp.getCity() == searched) {
                    list.add(temp.getState());
                }
            }
            
            jComboBoxState.removeAllItems();
            for(String temp : list) {
                this.jComboBoxState.addItem(temp);
            }
        } catch (IOException ex) {
            Logger.getLogger(Frame_Transaksi_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxCityItemStateChanged

    private void jComboBoxStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxStateItemStateChanged
        try {
            // TODO add your handling code here:
            String searched = (String) jComboBoxState.getSelectedItem();
            String postalCode = null;
            
            for(ModelDaerah temp : new DaerahController().getList()) {
                if(temp.getState()== searched) {
                    postalCode = temp.getPostalCode();
                    break;
                }
            }
            
            this.jLabelPostalCode.setText(postalCode);
        } catch (IOException ex) {
            Logger.getLogger(Frame_Transaksi_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBoxStateItemStateChanged

    private void jTextFieldDonasiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldDonasiPropertyChange
        // TODO add your handling code here:
        this.jLabelJumlahBayar.setText(String.valueOf(Double.parseDouble(jLabelTotal.getText().substring(1)) + Double.parseDouble(jTextFieldDonasi.getText())));
    }//GEN-LAST:event_jTextFieldDonasiPropertyChange

    private void jTextFieldDonasiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDonasiKeyReleased
        // TODO add your handling code here:
        if(jTextFieldDonasi.getText().length() == 0) {
            jTextFieldDonasi.setText("0");
        }
        try {
            this.jLabelJumlahBayar.setText(String.valueOf(Double.parseDouble(jLabelTotal.getText().substring(1)) + Double.parseDouble(jTextFieldDonasi.getText())));
        } catch (NumberFormatException e) {
            jTextFieldDonasi.setText("0");
            this.jLabelJumlahBayar.setText(String.valueOf(Double.parseDouble(jLabelTotal.getText().substring(1)) + Double.parseDouble(jTextFieldDonasi.getText())));
        }
    }//GEN-LAST:event_jTextFieldDonasiKeyReleased

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JComboBox<String> jComboBoxCity;
    private javax.swing.JComboBox<String> jComboBoxCountry;
    private javax.swing.JComboBox<String> jComboBoxRegion;
    private javax.swing.JComboBox<String> jComboBoxShipping;
    private javax.swing.JComboBox<String> jComboBoxState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelJumlahBayar;
    private javax.swing.JLabel jLabelPostalCode;
    private javax.swing.JLabel jLabelQty1;
    private javax.swing.JLabel jLabelQty2;
    private javax.swing.JLabel jLabelShipping;
    private javax.swing.JLabel jLabelSubTotal;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextFieldDonasi;
    // End of variables declaration//GEN-END:variables
}

