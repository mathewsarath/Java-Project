-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 29, 2020 at 09:48 PM
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
(2, 3);

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
  `contact` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Did`, `name`, `sex`, `specialized`, `incomeid`, `password`, `Type`, `house`, `place`, `district`, `state`, `pin`, `contact`) VALUES
(1, 'ram', 'male', 'dermatology', 23, 'hello', 'doctor', 'punjabi', 'karikode', 'kollam', 'kerala', '12345', 123456789),
(2, 'raju', 'male', 'cardiac', 43, 'qwerty', 'doctor', 'melepura', 'ottapalam', 'kollam', 'kerala', '45893', 934678293),
(3, 'david', 'M', '', 12000, '1234', 'reception', 'kaithapura', 'keezgmad', 'kollam', 'kerala', '567893', 123456789),
(13, 'indu', 'F', 'gyno', 12345, '123', 'nurse', 'kalaparamb', 'karikode', 'kollam', 'kerala', '3456789', 987654321),
(17, 'Hannah', 'f', NULL, 2009, '13rw', 'pharmasist', 'blubber house', 'kodungalloor', 'ernakulam', 'kerala', '650897', 1123765456);

-- --------------------------------------------------------

--
-- Table structure for table `Lab`
--

CREATE TABLE `Lab` (
  `labid` int(11) NOT NULL,
  `test` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Lab`
--

INSERT INTO `Lab` (`labid`, `test`) VALUES
(1, 'BP'),
(2, 'Blood'),
(4, 'Xray'),
(5, 'MRI'),
(6, 'urine');

-- --------------------------------------------------------

--
-- Table structure for table `labPatient`
--

CREATE TABLE `labPatient` (
  `labid` int(8) NOT NULL,
  `cid` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `labPatient`
--

INSERT INTO `labPatient` (`labid`, `cid`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(1, 4),
(4, 1);

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
  `Remarks` varchar(1000) NOT NULL,
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
(1, 'kuttan', 'M', 169.56, 62.4, 26, 'chrone', 'a-202', 4, 1, '2eqwfdrgtfy', '3e2wre4gth', '3e2wre4gth', '0', '', '', '', '', 1),
(2, 'njbg', 'M', NULL, NULL, 19, NULL, 'a-202', NULL, 2, NULL, NULL, 'tehnnnnnnnnnnnnnn', '1234567890', 'y4bbbbbb', 'O+', NULL, NULL, 0),
(3, 'sxdcfvg', 'M', 169, 49, 56, NULL, NULL, NULL, 1, NULL, NULL, 'rtgyhuj', '1234567890', 'cvbnm', 'O+', 'zxcvbnm', 'wertyuiokfdsa', 0),
(4, 'wexrcftv', 'F', 165, 59, 67, NULL, NULL, NULL, 2, NULL, NULL, 'tvybgh', '987654321', 'qwertyuiolkjhgfdsazxcvbnm', 'A-', 'zesxdrcftvg', 'ercdftvgybhnj', 0),
(5, 'rredc', 'F', 178, 67, 35, NULL, 'a-104', NULL, 1, NULL, NULL, 'tyguh', 'vgbh', 'dcfgvhb', 'A+', '6trvg', 'vghb', 0);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `roomid` int(8) NOT NULL,
  `roomnum` varchar(8) NOT NULL,
  `nurseid` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`roomid`, `roomnum`, `nurseid`) VALUES
(1, 'a-202', 13),
(2, 'a-203', 13),
(3, 'a-104', 2),
(4, 'a-106', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Token`
--

CREATE TABLE `Token` (
  `Docid` int(8) NOT NULL,
  `token` int(8) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Token`
--

INSERT INTO `Token` (`Docid`, `token`) VALUES
(1, 2),
(2, 4);

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
-- Indexes for table `Lab`
--
ALTER TABLE `Lab`
  ADD PRIMARY KEY (`labid`);

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
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`roomid`);

--
-- Indexes for table `Token`
--
ALTER TABLE `Token`
  ADD UNIQUE KEY `Docid` (`Docid`);

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
  MODIFY `currentid` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `Did` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `Lab`
--
ALTER TABLE `Lab`
  MODIFY `labid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `medicine`
--
ALTER TABLE `medicine`
  MODIFY `mid` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `Patient`
--
ALTER TABLE `Patient`
  MODIFY `PatientID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `roomid` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
