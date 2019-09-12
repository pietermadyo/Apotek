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
public class Pegawai
{
    private String nama,alamat,Jabatan;
    private int umur,id;
    private double gaji_pokok;
   
    
    public Pegawai(String nama,String alamat,int umur,double gaji_pokok,int id,String jabatan)
    {
        this.nama=nama;       
        this.umur=umur;
        this.alamat=alamat;
        this.gaji_pokok=gaji_pokok;
        this.id=id;
        this.Jabatan=jabatan;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the Jabatan
     */
    public String getJabatan() {
        return Jabatan;
    }

    /**
     * @param Jabatan the Jabatan to set
     */
    public void setJabatan(String Jabatan) {
        this.Jabatan = Jabatan;
    }

    /**
     * @return the umur
     */
    public int getUmur() {
        return umur;
    }

    /**
     * @param umur the umur to set
     */
    public void setUmur(int umur) {
        this.umur = umur;
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
     * @return the gaji_pokok
     */
    public double getGaji_pokok() {
        return gaji_pokok;
    }

    /**
     * @param gaji_pokok the gaji_pokok to set
     */
    public void setGaji_pokok(double gaji_pokok) {
        this.gaji_pokok = gaji_pokok;
    }
    
   

    
    
}
