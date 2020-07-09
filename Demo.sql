-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 09, 2020 at 11:07 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `specialized` varchar(20) DEFAULT NULL,
  `incomeid` int(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `Type` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Did`, `name`, `sex`, `specialized`, `incomeid`, `password`, `Type`) VALUES
(1, 'ram', 'male', 'dermatology', 23, 'hello', 'doctor'),
(2, 'raju', 'male', 'cardiac', 43, 'qwerty', 'doctor'),
(12, 'david', 'M', NULL, 12000, '1234', 'reception');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `mid` int(8) NOT NULL,
  `mname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`mid`, `mname`) VALUES
(1, 'paracetamol'),
(2, 'bryonia'),
(3, 'strepstrills');

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `PatientID` int(10) NOT NULL,
  `Patientname` varchar(30) NOT NULL,
  `Gen` char(1) NOT NULL,
  `Height` float DEFAULT NULL,
  `Weight` float DEFAULT NULL,
  `Age` int(3) NOT NULL,
  `disease` varchar(30) DEFAULT NULL,
  `roomid` varchar(8) DEFAULT NULL,
  `billid` int(5) DEFAULT NULL,
  `doctor_id` int(6) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `Remarks` varchar(1000) NOT NULL,
  `ContactNo` varchar(10) NOT NULL,
  `Address` text NOT NULL,
  `BG` varchar(3) NOT NULL,
  `FatherName` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`PatientID`, `Patientname`, `Gen`, `Height`, `Weight`, `Age`, `disease`, `roomid`, `billid`, `doctor_id`, `description`, `Remarks`, `ContactNo`, `Address`, `BG`, `FatherName`, `Email`) VALUES
(2, 'kuttan', 'M', 169.56, 62.4, 26, 'chrone', '', 4, 1, '2eqwfdrgtfy', '3e2wre4gth', '0', '', '', NULL, NULL);

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
  ADD PRIMARY KEY (`PatientID`);

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
  MODIFY `Did` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `mid` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `PatientID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
