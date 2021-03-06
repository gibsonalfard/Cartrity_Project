/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;

/**
 *
 * @author Annazar
 */
public class Grid extends javax.swing.JPanel {

    /**
     * Creates new form Grid
     */
    public Grid() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNama = new javax.swing.JLabel();
        jLabelHarga = new javax.swing.JLabel();
        jLabelKategori = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jLabelImage = new javax.swing.JLabel();
        jmlBarang = new javax.swing.JSpinner();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        setMinimumSize(new java.awt.Dimension(370, 0));
        setPreferredSize(new java.awt.Dimension(370, 120));

        jLabelNama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNama.setText("NAMA BARANG");
        jLabelNama.setMaximumSize(new java.awt.Dimension(220, 30));
        jLabelNama.setMinimumSize(new java.awt.Dimension(220, 30));
        jLabelNama.setPreferredSize(new java.awt.Dimension(220, 30));

        jLabelHarga.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelHarga.setText("HARGA BARANG");
        jLabelHarga.setMaximumSize(new java.awt.Dimension(220, 30));
        jLabelHarga.setMinimumSize(new java.awt.Dimension(220, 30));
        jLabelHarga.setPreferredSize(new java.awt.Dimension(220, 30));

        jLabelKategori.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabelKategori.setText("KATEGORI BARANG");
        jLabelKategori.setMaximumSize(new java.awt.Dimension(220, 10));
        jLabelKategori.setMinimumSize(new java.awt.Dimension(220, 10));
        jLabelKategori.setPreferredSize(new java.awt.Dimension(220, 10));

        jButtonAdd.setText("ADD TO CART");
        jButtonAdd.setMaximumSize(new java.awt.Dimension(220, 35));
        jButtonAdd.setMinimumSize(new java.awt.Dimension(220, 35));
        jButtonAdd.setPreferredSize(new java.awt.Dimension(220, 35));

        jLabelImage.setToolTipText("");

        jmlBarang.setValue(new Integer(9));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jmlBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabelKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jmlBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JLabel jLabelHarga;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelKategori;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JSpinner jmlBarang;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jButtonAdd
     */
    public javax.swing.JButton getjButtonAdd() {
        return jButtonAdd;
    }

    /**
     * @return the jLabelBarang
     */
    public javax.swing.JLabel getjLabelHarga() {
        return jLabelHarga;
    }

    /**
     * @return the jLabelImage
     */
    public javax.swing.JLabel getjLabelImage() {
        return jLabelImage;
    }

    /**
     * @return the jLabelKategori
     */
    public javax.swing.JLabel getjLabelKategori() {
        return jLabelKategori;
    }

    public javax.swing.JSpinner getJSpinnerJml() {
        return jmlBarang;
    }

    /**
     * @return the jLabelNama
     */
    public javax.swing.JLabel getjLabelNama() {
        return jLabelNama;
    }
}
