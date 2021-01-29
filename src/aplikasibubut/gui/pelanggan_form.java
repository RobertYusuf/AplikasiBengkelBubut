/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut.gui;

import aplikasibubut.login.Login;
import aplikasibubut.login.LoginForm;
import aplikasibubut.login.Session;
import aplikasibubut.pelanggancrud;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pelanggan_form extends javax.swing.JFrame {

    private DefaultTableModel tabmod;
    private ResultSet hasil;

    pelanggancrud aa = new pelanggancrud();
    Login bb = new Login();

    public pelanggan_form() {
        initComponents();
        
        setTabel();
        tampil_databaseplgn();
        this.setLocationRelativeTo(null);
    }

    public void setTabel() {
            Object[] baris = {"Kode Pelanggan", "Nama Pelanggan",
            "Tanggal Langganan", "No Telepone", "Alamat"};
        tabmod = new DefaultTableModel(baris, 0);
        tablepelanggan.setModel(tabmod);
    }
    public void resetTabel() {
        int baris = tablepelanggan.getRowCount();
        for (int i = 0; i < baris; i++) {
            tabmod.removeRow(0);
        }
    }

    public void tampil_databaseplgn() {
        resetTabel();
//    Object[] baris = {"Kode Pelanggan", "Nama Pelanggan",
//            "Tanggal Langganan", "No Telepone", "Alamat"};
//        tabmod = new DefaultTableModel(null, baris);
//        tablepelanggan.setModel(tabmod);
        try {
            hasil = aa.tampildatapelanggan();
            while (hasil.next()) {
                aa.setKd_pelanggan(hasil.getString("kd_pelanggan"));
                aa.setNm_pelanggan(hasil.getString("nm_pelanggan"));
                aa.setTanggal_berlangganan(hasil.getString("tanggal_berlangganan"));
                aa.setNo_telpon(hasil.getString("no_telepon"));
                aa.setAlamat(hasil.getString("alamat"));

                String[] data = {aa.getKd_pelanggan(), aa.getNm_pelanggan(), aa.getTanggal_berlangganan(), aa.getNo_telpon(), aa.getAlamat()};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
//        public void tampil_databaseplgncari() {
//        Object[] baris = {"Kode Pelanggan", "Nama Pelanggan",
//            "Tanggal Langganan", "No Telepone", "Alamat"};
//        tabmod = new DefaultTableModel(null, baris);
//        tablepelanggan.setModel(tabmod);
//        
//        try {
//            hasil = aa.tampildatapelanggancari(kd_pelanggan);
//            while (hasil.next()) {
//                aa.setKd_pelanggan(hasil.getString("kd_pelanggan"));
//                aa.setNm_pelanggan(hasil.getString("nm_pelanggan"));
//                aa.setTanggal_berlangganan(hasil.getString("tanggal_berlangganan"));
//                aa.setNo_telpon(hasil.getString("no_telepon"));
//                aa.setAlamat(hasil.getString("alamat"));
//
//                String[] data = {aa.getKd_pelanggan(), aa.getNm_pelanggan(), aa.getTanggal_berlangganan(),aa.getNo_telpon(), aa.getAlamat()};
//                tabmod.addRow(data);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public void reset_txt() {
        txtalamat.setText("");
        txtkdpelanggan.setText("");
        txtnmpelanggan.setText("");
        txttelpon.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepelanggan = new javax.swing.JTable();
        tambahbutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        hapusbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtkdpelanggan = new javax.swing.JTextField();
        txttelpon = new javax.swing.JTextField();
        txtnmpelanggan = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        exitbut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Data Pelanggan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 132, 44));

        tablepelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Pelanggan", "Nama Pelanggan", "Tanggal Langganan", "No_Telpon", "Alamat"
            }
        ));
        tablepelanggan.setRowHeight(25);
        tablepelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepelanggan);
        if (tablepelanggan.getColumnModel().getColumnCount() > 0) {
            tablepelanggan.getColumnModel().getColumn(0).setMaxWidth(90);
            tablepelanggan.getColumnModel().getColumn(2).setMinWidth(170);
            tablepelanggan.getColumnModel().getColumn(3).setMinWidth(120);
            tablepelanggan.getColumnModel().getColumn(4).setMinWidth(170);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 73, 770, 435));

        tambahbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-icon-silhouette.png"))); // NOI18N
        tambahbutton.setText("Tambah");
        tambahbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(tambahbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 469, -1, -1));

        editbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/medical-history.png"))); // NOI18N
        editbutton.setText("Edit");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 95, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home-icon-silhouette.png"))); // NOI18N
        jButton3.setText("Halaman Utama");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 170, -1));

        hapusbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/recycle-bin.png"))); // NOI18N
        hapusbutton.setText("Hapus ");
        hapusbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(hapusbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Kode Pelanggan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 73, -1, 24));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Nama Pelanggan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 150, -1, 24));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Alamat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 364, -1, 24));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("No Telepone");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 252, -1, 24));

        txtkdpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkdpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txtkdpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 75, 252, -1));
        getContentPane().add(txttelpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 254, 252, -1));
        getContentPane().add(txtnmpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 152, 252, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pemesanan.png"))); // NOI18N
        jButton5.setText("Pengelolaan Pemesanan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, 40));

        exitbut.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        exitbut.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\exit.png")); // NOI18N
        exitbut.setText("Keluar");
        exitbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbutActionPerformed(evt);
            }
        });
        getContentPane().add(exitbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 530, 140, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reset.png"))); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, -1, -1));

        txtalamat.setColumns(20);
        txtalamat.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtalamat.setLineWrap(true);
        txtalamat.setRows(5);
        txtalamat.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtalamat);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 346, 252, 65));

        jButton2.setText("cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 80, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\104160221-modern-abstract-geometric-art-deco-mockup-minimalistic-background-white-primitive-shapes-3d-render-i.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkdpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkdpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkdpelangganActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (Session.getStatusLogin() == "AKTIF") {
            dispose();

            pemesanan form = null;
            try {
                form = new pemesanan();
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            form.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tambahbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbuttonActionPerformed

        if (txtkdpelanggan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Pelanggan Belum Di Isi!");
            txtkdpelanggan.requestFocus();
        } else if (txtnmpelanggan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Pelanggan Belum Di Isi!");
            txtnmpelanggan.requestFocus();
        } else if (txtalamat.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Belum Di Isi!");
            txtalamat.requestFocus();
        } else if (txttelpon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No Telpone Belum Di Isi!");
            txttelpon.requestFocus();
        } else {
            try {
                aa.setKd_pelanggan(txtkdpelanggan.getText());
                aa.setNm_pelanggan(txtnmpelanggan.getText());
                aa.setNo_telpon(txttelpon.getText());
                aa.setAlamat(txtalamat.getText());
                aa.tambahpelanggan(aa.getKd_pelanggan(), aa.getNm_pelanggan(), aa.getNo_telpon(), aa.getAlamat());
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databaseplgn();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_tambahbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reset_txt();
//        resetTabel();
        tampil_databaseplgn();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        if (txtkdpelanggan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Pelanggan Belum Di Isi!");
            txtkdpelanggan.requestFocus();
        } else if (txtnmpelanggan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Pelanggan Belum Di Isi!");
            txtnmpelanggan.requestFocus();
        } else if (txtalamat.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Belum Di Isi!");
            txtalamat.requestFocus();
        } else if (txttelpon.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No Telpone Belum Di Isi!");
            txttelpon.requestFocus();
        } else {
            try {
                aa.setKd_pelanggan(txtkdpelanggan.getText());
                aa.setNm_pelanggan(txtnmpelanggan.getText());
                aa.setNo_telpon(txttelpon.getText());
                aa.setAlamat(txtalamat.getText());
                aa.editdata(aa.getKd_pelanggan(), aa.getNm_pelanggan(), aa.getNo_telpon(), aa.getAlamat());
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databaseplgn();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_editbuttonActionPerformed

    private void hapusbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbuttonActionPerformed

        if (txtkdpelanggan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Pelanggan Belum Di Isi!");
            txtkdpelanggan.requestFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Data Pelanggan Ini?", "WARNING!", 2) == JOptionPane.YES_OPTION) {
                try {
                    aa.setKd_pelanggan(txtkdpelanggan.getText());
                    aa.hapusData(aa.getKd_pelanggan());

                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                    tampil_databaseplgn();
                    reset_txt();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_hapusbuttonActionPerformed

    private void tablepelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepelangganMouseClicked
        try {
            int row = tablepelanggan.rowAtPoint(evt.getPoint());
            String kd_pelanggan = tablepelanggan.getValueAt(row, 0).toString();
            String nm_pelanggan = tablepelanggan.getValueAt(row, 1).toString();
            String no_telepon = tablepelanggan.getValueAt(row, 3).toString();
            String alamat = tablepelanggan.getValueAt(row, 4).toString();

            txtalamat.setText(alamat);
            txtkdpelanggan.setText(kd_pelanggan);
            txtnmpelanggan.setText(nm_pelanggan);
            txttelpon.setText(no_telepon);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tablepelangganMouseClicked

    private void exitbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbutActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?", "Warning", 2)
                == JOptionPane.YES_OPTION) {
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_exitbutActionPerformed

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        hasil = aa.tampildatapelanggancari(txtkdpelanggan.getText());
        resetTabel();
//        Object[] baris = {"Kode Pelanggan", "Nama Pelanggan",
//            "Tanggal Langganan", "No Telepone", "Alamat"};
//        tabmod = new DefaultTableModel(null, baris);
//        tablepelanggan.setModel(tabmod);
        try {

            while (hasil.next()) {
                aa.setKd_pelanggan(hasil.getString("kd_pelanggan"));
                aa.setNm_pelanggan(hasil.getString("nm_pelanggan"));
                aa.setTanggal_berlangganan(hasil.getString("tanggal_berlangganan"));
                aa.setNo_telpon(hasil.getString("no_telepon"));
                aa.setAlamat(hasil.getString("alamat"));

                String[] data = {aa.getKd_pelanggan(), aa.getNm_pelanggan(), aa.getTanggal_berlangganan(), aa.getNo_telpon(), aa.getAlamat()};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pelanggan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelanggan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelanggan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelanggan_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pelanggan_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbutton;
    private javax.swing.JButton exitbut;
    private javax.swing.JButton hapusbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablepelanggan;
    private javax.swing.JButton tambahbutton;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtkdpelanggan;
    private javax.swing.JTextField txtnmpelanggan;
    private javax.swing.JTextField txttelpon;
    // End of variables declaration//GEN-END:variables
}
