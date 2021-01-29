/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class kategoriCRUD extends parent{

   
    private String kd_kategori, nm_kategori;

    public kategoriCRUD() {
        koneksi connection = new koneksi();
        CRUDkoneksi = connection.config();
    }

    public void setKd_kategori(String kd_kategori) {
        this.kd_kategori = kd_kategori;
    }

    public String getKd_kategori() {
        return kd_kategori;
    }

    public void setNm_kategori(String nm_kategori) {
        this.nm_kategori = nm_kategori;
    }

    public String getNm_kategori() {
        return nm_kategori;
    }
    
     public ResultSet tampildatakategori(){
        CRUDquery = "select * from kategori";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil= CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public void tambahkategori(String kd_kategori, String nm_kategori){
        CRUDquery = "insert into kategori (kd_kategori,nm_kategori) "
                + "values (?,?)";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_kategori);
            CRUDpsmt.setString(2, nm_kategori);
            
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void editdata(String kd_kategori,String nm_kategori){
        CRUDquery = "update kategori set nm_kategori=? where kd_kategori=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nm_kategori);
            
            CRUDpsmt.setString(2, kd_kategori);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public void hapusData(String kd_kategori){
        CRUDquery = "delete from kategori where kd_kategori=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_kategori);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }   
    }

}
