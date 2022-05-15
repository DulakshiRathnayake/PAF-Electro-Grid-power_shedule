-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: May 15, 2022 at 05:33 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `pshedule`
--

CREATE TABLE `pshedule` (
  `id` int(11) NOT NULL,
  `location` varchar(20) NOT NULL,
  `duration` varchar(20) NOT NULL,
  `reason` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pshedule`
--

INSERT INTO `pshedule` (`id`, `location`, `duration`, `reason`, `description`) VALUES
(45, 'Colombo', '3hrs', ' weather related', 'due to high raing day  '),
(55, 'Matara', '6 hrs', 'sudden powercut', 'supplier may have reasons for power outages, like the need to conduct routine maintenance'),
(77, 'Padukka', '2 hrs', 'Quick powercut', 'supplier may have reasons for power outages, like the need to conduct routine maintenance'),
(88, 'Malabe', '45 min', ' Fallen trees', 'to rescue of the others'),
(89, 'Kandy', '4hrs', 'maintainance of main line', 'electricity supply to a particular building or area is stopped ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pshedule`
--
ALTER TABLE `pshedule`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
