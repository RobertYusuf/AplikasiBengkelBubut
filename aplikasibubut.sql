-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2019 at 03:00 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasibubut`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kd_barang` varchar(20) NOT NULL,
  `nm_barang` varchar(20) NOT NULL,
  `harga_jasa` int(20) NOT NULL,
  `harga_barang` int(20) NOT NULL,
  `stok` int(10) NOT NULL,
  `keterangan` varchar(20) NOT NULL,
  `kd_kategori` varchar(20) NOT NULL,
  `totalharga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kd_barang`, `nm_barang`, `harga_jasa`, `harga_barang`, `stok`, `keterangan`, `kd_kategori`, `totalharga`) VALUES
('BevelG11', 'Bevel Gear 11 ', 15000, 70000, 9, '8mm 11 Bevel', 'GM', 85000),
('BevelG27', 'Bevel Gear Helical', 40000, 450000, 10, '27 / 8T', 'GM', 490000),
('CopperF1', 'Copper Flange S', 5000, 20000, 17, '0,75 inchi', 'FM', 25000),
('CopperF2', 'Copper Flange JIS M', 30000, 80000, 14, '3 inchi/ 30 mm', 'FM', 110000),
('CopperF4', 'Copper Flange XL', 60000, 800000, 5, '6 Inchi 30K', 'FM', 860000),
('Gear eSP', 'Gear Counter eSP', 10000, 60000, 9, '51T', 'GM', 70000),
('GearSSS', 'Gear SSS 428', 20000, 100000, 26, '35 - 40', 'GM', 120000),
('ShaftFD', 'Shaft Final Drive', 100000, 1100000, 9, 'SK200-6 Korea', 'FM', 2200000),
('WormGSAAM', 'Worm Gear SAAM', 60000, 640000, 10, 'Tipe SAAM Weeder', 'M', 700000);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `kd_kategori` varchar(20) NOT NULL,
  `nm_kategori` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`kd_kategori`, `nm_kategori`) VALUES
('FM', 'Fabrication and Miling'),
('GM', 'Grinding and Miling'),
('M', 'Milling');

-- --------------------------------------------------------

--
-- Table structure for table `konfirmasi`
--

CREATE TABLE `konfirmasi` (
  `id_pembayaran` varchar(20) NOT NULL,
  `no_pemesanan` int(20) NOT NULL,
  `jumlah_pembayaran` int(14) NOT NULL,
  `keterangan` varchar(20) DEFAULT NULL,
  `tanggal` datetime NOT NULL DEFAULT current_timestamp(),
  `bukti_tranfer` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `konfirmasi`
--

INSERT INTO `konfirmasi` (`id_pembayaran`, `no_pemesanan`, `jumlah_pembayaran`, `keterangan`, `tanggal`, `bukti_tranfer`) VALUES
('Pem1', 1, 507000, 'Tranfer', '2019-12-02 08:16:00', '58s8d4sa8ds'),
('Pem2', 2, 255000, 'Cash', '2019-12-02 08:16:19', ''),
('Pem4', 4, 350000, 'Cash', '2019-12-02 08:16:37', '');

-- --------------------------------------------------------

--
-- Table structure for table `log_login`
--

CREATE TABLE `log_login` (
  `id` bigint(18) NOT NULL,
  `id_user` varchar(50) DEFAULT NULL,
  `waktu_login` timestamp NOT NULL DEFAULT current_timestamp(),
  `waktu_logout` time DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `log_login`
--

INSERT INTO `log_login` (`id`, `id_user`, `waktu_login`, `waktu_logout`) VALUES
(39, 'admin', '2019-12-03 07:19:59', '14:21:18'),
(38, 'admin', '2019-12-03 00:08:47', '07:10:15'),
(37, 'admin', '2019-12-02 23:42:57', '06:44:20'),
(36, 'admin', '2019-12-02 23:37:57', '06:38:05'),
(35, 'admin', '2019-12-02 23:35:03', '06:37:07'),
(34, 'admin', '2019-12-02 01:20:04', '08:20:09');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kd_pelanggan` varchar(20) NOT NULL,
  `nm_pelanggan` varchar(20) NOT NULL,
  `tanggal_berlangganan` datetime NOT NULL DEFAULT current_timestamp(),
  `no_telepon` varchar(20) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`kd_pelanggan`, `nm_pelanggan`, `tanggal_berlangganan`, `no_telepon`, `alamat`) VALUES
('PL1', 'Bambang', '2019-11-23 12:53:44', '62857913295', 'JL Sejati no 14 Sempalwadak'),
('PL2', 'Nuryadii', '2019-11-23 12:54:34', '62894525413', 'JL Dukuh no 14 Wandanpuro Bululawang Kab Malang'),
('PL3', 'Haryanto', '2019-12-02 07:33:35', '62856158745', 'JL Jayakarta No 5 Wandanpuro  Bululawang');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `no_pemesanan` int(20) NOT NULL,
  `kd_pelanggan` varchar(20) NOT NULL,
  `tgl_pemesanan` timestamp NOT NULL DEFAULT current_timestamp(),
  `Keterangan` text DEFAULT NULL,
  `alamat_lengkap` text NOT NULL,
  `total_harga_semua_item` int(30) DEFAULT NULL,
  `status_kirim` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`no_pemesanan`, `kd_pelanggan`, `tgl_pemesanan`, `Keterangan`, `alamat_lengkap`, `total_harga_semua_item`, `status_kirim`) VALUES
(1, 'PL1', '2019-11-24 01:06:16', 'Dikirim tgl 20 Desember 2019 ukuran standart', 'JL Sejati no 14 Sempalwadak', 507000, 'Belum Dikirim'),
(2, 'PL3', '2019-11-25 11:42:45', 'Dikirim Akhir Desember', 'JL Jayakarta No 5 Wandanpuro  Bululawang', 255000, 'Belom'),
(4, 'PL2', '2019-11-28 04:09:20', 'Dikirim Awal January', 'JL Dukuh no 14 Wandanpuro Bululawang  Kab Malang', 350000, 'Belom');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan_item`
--

CREATE TABLE `pemesanan_item` (
  `id_item` varchar(20) NOT NULL,
  `no_pemesanan` int(20) NOT NULL,
  `kd_barang` varchar(20) NOT NULL,
  `jumlah_item` int(20) NOT NULL,
  `total_harga` int(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pemesanan_item`
--

INSERT INTO `pemesanan_item` (`id_item`, `no_pemesanan`, `kd_barang`, `jumlah_item`, `total_harga`) VALUES
('A1', 1, 'BevelG27', 3, 147000),
('A10', 1, 'GearSSS', 3, 360000),
('A2', 2, 'BevelG11', 6, 255000),
('A7', 4, 'Gear eSP', 5, 350000);

--
-- Triggers `pemesanan_item`
--
DELIMITER $$
CREATE TRIGGER `perkalianharga` BEFORE INSERT ON `pemesanan_item` FOR EACH ROW BEGIN
DECLARE habag int;

set habag=(SELECT totalharga from barang where kd_barang=new.kd_barang);

SET new.total_harga = new.jumlah_item*habag;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `stokupdate` AFTER INSERT ON `pemesanan_item` FOR EACH ROW BEGIN
UPDATE barang SET stok = stok - NEW.jumlah_item
WHERE kd_barang = NEW.kd_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(50) NOT NULL,
  `password` char(32) DEFAULT NULL,
  `nama` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `password`, `nama`) VALUES
('admin', '1a1dc91c907325c69271ddf0c944bc72', 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_barang`),
  ADD KEY `kd_kategori` (`kd_kategori`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kd_kategori`);

--
-- Indexes for table `konfirmasi`
--
ALTER TABLE `konfirmasi`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `ok` (`no_pemesanan`);

--
-- Indexes for table `log_login`
--
ALTER TABLE `log_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kd_pelanggan`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`no_pemesanan`),
  ADD KEY `kd_pelangan` (`kd_pelanggan`);

--
-- Indexes for table `pemesanan_item`
--
ALTER TABLE `pemesanan_item`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `no_pemesanan` (`no_pemesanan`),
  ADD KEY `kd_barang` (`kd_barang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `log_login`
--
ALTER TABLE `log_login`
  MODIFY `id` bigint(18) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `kd_kategori` FOREIGN KEY (`kd_kategori`) REFERENCES `kategori` (`kd_kategori`);

--
-- Constraints for table `konfirmasi`
--
ALTER TABLE `konfirmasi`
  ADD CONSTRAINT `ok` FOREIGN KEY (`no_pemesanan`) REFERENCES `pemesanan` (`no_pemesanan`);

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `kd_pelangan` FOREIGN KEY (`kd_pelanggan`) REFERENCES `pelanggan` (`kd_pelanggan`);

--
-- Constraints for table `pemesanan_item`
--
ALTER TABLE `pemesanan_item`
  ADD CONSTRAINT `kd_barang` FOREIGN KEY (`kd_barang`) REFERENCES `barang` (`kd_barang`),
  ADD CONSTRAINT `no_pemesanan` FOREIGN KEY (`no_pemesanan`) REFERENCES `pemesanan` (`no_pemesanan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
