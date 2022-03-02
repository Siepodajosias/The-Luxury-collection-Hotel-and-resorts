-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 27 fév. 2022 à 17:02
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `luxury_hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `avoir`
--

CREATE TABLE `avoir` (
  `id_Service` int(11) NOT NULL,
  `id_Chambre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `avoir`
--

INSERT INTO `avoir` (`id_Service`, `id_Chambre`) VALUES
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(4, 6),
(5, 1),
(5, 2),
(5, 3),
(5, 4),
(5, 5),
(5, 6),
(6, 2),
(6, 3),
(6, 4),
(6, 5),
(6, 6),
(7, 1),
(7, 4),
(7, 5),
(7, 6),
(8, 1),
(8, 2),
(8, 3),
(8, 4),
(8, 5),
(8, 6),
(9, 1),
(9, 2),
(9, 3),
(9, 4),
(9, 5),
(9, 6),
(10, 1),
(10, 2),
(10, 3),
(10, 4),
(10, 5),
(10, 6);

-- --------------------------------------------------------

--
-- Structure de la table `chambres`
--

CREATE TABLE `chambres` (
  `Chambre_Numero` int(11) NOT NULL,
  `Chambre_Telephone` int(11) NOT NULL,
  `Chambre_Description` varchar(45) NOT NULL,
  `Chambre_Prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `chambres`
--

INSERT INTO `chambres` (`Chambre_Numero`, `Chambre_Telephone`, `Chambre_Description`, `Chambre_Prix`) VALUES
(1, 325, 'avec une piscine, 4 personnes ,mini réfrigéra', 300),
(2, 233, '1 personne, baie vitré, climatisé', 150),
(3, 167, 'Famille, 3 grands lits,2 grandes douche baign', 500),
(4, 109, 'tv 100 pouces, dressing, piscine', 200),
(5, 100, 'rand lit, tv', 100),
(6, 758, 'lit superposé , douche', 75);

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `iClient_Id` int(11) NOT NULL,
  `Client_Nom` varchar(30) NOT NULL,
  `Client_Prenom` varchar(30) NOT NULL,
  `Client_age` int(15) NOT NULL,
  `Client_Numero` int(20) NOT NULL,
  `Client_Ville` varchar(30) NOT NULL,
  `Client_Profession` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`iClient_Id`, `Client_Nom`, `Client_Prenom`, `Client_age`, `Client_Numero`, `Client_Ville`, `Client_Profession`) VALUES
(1, 'souame', 'marie dominique', 21, 789103379, 'Abidjan', 'etudiante'),
(4, 'sié', 'poda', 23, 714326787, 'jacqueville', 'entrepreneur'),
(5, 'youbi', 'mélanie', 35, 724983745, 'Adiaké', 'juge'),
(6, 'aké', 'marilyse', 25, 539185454, 'san-pédro', 'conseillé client'),
(7, 'Ouattara', 'michelle', 45, 545673234, 'Mankono', 'commerçant'),
(8, 'yao', 'sandrine', 30, 748562910, 'Bouaké', 'comptable'),
(9, 'datcha', 'cédric', 25, 1235479800, 'Abidjan', 'étudiant');

-- --------------------------------------------------------

--
-- Structure de la table `employes`
--

CREATE TABLE `employes` (
  `Employe_id` int(11) NOT NULL,
  `Employe_Nom` varchar(30) NOT NULL,
  `Employe_Prenom` varchar(45) NOT NULL,
  `Employe_age` int(20) NOT NULL,
  `Employe_Genre` varchar(20) NOT NULL,
  `Employe_Ville` varchar(45) NOT NULL,
  `Employe_Numero` int(15) NOT NULL,
  `Employe_service` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employes`
--

INSERT INTO `employes` (`Employe_id`, `Employe_Nom`, `Employe_Prenom`, `Employe_age`, `Employe_Genre`, `Employe_Ville`, `Employe_Numero`, `Employe_service`) VALUES
(1, 'Loulou', 'dida', 27, 'Feminin', 'Abidjan', 767893445, 9),
(2, 'Benoit', 'Boukari', 45, 'Masculin', 'Yaoudé', 77830410, 7),
(3, 'Saada', 'lisa', 34, 'Feminin', 'gagnoa', 756931267, 8),
(4, 'Mendor', 'djeli', 54, 'Feminin', 'San-pedro', 565903345, 2),
(5, 'Diallo', 'djenabou', 27, 'Feminin', 'Guinée', 678432119, 6),
(6, 'André ', 'la porte', 32, 'Masculin', 'Abidjan', 768954329, 3),
(7, 'Aristide', 'la branche', 60, 'Masculin', 'Abidjan', 765894532, 10),
(8, 'Assey', 'la neige', 37, 'Masculin', 'Nice', 937491874, 4),
(9, 'Kouassi', 'mirabelle', 24, 'Feminin', 'Sergi', 5382402, 5);

-- --------------------------------------------------------

--
-- Structure de la table `factures`
--

CREATE TABLE `factures` (
  `Facture_Id` int(11) NOT NULL,
  `Facture_Montant` double NOT NULL,
  `Facture_Date` date NOT NULL,
  `Facture_Reservation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `factures`
--

INSERT INTO `factures` (`Facture_Id`, `Facture_Montant`, `Facture_Date`, `Facture_Reservation`) VALUES
(1, 300, '2022-09-06', 38),
(2, 150, '2022-02-08', 39),
(3, 500, '2022-02-25', 40),
(4, 200, '2022-03-23', 41),
(5, 100, '2022-04-02', 42),
(6, 75, '2022-04-25', 43);

-- --------------------------------------------------------

--
-- Structure de la table `occupation`
--

CREATE TABLE `occupation` (
  `Occupation_Id` int(11) NOT NULL,
  `Occupation_Date_Debut` date NOT NULL,
  `Occupation_Date_Fin` date NOT NULL,
  `Occupation_Chambre` int(11) NOT NULL,
  `Occupation_Client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `occupation`
--

INSERT INTO `occupation` (`Occupation_Id`, `Occupation_Date_Debut`, `Occupation_Date_Fin`, `Occupation_Chambre`, `Occupation_Client`) VALUES
(1, '2022-02-07', '2022-09-06', 1, 1),
(2, '2022-02-08', '2022-02-25', 2, 4),
(3, '2022-02-17', '2022-02-26', 3, 5),
(4, '2022-02-23', '2022-03-23', 4, 6),
(5, '2022-04-06', '2022-05-09', 5, 7),
(6, '2022-02-08', '2022-02-28', 6, 8),
(7, '2022-02-24', '2022-02-24', 2, 9);

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

CREATE TABLE `reservations` (
  `Reservation_Id` int(11) NOT NULL,
  `Reservation_Date_Debut` date NOT NULL,
  `Reservation_Date_Fin` date NOT NULL,
  `Reservation_DatePaye` date NOT NULL,
  `Reservation_Service` int(11) NOT NULL,
  `Reservation_Chambre` int(11) NOT NULL,
  `Reservation_Client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `reservations`
--

INSERT INTO `reservations` (`Reservation_Id`, `Reservation_Date_Debut`, `Reservation_Date_Fin`, `Reservation_DatePaye`, `Reservation_Service`, `Reservation_Chambre`, `Reservation_Client`) VALUES
(38, '2022-02-07', '2022-09-06', '2022-09-06', 2, 1, 1),
(39, '2022-02-08', '2022-02-25', '2022-02-08', 3, 2, 4),
(40, '2022-02-17', '2022-02-26', '2022-02-25', 4, 3, 5),
(41, '2022-02-23', '2022-03-23', '2022-03-23', 7, 4, 6),
(42, '2022-04-06', '2022-05-09', '2022-04-02', 9, 5, 7),
(43, '2022-02-08', '2022-02-28', '2022-02-25', 8, 6, 8),
(44, '2022-02-24', '2022-02-24', '2022-02-24', 6, 2, 9);

-- --------------------------------------------------------

--
-- Structure de la table `services`
--

CREATE TABLE `services` (
  `Services_Id` int(11) NOT NULL,
  `Service_Description` varchar(45) NOT NULL,
  `Service_Heure_Debut` date NOT NULL,
  `Service_Heure_Fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `services`
--

INSERT INTO `services` (`Services_Id`, `Service_Description`, `Service_Heure_Debut`, `Service_Heure_Fin`) VALUES
(2, 'menage', '2022-02-01', '2022-10-26'),
(3, 'plombier', '2022-02-02', '2023-05-19'),
(4, 'chauffeur', '2022-02-01', '2022-11-10'),
(5, 'jardinier', '2022-02-02', '2022-09-09'),
(6, 'sécrétaire', '2022-02-02', '2022-03-24'),
(7, 'cuisinier', '2022-02-01', '2022-05-20'),
(8, 'sécurité', '2022-02-15', '2022-10-13'),
(9, 'bagagiste', '2022-02-10', '2022-11-03'),
(10, 'maitre d\'hotel', '2022-02-02', '2022-07-13');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD PRIMARY KEY (`id_Service`,`id_Chambre`),
  ADD KEY `id_Service_idx` (`id_Service`),
  ADD KEY `id_Chambre_idx` (`id_Chambre`);

--
-- Index pour la table `chambres`
--
ALTER TABLE `chambres`
  ADD PRIMARY KEY (`Chambre_Numero`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`iClient_Id`);

--
-- Index pour la table `employes`
--
ALTER TABLE `employes`
  ADD PRIMARY KEY (`Employe_id`),
  ADD KEY `Employe_Service_idx` (`Employe_service`);

--
-- Index pour la table `factures`
--
ALTER TABLE `factures`
  ADD PRIMARY KEY (`Facture_Id`),
  ADD KEY `Facture_Reservation_idx` (`Facture_Reservation`);

--
-- Index pour la table `occupation`
--
ALTER TABLE `occupation`
  ADD PRIMARY KEY (`Occupation_Id`),
  ADD KEY `Occupation_Chambre_idx` (`Occupation_Chambre`),
  ADD KEY `Occupation_Client_idx` (`Occupation_Client`);

--
-- Index pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`Reservation_Id`),
  ADD KEY `Reservation_Service_idx` (`Reservation_Service`),
  ADD KEY `Reservation_Chambre_idx` (`Reservation_Chambre`),
  ADD KEY `Reservation_Client_idx` (`Reservation_Client`);

--
-- Index pour la table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`Services_Id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `iClient_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `employes`
--
ALTER TABLE `employes`
  MODIFY `Employe_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `factures`
--
ALTER TABLE `factures`
  MODIFY `Facture_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `occupation`
--
ALTER TABLE `occupation`
  MODIFY `Occupation_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `Reservation_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT pour la table `services`
--
ALTER TABLE `services`
  MODIFY `Services_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD CONSTRAINT `id_Chambre` FOREIGN KEY (`id_Chambre`) REFERENCES `chambres` (`Chambre_Numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_Service` FOREIGN KEY (`id_Service`) REFERENCES `services` (`Services_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `employes`
--
ALTER TABLE `employes`
  ADD CONSTRAINT `Employe_Service` FOREIGN KEY (`Employe_service`) REFERENCES `services` (`Services_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `factures`
--
ALTER TABLE `factures`
  ADD CONSTRAINT `Facture_Reservation` FOREIGN KEY (`Facture_Reservation`) REFERENCES `reservations` (`Reservation_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `occupation`
--
ALTER TABLE `occupation`
  ADD CONSTRAINT `Occupation_Chambre` FOREIGN KEY (`Occupation_Chambre`) REFERENCES `chambres` (`Chambre_Numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Occupation_Client` FOREIGN KEY (`Occupation_Client`) REFERENCES `clients` (`iClient_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `Reservation_Chambre` FOREIGN KEY (`Reservation_Chambre`) REFERENCES `chambres` (`Chambre_Numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Reservation_Client` FOREIGN KEY (`Reservation_Client`) REFERENCES `clients` (`iClient_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Reservation_Service` FOREIGN KEY (`Reservation_Service`) REFERENCES `services` (`Services_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
