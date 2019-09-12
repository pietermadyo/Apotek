/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import java.util.ArrayList;
/**
 *
 * @author pieter
 */
public class Transaksi {
    private int id = -1;
    private double total_bayar;
    private double bayar;
    private double kembalian;
    private String tanggal;
    private ArrayList<detail_transaksi> list;
    
    public Transaksi(){
        
    }
    //buat ambil dari database beda di id, dari database ada id transaksi
    public Transaksi(int id, double total_bayar, double bayar, double kembalian, String tanggal, ArrayList<detail_transaksi> list){
        this.tanggal = tanggal;
        this.id = id; this.total_bayar = total_bayar; this.bayar = bayar; this.kembalian = kembalian; this.list = list;
    }
    
    //input ke database , ga perlu id, id di generate di database
    public Transaksi(double total_bayar, double bayar, double kembalian, String tanggal,ArrayList<detail_transaksi> list){
        this.tanggal = tanggal;
        this.total_bayar = total_bayar; this.bayar = bayar; this.kembalian = kembalian; this.list = list;
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

    /**
     * @return the total_bayar
     */
    public double getTotal_bayar() {
        return total_bayar;
    }

    /**
     * @param total_bayar the total_bayar to set
     */
    public void setTotal_bayar(double total_bayar) {
        this.total_bayar = total_bayar;
    }

    /**
     * @return the bayar
     */
    public double getBayar() {
        return bayar;
    }

    /**
     * @param bayar the bayar to set
     */
    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    /**
     * @return the kembalian
     */
    public double getKembalian() {
        return kembalian;
    }

    /**
     * @param kembalian the kembalian to set
     */
    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }

    /**
     * @return the list
     */
    public ArrayList<detail_transaksi> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<detail_transaksi> list) {
        this.list = list;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
