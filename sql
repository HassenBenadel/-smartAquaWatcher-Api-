-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 12 mai 2023 à 00:48
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pi4sleam`
--

-- --------------------------------------------------------

--
-- Structure de la table `barage`
--

CREATE TABLE `barage` (
  `id` bigint(20) NOT NULL,
  `capacite` float DEFAULT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `niveau` float DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `barage`
--

INSERT INTO `barage` (`id`, `capacite`, `mac`, `niveau`, `nom`, `region`) VALUES
(1, 220, 'BARAGE1', 50, 'SIDI THABT', 'SIDI THABET'),
(2, 300, 'BARAGE2', 30, 'BIR BAY', 'BIR BAY'),
(3, 50, 'c27635670b9e1565c3cf916d4e62a0a0bed75ed31c348723147763bf29426b46', 26.1402, 'sidi barrak', 'beja');

-- --------------------------------------------------------

--
-- Structure de la table `grandeur`
--

CREATE TABLE `grandeur` (
  `id` bigint(20) NOT NULL,
  `critique` bit(1) DEFAULT NULL,
  `heure` datetime DEFAULT current_timestamp(),
  `humidite` float DEFAULT NULL,
  `ph` float DEFAULT NULL,
  `temp` float DEFAULT NULL,
  `turbidite` float DEFAULT NULL,
  `noeud_id_noeud` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `grandeur`
--

INSERT INTO `grandeur` (`id`, `critique`, `heure`, `humidite`, `ph`, `temp`, `turbidite`, `noeud_id_noeud`) VALUES
(2, b'0', '2023-03-07 18:15:19', 2, 2, 2, 2, NULL),
(3, b'0', '2023-03-07 18:15:19', 2, 2, 2, 2, NULL),
(4, b'0', '2023-03-07 18:15:50', 3, 3, 33, 3, NULL),
(5, b'0', '2023-03-07 18:15:50', 4, 4, 4, 4, NULL),
(6, b'0', '2023-03-07 18:15:50', 3, 3, 33, 3, NULL),
(7, b'0', '2023-03-07 18:15:50', 4, 4, 4, 4, NULL),
(8, b'1', NULL, 0, 5.87, 19.37, 2489.64, 1),
(9, b'1', NULL, 59, 4.85, 19.62, 2779.49, 1),
(10, b'1', NULL, 58, 4.83, 19.56, 2844.17, 1),
(11, b'1', NULL, 58, 4.8, 19.56, 2868.53, 1),
(12, b'1', NULL, 57, 4.81, 19.56, 2883.65, 1),
(13, b'1', NULL, 57, 4.76, 19.56, 2960.09, 1),
(14, b'1', NULL, 56, 4.75, 19.56, 2964.4, 1),
(15, b'1', NULL, 56, 4.75, 19.56, 2964.4, 1),
(16, b'1', NULL, 56, 4.75, 19.56, 2968.49, 1),
(17, b'1', NULL, 56, 4.75, 19.56, 2968.49, 1),
(18, b'1', NULL, 56, 4.76, 19.5, 2968.49, 1),
(19, b'1', NULL, 54, 4.55, 19.69, 3000, 1),
(20, b'1', NULL, 54, 4.52, 19.69, 3000, 1),
(21, b'1', NULL, 54, 6.46, 17.75, 3000, 1),
(22, b'1', NULL, 54, 6.24, 17.94, 3000, 1),
(23, b'1', NULL, 53, 6.23, 16.69, 3000, 1),
(24, b'1', NULL, 53, 6.27, 16.06, 3000, 1),
(25, b'1', NULL, 54, 6.25, 15.88, 3000, 1),
(26, b'1', NULL, 54, 6.15, 15.81, 3000, 1),
(27, b'1', NULL, 54, 6.18, 15.81, 3000, 1),
(28, b'1', NULL, 54, 6.24, 15.81, 3000, 1),
(29, b'1', NULL, 54, 6.27, 15.81, 3000, 1),
(30, b'1', NULL, 54, 6.26, 15.75, 3000, 1),
(31, b'1', NULL, 55, 6.27, 15.75, 3000, 1),
(32, b'1', NULL, 55, 6.27, 15.75, 3000, 1),
(33, b'1', NULL, 55, 6.28, 15.75, 3000, 1),
(34, b'1', NULL, 55, 6.26, 15.81, 3000, 1),
(35, b'1', NULL, 55, 6.26, 15.81, 3000, 1),
(36, b'1', NULL, 55, 6.26, 15.81, 3000, 1),
(37, b'1', NULL, 55, 6.26, 15.81, 3000, 1),
(38, b'1', NULL, 55, 6.26, 15.88, 3000, 1),
(39, b'1', NULL, 55, 6.24, 15.81, 3000, 1),
(40, b'1', NULL, 55, 6.25, 15.81, 3000, 1),
(41, b'1', NULL, 55, 6.24, 15.81, 3000, 1),
(42, b'0', '2023-05-04 21:16:35', 56.5, 7, 23.32, 2900, 1),
(43, b'0', '2023-05-05 19:12:09', 100, 7, 20, 3000, NULL),
(44, b'0', '2023-05-05 19:12:09', 200, 7, 30, 2500, NULL),
(45, b'0', '2023-05-05 19:12:09', 50, 7, 30, 2900, NULL),
(46, b'0', '2023-05-05 19:12:56', 250, 5, 5, 5, NULL),
(47, b'0', '2023-05-05 19:12:56', 350, 7, 44, 1000, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `noeud`
--

CREATE TABLE `noeud` (
  `id_noeud` bigint(20) NOT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `barage_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `noeud`
--

INSERT INTO `noeud` (`id_noeud`, `mac`, `barage_id`) VALUES
(1, 'eb978065e80b1b67c83be37c2a8f1630e54e16887796bb30f9088b3006a017c1', 3),
(2, '5555', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `approval` bit(1) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `approval`, `code`, `email`, `login`, `password`, `phone_number`, `type`) VALUES
(1, b'1', 139, 'siamend123456789@gmail.com', 'string', '_Mhb321654987', 'string', 1),
(3, b'1', 0, 'string1', 'string1', 'string2', 'string2', 0),
(6, b'1', 0, 'string4', 'string4', 'string2', 'string2', 0),
(8, b'1', NULL, 'nehdi@gmail.com', 'nehdi', 'nehdi', '25361247', 0),
(9, b'1', 0, 'stringg', 'stringg', 'stringg', 'stringg', 0);

-- --------------------------------------------------------

--
-- Structure de la table `user_barages`
--

CREATE TABLE `user_barages` (
  `users_id` bigint(20) NOT NULL,
  `barages_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_barages`
--

INSERT INTO `user_barages` (`users_id`, `barages_id`) VALUES
(1, 1),
(1, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `barage`
--
ALTER TABLE `barage`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `grandeur`
--
ALTER TABLE `grandeur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK20464o1g32k1uj318sdhkfd7a` (`noeud_id_noeud`);

--
-- Index pour la table `noeud`
--
ALTER TABLE `noeud`
  ADD PRIMARY KEY (`id_noeud`),
  ADD KEY `FK7dejemc1i3vm6hp0k62qvv0ik` (`barage_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UK_ew1hvam8uwaknuaellwhqchhb` (`login`);

--
-- Index pour la table `user_barages`
--
ALTER TABLE `user_barages`
  ADD PRIMARY KEY (`users_id`,`barages_id`),
  ADD KEY `FKbwxuaqkwvxss65vf6mfpiqfe2` (`barages_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `barage`
--
ALTER TABLE `barage`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `grandeur`
--
ALTER TABLE `grandeur`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT pour la table `noeud`
--
ALTER TABLE `noeud`
  MODIFY `id_noeud` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `grandeur`
--
ALTER TABLE `grandeur`
  ADD CONSTRAINT `FK20464o1g32k1uj318sdhkfd7a` FOREIGN KEY (`noeud_id_noeud`) REFERENCES `noeud` (`id_noeud`);

--
-- Contraintes pour la table `noeud`
--
ALTER TABLE `noeud`
  ADD CONSTRAINT `FK7dejemc1i3vm6hp0k62qvv0ik` FOREIGN KEY (`barage_id`) REFERENCES `barage` (`id`);

--
-- Contraintes pour la table `user_barages`
--
ALTER TABLE `user_barages`
  ADD CONSTRAINT `FKbwxuaqkwvxss65vf6mfpiqfe2` FOREIGN KEY (`barages_id`) REFERENCES `barage` (`id`),
  ADD CONSTRAINT `FKrmevtrvjmvwk3m3r2jm5opubk` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
