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

public class pembayaranCRUD extends parent {

  
    private String id_pembayaran,
            no_pemesanan,
            jumlah_pembayaran,
            keterangan,
            tanggal,
            bukti_tranfer;

    public pembayaranCRUD() {
        koneksi connection = new koneksi();
        CRUDkoneksi = connection.config();
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    
    public void setBukti_tranfer(String bukti_tranfer) {
        this.bukti_tranfer = bukti_tranfer;
    }

    public String getBukti_tranfer() {
        return bukti_tranfer;
    }

    public void setId_pembayaran(String id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public String getJumlah_pembayaran() {
        return jumlah_pembayaran;
    }

    public void setJumlah_pembayaran(String jumlah_pembayaran) {
        this.jumlah_pembayaran = jumlah_pembayaran;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setNo_pemesanan(String no_pemesanan) {
        this.no_pemesanan = no_pemesanan;
    }

    public String getId_pembayaran() {
        return id_pembayaran;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getNo_pemesanan() {
        return no_pemesanan;
    }

    public ResultSet tampildatapembayaran() {
        CRUDquery = "select * from konfirmasi";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }


    public void tambahpembayaran(String id_pembayaran, String no_pemesanan, String jumlah_pembayaran,
            String keterangan, String bukti_tranfer) {
        CRUDquery = "insert into konfirmasi (id_pembayaran,no_pemesanan,jumlah_pembayaran,keterangan,bukti_tranfer) "
                + "values (?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id_pembayaran);
            CRUDpsmt.setString(2, no_pemesanan);
            CRUDpsmt.setString(3, jumlah_pembayaran);
            CRUDpsmt.setString(4, keterangan);
            CRUDpsmt.setString(5, bukti_tranfer);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editdata(String id_pembayaran, String no_pemesanan, String jumlah_pembayaran,
            String keterangan, String bukti_tranfer) {
        CRUDquery = "update konfirmasi set no_pemesanan=?, jumlah_pembayaran=?,"
                + " keterangan=?, bukti_tranfer=? where id_pembayaran=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(5, id_pembayaran);
            CRUDpsmt.setString(1, no_pemesanan);
            CRUDpsmt.setString(2, jumlah_pembayaran);
            CRUDpsmt.setString(3, keterangan);
            CRUDpsmt.setString(4, bukti_tranfer);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void hapusData(String id_pembayaran){
        CRUDquery = "delete from konfirmasi where id_pembayaran=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id_pembayaran);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }   
    }
    

}
