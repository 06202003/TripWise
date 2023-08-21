-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2023 at 05:48 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trip_wise`
--

-- --------------------------------------------------------

--
-- Table structure for table `airplane`
--

CREATE TABLE `airplane` (
  `airplane_id` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `origin_time` time NOT NULL,
  `departure_time` time NOT NULL,
  `ticket_price` varchar(255) NOT NULL,
  `airplane_class` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airplane`
--

INSERT INTO `airplane` (`airplane_id`, `name`, `origin_time`, `departure_time`, `ticket_price`, `airplane_class`) VALUES
('MH 0785', 'Malaysia Airlines', '10:40:00', '11:40:00', '1.200.000', 'Business'),
('QG-178', 'Citilink', '20:15:00', '21:35:00', '700.000', 'Economy');

-- --------------------------------------------------------

--
-- Table structure for table `airplaneroute_airplane`
--

CREATE TABLE `airplaneroute_airplane` (
  `id` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `airplane_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airplaneroute_airplane`
--

INSERT INTO `airplaneroute_airplane` (`id`, `route_id`, `airplane_id`) VALUES
(1, 1, 'QG-178'),
(2, 2, 'MH 0785');

-- --------------------------------------------------------

--
-- Table structure for table `airplane_route`
--

CREATE TABLE `airplane_route` (
  `route_id` int(11) NOT NULL,
  `source_airport` varchar(255) NOT NULL,
  `destination_airport` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `airplane_route`
--

INSERT INTO `airplane_route` (`route_id`, `source_airport`, `destination_airport`) VALUES
(1, 'Halim Perdanakusuma', 'Juanda'),
(2, 'Kuala Lumpur', 'Suvarnabhumi');

-- --------------------------------------------------------

--
-- Table structure for table `booked_train_ticket`
--

CREATE TABLE `booked_train_ticket` (
  `booked_ticket_id` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `train_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `cityName` varchar(100) NOT NULL,
  `countryName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `cityName`, `countryName`) VALUES
(1, 'Jakarta', 'Indonesia'),
(2, 'Bandung', 'Indonesia'),
(3, 'Surabaya', 'Indonesia'),
(4, 'Medan', 'Indonesia'),
(5, 'Bali', 'Indonesia'),
(6, 'Yogyakarta', 'Indonesia'),
(7, 'Makassar', 'Indonesia'),
(8, 'Palembang', 'Indonesia'),
(9, 'Semarang', 'Indonesia'),
(10, 'Batam', 'Indonesia');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `id` int(11) NOT NULL,
  `hotelName` varchar(100) NOT NULL,
  `location` varchar(255) NOT NULL,
  `city_id` int(11) NOT NULL,
  `tipeRoom` varchar(50) NOT NULL,
  `returnTicket` enum('Yes','No') NOT NULL,
  `maxCapacity` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `status` enum('Available','Full','Closed') NOT NULL,
  `remainingRoom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `hotelName`, `location`, `city_id`, `tipeRoom`, `returnTicket`, `maxCapacity`, `price`, `status`, `remainingRoom`) VALUES
(1, 'Hotel Alpha', 'Jl. Mawar No.1', 1, 'Deluxe', 'No', 2, '150.00', 'Available', 10),
(2, 'Hotel Beta', 'Jl. Melati No.5', 2, 'Standard', 'Yes', 4, '100.50', 'Available', 20),
(3, 'Hotel Gamma', 'Jl. Cendana No.10', 3, 'Suite', 'No', 3, '250.75', 'Available', 5),
(4, 'Hotel Delta', 'Jl. Teratai Blok A2', 4, 'Deluxe', 'No', 2, '145.00', 'Full', 0),
(5, 'Hotel Epsilon', 'Jl. Anggrek No.8', 5, 'Standard', 'No', 4, '95.00', 'Available', 15),
(6, 'Hotel Zeta', 'Jl. Kemuning No.3', 6, 'Suite', 'Yes', 3, '220.50', 'Available', 6),
(7, 'Hotel Eta', 'Jl. Jati No.7', 7, 'Deluxe', 'Yes', 2, '160.25', 'Available', 8),
(8, 'Hotel Theta', 'Jl. Pinus Blok B5', 8, 'Standard', 'No', 4, '90.00', 'Closed', 0),
(9, 'Hotel Iota', 'Jl. Cemara No.12', 9, 'Suite', 'No', 3, '210.00', 'Available', 7),
(10, 'Hotel Kappa', 'Jl. Sakura No.15', 10, 'Deluxe', 'Yes', 2, '170.75', 'Available', 9);

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE `train` (
  `train_id` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `departure_time` time NOT NULL,
  `origin_time` time NOT NULL,
  `ticket_price` varchar(100) NOT NULL,
  `train_class` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`train_id`, `name`, `departure_time`, `origin_time`, `ticket_price`, `train_class`) VALUES
('A-123', 'Harina', '09:35:00', '20:15:00', '202500', 'Economy'),
('C-124', 'Mutiara Selatan', '19:20:00', '10:40:00', '457000', 'Executive');

-- --------------------------------------------------------

--
-- Table structure for table `trainroute_train`
--

CREATE TABLE `trainroute_train` (
  `id` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `train_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trainroute_train`
--

INSERT INTO `trainroute_train` (`id`, `route_id`, `train_id`) VALUES
(1, 1, 'A-123'),
(2, 1, 'C-124');

-- --------------------------------------------------------

--
-- Table structure for table `train_route`
--

CREATE TABLE `train_route` (
  `route_id` int(11) NOT NULL,
  `source_station` varchar(255) NOT NULL,
  `destination_station` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train_route`
--

INSERT INTO `train_route` (`route_id`, `source_station`, `destination_station`) VALUES
(1, 'Bandung', 'Surabaya');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `birthDate` date NOT NULL,
  `address` text NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nik` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `profilePicture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `birthDate`, `address`, `phoneNumber`, `username`, `password`, `nik`, `email`, `profilePicture`) VALUES
(1, 'admin', '0000-00-00', 'xyz', '001122233', 'admin', 'asd123', 'nik123', 'admin@gmail.com', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `airplane`
--
ALTER TABLE `airplane`
  ADD PRIMARY KEY (`airplane_id`);

--
-- Indexes for table `airplaneroute_airplane`
--
ALTER TABLE `airplaneroute_airplane`
  ADD PRIMARY KEY (`id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `airplane_id` (`airplane_id`);

--
-- Indexes for table `airplane_route`
--
ALTER TABLE `airplane_route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `booked_train_ticket`
--
ALTER TABLE `booked_train_ticket`
  ADD PRIMARY KEY (`booked_ticket_id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `train_id` (`train_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indexes for table `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`train_id`);

--
-- Indexes for table `trainroute_train`
--
ALTER TABLE `trainroute_train`
  ADD PRIMARY KEY (`id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `train_id` (`train_id`);

--
-- Indexes for table `train_route`
--
ALTER TABLE `train_route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `nik` (`nik`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `airplaneroute_airplane`
--
ALTER TABLE `airplaneroute_airplane`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `airplane_route`
--
ALTER TABLE `airplane_route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `booked_train_ticket`
--
ALTER TABLE `booked_train_ticket`
  MODIFY `booked_ticket_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `trainroute_train`
--
ALTER TABLE `trainroute_train`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `train_route`
--
ALTER TABLE `train_route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `airplaneroute_airplane`
--
ALTER TABLE `airplaneroute_airplane`
  ADD CONSTRAINT `airplaneroute_airplane_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `airplane_route` (`route_id`),
  ADD CONSTRAINT `airplaneroute_airplane_ibfk_2` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`);

--
-- Constraints for table `booked_train_ticket`
--
ALTER TABLE `booked_train_ticket`
  ADD CONSTRAINT `booked_train_ticket_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `train_route` (`route_id`),
  ADD CONSTRAINT `booked_train_ticket_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`);

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `trainroute_train`
--
ALTER TABLE `trainroute_train`
  ADD CONSTRAINT `trainroute_train_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `train_route` (`route_id`),
  ADD CONSTRAINT `trainroute_train_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
