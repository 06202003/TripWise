-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 14 Agu 2023 pada 04.49
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
-- Database: `tripwise`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `airplane`
--

CREATE TABLE `airplane` (
  `airplaneName` varchar(50) NOT NULL,
  `originTime` varchar(50) DEFAULT NULL,
  `departureTime` varchar(50) DEFAULT NULL,
  `ticketPrice` varchar(50) DEFAULT NULL,
  `airplaneClass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `airplaneroute`
--

CREATE TABLE `airplaneroute` (
  `sourceAirport` varchar(50) DEFAULT NULL,
  `destinationAirport` varchar(50) DEFAULT NULL,
  `availableAirplane` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `event`
--

CREATE TABLE `event` (
  `name` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hotel`
--

CREATE TABLE `hotel` (
  `nameHotel` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  `checkIn` varchar(50) DEFAULT NULL,
  `checkOut` varchar(50) DEFAULT NULL,
  `tipeRoom` varchar(50) DEFAULT NULL,
  `returnTicket` varchar(50) DEFAULT NULL,
  `maxCapacity` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `station`
--

CREATE TABLE `station` (
  `name` varchar(50) NOT NULL,
  `location` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `ticket`
--

CREATE TABLE `ticket` (
  `id` int(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `NIK` int(50) DEFAULT NULL,
  `PNR` int(50) DEFAULT NULL,
  `orderDate` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `departure` varchar(50) DEFAULT NULL,
  `arrival` varchar(50) DEFAULT NULL,
  `departureTime` varchar(50) DEFAULT NULL,
  `arrivalTime` varchar(50) DEFAULT NULL,
  `noChair` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `train`
--

CREATE TABLE `train` (
  `trainName` varchar(50) NOT NULL,
  `departureTime` varchar(50) DEFAULT NULL,
  `originTime` varchar(50) DEFAULT NULL,
  `ticketPrice` varchar(50) DEFAULT NULL,
  `trainClass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `trainroute`
--

CREATE TABLE `trainroute` (
  `sourceStation` varchar(50) DEFAULT NULL,
  `destinationStation` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `tanggalLahir` varchar(50) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `NIK` int(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `profilePicture` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `airplane`
--
ALTER TABLE `airplane`
  ADD PRIMARY KEY (`airplaneName`);

--
-- Indeks untuk tabel `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`name`);

--
-- Indeks untuk tabel `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`nameHotel`);

--
-- Indeks untuk tabel `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`name`);

--
-- Indeks untuk tabel `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`trainName`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
