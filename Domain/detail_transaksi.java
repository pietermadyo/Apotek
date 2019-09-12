/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author pieter
 */
public class detail_transaksi {
    private int id;
    private Obat obat;
    private int jml;
    private double total_harga;
    
    public detail_transaksi(Obat obat, int juml, double total_harga){
        this.obat = obat;
        this.jml = juml;
        this.total_harga = total_harga;
    }
    
     public detail_transaksi(int id, Obat obat, int juml, double total_harga){
         this.id = id;
        this.obat = obat;
        this.jml = juml;
        this.total_harga = total_harga;
    }
     
     
    
    /**
     * @return the obat
     */
    public Obat getObat() {
        return obat;
    }

    /**
     * @param obat the obat to set
     */
    public void setObat(Obat obat) {
        this.obat = obat;
    }

    /**
     * @return the jenis
     */
  

    /**
     * @return the total_harga
     */
    public double getTotal_harga() {
        return total_harga;
    }

    /**
     * @param total_harga the total_harga to set
     */
    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }

    /**
     * @return the jml
     */
    public int getJml() {
        return jml;
    }

    /**
     * @param jml the jml to set
     */
    public void setJml(int jml) {
        this.jml = jml;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
