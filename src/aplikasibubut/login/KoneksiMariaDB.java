/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasibubut.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMariaDB {
    private Connection connect;
    private String DriverName = "org.mariadb.jdbc.Driver";
    private String jdbc = "jdbc:mariadb://";
    private String host = "localhost:";
    private String port = "3306/";
    private String database = "aplikasibubut";
    private String url = jdbc + host + port + database;
    private String username = "root";
    private String password = "";
  
    public Connection getKoneksi() throws SQLException{
        if (connect == null){
            try {
                Class.forName(DriverName);
//                System.out.println("Class Driver Ditemukan");
                try {
                    connect = DriverManager.getConnection(url, username, password);
//                    System.out.println("Koneksi Database Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal : " + se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi kesalahan Pada : " + cnfe);
                System.exit(0);
            }
        }
        return connect;
    }

}
