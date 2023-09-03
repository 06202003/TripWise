-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Sep 2023 pada 15.19
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

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
-- Struktur dari tabel `airplane`
--

CREATE TABLE `airplane` (
  `airplane_id` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `origin_time` time NOT NULL,
  `departure_time` time NOT NULL,
  `ticket_price` varchar(255) NOT NULL,
  `airplane_class` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `airplane`
--

INSERT INTO `airplane` (`airplane_id`, `name`, `origin_time`, `departure_time`, `ticket_price`, `airplane_class`) VALUES
('1', 'Garuda Indonesia Flight 101', '08:00:00', '10:00:00', '1,500,000', 'Economy'),
('10', 'Delta Air Lines Flight 1010', '18:00:00', '20:00:00', '2,000,000', 'Business'),
('11', 'KLM Flight 1111', '14:00:00', '16:00:00', '2,100,000', 'Business'),
('12', 'Air France Flight 1212', '15:00:00', '17:00:00', '1,900,000', 'Economy'),
('13', 'Etihad Airways Flight 1313', '08:00:00', '10:00:00', '2,400,000', 'Business'),
('14', 'China Eastern Airlines Flight 1414', '09:00:00', '11:00:00', '1,500,000', 'Economy'),
('15', 'United Airlines Flight 1515', '12:00:00', '14:00:00', '2,800,000', 'First'),
('16', 'Cathay Dragon Flight 1616', '15:00:00', '17:00:00', '1,300,000', 'Economy'),
('17', 'EVA Air Flight 1717', '08:00:00', '10:00:00', '1,700,000', 'Business'),
('18', 'Japan Airlines Flight 1818', '09:00:00', '11:00:00', '2,200,000', 'Business'),
('19', 'Thai Airways Flight 1919', '12:00:00', '14:00:00', '2,100,000', 'Economy'),
('2', 'Lion Air Flight 202', '09:00:00', '11:00:00', '1,800,000', 'Business'),
('20', 'British Airways Flight 2020', '15:00:00', '17:00:00', '2,600,000', 'First'),
('21', 'Malaysia Airlines Flight 2121', '08:00:00', '10:00:00', '1,600,000', 'Economy'),
('22', 'Swiss International Air Lines Flight 2222', '09:00:00', '11:00:00', '2,300,000', 'Business'),
('23', 'Korean Air Flight 2323', '12:00:00', '14:00:00', '1,800,000', 'Business'),
('24', 'Qatar Airways Flight 2424', '15:00:00', '17:00:00', '2,700,000', 'First'),
('25', 'Virgin Atlantic Flight 2525', '08:00:00', '10:00:00', '2,400,000', 'Business'),
('3', 'Singapore Airlines Flight 303', '12:00:00', '14:00:00', '2,500,000', 'First'),
('4', 'Emirates Flight 404', '15:00:00', '17:00:00', '2,800,000', 'Business'),
('5', 'Cathay Pacific Flight 505', '18:00:00', '20:00:00', '1,200,000', 'Economy'),
('6', 'AirAsia Flight 606', '08:00:00', '10:00:00', '800,000', 'Economy'),
('7', 'Qantas Flight 707', '09:00:00', '11:00:00', '2,200,000', 'Business'),
('8', 'Turkish Airlines Flight 808', '12:00:00', '14:00:00', '2,800,000', 'First'),
('9', 'ANA Flight 909', '15:00:00', '17:00:00', '1,700,000', 'Economy');

-- --------------------------------------------------------

--
-- Struktur dari tabel `airplaneroute_airplane`
--

CREATE TABLE `airplaneroute_airplane` (
  `id` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `airplane_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `airplaneroute_airplane`
--

INSERT INTO `airplaneroute_airplane` (`id`, `route_id`, `airplane_id`) VALUES
(78, 3, '1'),
(79, 4, '2'),
(80, 5, '3'),
(81, 6, '4'),
(82, 7, '5'),
(83, 8, '6'),
(84, 9, '7'),
(85, 10, '8'),
(86, 11, '9'),
(87, 12, '10'),
(88, 13, '11'),
(89, 14, '12'),
(90, 15, '13'),
(91, 16, '14'),
(92, 17, '15'),
(93, 18, '16'),
(94, 19, '17'),
(95, 20, '18'),
(96, 21, '19'),
(97, 22, '20'),
(98, 23, '21'),
(99, 24, '22'),
(100, 25, '23'),
(101, 26, '24'),
(102, 27, '25');

-- --------------------------------------------------------

--
-- Struktur dari tabel `airplane_route`
--

CREATE TABLE `airplane_route` (
  `route_id` int(11) NOT NULL,
  `source_airport` varchar(255) NOT NULL,
  `destination_airport` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `airplane_route`
--

INSERT INTO `airplane_route` (`route_id`, `source_airport`, `destination_airport`) VALUES
(3, 'Soekarno-Hatta International Airport', 'Ngurah Rai International Airport'),
(4, 'Juanda International Airport', 'Kuala Lumpur International Airport'),
(5, 'Changi Airport', 'Incheon International Airport'),
(6, 'Los Angeles International Airport', 'London Heathrow Airport'),
(7, 'Tokyo Haneda Airport', 'Sydney Kingsford Smith Airport'),
(8, 'Hong Kong International Airport', 'Dubai International Airport'),
(9, 'Jomo Kenyatta International Airport', 'Cape Town International Airport'),
(10, 'Adolfo Suárez Madrid–Barajas Airport', 'São Paulo/Guarulhos–Governador André Franco Montoro International Airport'),
(11, 'Hamad International Airport', 'Paris Charles de Gaulle Airport'),
(12, 'Indira Gandhi International Airport', 'Pudong International Airport'),
(13, 'Soekarno-Hatta International Airport', 'Juanda International Airport'),
(14, 'Kuala Lumpur International Airport', 'Changi Airport'),
(15, 'Incheon International Airport', 'Los Angeles International Airport'),
(16, 'London Heathrow Airport', 'Tokyo Haneda Airport'),
(17, 'Sydney Kingsford Smith Airport', 'Hong Kong International Airport'),
(18, 'Dubai International Airport', 'Jomo Kenyatta International Airport'),
(19, 'Cape Town International Airport', 'Adolfo Suárez Madrid–Barajas Airport'),
(20, 'São Paulo/Guarulhos–Governador André Franco Montoro International Airport', 'Hamad International Airport'),
(21, 'Paris Charles de Gaulle Airport', 'Indira Gandhi International Airport'),
(22, 'Pudong International Airport', 'Soekarno-Hatta International Airport'),
(23, 'Ngurah Rai International Airport', 'Juanda International Airport'),
(24, 'Kuala Lumpur International Airport', 'Incheon International Airport'),
(25, 'Changi Airport', 'London Heathrow Airport'),
(26, 'Los Angeles International Airport', 'Sydney Kingsford Smith Airport'),
(27, 'Tokyo Haneda Airport', 'Dubai International Airport');

-- --------------------------------------------------------

--
-- Struktur dari tabel `booked_train_ticket`
--

CREATE TABLE `booked_train_ticket` (
  `booked_ticket_id` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `train_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `cityName` varchar(100) NOT NULL,
  `countryName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `city`
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
-- Struktur dari tabel `hotel`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `hotel`
--

INSERT INTO `hotel` (`id`, `hotelName`, `location`, `city_id`, `tipeRoom`, `returnTicket`, `maxCapacity`, `price`, `status`, `remainingRoom`) VALUES
(1, 'Hotel Alpha', 'Jl. Mawar No.1', 1, 'Deluxe', 'No', 2, 150.00, 'Available', 10),
(2, 'Hotel Beta', 'Jl. Melati No.5', 2, 'Standard', 'Yes', 4, 100.50, 'Available', 20),
(3, 'Hotel Gamma', 'Jl. Cendana No.10', 3, 'Suite', 'No', 3, 250.75, 'Available', 5),
(4, 'Hotel Delta', 'Jl. Teratai Blok A2', 4, 'Deluxe', 'No', 2, 145.00, 'Full', 0),
(5, 'Hotel Epsilon', 'Jl. Anggrek No.8', 5, 'Standard', 'No', 4, 95.00, 'Available', 15),
(6, 'Hotel Zeta', 'Jl. Kemuning No.3', 6, 'Suite', 'Yes', 3, 220.50, 'Available', 6),
(7, 'Hotel Eta', 'Jl. Jati No.7', 7, 'Deluxe', 'Yes', 2, 160.25, 'Available', 8),
(8, 'Hotel Theta', 'Jl. Pinus Blok B5', 8, 'Standard', 'No', 4, 90.00, 'Closed', 0),
(9, 'Hotel Iota', 'Jl. Cemara No.12', 9, 'Suite', 'No', 3, 210.00, 'Available', 7),
(10, 'Hotel Kappa', 'Jl. Sakura No.15', 10, 'Deluxe', 'Yes', 2, 170.75, 'Available', 9);

-- --------------------------------------------------------

--
-- Struktur dari tabel `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `check_in_date` date DEFAULT NULL,
  `check_out_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `hotel_id`, `city_id`, `check_in_date`, `check_out_date`) VALUES
(1, 1, 5, 5, '2023-09-13', '2023-09-19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `train`
--

CREATE TABLE `train` (
  `train_id` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `departure_time` time NOT NULL,
  `origin_time` time NOT NULL,
  `ticket_price` varchar(100) NOT NULL,
  `train_class` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `train`
--

INSERT INTO `train` (`train_id`, `name`, `departure_time`, `origin_time`, `ticket_price`, `train_class`) VALUES
('T001', 'Java Express', '08:00:00', '06:00:00', '200000', 'Economy'),
('T002', 'Sumatra Fast Train', '09:00:00', '07:30:00', '250000', 'Business'),
('T003', 'Borneo Railways', '12:00:00', '09:30:00', '300000', 'First'),
('T004', 'Sulawesi Supertrain', '15:00:00', '12:00:00', '350000', 'Business'),
('T005', 'Kalimantan Express', '18:00:00', '15:30:00', '180000', 'Economy'),
('T006', 'Jakarta Metro', '07:30:00', '05:30:00', '150000', 'Economy'),
('T007', 'Medan Swift Line', '09:30:00', '07:00:00', '220000', 'Business'),
('T008', 'Bandung Pegasus', '12:30:00', '10:00:00', '280000', 'First'),
('T009', 'Yogyakarta Royal', '14:30:00', '12:30:00', '210000', 'Economy'),
('T010', 'Surabaya Bullet', '17:30:00', '15:00:00', '260000', 'Business'),
('T011', 'Bali Railtour', '08:30:00', '06:30:00', '190000', 'Economy'),
('T012', 'Lombok Express', '10:30:00', '08:30:00', '230000', 'Business'),
('T013', 'Sumbawa Islander', '13:30:00', '11:30:00', '270000', 'First'),
('T014', 'Flores Voyager', '16:30:00', '14:30:00', '240000', 'Business'),
('T015', 'Papua Odyssey', '07:00:00', '04:30:00', '170000', 'Economy'),
('T016', 'Maluku Express', '09:00:00', '06:30:00', '200000', 'Economy'),
('T017', 'Bintan Railways', '11:00:00', '08:30:00', '250000', 'Business'),
('T018', 'Batam Metro', '14:00:00', '11:30:00', '290000', 'First'),
('T019', 'Karimun Line', '16:00:00', '13:30:00', '220000', 'Economy'),
('T020', 'Kalimantan Explorer', '08:00:00', '05:30:00', '260000', 'Business'),
('T021', 'Sulawesi Safari', '10:00:00', '07:30:00', '180000', 'Economy'),
('T022', 'Java Jet', '12:00:00', '09:30:00', '230000', 'Business'),
('T023', 'Sumatra Voyager', '15:00:00', '12:30:00', '270000', 'First'),
('T024', 'Borneo Express', '17:00:00', '14:30:00', '240000', 'Business'),
('T025', 'Bali Pacific', '19:00:00', '16:30:00', '210000', 'Economy'),
('T026', 'Sumatra Express', '08:30:00', '06:30:00', '220000', 'Economy'),
('T027', 'Borneo Rapid', '10:30:00', '08:30:00', '260000', 'Business'),
('T028', 'Java Voyager', '13:30:00', '11:30:00', '280000', 'First'),
('T029', 'Sulawesi Rocket', '16:30:00', '14:30:00', '240000', 'Business'),
('T030', 'Kalimantan Flyer', '18:30:00', '16:30:00', '210000', 'Economy'),
('T031', 'Jakarta Shuttle', '07:00:00', '04:30:00', '170000', 'Economy'),
('T032', 'Medan Express', '09:00:00', '06:30:00', '200000', 'Economy'),
('T033', 'Bandung Rocket', '11:00:00', '08:30:00', '250000', 'Business'),
('T034', 'Yogyakarta Jet', '14:00:00', '11:30:00', '290000', 'First'),
('T035', 'Surabaya Express', '16:00:00', '13:30:00', '220000', 'Economy'),
('T036', 'Bali Supertrain', '08:00:00', '05:30:00', '260000', 'Business'),
('T037', 'Lombok Bullet', '10:00:00', '07:30:00', '180000', 'Economy'),
('T038', 'Sumbawa Jet', '12:00:00', '09:30:00', '230000', 'Business'),
('T039', 'Flores Voyager', '15:00:00', '12:30:00', '270000', 'First'),
('T040', 'Papua Express', '17:00:00', '14:30:00', '240000', 'Business'),
('T041', 'Maluku Rocket', '19:00:00', '16:30:00', '210000', 'Economy'),
('T042', 'Bintan Express', '08:30:00', '06:30:00', '200000', 'Economy'),
('T043', 'Batam Flyer', '10:30:00', '08:30:00', '250000', 'Business'),
('T044', 'Karimun Express', '13:30:00', '11:30:00', '290000', 'First'),
('T045', 'Kalimantan Voyager', '16:30:00', '14:30:00', '240000', 'Business'),
('T046', 'Sulawesi Express', '18:30:00', '16:30:00', '210000', 'Economy');

-- --------------------------------------------------------

--
-- Struktur dari tabel `trainroute_train`
--

CREATE TABLE `trainroute_train` (
  `id` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `train_id` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `trainroute_train`
--

INSERT INTO `trainroute_train` (`id`, `route_id`, `train_id`) VALUES
(3, 1, 'T001'),
(4, 2, 'T002'),
(5, 3, 'T003'),
(6, 4, 'T004'),
(7, 5, 'T005'),
(8, 6, 'T006'),
(9, 7, 'T007'),
(10, 8, 'T008'),
(11, 9, 'T009'),
(12, 10, 'T010'),
(13, 11, 'T011'),
(14, 12, 'T012'),
(15, 13, 'T013'),
(16, 14, 'T014'),
(17, 15, 'T015'),
(18, 16, 'T016'),
(19, 17, 'T017'),
(20, 18, 'T018'),
(21, 19, 'T019'),
(22, 20, 'T020'),
(23, 21, 'T021'),
(24, 22, 'T022'),
(25, 23, 'T023'),
(26, 24, 'T024'),
(27, 25, 'T025'),
(29, 1, 'T026'),
(30, 2, 'T027'),
(31, 3, 'T028'),
(32, 4, 'T029'),
(33, 5, 'T030'),
(34, 6, 'T031'),
(35, 7, 'T032'),
(36, 8, 'T033'),
(37, 9, 'T034'),
(38, 10, 'T035'),
(39, 11, 'T036'),
(40, 12, 'T037'),
(41, 13, 'T038'),
(42, 14, 'T039'),
(43, 15, 'T040'),
(44, 16, 'T041'),
(45, 17, 'T042'),
(46, 18, 'T043'),
(47, 19, 'T044'),
(48, 20, 'T045');

-- --------------------------------------------------------

--
-- Struktur dari tabel `train_route`
--

CREATE TABLE `train_route` (
  `route_id` int(11) NOT NULL,
  `source_station` varchar(255) NOT NULL,
  `destination_station` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `train_route`
--

INSERT INTO `train_route` (`route_id`, `source_station`, `destination_station`) VALUES
(1, 'Bandung', 'Surabaya'),
(2, 'Jakarta Station', 'Surabaya Station'),
(3, 'Bandung Station', 'Yogyakarta Station'),
(4, 'Medan Station', 'Padang Station'),
(5, 'Semarang Station', 'Solo Station'),
(6, 'Makassar Station', 'Manado Station'),
(7, 'Denpasar Station', 'Lombok Station'),
(8, 'Palembang Station', 'Pekanbaru Station'),
(9, 'Baliuag Station', 'Caloocan Station'),
(10, 'Bangkok Station', 'Chiang Mai Station'),
(11, 'Kuala Lumpur Station', 'Penang Station'),
(12, 'Singapore Station', 'Kuala Lumpur Station'),
(13, 'Ho Chi Minh City Station', 'Hanoi Station'),
(14, 'Beijing Station', 'Shanghai Station'),
(15, 'Tokyo Station', 'Osaka Station'),
(16, 'Seoul Station', 'Busan Station'),
(17, 'Istanbul Station', 'Ankara Station'),
(18, 'Cairo Station', 'Alexandria Station'),
(19, 'Rome Station', 'Milan Station'),
(20, 'Paris Station', 'Marseille Station'),
(21, 'London Station', 'Manchester Station'),
(22, 'Berlin Station', 'Hamburg Station'),
(23, 'New York Station', 'Los Angeles Station'),
(24, 'Toronto Station', 'Montreal Station'),
(25, 'Sydney Station', 'Melbourne Station'),
(26, 'Cape Town Station', 'Durban Station');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `name`, `birthDate`, `address`, `phoneNumber`, `username`, `password`, `nik`, `email`, `profilePicture`) VALUES
(1, 'admin', '2023-09-03', 'xyz', '001122233', 'admin', 'asd123', 'nik123', 'admin@gmail.com', '');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `airplane`
--
ALTER TABLE `airplane`
  ADD PRIMARY KEY (`airplane_id`);

--
-- Indeks untuk tabel `airplaneroute_airplane`
--
ALTER TABLE `airplaneroute_airplane`
  ADD PRIMARY KEY (`id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `airplane_id` (`airplane_id`);

--
-- Indeks untuk tabel `airplane_route`
--
ALTER TABLE `airplane_route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indeks untuk tabel `booked_train_ticket`
--
ALTER TABLE `booked_train_ticket`
  ADD PRIMARY KEY (`booked_ticket_id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `train_id` (`train_id`);

--
-- Indeks untuk tabel `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indeks untuk tabel `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `hotel_id` (`hotel_id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indeks untuk tabel `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`train_id`);

--
-- Indeks untuk tabel `trainroute_train`
--
ALTER TABLE `trainroute_train`
  ADD PRIMARY KEY (`id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `train_id` (`train_id`);

--
-- Indeks untuk tabel `train_route`
--
ALTER TABLE `train_route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `nik` (`nik`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `airplaneroute_airplane`
--
ALTER TABLE `airplaneroute_airplane`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT untuk tabel `airplane_route`
--
ALTER TABLE `airplane_route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT untuk tabel `booked_train_ticket`
--
ALTER TABLE `booked_train_ticket`
  MODIFY `booked_ticket_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT untuk tabel `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `trainroute_train`
--
ALTER TABLE `trainroute_train`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT untuk tabel `train_route`
--
ALTER TABLE `train_route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `airplaneroute_airplane`
--
ALTER TABLE `airplaneroute_airplane`
  ADD CONSTRAINT `airplaneroute_airplane_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `airplane_route` (`route_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `airplaneroute_airplane_ibfk_2` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`airplane_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `booked_train_ticket`
--
ALTER TABLE `booked_train_ticket`
  ADD CONSTRAINT `booked_train_ticket_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `train_route` (`route_id`),
  ADD CONSTRAINT `booked_train_ticket_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`);

--
-- Ketidakleluasaan untuk tabel `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);

--
-- Ketidakleluasaan untuk tabel `trainroute_train`
--
ALTER TABLE `trainroute_train`
  ADD CONSTRAINT `trainroute_train_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `train_route` (`route_id`),
  ADD CONSTRAINT `trainroute_train_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
