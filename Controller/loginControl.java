/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Dao.*;
/**
 *
 * @author pieter
 */
public class loginControl 
{
     private Dao dao = new Dao();
     public int CekLogin(String un, String pass)
     {
        
         dao.makeConnection();
         int role= dao.cekLogin(un,pass); 
         dao.closeConnection();
         if(role==1)
         {
             return 1;
         }
         else
         {
             return 0;
         }  
     }
     
  public int role(String un, String pass){
      int a=0;
         dao.makeConnection();
         a= dao.getRolle(un,pass); 
         dao.closeConnection();
         return a;
  }
     
}
