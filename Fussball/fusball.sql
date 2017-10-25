-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 20, 2017 at 11:55 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fusball`
--

-- --------------------------------------------------------

--
-- Table structure for table `fixtures`
--

CREATE TABLE `fixtures` (
  `fixtures_id` int(11) NOT NULL,
  `home_points` int(11) NOT NULL,
  `away_points` int(11) NOT NULL,
  `home_team` int(11) NOT NULL,
  `away_team` int(11) NOT NULL,
  `league` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fixtures`
--

INSERT INTO `fixtures` (`fixtures_id`, `home_points`, `away_points`, `home_team`, `away_team`, `league`, `date`) VALUES
(1, 2, 3, 7, 6, 1, '2017-10-06'),
(2, 1, 0, 50, 54, 3, '2017-10-06'),
(3, 2, 5, 25, 35, 4, '2017-09-14'),
(4, 2, 2, 14, 10, 1, '2017-09-14'),
(5, 1, 1, 43, 41, 4, '2017-10-06');

-- --------------------------------------------------------

--
-- Table structure for table `league`
--

CREATE TABLE `league` (
  `league_id` int(11) NOT NULL,
  `league_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Football leagues';

--
-- Dumping data for table `league`
--

INSERT INTO `league` (`league_id`, `league_name`) VALUES
(1, 'Premier League'),
(3, 'Serie A'),
(4, 'La Liga');

-- --------------------------------------------------------

--
-- Table structure for table `leaguetable`
--

CREATE TABLE `leaguetable` (
  `leaguetable_id` int(11) NOT NULL,
  `team` int(11) NOT NULL,
  `league` int(11) NOT NULL,
  `played` int(11) NOT NULL,
  `wins` int(11) NOT NULL,
  `losses` int(11) NOT NULL,
  `draws` int(11) NOT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `team_id` int(11) NOT NULL,
  `team_name` varchar(64) NOT NULL,
  `league` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Team table';

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`team_id`, `team_name`, `league`) VALUES
(1, 'Brandbergen IF', 1),
(2, 'Liverpool', 1),
(3, 'Manchester United', 1),
(4, 'Manchester City', 1),
(5, 'Stoke City', 1),
(6, 'Tottenham Hotspur', 1),
(7, 'Chelsea', 1),
(8, 'Crystal Palace', 1),
(9, 'Watford', 1),
(10, 'Burnley', 1),
(11, 'Huddersfield Town', 1),
(12, 'Everton', 1),
(13, 'Leicester', 1),
(14, 'Bournemouth', 1),
(15, 'West Ham United', 1),
(16, 'Brighton Hove Albion', 1),
(17, 'Swansea City', 1),
(18, 'Southampton', 1),
(19, 'West Bromwich Albion', 1),
(20, 'Newcastle United', 1),
(25, 'Real Madrid', 4),
(26, 'Atletico Madrid', 4),
(27, 'Barcelona', 4),
(28, 'Sevilla', 4),
(29, 'Athletic Bilbao', 4),
(30, 'Valencia', 4),
(31, 'Real Sociedad', 4),
(32, 'Rojterz', 4),
(33, 'Espanyol', 4),
(34, 'Celta Vigo', 4),
(35, 'Getafe', 4),
(36, 'Deportivo', 4),
(37, 'Eibar', 4),
(38, 'Girona', 4),
(39, 'Las Palmas', 4),
(40, 'Alavés', 4),
(41, 'Malaga', 4),
(42, 'Leganés', 4),
(43, 'Real Betis', 4),
(44, '', 4),
(45, 'Internazionale', 3),
(46, 'Milan', 3),
(47, 'Napoli', 3),
(48, 'Juventus', 3),
(49, 'Torino', 3),
(50, 'Lazio', 3),
(51, 'Fiorentina', 3),
(52, 'Chievo Verona', 3),
(53, 'Hellas Verona', 3),
(54, 'Roma', 3),
(55, '', 3),
(56, 'Bologna', 3),
(57, 'Atalanta', 3),
(58, 'Cagliari', 3),
(59, 'Udinese', 3),
(60, 'Crotone', 3),
(61, 'Genoa', 3),
(62, 'Sassuolo', 3),
(63, 'SPAL', 3),
(64, 'Benevento', 3),
(65, 'Wolverhampton', 1),
(66, 'Sheffield Wednesday', 1),
(67, 'Sheffield United', 1),
(68, 'Uppsala TopBoyz', 1),
(77, 'Gabriels FK', 4),
(78, 'Apberget FC', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fixtures`
--
ALTER TABLE `fixtures`
  ADD PRIMARY KEY (`fixtures_id`),
  ADD KEY `home_team_toid` (`home_team`),
  ADD KEY `away_team_toid` (`away_team`),
  ADD KEY `fixtures_to_league` (`league`);

--
-- Indexes for table `league`
--
ALTER TABLE `league`
  ADD PRIMARY KEY (`league_id`);

--
-- Indexes for table `leaguetable`
--
ALTER TABLE `leaguetable`
  ADD PRIMARY KEY (`leaguetable_id`),
  ADD KEY `table_to_league` (`league`),
  ADD KEY `table_to_team` (`team`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`team_id`),
  ADD KEY `team_to_league` (`league`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fixtures`
--
ALTER TABLE `fixtures`
  MODIFY `fixtures_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `league`
--
ALTER TABLE `league`
  MODIFY `league_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `leaguetable`
--
ALTER TABLE `leaguetable`
  MODIFY `leaguetable_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `fixtures`
--
ALTER TABLE `fixtures`
  ADD CONSTRAINT `away_team_toid` FOREIGN KEY (`away_team`) REFERENCES `team` (`team_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fixtures_to_league` FOREIGN KEY (`league`) REFERENCES `league` (`league_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `home_team_toid` FOREIGN KEY (`home_team`) REFERENCES `team` (`team_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `leaguetable`
--
ALTER TABLE `leaguetable`
  ADD CONSTRAINT `table_to_league` FOREIGN KEY (`league`) REFERENCES `league` (`league_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `table_to_team` FOREIGN KEY (`team`) REFERENCES `team` (`team_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `team_to_league` FOREIGN KEY (`league`) REFERENCES `league` (`league_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
