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
public class tblObat extends AbstractTableModel
{
    private List<Obat> list;
    
    public tblObat(List<Obat> list)
    {
        this.list=list;
    }
    
    public int getRowCount()
    {
        return list.size();
    }
    public int getColumnCount(){
        return 6;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getKategori();
            case 3 :
                return list.get(rowIndex).getStok();
            case 4 :
                return list.get(rowIndex).getStatus();
            case 5 :
                return list.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama Obat"; 
            case 2 :
                return "Kategori";
            case 3 :
                return "Stok ";
            case 4 :
                return "Status";
            case 5 :
                return "Harga";          
            default:
                return null;
        }
    }
    
}
