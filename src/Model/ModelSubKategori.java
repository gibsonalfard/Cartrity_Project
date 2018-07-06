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
public class ModelSubKategori {

    /**
     * @return the id_sub
     */
    public String getId_sub() {
        return id_sub;
    }

    /**
     * @param id_sub the id_suB to set
     */
    public void setId_sub(String id_suB) {
        this.id_sub = id_suB;
    }

    /**
     * @return the kategori
     */
    public ModelKategori getKategori() {
        return kategori;
    }

    /**
     * @param kategori the kategori to set
     */
    public void setKategori(ModelKategori kategori) {
        this.kategori = kategori;
    }

    /**
     * @return the subKategori
     */
    public String getSubKategori() {
        return subKategori;
    }

    /**
     * @param subKategori the subKategori to set
     */
    public void setSubKategori(String subKategori) {
        this.subKategori = subKategori;
    }
    
    /**
     * @return the imageSource
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * @param imageSource the imageSource to set
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }
    
    public static final String FILE_NAME = "*/../src/Excel/DataTransaksi.xlsx";
    
    private String id_sub;
    private ModelKategori kategori;
    private String subKategori;
    private String imageSource;
}
