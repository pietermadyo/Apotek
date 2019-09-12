/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Robertus Pamungkas
 */
public class User {
    private int ID;
    private String user;
    private String pass;
    private int role;
    private String peran;
    
    public User(String user,String pass, int role,int ID,String peran){
        this.pass=pass;
        this.role=role;
        this.user=user;
        this.ID=ID;
        this.peran=peran;
        
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the peran
     */
    public String getPeran() {
        return peran;
    }

    /**
     * @param peran the peran to set
     */
    public void setPeran(String peran) {
        this.peran = peran;
    }
    
      
}
