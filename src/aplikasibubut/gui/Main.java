/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut.gui;

import aplikasibubut.login.*;


import aplikasibubut.maintampil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    private DefaultTableModel tabmod;
    private ResultSet hasil;

    maintampil aa = new maintampil();
    Login bb = new Login();

    public Main() {

        if (Session.getStatusLogin() == "AKTIF") {
            initComponents();
            tampil_datasemuamini();
                 this.setLocationRelativeTo(null);

        } else {
            dispose();

            LoginForm form = new LoginForm();
            form.setVisible(true);
        }
    }

    public void tampil_datasemuamini() {

//         String no_pemesanan,
//            nm_pelanggan,
//            nm_kategori,
//            nm_barang,
//            tgl_pemesanan,
//            id_item,
//            jumlah_item,
//            total_harga;
        Object[] baris = {"No", "Pelanggan", "Kategori",
            "Barang", " Tanggal", "ID Item", "Jumlah", "Harga"};
        tabmod = new DefaultTableModel(null, baris);
        tablekomplek.setModel(tabmod);

        try {
            hasil = aa.tampildatakomplekall();
            while (hasil.next()) {
                aa.setNo_pemesanan(hasil.getString("no_pemesanan"));
                aa.setNm_pelanggan(hasil.getString("nm_pelanggan"));
                aa.setNm_kategori(hasil.getString("nm_kategori"));
                aa.setNm_barang(hasil.getString("nm_barang"));
                aa.setTgl_pemesanan(hasil.getString("tgl_pemesanan"));
                aa.setId_item(hasil.getString("id_item"));
                aa.setTotal_harga(hasil.getString("total_harga"));
                aa.setJumlah_item(hasil.getString("jumlah_item"));

                String[] data = {
                    aa.getNo_pemesanan(),
                    aa.getNm_pelanggan(),
                    aa.getNm_kategori(),
                    aa.getNm_barang(),
                    aa.getTgl_pemesanan(),
                    aa.getId_item(),
                    aa.getJumlah_item(),
                    aa.getTotal_harga()};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        butkategori = new javax.swing.JButton();
        butdatabarang = new javax.swing.JButton();
        butpemesanan = new javax.swing.JButton();
        butpembayaran = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablekomplek = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 102, 0));
        setForeground(new java.awt.Color(153, 0, 204));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(255, 255, 255)));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\customer.png")); // NOI18N
        jButton1.setText("Data Pelanggan");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        butkategori.setBackground(new java.awt.Color(255, 255, 255));
        butkategori.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        butkategori.setForeground(new java.awt.Color(0, 204, 204));
        butkategori.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\category-icon-png-21.jpg.png")); // NOI18N
        butkategori.setText("Data Kategori");
        butkategori.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butkategori.setMaximumSize(new java.awt.Dimension(200, 40));
        butkategori.setMinimumSize(new java.awt.Dimension(200, 40));
        butkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butkategoriActionPerformed(evt);
            }
        });

        butdatabarang.setBackground(new java.awt.Color(255, 255, 255));
        butdatabarang.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        butdatabarang.setForeground(new java.awt.Color(0, 204, 204));
        butdatabarang.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\barang.png")); // NOI18N
        butdatabarang.setText("Data Barang");
        butdatabarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butdatabarang.setMaximumSize(new java.awt.Dimension(200, 40));
        butdatabarang.setMinimumSize(new java.awt.Dimension(200, 40));
        butdatabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butdatabarangActionPerformed(evt);
            }
        });

        butpemesanan.setBackground(new java.awt.Color(255, 255, 255));
        butpemesanan.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        butpemesanan.setForeground(new java.awt.Color(0, 204, 204));
        butpemesanan.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\pemesanan.png")); // NOI18N
        butpemesanan.setText("Kelola Pemesanan");
        butpemesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butpemesanan.setMaximumSize(new java.awt.Dimension(200, 40));
        butpemesanan.setMinimumSize(new java.awt.Dimension(200, 40));
        butpemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butpemesananActionPerformed(evt);
            }
        });

        butpembayaran.setBackground(new java.awt.Color(255, 255, 255));
        butpembayaran.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        butpembayaran.setForeground(new java.awt.Color(0, 204, 204));
        butpembayaran.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\5.png")); // NOI18N
        butpembayaran.setText("Pembayaran");
        butpembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butpembayaran.setMaximumSize(new java.awt.Dimension(200, 40));
        butpembayaran.setMinimumSize(new java.awt.Dimension(200, 40));
        butpembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butpembayaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butpembayaran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(butpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(butdatabarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butkategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(butkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(butdatabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(butpemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(butpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(255, 255, 255)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        tablekomplek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No ", "Pelanggan", "Kategori ", "Nama Barang", "Tanggal ", "Jumlah", "Harga", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablekomplek.setRowHeight(25);
        tablekomplek.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablekomplek);
        if (tablekomplek.getColumnModel().getColumnCount() > 0) {
            tablekomplek.getColumnModel().getColumn(0).setResizable(false);
            tablekomplek.getColumnModel().getColumn(0).setPreferredWidth(40);
            tablekomplek.getColumnModel().getColumn(1).setResizable(false);
            tablekomplek.getColumnModel().getColumn(2).setResizable(false);
            tablekomplek.getColumnModel().getColumn(3).setResizable(false);
            tablekomplek.getColumnModel().getColumn(4).setResizable(false);
            tablekomplek.getColumnModel().getColumn(5).setResizable(false);
            tablekomplek.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablekomplek.getColumnModel().getColumn(6).setResizable(false);
            tablekomplek.getColumnModel().getColumn(6).setPreferredWidth(80);
            tablekomplek.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Detail Pemesanan Item");

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\desainprojek\\cropped-bengkel-icon-white.png")); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BUBUT MANDIRI");

        jButton6.setText("Keluar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Session.getStatusLogin() == "AKTIF") {
            dispose();

            pelanggan_form form = null;
            try {
                form = new pelanggan_form();
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            form.setVisible(true);
        } else {

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void butkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butkategoriActionPerformed
        if (Session.getStatusLogin() == "AKTIF") {
            dispose();

            Kategori_barang form = null;
            try {
                form = new Kategori_barang();
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            form.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_butkategoriActionPerformed

    private void butdatabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butdatabarangActionPerformed
        if (Session.getStatusLogin() == "AKTIF") {
            dispose();

            barang form = null;
            try {
                form = new barang();
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            form.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_butdatabarangActionPerformed

    private void butpemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butpemesananActionPerformed
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
    }//GEN-LAST:event_butpemesananActionPerformed

    private void butpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butpembayaranActionPerformed
        if (Session.getStatusLogin() == "AKTIF") {
            dispose();

            pembayaran form = null;
            try {
                form = new pembayaran();
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            form.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_butpembayaranActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?", "Warning", 2)
            == JOptionPane.YES_OPTION) {
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 new LoginForm().setVisible(true);
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Main().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butdatabarang;
    private javax.swing.JButton butkategori;
    private javax.swing.JButton butpembayaran;
    private javax.swing.JButton butpemesanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablekomplek;
    // End of variables declaration//GEN-END:variables
}
