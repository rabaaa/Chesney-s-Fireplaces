-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2019 at 10:24 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaassignment`
--

-- --------------------------------------------------------

--
-- Table structure for table `fireplace`
--

CREATE TABLE `fireplace` (
  `itemId` int(11) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `supplierId` int(10) NOT NULL,
  `style` varchar(50) DEFAULT NULL,
  `finish` varchar(11) DEFAULT NULL,
  `quantityInStock` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fireplace`
--

INSERT INTO `fireplace` (`itemId`, `description`, `supplierId`, `style`, `finish`, `quantityInStock`) VALUES
(15, 'Contemporary Collection', 14, 'modern fireplace', 'ok', 30),
(20, 'Heritage Collection', 10, 'traditional design', 'posh', 6),
(51, 'Soane Collection', 12, 'John Soane Design', 'perfect', 10);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `supplier_id` int(10) NOT NULL,
  `supplier_name` varchar(20) DEFAULT NULL,
  `house_number` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `post_code` varchar(20) NOT NULL,
  `email_address` varchar(30) DEFAULT NULL,
  `phone_no` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`supplier_id`, `supplier_name`, `house_number`, `city`, `post_code`, `email_address`, `phone_no`) VALUES
(10, 'churchill Ltd', '4', 'bournemouth', 'bh4 2ty', 'church@gmail.com', '74637382'),
(12, 'Aspel Ltd', '8', 'bristol', 'bh5 9ty', 'aa@hotmail.co.uk', '76473875'),
(14, 'Jasper Conran', '19', 'leeds', 'l12 5hy', 'jj@gmail.com', '67437562');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fireplace`
--
ALTER TABLE `fireplace`
  ADD PRIMARY KEY (`itemId`),
  ADD KEY `supplier_id` (`supplierId`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fireplace`
--
ALTER TABLE `fireplace`
  ADD CONSTRAINT `fireplace_ibfk_1` FOREIGN KEY (`supplierId`) REFERENCES `suppliers` (`supplier_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
