-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 05 fév. 2022 à 19:30
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gatcha`
--
CREATE DATABASE IF NOT EXISTS `gatcha` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gatcha`;

-- --------------------------------------------------------

--
-- Structure de la table `box`
--

DROP TABLE IF EXISTS `box`;
CREATE TABLE IF NOT EXISTS `box` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `GatchaID` varchar(255) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `carte` varchar(255) NOT NULL,
  `logo` varchar(255) NOT NULL,
  `ATQ` int(11) NOT NULL,
  `DEF` int(11) NOT NULL,
  `PV` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
