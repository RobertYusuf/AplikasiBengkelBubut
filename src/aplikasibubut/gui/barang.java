/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut.gui;

import aplikasibubut.barangcrud;
import aplikasibubut.koneksi;
import aplikasibubut.login.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import aplikasibubut.login.Login;
import aplikasibubut.login.LoginForm;
import java.awt.Font;

import javax.swing.JFrame;

public class barang extends javax.swing.JFrame {

    private DefaultTableModel tabmod;
    private ResultSet hasil;
    private String CRUDquery;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private ResultSet CRUDhasil;
    private Statement CRUDstat;
    barangcrud aa = new barangcrud();
    Login bb = new Login();

    public barang() {
             
        initComponents();
        tampil_databasebarang();
        tampilkategori();
        this.setLocationRelativeTo(null);
        table_barang.getTableHeader().setOpaque(false);
       
    }

    public void tampilkategori() {
        combokat.removeAllItems();

        try {
            koneksi con = new koneksi();
            CRUDkoneksi = con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "select * from kategori";
            ResultSet kategori = stat.executeQuery(CRUDquery);

            while (kategori.next()) {
                String kode = kategori.getString("kd_kategori");

                combokat.addItem(kode);
            }
        } catch (SQLException ex) {

        }
    }

    public void tampil_databasebarang() {
        Object[] baris = {"Kode Barang", "Nama Barang",
            "Harga Jasa", "Harga Barang", "Stok", "Keterangan", "Kategori Barang", "Total Harga"};
        tabmod = new DefaultTableModel(null, baris);
        table_barang.setModel(tabmod);

        try {
            hasil = aa.tampildatabarang();
            while (hasil.next()) {
                aa.setKd_barang(hasil.getString("kd_barang"));
                aa.setNm_barang(hasil.getString("nm_barang"));
                aa.setHarga_jasa(hasil.getString("harga_jasa"));
                aa.setHarga_barang(hasil.getString("harga_barang"));
                aa.setStok(hasil.getString("stok"));
                aa.setKeterangan(hasil.getString("keterangan"));
                aa.setKd_kategori(hasil.getString("kd_kategori"));
                aa.setTotalharga(hasil.getString("totalharga"));

                String[] data = {aa.getKd_barang(), aa.getNm_barang(),
                    aa.getHarga_jasa(),
                    aa.getHarga_barang(),
                    aa.getStok(),
                    aa.getKeterangan(),
                    aa.getKd_kategori(),
                    aa.getTotalharga(),};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void reset_txt() {
        txthbarang.setText("");
        txthjasa.setText("");
        txtkodeb.setText("");
        txtnamab.setText("");
        txtstok.setText("");
        txtbanyakstoktambah.setText("");
        txtket.setText("");

        txtbanyakstoktambah.setText("");
        txttambahkode.setText("");
        stok2.setText("");
    }

    public void totalharga() {
        int totalhargaint;
        totalhargaint = Integer.parseInt(txthbarang.getText()) + Integer.parseInt(txthbarang.getText());
        String totalharga = String.valueOf(totalhargaint);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_barang = new javax.swing.JTable();
        buttambah = new javax.swing.JButton();
        butedit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        buthapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtkodeb = new javax.swing.JTextField();
        txthjasa = new javax.swing.JTextField();
        txtnamab = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtstok = new javax.swing.JTextField();
        txthbarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtbanyakstoktambah = new javax.swing.JTextField();
        buttambahstok = new javax.swing.JButton();
        butreset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtket = new javax.swing.JTextArea();
        kodekategori = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txttambahkode = new javax.swing.JTextField();
        stok2 = new javax.swing.JTextField();
        txt_namakat = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        combokat = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Data Barang");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 169, 27));

        table_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga Jasa", "Harga Barang", "Stok", "Keterangan", "kd_kategori", "Total Harga"
            }
        ));
        table_barang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_barang.setRowHeight(25);
        table_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_barang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 626, 500));

        buttambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-icon-silhouette.png"))); // NOI18N
        buttambah.setText("Tambah Data");
        buttambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttambahActionPerformed(evt);
            }
        });
        getContentPane().add(buttambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        butedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pencil.png"))); // NOI18N
        butedit.setText("Edit");
        butedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buteditActionPerformed(evt);
            }
        });
        getContentPane().add(butedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 80, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/home-icon-silhouette.png"))); // NOI18N
        jButton3.setText("Halaman Utama");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 620, 233, -1));

        buthapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/recycle-bin.png"))); // NOI18N
        buthapus.setText("Hapus");
        buthapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buthapusActionPerformed(evt);
            }
        });
        getContentPane().add(buthapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setText("Kode Barang");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 24));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 51));
        jLabel3.setText("Harga Jasa");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 24));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 51));
        jLabel4.setText("Nama Barang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 24));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 51));
        jLabel5.setText("Keterangan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 24));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 51));
        jLabel6.setText("Stok");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 24));

        txtkodeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodebActionPerformed(evt);
            }
        });
        getContentPane().add(txtkodeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 300, -1));
        getContentPane().add(txthjasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 300, -1));
        getContentPane().add(txtnamab, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 300, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 51));
        jLabel7.setText("Harga Barang");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 24));
        getContentPane().add(txtstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 300, -1));
        getContentPane().add(txthbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 300, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 51));
        jLabel8.setText("Tambah Stok kode barang ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 160, -1));

        txtbanyakstoktambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbanyakstoktambahActionPerformed(evt);
            }
        });
        getContentPane().add(txtbanyakstoktambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 580, 60, -1));

        buttambahstok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-icon-silhouette.png"))); // NOI18N
        buttambahstok.setText("Tambah Stok");
        buttambahstok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttambahstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttambahstokActionPerformed(evt);
            }
        });
        getContentPane().add(buttambahstok, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 124, -1));

        butreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reset.png"))); // NOI18N
        butreset.setText("Reset");
        butreset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butresetActionPerformed(evt);
            }
        });
        getContentPane().add(butreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, -1));

        txtket.setColumns(20);
        txtket.setRows(5);
        jScrollPane2.setViewportView(txtket);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 300, 66));

        kodekategori.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        kodekategori.setForeground(new java.awt.Color(153, 0, 51));
        kodekategori.setText("Kode Kategori");
        getContentPane().add(kodekategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 51));
        jLabel9.setText("Tambah Stok Sebanyak :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 170, -1));

        txttambahkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttambahkodeActionPerformed(evt);
            }
        });
        getContentPane().add(txttambahkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, 183, -1));
        getContentPane().add(stok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 49, -1));

        txt_namakat.setForeground(new java.awt.Color(102, 0, 0));
        txt_namakat.setText("________________________");
        getContentPane().add(txt_namakat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 200, 20));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 51));
        jLabel10.setText("+");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 580, -1, -1));

        combokat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokatActionPerformed(evt);
            }
        });
        getContentPane().add(combokat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 79, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit_1.png"))); // NOI18N
        jButton1.setText("Keluar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 620, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 140, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/thumb-1920-438372.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkodebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkodebActionPerformed

    private void txtbanyakstoktambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbanyakstoktambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbanyakstoktambahActionPerformed

    private void table_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barangMouseClicked

        try {
            int row = table_barang.rowAtPoint(evt.getPoint());
            String kd_barang = table_barang.getValueAt(row, 0).toString();
            String nm_barang = table_barang.getValueAt(row, 1).toString();
            String harga_jasa = table_barang.getValueAt(row, 2).toString();
            String harga_barang = table_barang.getValueAt(row, 3).toString();
            String stok = table_barang.getValueAt(row, 4).toString();
            String keterangan = table_barang.getValueAt(row, 5).toString();
            String kd_kategori = table_barang.getValueAt(row, 6).toString();

            txtkodeb.setText(kd_barang);
            txtnamab.setText(nm_barang);
            txthjasa.setText(harga_jasa);
            txthbarang.setText(harga_barang);
            txtstok.setText(stok);
            txtket.setText(keterangan);
            combokat.setSelectedItem(kd_kategori);
            txttambahkode.setText(kd_barang);
            stok2.setText(stok);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_table_barangMouseClicked

    private void butresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butresetActionPerformed
        reset_txt();
    }//GEN-LAST:event_butresetActionPerformed

    private void buttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttambahActionPerformed
        /*
      CRUDpsmt.setString(8, kd_barang);
            CRUDpsmt.setString(1, nm_barang);
            CRUDpsmt.setString(2, harga_jasa );
            CRUDpsmt.setString(3, harga_barang);
            CRUDpsmt.setString(4, stok );
            CRUDpsmt.setString(5, keterangan);
            CRUDpsmt.setString(6, kd_kategori);
            CRUDpsmt.setString(7, totalharga);*/

        if (txtkodeb.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Di Isi!");
            txtkodeb.requestFocus();
        } else if (txtnamab.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Barang Belum Di Isi!");
            txtnamab.requestFocus();
        } else if (txthjasa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Jasa Belum Di ISI!");
            txthjasa.requestFocus();
        } else if (txthbarang.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Barang Belum Di Isi!");
            txthbarang.requestFocus();
        } else if (txtstok.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Stok Barang Belum Di Isi!");
            txtstok.requestFocus();
        } else if (combokat.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "Kategori Barang Belum Di Isi!");
            combokat.requestFocus();
        } else {
            try {
                aa.setKd_barang(txtkodeb.getText());
                aa.setNm_barang(txtnamab.getText());
                aa.setHarga_jasa(txthjasa.getText());
                aa.setHarga_barang(txthbarang.getText());
                aa.setStok(txtstok.getText());
                aa.setKeterangan(txtket.getText());
                aa.setKd_kategori(combokat.getSelectedItem().toString());

                int totalhargaint;
                totalhargaint = Integer.parseInt(txthbarang.getText()) + Integer.parseInt(txthjasa.getText());
                String totalharga = String.valueOf(totalhargaint);

                aa.setTotalharga(totalharga);

                aa.tambahbarang(aa.getKd_barang(), aa.getNm_barang(), aa.getHarga_jasa(), aa.getHarga_barang(), aa.getStok(),
                        aa.getKeterangan(), aa.getKd_kategori(), aa.getTotalharga());

                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasebarang();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_buttambahActionPerformed

    private void buteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buteditActionPerformed
        if (txtkodeb.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Di Isi!");
            txtkodeb.requestFocus();
        } else if (txtnamab.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Barang Belum Di Isi!");
            txtnamab.requestFocus();
        } else if (txthjasa.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Jasa Belum Di ISI!");
            txthjasa.requestFocus();
        } else if (txthbarang.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Harga Barang Belum Di Isi!");
            txthbarang.requestFocus();
        } else if (txtstok.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Stok Barang Belum Di Isi!");
            txtstok.requestFocus();

        } else if (combokat.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "Kategori jasa Belum Di Isi!");
            combokat.requestFocus();

        } else {
            try {
                aa.setKd_barang(txtkodeb.getText());
                aa.setNm_barang(txtnamab.getText());
                aa.setHarga_jasa(txthjasa.getText());
                aa.setHarga_barang(txthbarang.getText());
                aa.setStok(txtstok.getText());
                aa.setKeterangan(txtket.getText());
                aa.setKd_kategori(combokat.getSelectedItem().toString());

                int totalhargaint;
                totalhargaint = Integer.parseInt(txthbarang.getText()) + Integer.parseInt(txthjasa.getText());
                String totalharga = String.valueOf(totalhargaint);
                aa.setTotalharga(totalharga);

                aa.editdata(aa.getKd_barang(), aa.getNm_barang(), aa.getHarga_jasa(), aa.getHarga_barang(), aa.getStok(),
                        aa.getKeterangan(), aa.getKd_kategori(), aa.getTotalharga());

                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasebarang();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_buteditActionPerformed

    private void buthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buthapusActionPerformed
        if (txtkodeb.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Di Isi!");
            txtkodeb.requestFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Data Barang Ini?", "WARNING!", 2) == JOptionPane.YES_OPTION) {
                try {
                    aa.setKd_barang(txtkodeb.getText());
                    aa.hapusData(aa.getKd_barang());

                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                    tampil_databasebarang();
                    reset_txt();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_buthapusActionPerformed

    private void txttambahkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttambahkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttambahkodeActionPerformed

    private void buttambahstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttambahstokActionPerformed
        if (txttambahkode.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Penambahan Stok Belum Di Isi!");
            txttambahkode.requestFocus();
        } else {
            try {
                aa.setKd_barang(txttambahkode.getText());
                aa.setStok(stok2.getText());
                aa.setTambahstok(txtbanyakstoktambah.getText());
                aa.tambahstok(aa.getKd_barang(), aa.getStok(), aa.getTambahstok());
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasebarang();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Ditambah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }
            tampil_databasebarang();
            reset_txt();

        }
    }//GEN-LAST:event_buttambahstokActionPerformed

    private void combokatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokatActionPerformed
        if (combokat.getSelectedIndex() > -1) {
            try {
                koneksi con = new koneksi();
                CRUDkoneksi = con.config();
                Statement stat = CRUDkoneksi.createStatement();
                CRUDquery = "select * from kategori";
                ResultSet kategori = stat.executeQuery(CRUDquery);

                while (kategori.next()) {
                    if (kategori.getString("kd_kategori").equals(combokat.getSelectedItem().toString())) {
                        txt_namakat.setText(kategori.getString("nm_kategori"));
                        break;
                    }
                }
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_combokatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?", "Warning", 2)
                == JOptionPane.YES_OPTION) {
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
//            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new barang().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butedit;
    private javax.swing.JButton buthapus;
    private javax.swing.JButton butreset;
    private javax.swing.JButton buttambah;
    private javax.swing.JButton buttambahstok;
    private javax.swing.JComboBox<String> combokat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kodekategori;
    private javax.swing.JTextField stok2;
    private javax.swing.JTable table_barang;
    private javax.swing.JLabel txt_namakat;
    private javax.swing.JTextField txtbanyakstoktambah;
    private javax.swing.JTextField txthbarang;
    private javax.swing.JTextField txthjasa;
    private javax.swing.JTextArea txtket;
    private javax.swing.JTextField txtkodeb;
    private javax.swing.JTextField txtnamab;
    private javax.swing.JTextField txtstok;
    private javax.swing.JTextField txttambahkode;
    // End of variables declaration//GEN-END:variables
}
