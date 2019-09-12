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
public class PegawaiControl
{
     private Dao myDao = new Dao();
     
      public TableModel displayApoteker()
   {

       myDao.makeConnection();
       TableModel modelApoteker = new tblPegawai(myDao.showPegawai());
       myDao.closeConnection();
       return modelApoteker;
   }
    
   public TableModel displaySearchApoteker(String Search)
    {

       myDao.makeConnection();
       TableModel modelApoteker = new tblPegawai(myDao.showSearchPeg(Search));
       myDao.closeConnection();
       return modelApoteker;
    }
    
    public String GetApoteker()
     {
         myDao.makeConnection();
         String temp = myDao.getPegA();
         myDao.closeConnection();
         return temp;
     }
    
    public void InsertData(Apoteker A){
        myDao.makeConnection();
        myDao.insertPegawai(A);
        myDao.closeConnection();
    }
    
    public void DeletePeg(int key){
        myDao.makeConnection();
        myDao.deletePeg(key);
        myDao.closeConnection();
    }
    
    public void editPegawai(Apoteker A,String ID)
    {
        myDao.makeConnection();
        myDao.edit(A,ID);
        myDao.closeConnection();
    }
     
    public String Search(String key)
    {
        myDao.makeConnection();
        String temp=myDao.searchPeg(key);
        myDao.closeConnection();
       return temp;
    }  
}
