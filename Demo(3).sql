-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 08, 2020 at 12:00 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

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
  `date` varchar(50) NOT NULL,
  `pid` int(8) NOT NULL,
  `labfinish` int(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `checkup`
--

INSERT INTO `checkup` (`cid`, `date`, `pid`, `labfinish`) VALUES
(1, 'enthelum', 2, 0),
(2, 'vere enthelum', 2, 0),
(8, 'Tue Jul 14 22:28:02 IST 2020', 2, 0);

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
(1, 2),
(2, 3),
(5, 1),
(6, 8);

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
  `Type` varchar(20) DEFAULT NULL,
  `house` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `pin` varchar(7) NOT NULL,
  `contact` int(10) NOT NULL,
  `permission` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Did`, `name`, `sex`, `specialized`, `incomeid`, `password`, `Type`, `house`, `place`, `district`, `state`, `pin`, `contact`, `permission`) VALUES
(1, 'ram', 'male', 'dermatology', 23, 'hello', 'doctor', 'punjabi', 'karikode', 'kollam', 'kerala', '12345', 123456789, b'0'),
(2, 'raju', 'male', 'cardiac', 43, 'qwerty', 'doctor', 'melepura', 'ottapalam', 'kollam', 'kerala', '45893', 934678293, b'0'),
(3, 'david', 'M', '', 12000, '1234', 'reception', 'kaithapura', 'keezgmad', 'kollam', 'kerala', '567893', 123456789, b'0'),
(13, 'indu', 'F', 'gyno', 12345, '123', 'nurse', 'kalaparamb', 'karikode', 'kollam', 'kerala', '3456789', 987654321, b'0'),
(17, 'Hannah', 'f', NULL, 2009, '13rw', 'pharmasist', 'blubber house', 'kodungalloor', 'ernakulam', 'kerala', '650897', 1123765456, b'0'),
(18, 'sasi', 'M', 'ortho', 3, '123', 'Admin', '43e', 'fer', 'we', '3erfc', 'defrfv', 1234567890, b'0'),
(20, 'lilly', 'F', 'gyno', 2, '123', 'nurse', 'fr', '3ref', 'd3erecf', '3ref', '258963', 1234567890, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE `medicine` (
  `mid` int(8) NOT NULL,
  `mname` varchar(30) NOT NULL,
  `Manufacturer` varchar(20) NOT NULL,
  `expdate` varchar(5) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`mid`, `mname`, `Manufacturer`, `expdate`, `price`) VALUES
(1, 'paracetamol', 'Sun pharmaceuticals', '02/23', 1),
(2, 'bryonia', 'Cipla', '04/21', 95),
(3, 'strepstrills', 'Reckit Benckiser', '02/22', 30),
(4, 'acetaminophen', 'Lupin', '06/21', 25),
(5, 'Amoxicillin', 'Lloyd pharma', '03/22', 75);

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
  `notes` varchar(100) DEFAULT NULL,
  `Remarks` varchar(1000) DEFAULT NULL,
  `ContactNo` varchar(10) NOT NULL,
  `Address` text NOT NULL,
  `BG` varchar(3) NOT NULL,
  `FatherName` varchar(30) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `flag` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`PatientID`, `Patientname`, `Gen`, `Height`, `Weight`, `Age`, `disease`, `roomid`, `billid`, `doctor_id`, `description`, `notes`, `Remarks`, `ContactNo`, `Address`, `BG`, `FatherName`, `Email`, `flag`) VALUES
(1, 'kuttan', 'M', 169.56, 62.4, 26, 'chrone', 'a-202', 4, 1, '2eqwfdrgtfy', '3e2wre4gth', '3e2wre4gth', '987654320', 'zsdxfcgvhbjnkkkkk', 'b-', 'dhasappan', 'q@gmail.com', 1),
(2, 'njbg', 'M', NULL, NULL, 19, NULL, 'a-202', NULL, 2, NULL, NULL, 'tehnnnnnnnnnnnnnn', '1234567890', 'y4bbbbbb', 'O+', NULL, NULL, 0),
(3, 'sxdcfvg', 'M', 169, 49, 56, NULL, NULL, NULL, 1, NULL, NULL, 'rtgyhuj', '1234567890', 'cvbnm', 'O+', 'zxcvbnm', 'wertyuiokfdsa', 0),
(4, 'wexrcftv', 'F', 165, 59, 67, NULL, NULL, NULL, 2, NULL, NULL, 'tvybgh', '987654321', 'qwertyuiolkjhgfdsazxcvbnm', 'A-', 'zesxdrcftvg', 'ercdftvgybhnj', 0),
(5, 'rredc', 'F', 178, 67, 35, NULL, 'a-104', NULL, 1, NULL, NULL, 'tyguh', 'vgbh', 'dcfgvhb', 'A+', '6trvg', 'vghb', 0),
(8, 'cfgvhbj', 'M', 176, 67, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '987654321', 'fgvhbjk\ndfcgvhbjnk\ncgvhbhnjkml', 'O+', 'cfgvhbnjm', 't@gmail', 0);

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
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `current`
--
ALTER TABLE `current`
  MODIFY `currentid` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `Did` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `mid` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `PatientID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
