/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut.gui;

import aplikasibubut.koneksi;
import aplikasibubut.login.Login;
import aplikasibubut.login.LoginForm;
import aplikasibubut.login.Session;
import aplikasibubut.pembayaranCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pembayaran extends javax.swing.JFrame {

    private DefaultTableModel tabmod;
    private ResultSet hasil;
    
    private String CRUDquery ;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private ResultSet CRUDhasil;
    private Statement CRUDstat;
    

    pembayaranCRUD aa = new pembayaranCRUD();
    Login bb = new Login();
    public pembayaran() {
        initComponents();
        tampil_databasepembayaran();
        tampilnopem();
        this.setLocationRelativeTo(null);
    }
    
    public void tampilnopem(){
         combonopem.removeAllItems();
        
        try {
            koneksi con = new koneksi();
            CRUDkoneksi= con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "select * from pemesanan";
            ResultSet nopemesanan = stat.executeQuery(CRUDquery);
            
            while (nopemesanan.next())
            {
                String nopem = nopemesanan.getString("no_pemesanan");
                
                combonopem.addItem(nopem);
            }
        } catch (SQLException ex) {
            
        }
    }

    public void tampil_databasepembayaran() {
        Object[] baris = {"ID Pembayaran", "No Pemesanan",
            "Jumlah Pembayaran", "Keterangan",
            "Tanggal", "Bukti Tranfer"};
        tabmod = new DefaultTableModel(null, baris);
        tablepembayaran.setModel(tabmod);

        try {
            hasil = aa.tampildatapembayaran();
            while (hasil.next()) {
                aa.setId_pembayaran(hasil.getString("id_pembayaran"));
                aa.setNo_pemesanan(hasil.getString("no_pemesanan"));
                aa.setJumlah_pembayaran(hasil.getString("jumlah_pembayaran"));
                aa.setKeterangan(hasil.getString("keterangan"));
                aa.setTanggal(hasil.getString("tanggal"));
                aa.setBukti_tranfer(hasil.getString("bukti_tranfer"));

                String[] data = {aa.getId_pembayaran(), aa.getNo_pemesanan(),
                    aa.getJumlah_pembayaran(), aa.getKeterangan(),
                    aa.getTanggal(), aa.getBukti_tranfer()};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset_txt() {
        txtbukti.setText("");
        txtid.setText("");
        txtjumlahpembayaran.setText("");
      

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepembayaran = new javax.swing.JTable();
        txtid = new javax.swing.JTextField();
        txtbukti = new javax.swing.JTextField();
        txtjumlahpembayaran = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtket = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        combonopem = new javax.swing.JComboBox<>();
        txtnamapelanggan = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        txtharga = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("ID_Pembayaran");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 79, -1, 24));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Jumlah Pembayaran");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 265, -1, 24));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Bukti Tranfer");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 206, -1, 24));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("No Pemesanan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 140, -1, 24));

        jButton1.setText("Tambah Pembayaran");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 392, -1, 32));

        jButton2.setText("Edit Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 392, 95, 32));

        jButton4.setText("Hapus Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 392, -1, 32));

        tablepembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pembayaran", "No Pemesanan", "Jumlah Pembayaranr", "Keterangan", "Tanggal", "Bukti Tranfer"
            }
        ));
        tablepembayaran.setRowHeight(25);
        tablepembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepembayaran);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 553, 423));

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 83, 239, -1));
        getContentPane().add(txtbukti, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 210, 245, -1));
        getContentPane().add(txtjumlahpembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 269, 245, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Keterangan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 322, 103, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/house.png"))); // NOI18N
        jButton3.setText("Halaman Utama");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 461, 186, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Pembayaran Form");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 11, 117, 28));
        getContentPane().add(txtket, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 324, 245, -1));

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 392, -1, 32));

        combonopem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonopemActionPerformed(evt);
            }
        });
        getContentPane().add(combonopem, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 144, 67, -1));

        txtnamapelanggan.setText("______________________");
        getContentPane().add(txtnamapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 147, 183, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit_1.png"))); // NOI18N
        jButton6.setText("Keluar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 462, 168, -1));

        txtharga.setText("_____________________");
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 130, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\everest-minimalist-wallpaper-blue.png")); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void tablepembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepembayaranMouseClicked

        try {
            int row = tablepembayaran.rowAtPoint(evt.getPoint());
            String id_pembayaran = tablepembayaran.getValueAt(row, 0).toString();
            String no_pemesanan = tablepembayaran.getValueAt(row, 1).toString();
            String jumlah_pembayaran = tablepembayaran.getValueAt(row, 2).toString();
            String keterangan = tablepembayaran.getValueAt(row, 3).toString();

            txtket.setText(keterangan);
            txtid.setText(id_pembayaran);
            combonopem.setSelectedItem(no_pemesanan);
            txtjumlahpembayaran.setText(jumlah_pembayaran);

            try {
                String bukti_tranfer = tablepembayaran.getValueAt(row, 5).toString();
                txtbukti.setText(bukti_tranfer);
            } catch (Exception e) {
                txtbukti.setText("");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tablepembayaranMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //           id_pembayaran,
//           no_pemesanan,
//           jumlah_pembayaran,
//           keterangan,
//           tgl
//           bukti_tranfer; 
        if (txtid.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Pembayaran Belum Di Isi!");
            txtid.requestFocus();
        } else if (combonopem.getSelectedIndex() < -1){
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            combonopem.requestFocus();
        } else if (txtjumlahpembayaran.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Pembayaran Belum Di Isi!");
            txtjumlahpembayaran.requestFocus();
        } else if (txtket.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Keterangan Pembayaran Belum Di Isi!");
            txtket.requestFocus();
        } else {
            try {
                aa.setId_pembayaran(txtid.getText());
                aa.setNo_pemesanan(combonopem.getSelectedItem().toString());
                aa.setJumlah_pembayaran(txtjumlahpembayaran.getText());
                aa.setKeterangan(txtket.getText());
                aa.setBukti_tranfer(txtbukti.getText());
                aa.tambahpembayaran(aa.getId_pembayaran(),
                                    aa.getNo_pemesanan(),
                                    aa.getJumlah_pembayaran(), 
                                    aa.getKeterangan(),
                                    aa.getBukti_tranfer());
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasepembayaran();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (txtid.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Pembayaran Belum Di Isi!");
            txtid.requestFocus();
        } else if (combonopem.getSelectedIndex() < -1){
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            combonopem.requestFocus();
        } else if (txtjumlahpembayaran.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Pembayaran Belum Di Isi!");
            txtjumlahpembayaran.requestFocus();
        } else if (txtket.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Keterangan Pembayaran Belum Di Isi!");
            txtket.requestFocus();
        } else {
            try {
                aa.setId_pembayaran(txtid.getText());
                aa.setNo_pemesanan(combonopem.getSelectedItem().toString());
                aa.setJumlah_pembayaran(txtjumlahpembayaran.getText());
                aa.setKeterangan(txtket.getText());
                aa.setBukti_tranfer(txtbukti.getText());
                aa.editdata(aa.getId_pembayaran(),
                                    aa.getNo_pemesanan(),
                                    aa.getJumlah_pembayaran(), 
                                    aa.getKeterangan(),
                                    aa.getBukti_tranfer());
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasepembayaran();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if (txtid.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Pembayaran Belum Di Isi!");
            txtid.requestFocus();
       }else{
            if(JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Data Pembayaran Ini?","WARNING!",2)==JOptionPane.YES_OPTION){
                try{
                    aa.setId_pembayaran(txtid.getText());
                    aa.hapusData(aa.getId_pembayaran());
                    
                    JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
            
            tampil_databasepembayaran();
            reset_txt();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Data Gagal Dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
            
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
reset_txt();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void combonopemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonopemActionPerformed
     if (combonopem.getSelectedIndex() > -1)
        {
            try {
                koneksi con = new koneksi();
                CRUDkoneksi= con.config();
                Statement stat = CRUDkoneksi.createStatement();
                CRUDquery = "select nm_pelanggan, no_pemesanan,total_harga_semua_item from pelanggan pl, pemesanan p where pl.kd_pelanggan = p.kd_pelanggan";
                ResultSet kategori = stat.executeQuery(CRUDquery);

                while (kategori.next())
                {
                    if (kategori.getString("no_pemesanan").equals(combonopem.getSelectedItem().toString()))
                    {
                        txtnamapelanggan.setText(kategori.getString("nm_pelanggan"));
                        txtharga.setText(kategori.getString("total_harga_semua_item"));
                        break;
                    }
                }
            } catch (SQLException ex) {

            }
        }
      
    }//GEN-LAST:event_combonopemActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      if(JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?", "Warning",2)
        ==JOptionPane.YES_OPTION){
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   if (Session.getStatusLogin() == "AKTIF") {
                dispose();
                
                Main form = null;
                try {
                    form = new Main();
                } catch (Exception ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                form.setVisible(true);
            } else {
                
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new pembayaran().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combonopem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablepembayaran;
    private javax.swing.JTextField txtbukti;
    private javax.swing.JLabel txtharga;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjumlahpembayaran;
    private javax.swing.JTextField txtket;
    private javax.swing.JLabel txtnamapelanggan;
    // End of variables declaration//GEN-END:variables
}
