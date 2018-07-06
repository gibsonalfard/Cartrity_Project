/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Gibran
 */
public class ModelKategori {

    /**
     * @return the id_kategori
     */
    public String getId_kategori() {
        return id_kategori;
    }

    /**
     * @param id_kategori the id_kategori to set
     */
    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    /**
     * @return the kategori
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
    
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String id_kategori;
    private String kategori;
}
