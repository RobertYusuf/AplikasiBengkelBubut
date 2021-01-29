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

public class maintampil extends parent {

    
    private String no_pemesanan,
            nm_pelanggan,
            nm_kategori,
            nm_barang,
            tgl_pemesanan,
            id_item,
            jumlah_item,
            total_harga;
//    
    public maintampil(){
        koneksi connection = new koneksi();
        CRUDkoneksi= connection.config();
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public void setJumlah_item(String jumlah_item) {
        this.jumlah_item = jumlah_item;
    }

    public void setNm_barang(String nm_barang) {
        this.nm_barang = nm_barang;
    }

    public void setNm_kategori(String nm_kategori) {
        this.nm_kategori = nm_kategori;
    }

    public void setNm_pelanggan(String nm_pelanggan) {
        this.nm_pelanggan = nm_pelanggan;
    }

    public void setNo_pemesanan(String no_pemesanan) {
        this.no_pemesanan = no_pemesanan;
    }

    public void setTgl_pemesanan(String tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public void setTotal_harga(String total_harga) {
        this.total_harga = total_harga;
    }

    public String getId_item() {
        return id_item;
    }

    public String getJumlah_item() {
        return jumlah_item;
    }

    public String getNm_barang() {
        return nm_barang;
    }

    public String getNm_kategori() {
        return nm_kategori;
    }

    public String getNm_pelanggan() {
        return nm_pelanggan;
    }

    public String getNo_pemesanan() {
        return no_pemesanan;
    }

    public String getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public String getTotal_harga() {
        return total_harga;
    }
    
            
    

     public ResultSet tampildatakomplekall(){
        CRUDquery = "select pi.no_pemesanan, pl.nm_pelanggan, ke.nm_kategori,"
                + " b.nm_barang, tgl_pemesanan,id_item,jumlah_item, total_harga  "
                + "from pemesanan p, pelanggan pl, kategori ke, barang b,konfirmasi k,"
                + " pemesanan_item pi where p.kd_pelanggan=pl.kd_pelanggan "
                + "and pi.no_pemesanan=p.no_pemesanan and pi.kd_barang=b.kd_barang "
                + "and b.kd_kategori=ke.kd_kategori group by id_item";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil= CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
}
