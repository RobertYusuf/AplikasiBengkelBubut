/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasibubut.gui;

import aplikasibubut.barangcrud;
import aplikasibubut.koneksi;
import aplikasibubut.login.Login;
import aplikasibubut.login.LoginForm;
import aplikasibubut.login.Session;
import aplikasibubut.pelanggancrud;
import aplikasibubut.pemesanan_itemcrud;
import aplikasibubut.pemesanancrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pemesanan extends javax.swing.JFrame {

    private DefaultTableModel tabmod;
    private ResultSet hasil;

    private String CRUDquery;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private ResultSet CRUDhasil;
    private Statement CRUDstat;

    Login bb = new Login();

    pemesanan_itemcrud pi = new pemesanan_itemcrud();
    barangcrud br = new barangcrud();
    pemesanancrud pc = new pemesanancrud();
    pelanggancrud pl = new pelanggancrud();

    public pemesanan() {
        initComponents();
        //tampil_databasepemesanan();
        tampil_databasepemesananitem();
        tampil_datapemesanan();

        tampilcomboboxnopemesanan();
        tampilcomboboxkodepelanggan();
        tampilcomboboxkodebarang();
        tampilcomboboxnopemesanan1();
        this.setLocationRelativeTo(null);
    }

    public void tampilcomboboxkodebarang() {
        combokobar.removeAllItems();

        try {
            koneksi con = new koneksi();
            CRUDkoneksi = con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "select * from barang";
            ResultSet nobar = stat.executeQuery(CRUDquery);

            while (nobar.next()) {
                String nobar2 = nobar.getString("kd_barang");

                combokobar.addItem(nobar2);
            }
        } catch (SQLException ex) {

        }
    }

    public void tampilcomboboxkodepelanggan() {
        combokodepel.removeAllItems();

        try {
            koneksi con = new koneksi();
            CRUDkoneksi = con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "select * from pelanggan";
            ResultSet nopemesanan = stat.executeQuery(CRUDquery);

            while (nopemesanan.next()) {
                String nopem = nopemesanan.getString("kd_pelanggan");

                combokodepel.addItem(nopem);
            }
        } catch (SQLException ex) {

        }
    }

    public void tampilcomboboxnopemesanan() {
        combonopem.removeAllItems();

        try {
            koneksi con = new koneksi();
            CRUDkoneksi = con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "select * from pemesanan";
            ResultSet nopemesanan = stat.executeQuery(CRUDquery);

            while (nopemesanan.next()) {
                String nopem = nopemesanan.getString("no_pemesanan");

                combonopem.addItem(nopem);
            }
        } catch (SQLException ex) {

        }
    }

    public void tampilcomboboxnopemesanan1() {
        combonopem1.removeAllItems();

        try {
            koneksi con = new koneksi();
            CRUDkoneksi = con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "select * from pemesanan";
            ResultSet nopemesanan1 = stat.executeQuery(CRUDquery);

            while (nopemesanan1.next()) {
                String nopem1 = nopemesanan1.getString("no_pemesanan");

                combonopem1.addItem(nopem1);
            }
        } catch (SQLException ex) {

        }
    }

    public void reset_txtitem() {
        txt_iditem.setText("");

        txtjumlahitem.setText("");
    }

    public void reset_txt() {
        txtnopemesanan111.setText("");

        txtalamatlengkap.setText("");
        txtketerangan.setText("");
        txtstatuskirim.setText("");
    }

    public void tampil_datapemesanan() {
//        select p.no_pemesanan,nm_pelanggan,tgl_pemesanan,keterangan, alamat_lengkap,status_kirim,"
//                + " total_harga
        Object[] baris = {"No Pesan", "Kode Pelanggan",
            "Tanggal Pemesanan", "Keterangan", "Alamat ",
             "Status Kirim ", "Jumlah Item", "Total Harga Pemesanan"};
        tabmod = new DefaultTableModel(null, baris);
        tablepemesanan1.setModel(tabmod);

        try {
            hasil = pc.tampildatapemesanantable1();
            while (hasil.next()) {
                pc.setNo_pemesanan(hasil.getString("no_pemesanan"));
                pc.setKd_pelanggan(hasil.getString("kd_pelanggan"));
                pc.setTgl_pemesanan(hasil.getString("tgl_pemesanan"));
                pc.setKeterangan(hasil.getNString("keterangan"));
                pc.setAlamat_lengkap(hasil.getString("alamat_lengkap"));
                pc.setStatus_kirim(hasil.getString("status_kirim"));
                pi.setJumlahitemdipesan(hasil.getString("jumlah_pem_item"));
                pc.setTotalhargasemua(hasil.getString("total_harga_semua_item"));

                String[] data = {pc.getNo_pemesanan(), pc.getKd_pelanggan(),
                     pc.getTgl_pemesanan(), pc.getKeterangan(),
                    pc.getAlamat_lengkap(), pc.getStatus_kirim(),
                     pi.getJumlahitemdipesan(), pc.getTotalhargasemua()
                };
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void tampil_databasepemesananitem() {
        //select id_item,no_pemesanan, nm_barang,
        //harga_barang, jumlah_item, total_harga from pemesanan_item p 
        //, barang b where p.kd_barang=b.kd_barang;
        Object[] baris = {"ID Item", "No Pemesanan",
            "Kode Barang", "Harga Barang", "Jumlah Item ",
             "Harga Total "};
        tabmod = new DefaultTableModel(null, baris);
        tablepemesananitem.setModel(tabmod);

        try {
            hasil = pi.tampildataitempelanggan();
            while (hasil.next()) {
                pi.setId_item(hasil.getString("id_item"));
                pi.setNo_pemesanan(hasil.getString("no_pemesanan"));
                pi.setKode_barang(hasil.getString("kd_barang"));
                br.setTotalharga(hasil.getString("totalharga"));
                pi.setJumlah_item(hasil.getString("jumlah_item"));
                pi.setTotal_harga(hasil.getString("total_harga"));

                String[] data = {pi.getId_item(), pi.getNo_pemesanan(),
                    pi.getKode_barang(),
                    br.getTotalharga(),
                    pi.getJumlah_item(),
                    pi.getTotal_harga()};
                tabmod.addRow(data);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablepemesanan1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnopemesanan111 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        simpanpemesanan = new javax.swing.JButton();
        editpemesanan = new javax.swing.JButton();
        hapuspemesanan = new javax.swing.JButton();
        resetpemesanan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepemesananitem = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_iditem = new javax.swing.JTextField();
        txtjumlahitem = new javax.swing.JTextField();
        simpanitem = new javax.swing.JButton();
        edititem = new javax.swing.JButton();
        hapusitem = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtalamatlengkap = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtketerangan = new javax.swing.JTextArea();
        jButton14 = new javax.swing.JButton();
        txtstatuskirim = new javax.swing.JTextField();
        combokodepel = new javax.swing.JComboBox<>();
        txtnamapelang = new javax.swing.JLabel();
        combonopem = new javax.swing.JComboBox<>();
        combokobar = new javax.swing.JComboBox<>();
        txtnamapelanggan = new javax.swing.JLabel();
        txtnamabar = new javax.swing.JLabel();
        txttotalhargasemua = new javax.swing.JLabel();
        combonopem1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel1.setText("Pengelolaan Pemesanan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 23, 188, 26));

        tablepemesanan1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No Pemesanan", "Kode Pelanggan", "Tanggal Pemesanan", "Keterangan", "Alamat Penerima", "Status Kirim", "Jumlah Item Dipesan"
            }
        ));
        tablepemesanan1.setRowHeight(25);
        tablepemesanan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepemesanan1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepemesanan1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 933, 340));

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel2.setText("No Pemesanan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 67, 115, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel3.setText("Kode Pelanggan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 107, 115, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel7.setText("Alamat");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 161, 94, 50));

        txtnopemesanan111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnopemesanan111ActionPerformed(evt);
            }
        });
        getContentPane().add(txtnopemesanan111, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 69, 210, -1));

        jTextField2.setText("jTextField1");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 132, 210, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel8.setText("Status Kirim");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 338, -1, -1));

        simpanpemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-icon-silhouette.png"))); // NOI18N
        simpanpemesanan.setText("Simpan");
        simpanpemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanpemesananActionPerformed(evt);
            }
        });
        getContentPane().add(simpanpemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        editpemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/medical-history.png"))); // NOI18N
        editpemesanan.setText("Edit");
        editpemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editpemesananActionPerformed(evt);
            }
        });
        getContentPane().add(editpemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 80, -1));

        hapuspemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/recycle-bin.png"))); // NOI18N
        hapuspemesanan.setText("Hapus ");
        hapuspemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapuspemesananActionPerformed(evt);
            }
        });
        getContentPane().add(hapuspemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        resetpemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reset.png"))); // NOI18N
        resetpemesanan.setText("Reset");
        resetpemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetpemesananActionPerformed(evt);
            }
        });
        getContentPane().add(resetpemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        tablepemesananitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Item", "No Pemesanan", "Kode Barang", "Harga Jual", "Jumlah Item", "Total Harga Item"
            }
        ));
        tablepemesananitem.setRowHeight(25);
        tablepemesananitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepemesananitemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablepemesananitem);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 933, 300));

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel6.setText("No Pemesanan");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 535, -1, 25));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel9.setText("ID Item");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 492, -1, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel10.setText("Kode Barang");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 578, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel11.setText("Jumlah Item");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 618, -1, -1));

        txt_iditem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_iditemActionPerformed(evt);
            }
        });
        getContentPane().add(txt_iditem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 496, 203, -1));
        getContentPane().add(txtjumlahitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 203, -1));

        simpanitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save-icon-silhouette.png"))); // NOI18N
        simpanitem.setText("Simpan");
        simpanitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanitemActionPerformed(evt);
            }
        });
        getContentPane().add(simpanitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 679, -1, -1));

        edititem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/medical-history.png"))); // NOI18N
        edititem.setText("Edit");
        edititem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edititemActionPerformed(evt);
            }
        });
        getContentPane().add(edititem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 680, 80, -1));

        hapusitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/recycle-bin.png"))); // NOI18N
        hapusitem.setText("Hapus ");
        hapusitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusitemActionPerformed(evt);
            }
        });
        getContentPane().add(hapusitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 680, -1, -1));

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/reset.png"))); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 680, -1, -1));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/house.png"))); // NOI18N
        jButton10.setText("Halaman Utama");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 800, 219, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/barang.png"))); // NOI18N
        jButton11.setText("Daftar Barang");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 800, 247, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/customer.png"))); // NOI18N
        jButton12.setText("Daftar Pelanggan");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 800, 252, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel5.setText("Keterangan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 266, -1, -1));

        txtalamatlengkap.setColumns(20);
        txtalamatlengkap.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtalamatlengkap.setRows(5);
        txtalamatlengkap.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtalamatlengkap);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 145, 210, 79));

        txtketerangan.setColumns(20);
        txtketerangan.setRows(5);
        jScrollPane4.setViewportView(txtketerangan);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 247, 213, 72));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/check.png"))); // NOI18N
        jButton14.setText("Cek Harga Semua Item Pemesanan");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 750, -1, -1));
        getContentPane().add(txtstatuskirim, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 335, 213, 30));

        combokodepel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokodepelActionPerformed(evt);
            }
        });
        getContentPane().add(combokodepel, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 107, 69, -1));

        txtnamapelang.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtnamapelang.setForeground(new java.awt.Color(255, 255, 255));
        txtnamapelang.setText("__________________");
        getContentPane().add(txtnamapelang, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 107, 111, -1));

        combonopem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonopemActionPerformed(evt);
            }
        });
        getContentPane().add(combonopem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 539, 83, -1));

        combokobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokobarActionPerformed(evt);
            }
        });
        getContentPane().add(combokobar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 83, -1));

        txtnamapelanggan.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtnamapelanggan.setForeground(new java.awt.Color(255, 255, 255));
        txtnamapelanggan.setText("__________________");
        getContentPane().add(txtnamapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 537, 102, -1));

        txtnamabar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtnamabar.setForeground(new java.awt.Color(255, 255, 255));
        txtnamabar.setText("__________________");
        getContentPane().add(txtnamabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 578, 102, -1));

        txttotalhargasemua.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txttotalhargasemua.setForeground(new java.awt.Color(255, 255, 255));
        txttotalhargasemua.setText("___________________________________");
        getContentPane().add(txttotalhargasemua, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 750, 146, 33));

        combonopem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combonopem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonopem1ActionPerformed(evt);
            }
        });
        getContentPane().add(combonopem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 750, 108, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit_1.png"))); // NOI18N
        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 800, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/5.png"))); // NOI18N
        jButton2.setText("Pembayaran");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 800, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/22p.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnopemesanan111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnopemesanan111ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnopemesanan111ActionPerformed

    private void hapuspemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapuspemesananActionPerformed

        if (txtnopemesanan111.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            txtnopemesanan111.requestFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Data Pelanggan Ini?", "WARNING!", 2) == JOptionPane.YES_OPTION) {
                try {
                    pc.setNo_pemesanan(txtnopemesanan111.getText());
                    pc.hapusData(pc.getNo_pemesanan());

                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                    tampil_datapemesanan();
                    reset_txt();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_hapuspemesananActionPerformed

    private void txt_iditemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_iditemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_iditemActionPerformed

    private void hapusitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusitemActionPerformed
        if (txt_iditem.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Item Belum Di Isi!");
            txt_iditem.requestFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Akan Menghapus Data Pemesanan Item Ini?", "WARNING!", 2) == JOptionPane.YES_OPTION) {
                try {
                    pi.setId_item(txt_iditem.getText());
                    pi.hapusData(pi.getId_item());

                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                    tampil_databasepemesananitem();
                    tampil_datapemesanan();
                    reset_txtitem();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_hapusitemActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
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
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tablepemesananitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepemesananitemMouseClicked
        try {
            int row = tablepemesananitem.rowAtPoint(evt.getPoint());
            String id_item = tablepemesananitem.getValueAt(row, 0).toString();
            String no_pemesanan = tablepemesananitem.getValueAt(row, 1).toString();
            String kd_barang = tablepemesananitem.getValueAt(row, 2).toString();
            String jumlah_item = tablepemesananitem.getValueAt(row, 4).toString();

            txt_iditem.setText(id_item);
            combonopem.setSelectedItem(no_pemesanan);
            combokobar.setSelectedItem(kd_barang);
            txtjumlahitem.setText(jumlah_item);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tablepemesananitemMouseClicked

    private void simpanitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanitemActionPerformed
        if (txt_iditem.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Item Belum Di Isi!");
            txt_iditem.requestFocus();
        } else if (combonopem.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            combonopem.requestFocus();
        } else if (combokobar.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Di Isi! Lihat Tabel Disebelah kanan");
            combokobar.requestFocus();
        } else if (txtjumlahitem.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Item Belum Di Isi!");
            txtjumlahitem.requestFocus();
        } else {
            try {
                pi.setId_item(txt_iditem.getText());
                pi.setNo_pemesanan(combonopem.getSelectedItem().toString());
                pi.setKode_barang(combokobar.getSelectedItem().toString());
                pi.setJumlah_item(txtjumlahitem.getText());
                pi.tambahpemesananItem(pi.getId_item(), pi.getNo_pemesanan(), pi.getKode_barang(), pi.getJumlah_item());
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasepemesananitem();
                tampil_datapemesanan();
                reset_txtitem();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_simpanitemActionPerformed

    private void edititemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edititemActionPerformed
        if (txt_iditem.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ID Item Belum Di Isi!");
            txt_iditem.requestFocus();
        } else if (combonopem.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            combonopem.requestFocus();
        } else if (combokobar.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Di Isi! Lihat Tabel Disebelah kanan");
            combokobar.requestFocus();
        } else if (txtjumlahitem.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah Item Belum Di Isi!");
            txtjumlahitem.requestFocus();
        } else {
            try {
                pi.setId_item(txt_iditem.getText());
                pi.setNo_pemesanan(combonopem.getSelectedItem().toString());
                pi.setKode_barang(combokobar.getSelectedItem().toString());
                pi.setJumlah_item(txtjumlahitem.getText());
                pi.editdata(pi.getId_item(), pi.getNo_pemesanan(), pi.getKode_barang(), pi.getJumlah_item());
                JOptionPane.showMessageDialog(null, "Data Berhasil Di Ubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_databasepemesananitem();
                tampil_datapemesanan();
                reset_txtitem();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_edititemActionPerformed

    private void simpanpemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanpemesananActionPerformed
        if (txtnopemesanan111.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            txtnopemesanan111.requestFocus();
        } else if (combokodepel.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "Kode Pelanggan Belum Di Isi!");
            combokodepel.requestFocus();
        } else if (txtalamatlengkap.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Belum Di Isi!");
            txtalamatlengkap.requestFocus();
        } else if (txtstatuskirim.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Status Kirim Belum Di Isi!");
            txtstatuskirim.requestFocus();
        } else if (txtketerangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Keterangan Belum Di Isi!");
            txtketerangan.requestFocus();
        } else {
            try {
                pc.setNo_pemesanan(txtnopemesanan111.getText());
                pc.setKd_pelanggan(combokodepel.getSelectedItem().toString());
                pc.setAlamat_lengkap(txtalamatlengkap.getText());
                pc.setKeterangan(txtketerangan.getText());
                pc.setStatus_kirim(txtstatuskirim.getText());
                pc.tambahpemesanan(pc.getNo_pemesanan(), pc.getKd_pelanggan(), pc.getAlamat_lengkap(),
                         pc.getKeterangan(), pc.getStatus_kirim());
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_datapemesanan();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_simpanpemesananActionPerformed

    private void tablepemesanan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepemesanan1MouseClicked
        try {
            int row = tablepemesanan1.rowAtPoint(evt.getPoint());
            String no_pemesanan = tablepemesanan1.getValueAt(row, 0).toString();
            String kode_pelanggan = tablepemesanan1.getValueAt(row, 1).toString();
            String alamat_lengkap = tablepemesanan1.getValueAt(row, 4).toString();
            String keterangan = tablepemesanan1.getValueAt(row, 3).toString();
            String statuskirim = tablepemesanan1.getValueAt(row, 5).toString();

            txtnopemesanan111.setText(no_pemesanan);
            txtalamatlengkap.setText(alamat_lengkap);
            txtketerangan.setText(keterangan);
            txtstatuskirim.setText(statuskirim);
            combokodepel.setSelectedItem(kode_pelanggan);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tablepemesanan1MouseClicked

    private void editpemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editpemesananActionPerformed
        if (txtnopemesanan111.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "No Pemesanan Belum Di Isi!");
            txtnopemesanan111.requestFocus();
        } else if (combokodepel.getSelectedIndex() < -1) {
            JOptionPane.showMessageDialog(null, "Kode Pelanggan Belum Di Isi!");
            combokodepel.requestFocus();
        } else if (txtalamatlengkap.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Alamat Belum Di Isi!");
            txtalamatlengkap.requestFocus();
        } else if (txtstatuskirim.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Status Kirim Belum Di Isi!");
            txtstatuskirim.requestFocus();
        } else if (txtketerangan.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Keterangan Belum Di Isi!");
            txtketerangan.requestFocus();
        } else {
            try {
                pc.setNo_pemesanan(txtnopemesanan111.getText());
                pc.setKd_pelanggan(combokodepel.getSelectedItem().toString());
                pc.setAlamat_lengkap(txtalamatlengkap.getText());
                pc.setKeterangan(txtketerangan.getText());
                pc.setStatus_kirim(txtstatuskirim.getText());

                pc.editdata(pc.getNo_pemesanan(), pc.getKd_pelanggan(),
                         pc.getKeterangan(), pc.getAlamat_lengkap(), pc.getStatus_kirim());
                JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                tampil_datapemesanan();
                reset_txt();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_editpemesananActionPerformed

    private void combokodepelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokodepelActionPerformed
        if (combokodepel.getSelectedIndex() > -1) {
            try {
                koneksi con = new koneksi();
                CRUDkoneksi = con.config();
                Statement stat = CRUDkoneksi.createStatement();
                CRUDquery = "select * from pelanggan";
                ResultSet kategori = stat.executeQuery(CRUDquery);

                while (kategori.next()) {
                    if (kategori.getString("kd_pelanggan").equals(combokodepel.getSelectedItem().toString())) {
                        txtnamapelang.setText(kategori.getString("nm_pelanggan"));
                        txtalamatlengkap.setText(kategori.getString("alamat"));
                        break;
                    }
                }
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_combokodepelActionPerformed

    private void combonopemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonopemActionPerformed
        if (combonopem.getSelectedIndex() > -1) {
            try {
                koneksi con = new koneksi();
                CRUDkoneksi = con.config();
                Statement stat = CRUDkoneksi.createStatement();
                CRUDquery = "select nm_pelanggan, no_pemesanan from pelanggan pl, pemesanan p where pl.kd_pelanggan = p.kd_pelanggan";
                ResultSet kategori = stat.executeQuery(CRUDquery);

                while (kategori.next()) {
                    if (kategori.getString("no_pemesanan").equals(combonopem.getSelectedItem().toString())) {
                        txtnamapelanggan.setText(kategori.getString("nm_pelanggan"));
                        break;
                    }
                }
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_combonopemActionPerformed

    private void combokobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokobarActionPerformed
        if (combokobar.getSelectedIndex() > -1) {
            try {
                koneksi con = new koneksi();
                CRUDkoneksi = con.config();
                Statement stat = CRUDkoneksi.createStatement();
                CRUDquery = "select *from barang";
                ResultSet kategori = stat.executeQuery(CRUDquery);

                while (kategori.next()) {
                    if (kategori.getString("kd_barang").equals(combokobar.getSelectedItem().toString())) {
                        txtnamabar.setText(kategori.getString("nm_barang"));
                        break;
                    }
                }
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_combokobarActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        try {
            koneksi con = new koneksi();
            CRUDkoneksi = con.config();
            Statement stat = CRUDkoneksi.createStatement();
            CRUDquery = "SELECT SUM(total_harga) FROM pemesanan_item WHERE no_pemesanan =" + combonopem1.getSelectedItem();
            ResultSet tothargasemua = stat.executeQuery(CRUDquery);

            while (tothargasemua.next()) {
                String nopem = tothargasemua.getString("SUM(total_harga)");
                txttotalhargasemua.setText(nopem);
                try {
                    pc.setTotalhargasemua(txttotalhargasemua.getText());
                    pc.setNo_pemesanan(combonopem1.getSelectedItem().toString());

                    pc.tambahtotalharga(pc.getTotalhargasemua(), pc.getNo_pemesanan());

                    tampil_datapemesanan();
                    reset_txt();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);

                }

            }
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void combonopem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonopem1ActionPerformed
        int a = 0;
        if (combonopem.getSelectedIndex() > -1) {
            try {
                koneksi con = new koneksi();
                CRUDkoneksi = con.config();
                Statement stat = CRUDkoneksi.createStatement();
                CRUDquery = "select *from pemesanan_item ";
                ResultSet kategori = stat.executeQuery(CRUDquery);

                while (kategori.next()) {

                }
                txttotalhargasemua.setText(String.valueOf(a));
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_combonopem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar?", "Warning", 2)
                == JOptionPane.YES_OPTION) {
            bb.Logout(Session.getUserID());
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
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
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
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
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void resetpemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetpemesananActionPerformed
        reset_txt();
    }//GEN-LAST:event_resetpemesananActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        reset_txtitem();        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

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
//            java.util.logging.Logger.getLogger(pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(pemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new pemesanan().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combokobar;
    private javax.swing.JComboBox<String> combokodepel;
    private javax.swing.JComboBox<String> combonopem;
    private javax.swing.JComboBox<String> combonopem1;
    private javax.swing.JButton edititem;
    private javax.swing.JButton editpemesanan;
    private javax.swing.JButton hapusitem;
    private javax.swing.JButton hapuspemesanan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton reset;
    private javax.swing.JButton resetpemesanan;
    private javax.swing.JButton simpanitem;
    private javax.swing.JButton simpanpemesanan;
    private javax.swing.JTable tablepemesanan1;
    private javax.swing.JTable tablepemesananitem;
    private javax.swing.JTextField txt_iditem;
    private javax.swing.JTextArea txtalamatlengkap;
    private javax.swing.JTextField txtjumlahitem;
    private javax.swing.JTextArea txtketerangan;
    private javax.swing.JLabel txtnamabar;
    private javax.swing.JLabel txtnamapelang;
    private javax.swing.JLabel txtnamapelanggan;
    private javax.swing.JTextField txtnopemesanan111;
    private javax.swing.JTextField txtstatuskirim;
    private javax.swing.JLabel txttotalhargasemua;
    // End of variables declaration//GEN-END:variables
}
