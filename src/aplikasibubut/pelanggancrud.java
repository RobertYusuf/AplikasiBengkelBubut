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


public class pelanggancrud extends parent {
    private String kd_pelanggan,alamat,nm_pelanggan;
    private String no_telepon,tanggal_berlangganan;
   private String cari;

    public String getCari() {
        return cari;
    }

    public void setCari(String cari) {
        this.cari = cari;
    }
    
    
    public pelanggancrud(){
        koneksi connection = new koneksi();
        CRUDkoneksi= connection.config();
    }

    public void setKd_pelanggan(String kd_pelanggan) {
        this.kd_pelanggan = kd_pelanggan;
    }

    public void setTanggal_berlangganan(String tanggal_berlangganan) {
        this.tanggal_berlangganan = tanggal_berlangganan;
    }

    public String getTanggal_berlangganan() {
        return tanggal_berlangganan;
    }
    

    public String getKd_pelanggan() {
        return kd_pelanggan;
    }

    public void setNm_pelanggan(String nm_pelanggan) {
        this.nm_pelanggan = nm_pelanggan;
    }

    public String getNm_pelanggan() {
        return nm_pelanggan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNo_telpon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getNo_telpon() {
        return no_telepon;
    }
    
    
    public ResultSet tampildatapelanggan(){
        CRUDquery = "select * from pelanggan";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil= CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampildatapelanggancari(String kd_pelanggan){
        CRUDquery = "select * from pelanggan where kd_pelanggan = ?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_pelanggan);
            CRUDhasil = CRUDpsmt.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    public ResultSet tampildatapelangganmini(){
        CRUDquery = "select kd_pelanggan,nm_pelanggan from pelanggan";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil= CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
    
    
    public void tambahpelanggan(String kd_pelanggan,String nm_pelanggan, String no_telepon,String alamat){
        CRUDquery = "insert into pelanggan (kd_pelanggan,nm_pelanggan,no_telepon,alamat) "
                + "values (?,?,?,?)";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_pelanggan);
            CRUDpsmt.setString(2, nm_pelanggan);
            CRUDpsmt.setString(3, no_telepon );
            CRUDpsmt.setString(4, alamat);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void editdata(String kd_pelanggan,String nm_pelanggan,String no_telepon, String alamat){
        CRUDquery = "update pelanggan set nm_pelanggan=?, alamat=?, no_telepon=? where kd_pelanggan=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nm_pelanggan);
            CRUDpsmt.setString(2, alamat);
            CRUDpsmt.setString(3, no_telepon);
            CRUDpsmt.setString(4, kd_pelanggan);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public void hapusData(String kd_pelanggan){
        CRUDquery = "delete from pelanggan where kd_pelanggan=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_pelanggan);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }   
    }
    
}
