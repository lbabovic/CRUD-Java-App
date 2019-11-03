-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2019 at 03:47 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `milovanovic`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `userID`) VALUES
(1, 1),
(2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `cardID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `cardNumber` bigint(20) NOT NULL DEFAULT '1111111111111111',
  `isDeleted` tinyint(4) NOT NULL,
  `expDate` varchar(5000) NOT NULL DEFAULT 'Jan (01)',
  `CCV` int(11) NOT NULL DEFAULT '111',
  `expYear` int(11) NOT NULL DEFAULT '2047'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`cardID`, `userID`, `cardNumber`, `isDeleted`, `expDate`, `CCV`, `expYear`) VALUES
(1, 11, 0, 0, '0', 0, 0),
(2, 12, 1234123412341234, 0, 'Feb (02)', 565, 2019),
(3, 13, 0, 0, '', 0, 0),
(4, 14, 3123456456787987, 0, 'May (05)', 456, 2024),
(5, 15, 0, 0, '', 0, 0),
(6, 16, 0, 0, '', 0, 0),
(7, 17, 1565465465465465, 0, 'Apr (04)', 555, 2023),
(8, 18, 1111222226464555, 0, 'Apr (04)', 454, 2022),
(9, 19, 0, 0, '', 0, 0),
(10, 20, 1111222226464555, 0, 'Jan (01)', 111, 2047);

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `purchasedAmount` int(11) NOT NULL,
  `checkedOut` tinyint(4) NOT NULL DEFAULT '0',
  `dateOfPurchase` datetime NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartID`, `userID`, `productID`, `purchasedAmount`, `checkedOut`, `dateOfPurchase`, `batch`) VALUES
(1, 18, 18, 1, 1, '2019-01-25 21:02:43', 58),
(4, 18, 1, 1, 1, '2019-01-25 21:03:37', 57),
(5, 18, 8, 1, 1, '2019-01-25 21:05:47', 56),
(6, 12, 18, 1, 1, '2019-01-25 21:05:47', 1),
(7, 14, 34, 1, 1, '2019-01-25 21:07:20', 2),
(8, 14, 28, 1, 1, '2019-01-25 21:07:20', 2),
(9, 14, 29, 1, 1, '2019-01-25 21:07:20', 2),
(46, 18, 30, 1, 1, '2019-01-29 15:45:59', 55),
(52, 18, 34, 1, 1, '0000-00-00 00:00:00', 54),
(58, 18, 1, 1, 1, '2019-01-29 17:36:07', 35),
(59, 18, 13, 1, 1, '2019-01-29 17:36:07', 35),
(60, 18, 33, 1, 1, '2019-01-29 17:36:07', 35),
(61, 18, 41, 1, 1, '2019-01-29 17:36:07', 35),
(63, 18, 30, 1, 1, '2019-01-29 17:49:58', 34),
(65, 18, 33, 1, 1, '2019-01-29 17:54:26', 28),
(66, 18, 41, 1, 1, '2019-01-29 17:54:26', 28),
(67, 18, 13, 1, 1, '2019-01-29 17:54:26', 28),
(69, 18, 5, 1, 1, '2019-01-29 18:11:54', 24),
(70, 18, 5, 1, 1, '2019-01-29 18:13:32', 23),
(73, 18, 25, 1, 1, '2019-01-29 19:34:47', 19),
(74, 17, 5, 1, 1, '2019-01-29 20:06:27', 2),
(75, 17, 16, 1, 1, '2019-01-29 20:06:27', 2),
(77, 17, 35, 1, 1, '2019-01-29 20:06:27', 2),
(78, 17, 31, 1, 1, '2019-01-29 20:06:27', 2),
(79, 17, 30, 1, 1, '2019-01-29 20:06:27', 2),
(80, 17, 40, 1, 1, '2019-01-29 20:06:27', 2),
(82, 18, 35, 1, 1, '2019-01-29 20:13:55', 17),
(86, 18, 35, 1, 1, '2019-01-29 20:59:59', 16),
(88, 18, 2, 1, 1, '2019-01-29 21:01:51', 15),
(89, 18, 26, 1, 1, '2019-01-29 21:04:06', 14),
(90, 18, 26, 1, 1, '2019-01-29 21:11:32', 13),
(92, 18, 30, 1, 1, '2019-01-30 13:39:09', 11),
(94, 18, 35, 1, 1, '2019-01-30 13:39:09', 11),
(95, 18, 40, 1, 1, '2019-01-30 13:39:09', 11),
(96, 18, 40, 1, 1, '2019-01-30 13:39:48', 10),
(97, 18, 1, 1, 1, '2019-01-30 13:44:55', 9),
(98, 18, 2, 1, 1, '2019-01-30 13:46:28', 8),
(99, 18, 2, 1, 1, '2019-01-30 13:50:26', 7),
(100, 18, 38, 1, 1, '2019-01-30 13:50:26', 7),
(105, 18, 22, 1, 1, '2019-01-30 17:30:34', 5),
(106, 18, 14, 1, 1, '2019-01-30 17:30:34', 5),
(118, 14, 19, 1, 1, '2019-01-30 18:04:11', 1),
(119, 18, 3, 1, 1, '2019-01-30 18:07:24', 3),
(120, 18, 2, 6, 1, '2019-01-30 18:12:57', 2),
(121, 18, 21, 1, 1, '2019-01-30 18:20:31', 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `categoryID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `previousID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `picture` varchar(1000) NOT NULL,
  `gender` varchar(500) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `userID`, `picture`, `gender`, `description`, `balance`) VALUES
(1, 10, 'userImages/JOKKOJ.png', 'Male', 'Happy and good boy\n', -4774),
(2, 11, 'userImages/JOKKOJ.png', 'Male', 'Happy and good boy\n', -4774),
(3, 12, 'userImages/Dell-Optiplex-760-Desktop-2.jpg', 'Male', 'Happy and good boy\n', 4636),
(4, 13, '', 'Male', 'Happy and good boy\n', -4774),
(5, 14, '', 'Male', 'Happy and good boy\n', 17146),
(6, 15, '', 'Male', 'Happy and good boy\n', -1234),
(7, 16, '', 'Male', 'Happy and good boy\n', -1234),
(8, 17, '', 'Male', 'Happy and good boy\n', 10050),
(9, 18, '', 'Male', 'Happy and good boy\n', 4100.5),
(10, 19, '', 'Male', 'Happy and good boy\n', -1234),
(11, 20, '', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `invoices`
--

CREATE TABLE `invoices` (
  `invoiceID` int(11) NOT NULL,
  `itemsID` int(11) NOT NULL,
  `price` double NOT NULL,
  `ItemsNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemsID` int(11) NOT NULL,
  `cartID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `productID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `isDeleted` tinyint(4) NOT NULL,
  `imgUrl` varchar(500) NOT NULL DEFAULT 'img/placeholderImgUpload.png',
  `amount` int(11) NOT NULL,
  `category` varchar(5000) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`productID`, `name`, `description`, `isDeleted`, `imgUrl`, `amount`, `category`, `price`) VALUES
(1, 'Drug Special', 'Very good drug buy please', 0, 'uploaded/DavinciMoth.jpg', 47, 'Mouse and keyboards', 1234),
(2, 'Pita sa jabukama', 'Zjabukama', 0, 'uploaded/Pita-Bread-served-in-a-bowl-wrapped-in-white-cloth-featured.jpg', 991, 'Game console', 1.5),
(3, 'Praljak', 'Bottoms up', 0, 'uploaded/NAPPON.png', 0, 'Smartphone', 5678),
(4, 'Ok', 'Buddy', 0, 'uploaded/2jdms6.jpg', 14, 'Laptop', 234),
(5, 'God', 'God', 0, 'uploaded/DP9lW1zX4AAIoBh.jpg', 1420, 'Game console', 142),
(6, 'lmao', 'lmao', 0, 'uploaded/0d1.jpg', 124, 'Desktop PC', 665),
(7, 'NAPPON', 'LEOOEL', 0, 'uploaded/NAPPON.png', 4123, 'Smartphone', 423),
(8, 'JOKKOJ', 'KODZIMA', 0, 'uploaded/JOKKOJ.png', 411, 'Laptop', 886),
(10, 'Moljafc', 'agdsfrjgjrtyutrsgfxghadfgtrfd', 0, 'uploaded/DavinciMoth.jpg', 64, 'Mouse and keyboards', 245),
(11, 'THANOS MOTH', 'THANOS MOTH', 0, 'uploaded/thanosmoththanosmoth.jpg', 654, 'Smartphone', 3432),
(12, 'civ V', 'F', 0, 'uploaded/20171129210854_1.jpg', 53434, 'Smartphone', 74),
(13, 'Drug', 'Ð”Ð Ð£Ð“', 0, 'uploaded/mothbro.jpg', 50, 'Monitor', 232),
(14, 'Nokia 3000', 'A really durable phone!', 0, 'uploaded/1200px-Nokia_1112.jpg', 49, 'Smartphone', 40),
(15, 'Samsung Vive', 'Brand new virtual device from samsung.', 0, 'uploaded/gear-vr_overview_men.png', 20, 'Game console', 800),
(16, 'HP 1942 Stalingrad', 'Battle hardened laptop, for the Ð¼Ð¾Ñ‚Ñ…ÐµÑ€Ð»Ð°Ð½Ð´!', 0, 'uploaded/50049225_515381.png', 0, 'Laptop', 1200),
(17, 'Njegos Kindle', 'A revolutionary device!', 0, 'uploaded/Kindle-Wi-Fi-com-4GB-Tela-6-Sensivel-ao-Toque-Bateria-com-longa-Duracao-e-Leitura-sem-Reflexo-3875691.jpg', 5, 'Tablet', 600),
(18, 'LG 4K Monitor', 'Amazing resolution like you\'ve never seen before!', 0, 'uploaded/20_24M38H-medium01.jpg', 50, 'Monitor', 800),
(19, 'Acer 3456K', 'Really good monitor you guys', 0, 'uploaded/acer_um_fg6aa_b01_gn246hl_bbid_24_3d_ready_1073477.jpg', 8, 'Monitor', 500),
(20, 'HP 18.5 Inc', 'Great for people who like monitors!', 0, 'uploaded/51Z0ALvn1wL._SX300_QL70_.jpg', 37, 'Monitor', 470),
(21, 'Fighter Pilot monitor', 'It\'s a monitor.', 0, 'uploaded/91pVxwJwpwL._SL1500_.jpg', 31, 'Monitor', 543),
(22, 'PS4', 'Brand new Sony console has only been out for 6 years!', 0, 'uploaded/5850905_sa.jpg', 39, 'Game console', 299),
(23, 'Nintendo Switch', 'You can play the newest Mario and Zelda!', 0, 'uploaded/4NM8IK0000010_VD_999.jpg', 300, 'Game console', 400),
(24, 'Sega Genesis', 'Great Old Console!', 0, 'uploaded/GUEST_bf18e298-ba8b-43c6-b593-8ae9fcc9b8c1.jpg', 30, 'Game console', 120),
(25, 'LG-V30', 'Large Screen, Great Performance', 0, 'uploaded/V30-medium01.jpg', 299, 'Smartphone', 700),
(26, 'iPhone X', 'Same like last years only more expensive!', 0, 'uploaded/asdsadasd.jpg', 598, 'Smartphone', 1100),
(27, 'Lava', 'Lava', 0, 'uploaded/63427797.jpg', 12, 'Smartphone', 400),
(28, 'Lenovo Tab-4', 'If you\'re reading this you\'ve but 33 seconds to live', 0, 'uploaded/6201032_sa.jpg', 39, 'Tablet', 400),
(29, 'Samsung Galaxy S3', 'Samsung Galaxy S3', 0, 'uploaded/l_10161522_001.jpg', 29, 'Tablet', 600),
(30, 'Huawei MediaPad T-3', 'Huawei MediaPad', 0, 'uploaded/61joS5V1q9L._SX355_.jpg', 26, 'Tablet', 450),
(31, 'HP Envy 13-T', 'HP Envy 13-T laptop', 0, 'uploaded/aHR0cHM6Ly93d3cubGFwdG9wbWFnLmNvbS9pbWFnZXMvdXBsb2Fkcy80NjE0L2cvaHAtZW52eS0xMy0wMDEuanBn.jpg', 17, 'Laptop', 456),
(32, 'Mediacom SmartBook SB130', 'Mediacom Smartbook SB130 is very good buy it', 0, 'uploaded/mediacom-smartbook-sb130-not12029-laptop-13-3-quot-full-hd-intel-quad-core-atom-x5-z8350-4gb-32gb-ssd-128gb-ssd-intel-hd-win10-srebrni_0nXGH_3.jpg', 23, 'Laptop', 2345),
(33, 'Del XPS 9370', 'Great looking laptop!', 0, 'uploaded/41Kg1-vU4TL._SX425_.jpg', 397, 'Laptop', 676),
(34, 'Logitech K760', 'Keyboard of your dreams', 0, 'uploaded/k740-refresh-gallery-image.png', 297, 'Mouse and keyboards', 120),
(35, 'HP k1500', 'Keyboard!', 0, 'uploaded/41jXe9dmQmL._SX425_.jpg', 496, 'Mouse and keyboards', 80),
(36, 'CORSAIR K55', 'Keyboard for true GAMERS! ', 0, 'uploaded/5707081_sd.jpg', 499, 'Mouse and keyboards', 139),
(37, 'M90 HP Optical', 'Optical mouse', 0, 'uploaded/mouton-boat-m90-refresh-gallery-image.png', 300, 'Mouse and keyboards', 25),
(38, 'Pulsefire Surgett', 'Pretty RGB lights', 0, 'uploaded/hx-features-mouse-pulsefire-surge.jpg', 399, 'Mouse and keyboards', 100),
(39, 'ASUS ROG Pugio Aura', 'Even more RGB!!', 0, 'uploaded/201711AM280000002_15118170872067010087873.jpg', 300, 'Mouse and keyboards', 120),
(40, 'HP Omen', 'HP Omen', 0, 'uploaded/c05506810.png', 97, 'Desktop PC', 1600),
(41, 'Dell Optiplex 760', 'Great for office work!', 0, 'uploaded/Dell-Optiplex-760-Desktop-2.jpg', 496, 'Desktop PC', 345),
(42, 'Supercomputer', 'Can run Crysis', 0, 'uploaded/300px-IBM_Blue_Gene_P_supercomputer.jpg', 1, 'Desktop PC', 99999),
(46, 'NOVI ITEM OK', 'asdasd	', 0, 'img/placeholderImgUpload.png', 412, 'Monitor', 32);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  `location` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `username`, `password`, `name`, `surname`, `isDeleted`, `location`, `email`) VALUES
(1, 'admin', 'admin', 'Qw', 'Qw', 0, '', 'ns@ns.com'),
(2, 'Tukmak', 'test', 'Retard', 'Krenencic', 0, '', 'ok@adsasd.com'),
(3, 'ok', 'ataeta', 'ok', 'ok', 0, '', 'ok@ok.com'),
(4, 'tajmer', 'tajmer', 'tajmer', 'tajmer', 0, '', 'ok@ok.com'),
(5, 'We', 'we', 'We', 'We', 0, '', 'ns@ns.com'),
(6, 'asdasdads', 'marko', 'asdasd', 'dasdasd', 0, '', 'asdadas@asdasd.df'),
(7, 'ghdfdsg', 'markovic', 'gdsafhdgsdff', 'fdfgdssghfdgsdf', 0, '', 'asd@hdfdsf.jhgfd'),
(8, 'Asdf', '$2y$10$nKJ4zjaM1epej', 'iuytrew', 'qwerty', 0, '', 'ns@ns.com'),
(9, 'qwerty', 'qwerty', 'mnbvc', 'qwerty', 0, '', 'ns@ns.com'),
(10, 'qwerttrewq', '$2y$10$A4m.aXKCDFzYt', 'minimum', 'asdfghfdsa', 0, '', 'ns@ns.com'),
(11, 'LMAO', '$2y$10$9KDMH2I0EePpB', 'ttttyry', 'yyyyry', 0, '', 'ns@ns.com'),
(12, 'Er', '$2y$10$ovR5KGF/npaRr', 'Er', 'Er', 0, '', 'mr@mr.com'),
(13, 'Rt', '$2y$10$9D/Ct17LyCpIk', 'Rt', 'Rt', 0, '', 'Rt@RT.com'),
(14, 'Ar', '$2y$10$Vtea36nLRnzKI', 'Ar', 'ar@ar.com', 0, '', 'ar@ar.com'),
(15, 'Et', '$2y$10$xtXmxVARXNGTQ', 'Et', 'Et', 0, '', 'Et'),
(16, 'Aa', '$2y$10$lC0wRhcCHfMKS', 'Aa', 'Aa', 0, '', 'aA@aA'),
(17, 'Nibba', '$2y$10$xCbMaVmIT3Uh7', 'Nibba', 'Nibba', 0, '', 'Nibba@nibba'),
(18, 'Simon', '$2y$10$cDXZaTvXCDSYa', 'Simonida', 'Simono', 0, '', 'smon@a.com'),
(19, 'Aaaa', '$2y$10$KX1EWdhn8hpEP', 'Aaa', 'Aaa', 0, '', 'Aaa@aa'),
(20, 'Op', '$2y$10$vTrd/7ofT7c3E', 'asdasd', 'asdasda', 0, '', 'ok@ok.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`),
  ADD KEY `FK_UserAdminID` (`userID`);

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`cardID`),
  ADD KEY `FK_UserID` (`userID`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartID`),
  ADD KEY `FK_UserCartID` (`userID`),
  ADD KEY `FK_ProductCartID` (`productID`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`categoryID`),
  ADD KEY `FK_PreviousID` (`previousID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`),
  ADD KEY `FK_UserCustomerID` (`userID`);

--
-- Indexes for table `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`invoiceID`),
  ADD KEY `FK_ItemsID` (`itemsID`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemsID`),
  ADD KEY `FK_UserItemsID` (`userID`),
  ADD KEY `FK_ProdcutItemsID` (`productID`),
  ADD KEY `FK_CartItemsID` (`cartID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `userID` (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `card`
--
ALTER TABLE `card`
  MODIFY `cardID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `categoryID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `invoices`
--
ALTER TABLE `invoices`
  MODIFY `invoiceID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `itemsID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK_UserAdminID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `FK_UserID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `FK_ProductCartID` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`),
  ADD CONSTRAINT `FK_UserCartID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `FK_PreviousID` FOREIGN KEY (`previousID`) REFERENCES `category` (`categoryID`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FK_UserCustomerID` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`);

--
-- Constraints for table `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `FK_ItemsID` FOREIGN KEY (`itemsID`) REFERENCES `items` (`itemsID`);

--
-- Constraints for table `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `FK_CartItemsID` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`),
  ADD CONSTRAINT `FK_ProdcutItemsID` FOREIGN KEY (`productID`) REFERENCES `cart` (`productID`),
  ADD CONSTRAINT `FK_UserItemsID` FOREIGN KEY (`userID`) REFERENCES `cart` (`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
