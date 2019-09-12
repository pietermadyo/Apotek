/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Dao;
import Domain.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.TableModel;

/**
 *
 * @author Robertus Pamungkas
 */
public class UserControl {
    private Dao myDao = new Dao();
    public UserControl(){}
    
    
    public TableModel displayUser()
   {
       myDao.makeConnection();
       TableModel modelUser = new tblUser(myDao.showUser());
       myDao.closeConnection();
       return modelUser;
   }
    
    public String GetUser()
     {
         myDao.makeConnection();
         String role = myDao.getUser();
         myDao.closeConnection();
         return role;
     }
    
     public void InsertUser(User O){
        myDao.makeConnection();
        myDao.insertUser(O);
        myDao.closeConnection();
    }
    
    public void DeleteUser(int key){
        myDao.makeConnection();
        myDao.deleteuser(key);
        myDao.closeConnection();
    }
    
    public void edituser(User user,int id)
    {
        myDao.makeConnection();
        myDao.edituser(user,id);
        myDao.closeConnection();
    }
    
     public ArrayList<Obat> getObat(){
        ArrayList<Obat> obat;
        myDao.makeConnection();
        obat = (ArrayList<Obat>) myDao.showObat();
        myDao.closeConnection();
        
        return obat;
    }
    
    public void insertTransaksi(Transaksi t) throws SQLException{
        myDao.makeConnection();
        myDao.insertTransaksi(t);
        myDao.closeConnection();
    }
    
     public int cekadmin()
    {
        myDao.makeConnection();
        int rolle= myDao.cekadmin();
        myDao.closeConnection();
        return rolle;
    }
    
    public int ceknama(String un)
    {
        myDao.makeConnection();
        int rolle= myDao.ceknama(un);
        myDao.closeConnection();
        return rolle;
    }
}
