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
 * @author Robertus Pamungkas
 */
public class tblUser extends AbstractTableModel {
    private List<User> list;
    
    public tblUser(List<User> list)
    {
        this.list=list;
    }
    
    public int getRowCount()
    {
        return list.size();
    }
    public int getColumnCount(){
        return 4;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getID();
            case 1:
                return list.get(rowIndex).getUser();
            case 2:
                return list.get(rowIndex).getPass();          
            case 3:
                return list.get(rowIndex).getPeran();
             default:
                return null;
        }
    }
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "User";
            case 2:
                return "Password";           
            case 3:
                return "Peran";
            default:
                return null;
        }
    }
}
