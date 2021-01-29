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

public class barangcrud extends parent {


    private String kd_barang, nm_barang, harga_jasa, harga_barang, stok, keterangan,
            kd_kategori, totalharga;
    private String tambahstok;

    public barangcrud() {
        koneksi connection = new koneksi();
        CRUDkoneksi = connection.config();
    }

    public void tambahbarang(String kd_barang, String nm_barang,
            String harga_jasa, String harga_barang, String stok, String keterangan,
            String kd_kategori, String totalharga) {
        CRUDquery = "insert into barang "
                + "values (?,?,?,?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_barang);
            CRUDpsmt.setString(2, nm_barang);
            CRUDpsmt.setString(3, harga_jasa);
            CRUDpsmt.setString(4, harga_barang);
            CRUDpsmt.setString(5, stok);
            CRUDpsmt.setString(6, keterangan);
            CRUDpsmt.setString(7, kd_kategori);
            CRUDpsmt.setString(8, totalharga);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet tampildatabarangmini() {
        CRUDquery = "select kd_barang,nm_barang from barang";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    public void setTambahstok(String tambahstok) {
        this.tambahstok = tambahstok;
    }

    public String getTambahstok() {
        return tambahstok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public void setHarga_jasa(String harga_jasa) {
        this.harga_jasa = harga_jasa;
    }

    public void setHarga_barang(String harga_barang) {
        this.harga_barang = harga_barang;
    }

    public void setKd_barang(String kd_barang) {
        this.kd_barang = kd_barang;
    }

    public void setKd_kategori(String kd_kategori) {
        this.kd_kategori = kd_kategori;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setNm_barang(String nm_barang) {
        this.nm_barang = nm_barang;
    }

    public void setTotalharga(String totalharga) {
        this.totalharga = totalharga;
    }

    public String getKd_barang() {
        return kd_barang;
    }

    public String getNm_barang() {
        return nm_barang;
    }

    public String getHarga_jasa() {
        return harga_jasa;
    }

    public String getHarga_barang() {
        return harga_barang;
    }

    public String getStok() {
        return stok;
    }

    public String getKd_kategori() {
        return kd_kategori;
    }

    public String getTotalharga() {
        return totalharga;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public ResultSet tampildatabarang() {
        CRUDquery = "select * from barang";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    public void editdata(String kd_barang, String nm_barang,
            String harga_jasa, String harga_barang, String stok, String keterangan,
            String kd_kategori, String totalharga) {
        CRUDquery = "update barang set nm_barang=?, harga_jasa=?, harga_barang=?, stok=?,"
                + " keterangan=?, kd_kategori=?, totalharga=?"
                + " where kd_barang=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(8, kd_barang);
            CRUDpsmt.setString(1, nm_barang);
            CRUDpsmt.setString(2, harga_jasa);
            CRUDpsmt.setString(3, harga_barang);
            CRUDpsmt.setString(4, stok);
            CRUDpsmt.setString(5, keterangan);
            CRUDpsmt.setString(6, kd_kategori);
            CRUDpsmt.setString(7, totalharga);

            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void hapusData(String kd_barang) {
        CRUDquery = "delete from barang where kd_barang=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kd_barang);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tambahstok(String kd_barang, String stok, String stok_tambah) {
        CRUDquery = "update barang set stok=? + ? where kd_barang=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, stok);
            CRUDpsmt.setString(2, stok_tambah);
            CRUDpsmt.setString(3, kd_barang);

            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    

    

}
