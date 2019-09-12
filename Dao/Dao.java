/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import static Dao.Dao.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import Domain.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;



public class Dao 
{
    public static Connection con;
    public static final String url ="jdbc:ucanaccess://";
    public static final String path="F:"+File.separator+"apotik.mdb";
    
    
    //==== Tampil Table
     public List<Obat> showObat() 
     {       
       
        String sql ="SELECT tbl_obat.ID,tbl_obat.Nama,tbl_obat.Kategori,tbl_obat.Status,tbl_obat.Stok,tbl_obat.Harga from tbl_obat";
        
        System.out.println("Daftar Obat...");
        List<Obat> list = new ArrayList<Obat>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next())
                {                   
                    Obat obat = new Obat(rs.getInt("ID"),rs.getString("Kategori"), rs.getString("Nama"),rs.getInt("Stok"),rs.getString("Status"),rs.getDouble("Harga"));
                    list.add(obat);
                }
            }
            rs.close();
            statement.close();

        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return list;
    }
     
    public List<Obat> showSearch(String Search) {
        String sql = "SELECT tbl_obat.ID,tbl_obat.Nama,tbl_obat.Kategori,tbl_obat.Status,tbl_obat.Stok,tbl_obat.Harga from tbl_obat WHERE (Nama Like '%" + Search + "%') OR (ID Like '%" + Search + "%') OR (Kategori Like '%" + Search + "%') OR (Status Like '%" + Search + "%') ";
        System.out.println("Daftar Obat...");
        List<Obat> list = new ArrayList<Obat>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Obat obat = new Obat(rs.getInt("ID"),rs.getString("Kategori"), rs.getString("Nama"),rs.getInt("Stok"),rs.getString("Status"),rs.getDouble("Harga"));
                    list.add(obat);
                }
            }
            rs.close();
            statement.close();

        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return list;
    }
    //====================================================== 
    public void makeConnection()
    {
        System.out.println("Opening Database...");
        try
        {
           //Class.forName(driver);
            con=DriverManager.getConnection(url+path);
            System.out.println("Success !\n");   
        }catch(Exception ex){
            System.out.println("Error opening the database...");
            System.out.println(ex);
        }
    }
    
    public void closeConnection()
    {
       System.out.println("Closing database...");
        try{
              con.close();
            System.out.println("Success!\n");
        }catch(Exception ex){
            System.out.println("Error Closing the database...");
            System.out.println(ex);
        }
    }
    //====================================================================
    
    
    public int cekLogin(String un, String pass)
    {
         int hasil=0;
        String sql = "select username,password from tbl_user where username='"+un+"' and password='"+pass+"'";
        
        try{
            Statement statement=con.createStatement();                   
            ResultSet rs=statement.executeQuery(sql);
            if(rs!=null)
            {
                 while(rs.next())
                {
                    hasil=1;
                    System.out.println("Login berhasil");
                }
            }
            statement.close();
            rs.close();
        }catch(Exception ex){
            System.out.println("Error Login a user...");
            System.out.println(ex);
        }
       return hasil;
       
    }
    
    public int getRolle(String un, String pass)
    {
        int hasil=0;
        String sql = "select * from tbl_user";
        
        try{
            Statement statement=con.createStatement();                   
            ResultSet rs=statement.executeQuery(sql);
            if(rs!=null)
            {
                while(rs.next())
                {
                    if(rs.getString("username").equalsIgnoreCase(un))
                    {
                      hasil=rs.getInt("rolle");
                      System.out.println("hasil : "+hasil);
                    }
                }
            }
            statement.close();
            rs.close();
        }catch(Exception ex){
            System.out.println("Error Login a user...");
            System.out.println(ex);
        }
       return hasil;
       
    }
    public String getObat()
    {
        String hasil="";
        String sql = "select Nama,Kategori,Status,Stok,Harga from tbl_obat";
        try{
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);                     
            if(rs!=null){
                while (rs.next()){
                    hasil += "=== NAMA OBAT ==="+"\n"+
                            "Nama :  "+rs.getString("Nama")+"\n"+
                            "Kategori: "+rs.getString("Kategori")+"\n"+
                            "Status:   "+rs.getString("Status")+"\n"+
                            "Stok:  "+rs.getString("Stok")+"\n"+
                            "Harga:  "+rs.getString("Harga")+"\n"+
                            "\n";
                }
            }
            rs.close();
            state.close();
        }catch(Exception ex){
            System.out.println("Error Reading From database. . .");
            System.out.println(ex);
        }
        System.out.println(hasil);
        return hasil;
    }
    
    public void insertObat(Obat O)
    {
        String sql = "INSERT INTO tbl_obat(Nama,Kategori,Status,Stok,Harga) VALUES"
                +"('"+O.getNama()+
                "','"+O.getKategori()+
                "','"+O.getStatus()+
                "','"+O.getStok()+
                "','"+O.getHarga()+
                "')";
        System.out.println("Adding user...");
        try{
            Statement state =con.createStatement();
            int result =state.executeUpdate(sql);
            System.out.println("Added"+result+"user\n");
            state.close();
        }catch(Exception ex){
            System.out.println("Error Adding a user...");
            System.out.println(ex);
        }
    }
    
    public void edit(Obat obat, String ID) {
        String sql = "UPDATE tbl_obat SET id='" + obat.getId() + 
                "',Nama='" + obat.getNama() + "',Kategori='" + obat.getKategori() +
                "',Status='" + obat.getStatus() + 
                "',Stok='" +obat.getStok() + "',Harga='" + obat.getHarga() + "' where id='" + ID + "'";
        System.out.println("Edit Obat");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit" + result + "Obat\n" + ID);
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error edit a Obat...\n");
            System.out.println(Ex);
        }
    }
    
    public String search(String key)
    {
        String hasil="";
        String sql="SELECT Nama,Kategori,Status,Stok,Harga FROM tbl_obat"
                + "  WHERE Nama Like '%"+ key +"%' OR Kategori Like '%"+ key +"%' OR Status Like '%"+ key +"%'  ";
        System.out.println("Daftar Barang...");
        
        try
        {
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);                     
            if(rs!=null){
                while (rs.next()){
                    hasil += 
                            "=== NAMA OBAT ==="+"\n"+
                            "  "+rs.getString("Nama")+"\n"+
                            "  "+rs.getString("Kategori")+"\n"+
                            "  "+rs.getString("Status")+"\n"+
                            "  "+rs.getString("Stok")+"\n"+
                            "  "+rs.getString("Harga")+"\n"+
                            "\n";
                }
            }
            rs.close();
            state.close();

        }
        catch(Exception Ex)
        {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
         return hasil;
   
    }
    
    public void delete(int key)
    {
        String sql="DELETE FROM tbl_obat WHERE ID  Like '%"+ key +"%'";
        System.out.println("Delete Barang ");
        try{
            Statement statement=con.createStatement();                  
            int result=statement.executeUpdate(sql);
            System.out.println("Delete"+result+"Barang\n");
            statement.close();
        }
        catch(Exception Ex){
            System.out.println("Error deleting a Barang...\n");
            System.out.println(Ex);
        }
    }
    //=======================================================
   //User Dao 
       
    public void insertUser(User a)
    {
        String sql = "INSERT INTO tbl_user(username,password,rolle) VALUES"
                +"('"+a.getUser()+
                "','"+a.getPass()+
                "','"+a.getRole()+"')";
        System.out.println("Adding user...");
        try{
            Statement state =con.createStatement();
            int result =state.executeUpdate(sql);
            System.out.println("Added"+result+"user\n");
            state.close();
        }catch(Exception ex){
            System.out.println("Error Adding a user...");
            System.out.println(ex);
        }
    }
    
    
    
    public void deleteuser(int key)
    {
        String sql="DELETE FROM tbl_user WHERE ID  Like '%"+ key +"%'";
        System.out.println("Delete user ");
        try{
            Statement statement=con.createStatement();                  
            int result=statement.executeUpdate(sql);
            System.out.println("Delete"+result+"user\n");
            statement.close();
        }
        catch(Exception Ex){
            System.out.println("Error deleting a user...\n");
            System.out.println(Ex);
        }
    }
    
     public void edituser(User a, int user) {
        String sql = "UPDATE tbl_user SET username ='" + a.getUser()+ 
                "',password='" + a.getPass() + "',rolle='" + a.getRole()+"'where ID='"+user+"'" ;
        System.out.println("Edit User");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit" + result + "user\n" + user);
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error edit a user...\n");
            System.out.println(Ex);
        }
    }
    
     public String getUser()
    {
        String hasil="";
        String sql = "select username, password, rolle from tbl_user";
        try{
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);                     
            if(rs!=null){
                while (rs.next()){
                    hasil += "=== NAMA user ==="+"\n"+
                            "user :  "+rs.getString("username")+"\n"+
                            "password: "+rs.getString("password")+"\n"+
                            "rolle:   "+rs.getString("rolle")+"\n"+
                            "\n";
                }
            }
            rs.close();
            state.close();
        }catch(Exception ex){
            System.out.println("Error Reading From database. . .");
            System.out.println(ex);
        }
        System.out.println(hasil);
        return hasil;
    }
    
    public List<User> showUser() 
     {       
       
        String sql ="SELECT tbl_user.ID, tbl_user.username,tbl_user.password,tbl_user.rolle,tbl_peran.peran from tbl_user inner join tbl_peran on tbl_user.rolle=tbl_peran.ID";
        
        System.out.println("Daftar user...");
        List<User> list = new ArrayList<User>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next())
                {                   
                    User user = new User(rs.getString("username"),rs.getString("password"), rs.getInt("rolle"),rs.getInt("ID"),rs.getString("peran"));
                    list.add(user);
                }
            }
            rs.close();
            statement.close();

        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return list;
    } 
    
    //==========================================
    //Pegawai
     public String getPegA()
    {
        String hasil="";
        String sql = "select id,nama,alamat,umur,gaji,jabatan,jamkerja from tbl_pegawai";
        try{
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);                     
            if(rs!=null){
                while (rs.next()){
                    hasil += "=== NAMA Pegawai ==="+"\n"+
                            "Nama :  "+rs.getString("Nama")+"\n"+
                            "Alamat: "+rs.getString("Alamat")+"\n"+
                            "Umur:   "+rs.getString("Umur")+"\n"+
                            "Jabatan:  "+rs.getString("Jabatan")+"\n"+
                            "Gaji:  "+rs.getDouble("Gaji")+"\n"+
                            "Jam-Kerja:  "+rs.getInt("jamkerja")+"\n"+
                            "\n";
                }
            }
            rs.close();
            state.close();
        }catch(Exception ex){
            System.out.println("Error Reading From database. . .");
            System.out.println(ex);
        }
        System.out.println(hasil);
        return hasil;
    }
     
    public void insertPegawai(Apoteker A)
    {
        String sql = "INSERT INTO tbl_pegawai(nama,alamat,umur,jabatan,gaji,jamkerja) VALUES"
                +"('"+A.getNama()+
                "','"+A.getAlamat()+
                "','"+A.getUmur()+
                "','"+A.getJabatan()+
                "','"+A.hitBonus()+
                "','"+A.getJamKerja()+
                "')";
        System.out.println("Adding Pegawai...");
        try{
            Statement state =con.createStatement();
            int result =state.executeUpdate(sql);
            System.out.println("Added"+result+"user\n");
            state.close();
        }catch(Exception ex){
            System.out.println("Error Adding a user...");
            System.out.println(ex);
        }
    }
    
    public List<Apoteker> showPegawai() 
     {       
       
        String sql ="SELECT tbl_pegawai.id,tbl_pegawai.nama,tbl_pegawai.alamat,tbl_pegawai.umur,tbl_pegawai.gaji,tbl_pegawai.jabatan,tbl_pegawai.jamkerja from tbl_pegawai";
        
        System.out.println("Daftar Pegawai...");
        List<Apoteker> list = new ArrayList<Apoteker>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next())
                {         
                    Apoteker A = new Apoteker(
                    rs.getString("nama"),
                    rs.getString("alamat"), 
                    rs.getInt("umur"),
                    rs.getDouble("gaji"),
                    rs.getInt("id"),
                    rs.getString("jabatan"),
                    rs.getInt("jamkerja")
                    );
                    list.add(A);
                }
            }
            rs.close();
            statement.close();

        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return list;
    }
    
    public void edit(Apoteker A, String ID) {
        String sql = "UPDATE tbl_pegawai SET "
                + "id='" + A.getId() + 
                "',nama='" + A.getNama() +
                "',alamat='" + A.getAlamat()+
                "',umur='" + A.getUmur()+ 
                "',gaji='" + A.getGaji_pokok()+ 
                "',jabatan='" +A.getJabatan()+
                "' where id='" + ID + "'";
        System.out.println("Edit Pegawai");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edit" + result + "Pegawai\n" + ID);
            statement.close();
        } catch (Exception Ex) {
            System.out.println("Error edit a Pegawai...\n");
            System.out.println(Ex);
        }
    }
    
    public String searchPeg(String key)
    {
        String hasil="";
        String sql="SELECT id,nama,alamat,umur,gaji,jabatan,jamkerja FROM tbl_pegawai"
                + "  WHERE id Like '%"+ key +"%' OR nama Like '%"+ key +"%' OR alamat Like '%"+ key +"%' OR jabatan Like '%"+ key +"%'  ";
        System.out.println("Daftar Pegawai...");
        
        try
        {
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);                     
            if(rs!=null){
                while (rs.next()){
                    hasil += 
                            "=== NAMA Pekerja ==="+"\n"+
                            "  "+rs.getInt("id")+"\n"+
                            "  "+rs.getString("nama")+"\n"+
                            "  "+rs.getString("alamat")+"\n"+
                            "  "+rs.getInt("umur")+"\n"+
                            "  "+rs.getDouble("gaji")+"\n"+
                            "  "+rs.getString("jabatan")+"\n"+
                            "  "+rs.getInt("jamkerja")+"\n"+
                            "\n";
                }
            }
            rs.close();
            state.close();

        }
        catch(Exception Ex)
        {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
         return hasil;
   
    }
    
    public void deletePeg(int key)
    {
        String sql="DELETE FROM tbl_pegawai WHERE id  Like '%"+ key +"%'";
        System.out.println("Delete Pegawai ");
        try{
            Statement statement=con.createStatement();                  
            int result=statement.executeUpdate(sql);
            System.out.println("Delete"+result+"pegawai\n");
            statement.close();
        }
        catch(Exception Ex){
            System.out.println("Error deleting a pegawai...\n");
            System.out.println(Ex);
        }
    }
    
    public List<Apoteker> showSearchPeg(String Search) {
        String sql = "SELECT tbl_pegawai.id,tbl_pegawai.nama,"
                + "tbl_pegawai.alamat,tbl_pegawai.umur,tbl_pegawai.gaji,tbl_pegawai.jabatan,"
                + "tbl_pegawai.jamkerja from tbl_pegawai WHERE"
                + " (nama Like '%" + Search + "%') OR (id Like '%" + Search + "%')"
                + " OR (alamat Like '%" + Search + "%')";
        System.out.println("Daftar Pegawai...");
        List<Apoteker> list = new ArrayList<Apoteker>();
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                   Apoteker A = new Apoteker(
                    rs.getString("nama"),
                    rs.getString("alamat"), 
                    rs.getInt("umur"),
                    rs.getDouble("gaji"),
                    rs.getInt("id"),
                    rs.getString("jabatan"),
                    rs.getInt("jamkerja")
                    );
                    list.add(A);
                }
            }
            rs.close();
            statement.close();

        } catch (Exception Ex) {
            System.out.println("Error reading database information...\n");
            System.out.println(Ex);
        }
        return list;
    }
    //============TRANSAKSI
   
    public void insertTransaksi(Transaksi t) throws SQLException{
        String sql = "INSERT INTO tbl_transaksi(tanggal,total_bayar,bayar,kembalian) VALUES"
                +"('"+t.getTanggal()+
                "','"+t.getTotal_bayar()+
                "','"+t.getBayar()+
                "','"+t.getKembalian()+
                "')";
        System.out.println("Adding transaksi...");
        
        String sqlGetId = "SELECT MAX(id) as id FROM tbl_transaksi";
        
        try{
            Statement state =con.createStatement();
            int result =state.executeUpdate(sql);
            System.out.println("Added"+result+"transaksi\n");
            ResultSet rs = state.executeQuery(sqlGetId); 
            System.out.println("Get last "+result+"transaksi\n");
            int idTrans = -1;
            if(rs != null){
                rs.next();
                idTrans = rs.getInt("id");
            }
            
            if(idTrans != -1){
                for(int i=0;i<t.getList().size();i++){
                    detail_transaksi d = t.getList().get(i);
                    sql = "INSERT INTO tbl_detail_transaksi(id_transaksi,id_obat,jumlah,total_harga) VALUES"
                    +"('"+idTrans+
                    "','"+d.getObat().getId()+
                    "','"+d.getJml()+
                    "','"+d.getTotal_harga()+
                    "')";
                    
                    result =state.executeUpdate(sql);
                }
            }
            System.out.println("Added "+result+"detail transaksi\n");
            state.close();
            con.commit();
        }catch(Exception ex){
            System.out.println("Error Adding a transaksi...");
            System.out.println(ex);
            con.rollback();
        }
        
        
    }
    //==========================================================================
    public int cekadmin()
    {
         int hasil=0;
        String sql = "select rolle from tbl_user";
        
        try{
            Statement statement=con.createStatement();                   
            ResultSet rs=statement.executeQuery(sql);
            if(rs!=null)
            {
                 while(rs.next())
                {
                    if(rs.getInt("rolle")==1)
                    {
                       hasil=1;
                       System.out.println("Login berhasil");
                    }
                }
            }
            statement.close();
            rs.close();
        }catch(Exception ex){
            System.out.println("Error Login a user...");
            System.out.println(ex);
        }
       return hasil;
       
    }
    
     public int ceknama(String un)
    {
         int hasil=0;
        String sql = "select username,password from tbl_user where username='"+un+"'";
        
        try{
            Statement statement=con.createStatement();                   
            ResultSet rs=statement.executeQuery(sql);
            if(rs!=null)
            {
                 while(rs.next())
                {
                    hasil=1;
                    
                }
            }
            statement.close();
            rs.close();
        }catch(Exception ex){
            System.out.println("Error Login a user...");
            System.out.println(ex);
        }
       return hasil;      
    }  
}

