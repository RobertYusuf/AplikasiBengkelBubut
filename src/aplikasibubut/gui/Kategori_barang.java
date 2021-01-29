/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut.gui;

import aplikasibubut.kategoriCRUD;
import aplikasibubut.login.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import aplikasibubut.login.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
public class Kategori_barang extends javax.swing.JFrame {

    private DefaultTableModel tabmod;
    private ResultSet hasil;
    Login bb= new Login();
    kategoriCRUD aa= new kategoriCRUD();
    public Kategori_barang() {
        initComponents();
        tampil_databasekategori();
             this.setLocationRelativeTo(null);
    }

     public void tampil_databasekategori() {
        Object[] baris = {"Kode Kategori", "Nama Kategori"};
        tabmod = new DefaultTableModel(null, baris);
        tablekat.setModel(tabmod);

        try {
            hasil = aa.tampildatakategori();
            while (hasil.next()) {
                aa.setKd_kategori(hasil.getString("kd_kategori"));
                aa.setNm_kategori(hasil.getString("nm_kategori"));
                
                String[] data = {aa.getKd_kategori(), aa.getNm_kategori()};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void reset_txt(){
        txtkodekat.setText("");
        txtnamakat.setText("");
      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablekat = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtkodekat = new javax.swing.JTextField();
        txtnamakat = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Kategori Barang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 160, 30));

        tablekat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Kategori", "Nama Kategori"
            }
        ));
        tablekat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablekatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablekat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 78, 353, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Kode Kategori");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 78, 96, 23));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nama Kategori");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 96, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-icon-silhouette.png"))); // NOI18N
        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 201, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pencil.png"))); // NOI18N
        jButton3.setText("Ubah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 90, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/recycle-bin.png"))); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        txtkodekat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodekatActionPerformed(evt);
            }
        });
        getContentPane().add(txtkodekat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 223, -1));
        getContentPane().add(txtnamakat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 223, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home-icon-silhouette.png"))); // NOI18N
        jButton5.setText("Halaman Utama");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 254, 160, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit2.png"))); // NOI18N
        jButton6.setText("  Keluar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 254, 130, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\istockphoto-1001509116-1024x1024.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodekatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodekatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodekatActionPerformed

    private void tablekatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablekatMouseClicked
      try{
            int row= tablekat.rowAtPoint(evt.getPoint());
            String kd_kategori = tablekat.getValueAt(row, 0).toString();
            String nm_kategori = tablekat.getValueAt(row, 1).toString();
            
            txtkodekat.setText(kd_kategori);
            txtnamakat.setText(nm_kategori);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_tablekatMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(txtkodekat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Kode Kategori Belum Di Isi!");
            txtkodekat.requestFocus();
        }else if(txtnamakat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Kategori Belum Di Isi!");
            txtnamakat.requestFocus();
        }else{
            try{
                aa.setKd_kategori(txtkodekat.getText());
                aa.setNm_kategori(txtnamakat.getText());
                
                aa.tambahkategori(aa.getKd_kategori(),aa.getNm_kategori());
            JOptionPane.showMessageDialog(null,"Data Berhasil Tersimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
            
            tampil_databasekategori();
            reset_txt();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal Tersimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      if(txtkodekat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Kode Kategori Belum Di Isi!");
            txtkodekat.requestFocus();
        }else if(txtnamakat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Kategori Belum Di Isi!");
            txtnamakat.requestFocus();
        }else{
            try{
                aa.setKd_kategori(txtkodekat.getText());
                aa.setNm_kategori(txtnamakat.getText());
                
                aa.editdata(aa.getKd_kategori(),aa.getNm_kategori());
            JOptionPane.showMessageDialog(null,"Data Berhasil Diubah ","Informasi",JOptionPane.INFORMATION_MESSAGE);
            
            tampil_databasekategori();
            reset_txt();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal Diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if(txtkodekat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Kode Kategori Belum Di Isi!");
            txtkodekat.requestFocus();
        }else{
            if(JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Data Pelanggan Ini?","WARNING!",2)==JOptionPane.YES_OPTION){
                try{
                    aa.setKd_kategori(txtkodekat.getText());
                    aa.hapusData(aa.getKd_kategori());
                    
                    JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
            
            tampil_databasekategori();
            reset_txt();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Data Gagal Dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
            
                }
            }
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?", "Warning",2)
        ==JOptionPane.YES_OPTION){
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
//            java.util.logging.Logger.getLogger(Kategori_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Kategori_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Kategori_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Kategori_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Kategori_barang().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablekat;
    private javax.swing.JTextField txtkodekat;
    private javax.swing.JTextField txtnamakat;
    // End of variables declaration//GEN-END:variables
}
