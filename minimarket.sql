-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2021 at 04:03 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `no_faktur` varchar(10) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `kasir` varchar(50) NOT NULL,
  `nama_barang` varchar(50) NOT NULL,
  `harga_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`no_faktur`, `tanggal`, `kasir`, `nama_barang`, `harga_barang`, `jumlah`, `subtotal`, `discount`, `total_harga`) VALUES
('1', 'Sel 2021.12.28 pada 09:58:47 PM ', 'rii', 'SERUM', 400000, 4, 1600000, 80000, 1520000),
('2', 'Sel 2021.12.28 pada 10:00:03 PM ', 'shifa', 'PEPSODENT', 10000, 100, 1000000, 30000, 970000),
('3', 'Sel 2021.12.28 pada 10:00:28 PM ', 'riska', 'AQUA', 5000, 10, 50000, 0, 50000),
('4', 'Sel 2021.12.28 pada 10:00:53 PM ', 'shifa', 'MIE', 50000, 10, 500000, 0, 500000),
('5', 'Sel 2021.12.28 pada 10:01:21 PM ', 'riska', 'CASING', 50000, 100, 5000000, 250000, 4750000),
('6', 'Sel 2021.12.28 pada 10:01:40 PM ', 'shifa', 'SEPATU', 200000, 2, 400000, 0, 400000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`no_faktur`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
