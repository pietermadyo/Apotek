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
public class tblTransaksi  extends AbstractTableModel
{
    
  
        private final List<detail_transaksi> list;

        public tblTransaksi(List<detail_transaksi> list)
        {
            this.list=list;
        }

        @Override
        public int getRowCount()
        {
            return list.size();
        }
        @Override
        public int getColumnCount(){
            return 5;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getObat().getId();
                case 1:
                    return list.get(rowIndex).getObat().getNama();
                case 2:
                    return list.get(rowIndex).getObat().getHarga();
                case 3 :
                    return list.get(rowIndex).getJml();
                case 4 :
                    return list.get(rowIndex).getTotal_harga();
                default:
                    return null;
            }
        }
        @Override
        public String getColumnName(int column) {
            switch (column){
                case 0:
                    return "ID";
                case 1:
                    return "Nama Obat"; 
                case 2 :
                    return "Harga";
                case 3 :
                    return "Jumlah";
                case 4 :
                    return "Total Harga";          
                default:
                    return null;
            }
        }

}
