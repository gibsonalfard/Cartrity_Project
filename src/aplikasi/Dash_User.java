/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

import Controller.KeranjangController;
import Model.ModelKeranjang;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Gibran
 */
public class Dash_User extends javax.swing.JFrame {

    int start;
    int end;
    int max = 0;
    
    String user;
    int shipMode;
    List<ModelKeranjang> shopCart = new KeranjangController().getList();
    double jambleh = new KeranjangController().getTotal();

    /**
     * Creates new form Dash_User
     */
//    public Dash_User() {
//        initComponents();
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
////        userLabel.setText(username);
////        start = 0;
////        end = 15;
////        Frame_Grid_Barang grid = new Frame_Grid_Barang();
////
////        max = max == 0 ? grid.getMax() : max;
////
////        konten.removeAll();
////        konten.add(grid);
////        grid.setVisible(true);
////        
////        btnPrev.setEnabled(this.start > 0);
//    }
    void immove(JInternalFrame a){
        BasicInternalFrameUI ui = (BasicInternalFrameUI)a.getUI();
        Component north = ui.getNorthPane();
        MouseMotionListener[] actions =
        (MouseMotionListener[])north.getListeners(MouseMotionListener.class);

        for (int i = 0; i < actions.length; i++)
        north.removeMouseMotionListener( actions[i] ); 
    }
    public Dash_User(String username) throws IOException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.user = username;
        userLabel.setText(username);
        start = 0;
        end = 15;
        Frame_Grid_Barang grid = new Frame_Grid_Barang();

        max = max == 0 ? grid.getMax() : max;

        konten.removeAll();
        konten.add(grid);
        grid.setVisible(true);
        
        this.a_transaksi.setEnabled(false);
        
        for(MouseListener temp : this.a_transaksi.getMouseListeners()) {
            this.a_transaksi.removeMouseListener(temp);
        }
        
//        btnPrev.setEnabled(this.start > 0);
    }
    
    
    public Dash_User(String username, int shipMode) throws IOException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.user = username;
        this.shipMode = shipMode;
        userLabel.setText(username);
        start = 0;
        end = 15;
        Frame_Grid_Barang grid = new Frame_Grid_Barang();

        max = max == 0 ? grid.getMax() : max;

        konten.removeAll();
        konten.add(grid);
        grid.setVisible(true);
        
        this.makeTransaction(shipMode);
        this.a_keranjang.setEnabled(false);
        this.a_shop.setEnabled(false);
        this.FilterButton.setEnabled(false);
        this.FilterButton1.setEnabled(false);
        this.SearchButton.setEnabled(false);
        
        for(MouseListener temp : this.a_keranjang.getMouseListeners()) {
            this.a_keranjang.removeMouseListener(temp);
        }
        
        for(MouseListener temp : this.a_shop.getMouseListeners()) {
            this.a_shop.removeMouseListener(temp);
        }
        
        for(MouseListener temp : this.FilterButton.getMouseListeners()) {
            this.FilterButton.removeMouseListener(temp);
        }
        
        for(MouseListener temp : this.FilterButton1.getMouseListeners()) {
            this.FilterButton1.removeMouseListener(temp);
        }
        
        for(MouseListener temp : this.SearchButton.getMouseListeners()) {
            this.SearchButton.removeMouseListener(temp);
        }
      
//        btnPrev.setEnabled(this.start > 0);
    }
    
    public JPanel getKonten() {
        return this.konten;
    }
    
    public JLabel getUserLabel(){
        return this.userLabel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        a_keranjang = new javax.swing.JLabel();
        SearchButton = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        a_login = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FilterButton = new javax.swing.JLabel();
        a_shop = new javax.swing.JLabel();
        a_transaksi = new javax.swing.JLabel();
        FilterButton1 = new javax.swing.JLabel();
        konten = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(218, 238, 224));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(147, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N

        a_keranjang.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        a_keranjang.setForeground(new java.awt.Color(0, 0, 51));
        a_keranjang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping-bag.png"))); // NOI18N
        a_keranjang.setText("Keranjang");
        a_keranjang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a_keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_keranjangMouseClicked(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(0, 0, 51));
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifier.png"))); // NOI18N
        SearchButton.setText("Search");
        SearchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchButtonMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        jLabel2.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(218, 238, 224));
        jLabel2.setText("Kelompok 1 - Proyek 1");

        jLabel3.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(218, 238, 224));
        jLabel3.setText("D4 - Teknik Informatika");

        jLabel4.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(218, 238, 224));
        jLabel4.setText("JTK POLBAN 2017");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        a_login.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        a_login.setForeground(new java.awt.Color(0, 0, 51));
        a_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        a_login.setText("Logout");
        a_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_loginMouseClicked(evt);
            }
        });

        userLabel.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 51));
        userLabel.setText("Hallo Username !");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mansmall.png"))); // NOI18N

        FilterButton.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        FilterButton.setForeground(new java.awt.Color(0, 0, 51));
        FilterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/filter.png"))); // NOI18N
        FilterButton.setText("Filter");
        FilterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterButtonMouseClicked(evt);
            }
        });

        a_shop.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        a_shop.setForeground(new java.awt.Color(0, 0, 51));
        a_shop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping-cart.png"))); // NOI18N
        a_shop.setText("Shopping");
        a_shop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        a_shop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_shopMouseClicked(evt);
            }
        });

        a_transaksi.setForeground(new java.awt.Color(0, 0, 51));
        a_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaction.png"))); // NOI18N
        a_transaksi.setText("Transaction");
        a_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                a_transaksiMouseClicked(evt);
            }
        });

        FilterButton1.setFont(new java.awt.Font("Roboto Condensed", 0, 12)); // NOI18N
        FilterButton1.setForeground(new java.awt.Color(0, 0, 51));
        FilterButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reload.png"))); // NOI18N
        FilterButton1.setText("Refresh");
        FilterButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FilterButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FilterButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(a_keranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a_shop, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(a_login)
                                .addComponent(a_transaksi)
                                .addComponent(FilterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(a_shop, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_keranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(a_transaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(a_login)
                .addGap(74, 74, 74)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        konten.setBackground(new java.awt.Color(250, 250, 250));
        konten.setPreferredSize(new java.awt.Dimension(1220, 367));

        javax.swing.GroupLayout kontenLayout = new javax.swing.GroupLayout(konten);
        konten.setLayout(kontenLayout);
        kontenLayout.setHorizontalGroup(
            kontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        kontenLayout.setVerticalGroup(
            kontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(konten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addComponent(konten, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void a_keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_keranjangMouseClicked
        Frame_Keranjang fk = new Frame_Keranjang(shopCart,1,5,user, this);
        immove(fk);
        konten.removeAll();
        konten.add(fk);
        fk.setVisible(true);
    }//GEN-LAST:event_a_keranjangMouseClicked


    private void SearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMouseClicked
        Search search = new Search(this);
        search.setLocationRelativeTo(null);
        search.setVisible(true);
        search.setAlwaysOnTop(true);
//        search.reveal();
    }//GEN-LAST:event_SearchButtonMouseClicked

    private void a_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_barangMouseClicked
        //Frame_Barang fb = new Frame_Barang(false);
        Frame_Grid_Barang grid = new Frame_Grid_Barang();
        konten.removeAll();
        konten.add(grid);
        grid.setVisible(true);
    }//GEN-LAST:event_a_barangMouseClicked

    private void a_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_loginMouseClicked
        Login l = new Login();
        this.hide();
        l.setVisible(true);
    }//GEN-LAST:event_a_loginMouseClicked

    private void FilterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterButtonMouseClicked
        Filter filter = new Filter(this);
        filter.setLocationRelativeTo(null);
        filter.setVisible(true);
        filter.setAlwaysOnTop(true);
    }//GEN-LAST:event_FilterButtonMouseClicked

    private void a_shopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_shopMouseClicked
        Frame_Grid_Barang grid = new Frame_Grid_Barang();
        konten.removeAll();
        konten.add(grid);
        grid.setVisible(true);
    }//GEN-LAST:event_a_shopMouseClicked

    private void FilterButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilterButton1MouseClicked
        // TODO add your handling code here:
        start = 0;
        end = 15;
        Frame_Grid_Barang grid = new Frame_Grid_Barang();

        max = max == 0 ? grid.getMax() : max;

        konten.removeAll();
        konten.add(grid);
        grid.setVisible(true);
    }//GEN-LAST:event_FilterButton1MouseClicked

    private void a_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_a_transaksiMouseClicked
        this.makeTransaction(this.shipMode);
    }//GEN-LAST:event_a_transaksiMouseClicked

    private void makeTransaction(int shipMode) {
        try {
            // TODO add your handling code here:
            Frame_Transaksi_User fk = new Frame_Transaksi_User(shopCart,1,5,user,shipMode,this);
            immove(fk);
            konten.removeAll();
            konten.add(fk);
            fk.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Dash_User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dash_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dash_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dash_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dash_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Dash_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FilterButton;
    private javax.swing.JLabel FilterButton1;
    private javax.swing.JLabel SearchButton;
    private javax.swing.JLabel a_keranjang;
    private javax.swing.JLabel a_login;
    private javax.swing.JLabel a_shop;
    private javax.swing.JLabel a_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel konten;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}