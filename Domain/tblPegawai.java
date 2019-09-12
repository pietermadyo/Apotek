/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author pieter
 */
public class tblPegawai extends AbstractTableModel
{
    private List<Apoteker> list;
    
    public tblPegawai(List<Apoteker> list)
    {
        this.list=list;
    }
    
    public int getRowCount()
    {
        return list.size();
    }
    public int getColumnCount(){
        return 7;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3 :
                return list.get(rowIndex).getUmur();
            case 4 :
                return list.get(rowIndex).getJabatan();
            case 5 :
                return list.get(rowIndex).getJamKerja();
            case 6 :
                return list.get(rowIndex).hitBonus();
            default:
                return null;
        }
    }
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama"; 
            case 2 :
                return "Alamat";
            case 3 :
                return "Umur";
            case 4 :
                return "Jabatan";
            case 5 :
                return "Jam Kerja";
            case 6 :
                return "Gaji";
            default:
                return null;
        }
    }
    
}
