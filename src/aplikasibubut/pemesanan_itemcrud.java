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
        
public class pemesanan_itemcrud extends parent{
    private String id_item,
            no_pemesanan,
            kd_barang,
            jumlah_item,
            total_harga,
            jumlahitemdipesan;
    
   
//    
    public pemesanan_itemcrud(){
        koneksi connection = new koneksi();
        CRUDkoneksi= connection.config();
    }

    public void setJumlahitemdipesan(String jumlahitemdipesan) {
        this.jumlahitemdipesan = jumlahitemdipesan;
    }

    public String getJumlahitemdipesan() {
        return jumlahitemdipesan;
    }

    public String getKd_barang() {
        return kd_barang;
    }
    
    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public void setJumlah_item(String jumlah_item) {
        this.jumlah_item = jumlah_item;
    }

    public void setKode_barang(String kd_barang) {
        this.kd_barang = kd_barang;
    }

    public void setNo_pemesanan(String no_pemesanan) {
        this.no_pemesanan = no_pemesanan;
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

    public String getKode_barang() {
        return kd_barang;
    }

    public String getNo_pemesanan() {
        return no_pemesanan;
    }

    public String getTotal_harga() {
        return total_harga;
    }
    
      public ResultSet tampildataitempelanggan(){
        CRUDquery = "select id_item,no_pemesanan, p.kd_barang, totalharga, "
                + "jumlah_item, total_harga from pemesanan_item p , "
                + "barang b where p.kd_barang=b.kd_barang order by no_pemesanan desc";
        try{
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil= CRUDstat.executeQuery(CRUDquery);
        }catch (Exception e){
            System.out.println(e);
        }
        return CRUDhasil;
    }
      
    public void tambahpemesananItem(String id_item,
            String no_pemesanan,
            String kd_barang,
            String jumlah_item){
        CRUDquery = "insert into pemesanan_item (id_item,no_pemesanan,kd_barang,jumlah_item) "
                + "values (?,?,?,?)";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id_item);
            CRUDpsmt.setString(2, no_pemesanan);
            CRUDpsmt.setString(3, kd_barang );
            CRUDpsmt.setString(4, jumlah_item);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void editdata(String id_item,
            String no_pemesanan,
            String kd_barang,
            String jumlah_item
            ){
        CRUDquery = "update pemesanan_item set no_pemesanan=?, "
                + "kd_barang=?, "
                + "jumlah_item=? "
                + "where id_item=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
           CRUDpsmt.setString(4, id_item);
            CRUDpsmt.setString(1, no_pemesanan);
            CRUDpsmt.setString(2, kd_barang );
            CRUDpsmt.setString(3, jumlah_item);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
     public void hapusData(String id_item){
        CRUDquery = "delete from pemesanan_item where id_item=?";
        try{
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id_item);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch(Exception e){
            System.out.println(e);
        }   
    }
            
}

