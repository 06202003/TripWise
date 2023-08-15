-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Agu 2023 pada 18.09
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
(1, 'admin', '0000-00-00', 'xyz', '001122233', 'admin', 'asd123', 'nik123', 'admin@gmail.com', '');

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
