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
public class Apoteker extends Pegawai implements IHitungBonus,IHitGaji
{
    private int jamKerja;
    private double bonus;
    
    public Apoteker(String nama,String alamat,int umur,double gaji_pokok,int id,String jabatan,int jamKerja)
    {
        super( nama, alamat, umur, gaji_pokok, id, jabatan);
        this.jamKerja=jamKerja;
    }
    
    public double hitBonus()
    {
        double hasil=0;
        if(HitGaji()>500000)
        {
            hasil=getGaji_pokok()+HitGaji()+1000000;
        }else
        {
            hasil=getGaji_pokok()+HitGaji()+500000;
        }
       return hasil;
    }
    
    public double HitGaji()
    {
       double hasil=0;
       if(getJamKerja()==12)
        {
            hasil=500000+getGaji_pokok();
        }else
        {
            hasil=250000+getGaji_pokok();
        }
        return hasil;
    }
    /**
     * @return the jamKerja
     */
    public int getJamKerja() {
        return jamKerja;
    }

    /**
     * @param jamKerja the jamKerja to set
     */
    public void setJamKerja(int jamKerja) {
        this.jamKerja = jamKerja;
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
