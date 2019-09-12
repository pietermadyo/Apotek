/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.*;
import Domain.*;
import javax.swing.table.TableModel;

/**
 *
 * @author pieter
 */
public class ObatControl 
{
    private Dao myDao = new Dao();
    public ObatControl(){}
    
    
    public TableModel displayObat()
   {

       myDao.makeConnection();
       TableModel modelObat = new tblObat(myDao.showObat());
       myDao.closeConnection();
       return modelObat;
   }
    
   public TableModel displaySearchObat(String Search)
    {

       myDao.makeConnection();
       TableModel modelObat = new tblObat(myDao.showSearch(Search));
       myDao.closeConnection();
       return modelObat;
    }
    
    public String GetObat()
    {
        myDao.makeConnection();
        String role = myDao.getObat();
        myDao.closeConnection();
        return role;
    }
    
    public void InsertData(Obat O){
        myDao.makeConnection();
        myDao.insertObat(O);
        myDao.closeConnection();
    }
    
    public void Delete(int key){
        myDao.makeConnection();
        myDao.delete(key);
        myDao.closeConnection();
    }
    
    public void editObat(Obat obat,String ID)
    {
        myDao.makeConnection();
        myDao.edit(obat,ID);
        myDao.closeConnection();
    }
     
    public String Search(String key)
    {
        myDao.makeConnection();
        String role=myDao.search(key);
        myDao.closeConnection();
       return role;
    }  
}
