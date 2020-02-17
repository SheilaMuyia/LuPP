-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 14, 2019 at 01:55 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `admin`
--

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `password`) VALUES
(2, 'Librarian', 'laikipia');

-- --------------------------------------------------------

--
-- Table structure for table `lupp`
--

CREATE TABLE `lupp` (
  `id` int(11) NOT NULL,
  `name` varchar(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `hobby` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lupp`
--

INSERT INTO `lupp` (`id`, `name`, `username`, `password`, `hobby`) VALUES
(1, 'Karen', 'karen', 'abcde', 'Singing'),
(2, '', '', '', ''),
(4, 'dan', 'danny', '1234', 'n11/3/1229/016'),
(5, 'abcde', 'abcde', 'abcde', 'abcde'),
(6, 'dennis', 'den', '123', 'n16/3'),
(7, 'karen', 'karenn', 'karen', 'b12'),
(8, 'Daniel', 'danyz', 'dan123', 'L11/1/1507/016'),
(9, 'dan', 'Dan', 'dan123', 'L11/1/1507/016'),
(10, 'Nancy', 'nancyk', 'kigosho', 'N11/3/1228/016');

-- --------------------------------------------------------

--
-- Table structure for table `PdfTable`
--

CREATE TABLE `PdfTable` (
  `id` int(50) NOT NULL,
  `PdfURL` varchar(100) NOT NULL,
  `PdfName` varchar(50) NOT NULL,
  `year` int(10) NOT NULL,
  `unitname` varchar(50) NOT NULL,
  `unitcode` varchar(50) NOT NULL,
  `lecturer` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PdfTable`
--

INSERT INTO `PdfTable` (`id`, `PdfURL`, `PdfName`, `year`, `unitname`, `unitcode`, `lecturer`) VALUES
(22, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/22.pdf', 'den', 0, '', '', ''),
(24, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/24.pdf', 'lyrics', 0, '', '', ''),
(34, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/34.pdf', 'BICT', 20554667, 'Knowledge based systems', 'COMP 416', 'Ireri'),
(41, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/41.pdf', 'BICT', 0, 'Knowledge based systems', 'COMP 416', 'Ireri'),
(51, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/42.pdf', 'BICT', 2, 'Knowledge based systems', 'COMP 416', 'Ireri'),
(52, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/52.pdf', '', 0, '', '', ''),
(53, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/53.pdf', 'BICT', 1, 'whatever', 'COMP314', 'Ireri'),
(54, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/54.pdf', 'BICT', 1, 'whatever', 'COMP314', 'Ireri'),
(55, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/55.pdf', 'BICT', 1, 'whatever', 'COMP314', 'Ireri'),
(64, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/64.pdf', 'COMPSCI', 0, 'whatever', 'COMP314', 'Ireri'),
(65, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/65.pdf', 'COMPSCI', 1, 'HURI', 'Companies201', 'Poti'),
(66, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/66.pdf', 'COMPSCI', 1, 'Stack', 'stack3012', 'Poti'),
(68, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/68.pdf', 'COMPSCI', 1, 'Berea', 'nerea', 'Poti'),
(69, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/69.pdf', 'COMPSCI', 3, 'Components Design', 'COMP308', 'Sir'),
(70, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/70.pdf', 'COMPSCI', 1, 'Components Design', 'COMP308', 'Sir'),
(71, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/71.pdf', 'COMPSCI', 1, 'Components Design', 'COMP308', 'Sir'),
(72, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/72.pdf', 'COMPSCI', 1, 'Components Design', 'COMP308', 'Sir'),
(73, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/73.pdf', 'compsci', 2, 'ai', 'Comp308', 'Madam Ireri'),
(74, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/74.pdf', 'COMPSCI', 2, 'ai', 'Comp306', 'Sir Makupi'),
(75, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/75.pdf', 'COMPSCI', 2, 'ai', 'Comp306', 'Sir Makupi'),
(76, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/76.pdf', 'COMPSCI', 2, 'ai', 'Comp306', 'Sir Makupi'),
(77, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/77.pdf', 'COMPSCI', 2, 'pass', 'Comp306', 'Sir Makupi'),
(78, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/78.pdf', 'COMPSCI', 2, 'pass', 'Comp306', 'Sir Makupi'),
(79, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/79.pdf', 'COMPSCI', 2, 'pass', 'Comp306', 'Sir Makupi'),
(80, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/80.pdf', 'COMPSCI', 2, 'pass', 'Comp306', 'Sir Makupi'),
(81, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/81.pdf', 'COMPSCI', 2, 'pass', 'Comp306', 'Sir Makupi'),
(82, 'http://192.168.43.247/AndroidUpload/PdfUploadFolder/82.docx', 'COMPSCI', 3, 'Electricity & Magnetism II', 'Phys 220', 'Mr Muliro');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lupp`
--
ALTER TABLE `lupp`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `PdfTable`
--
ALTER TABLE `PdfTable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lupp`
--
ALTER TABLE `lupp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `PdfTable`
--
ALTER TABLE `PdfTable`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
