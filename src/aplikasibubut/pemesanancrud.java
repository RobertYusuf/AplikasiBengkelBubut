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

public class pemesanancrud extends parent{

    String no_pemesanan,
            kd_pelanggan,
            tgl_pemesanan,
            keterangan,
            alamat_lengkap,
            status_kirim,
            totalhargasemua;

  

    public pemesanancrud() {
        koneksi connection = new koneksi();
        CRUDkoneksi = connection.config();
    }

    public void setAlamat_lengkap(String alamat_lengkap) {
        this.alamat_lengkap = alamat_lengkap;
    }

    public String getAlamat_lengkap() {
        return alamat_lengkap;
    }

    public void setKd_pelanggan(String kd_pelanggan) {
        this.kd_pelanggan = kd_pelanggan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setNo_pemesanan(String no_pemesanan) {
        this.no_pemesanan = no_pemesanan;
    }

    public void setStatus_kirim(String status_kirim) {
        this.status_kirim = status_kirim;
    }

    public String getTotalhargasemua() {
        return totalhargasemua;
    }

    public void setTotalhargasemua(String totalhargasemua) {
        this.totalhargasemua = totalhargasemua;
    }

    public void setTgl_pemesanan(String tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public String getKd_pelanggan() {
        return kd_pelanggan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getNo_pemesanan() {
        return no_pemesanan;
    }

    public String getStatus_kirim() {
        return status_kirim;
    }

    public String getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public ResultSet tampildatapemesanantable1() {
        CRUDquery = "select p.no_pemesanan ,kd_pelanggan,tgl_pemesanan,keterangan,alamat_lengkap,status_kirim,count(id_item) as jumlah_pem_item ,total_harga_semua_item from pemesanan p, "
                + "pemesanan_item pi where p.no_pemesanan=pi.no_pemesanan group by no_pemesanan";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    public void tambahpemesanan(String no_pemesanan,
            String kd_pelanggan,
            String keterangan,
            String alamat_lengkap,
            String status_kirim) {
        CRUDquery = "insert into pemesanan (no_pemesanan,kd_pelanggan,keterangan,alamat_lengkap,"
                + "status_kirim) "
                + "values (?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, no_pemesanan);
            CRUDpsmt.setString(2, kd_pelanggan);
            CRUDpsmt.setString(3, keterangan);
            CRUDpsmt.setString(4, alamat_lengkap);
            CRUDpsmt.setString(5, status_kirim);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void tambahtotalharga(
            String total_harga_semua_item,String no_pemesanan) {
        CRUDquery = "update pemesanan set total_harga_semua_item=? where no_pemesanan=? "
                ;
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, total_harga_semua_item);
            CRUDpsmt.setString(2, no_pemesanan);
            
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editdata(String no_pemesanan,
            String kd_pelanggan,
            String keterangan,
            String alamat_lengkap,
            String status_kirim) {
        CRUDquery = "update pemesanan set kd_pelanggan=?,"
                + " keterangan=?, alamat_lengkap=?, status_kirim=? where no_pemesanan=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
           CRUDpsmt.setString(5, no_pemesanan);
            CRUDpsmt.setString(1, kd_pelanggan);
            CRUDpsmt.setString(2, keterangan);
            CRUDpsmt.setString(3, alamat_lengkap);
            CRUDpsmt.setString(4, status_kirim);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void hapusData(String no_pemesanan){
        CRUDquery = "delete from pemesanan where no_pemesanan=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, no_pemesanan);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }   
    }

}
