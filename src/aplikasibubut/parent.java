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

public class parent {

    protected Connection CRUDkoneksi;
    protected PreparedStatement CRUDpsmt;
    protected ResultSet CRUDhasil;
    protected Statement CRUDstat;
    protected String CRUDquery;
    
}
