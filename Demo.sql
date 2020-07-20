-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 20, 2020 at 04:37 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `checkup`
--

CREATE TABLE `checkup` (
  `cid` int(11) NOT NULL,
  `date` varchar(15) NOT NULL,
  `pid` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `checkup`
--

INSERT INTO `checkup` (`cid`, `date`, `pid`) VALUES
(1, 'enthelum', 2),
(2, 'vere enthelum', 2);

-- --------------------------------------------------------

--
-- Table structure for table `check_med`
--

CREATE TABLE `check_med` (
  `mid` int(8) NOT NULL,
  `checkid` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `check_med`
--

INSERT INTO `check_med` (`mid`, `checkid`) VALUES
(1, 1),
(2, 1),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `current`
--

CREATE TABLE `current` (
  `currentid` int(6) NOT NULL,
  `pid` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `current`
--

INSERT INTO `current` (`currentid`, `pid`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Did` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `specialized` varchar(20) NOT NULL,
  `incomeid` int(10) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Did`, `name`, `sex`, `specialized`, `incomeid`, `password`) VALUES
(1, 'ram', 'male', 'dermatology', 23, 'hello'),
(2, 'raju', 'male', 'cardiac', 43, 'qwerty');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `mid` int(8) NOT NULL,
  `mname` varchar(30) NOT NULL,
  `Manufacturer` varchar(20) NOT NULL,
  `Exp.Date` varchar(5) NOT NULL,
  `Rate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`mid`, `mname`, `Manufacturer`, `Exp.Date`, `Rate`) VALUES
(1, 'paracetamol', 'CAD pharma', '06/22', 1),
(2, 'bryonia', 'Cipla', '07/21', 85),
(3, 'strepstrills', 'Reckit Benckiser', '02/23', 95),
(4, 'acetaminophen', 'CAD pharma', '04/22', 74),
(5, 'Amoxicillin', 'Lupin ', '05/21', 7);

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `pid` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `age` int(3) NOT NULL,
  `disease` varchar(30) NOT NULL,
  `roomid` varchar(8) DEFAULT NULL,
  `billid` int(5) NOT NULL,
  `doctor_id` int(6) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `notes` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`pid`, `name`, `sex`, `height`, `weight`, `age`, `disease`, `roomid`, `billid`, `doctor_id`, `description`, `notes`) VALUES
(2, 'kuttan', 'male', 169.56, 62.4, 26, 'chrone', '', 4, 1, '2eqwfdrgtfy', '3e2wre4gth');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `checkup`
--
ALTER TABLE `checkup`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `current`
--
ALTER TABLE `current`
  ADD PRIMARY KEY (`currentid`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`Did`);

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
  ADD PRIMARY KEY (`mid`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`pid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `checkup`
--
ALTER TABLE `checkup`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `current`
--
ALTER TABLE `current`
  MODIFY `currentid` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `Did` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `mid` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `pid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
