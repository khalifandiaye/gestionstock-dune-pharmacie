-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Jeu 27 Novembre 2014 à 21:21
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `pharmacie`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `numcommande` varchar(20) NOT NULL,
  `codefournisseur` varchar(20) NOT NULL,
  `datecommande` date NOT NULL,
  `montant` decimal(20,0) NOT NULL,
  PRIMARY KEY (`numcommande`),
  KEY `com-cle-etr-four` (`codefournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`numcommande`, `codefournisseur`, `datecommande`, `montant`) VALUES
('1', '1', '2014-07-07', '650'),
('2', '1', '2014-07-06', '56');

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `codefournisseur` varchar(20) NOT NULL,
  `nomfournisseur` varchar(20) DEFAULT NULL,
  `adressefournisseur` varchar(20) NOT NULL,
  `villefournisseur` varchar(20) NOT NULL,
  `telefournisseur` int(20) NOT NULL,
  PRIMARY KEY (`codefournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `fournisseur`
--

INSERT INTO `fournisseur` (`codefournisseur`, `nomfournisseur`, `adressefournisseur`, `villefournisseur`, `telefournisseur`) VALUES
('1', 'Abdelah Alawi', 'Rue dispensaire sbat', 'Meknes', 632844167),
('2', 'Olkheiri Mohamed', '86;rue Twarga ', 'Fes', 677777788);

-- --------------------------------------------------------

--
-- Structure de la table `lignecommande`
--

CREATE TABLE IF NOT EXISTS `lignecommande` (
  `numcommande` varchar(20) NOT NULL,
  `codemedicament` varchar(20) NOT NULL,
  `qtemedicament` decimal(20,0) NOT NULL,
  `prix_achat` decimal(10,0) NOT NULL,
  KEY `lig-cle-etr-com` (`numcommande`),
  KEY `lig-cle-etr-med` (`codemedicament`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE IF NOT EXISTS `medicament` (
  `codemedicament` varchar(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  `prix` decimal(20,0) NOT NULL,
  `observation` varchar(20) NOT NULL,
  `posologie` varchar(20) NOT NULL,
  PRIMARY KEY (`codemedicament`),
  KEY `med-cle-etr-typ` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typemedicament`
--

CREATE TABLE IF NOT EXISTS `typemedicament` (
  `code` varchar(20) NOT NULL,
  `designation` varchar(20) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `typemedicament`
--

INSERT INTO `typemedicament` (`code`, `designation`) VALUES
('1', 'Comprimer'),
('2', 'Sirop');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `login`, `password`) VALUES
(1, 'aaa', 'aaa'),
(2, 'oifae', '123');

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE IF NOT EXISTS `vente` (
  `numvente` int(20) NOT NULL,
  `datevente` date NOT NULL,
  `montant` int(20) NOT NULL,
  PRIMARY KEY (`numvente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vente`
--

INSERT INTO `vente` (`numvente`, `datevente`, `montant`) VALUES
(1, '2014-11-02', 120);

-- --------------------------------------------------------

--
-- Structure de la table `ventemedicament`
--

CREATE TABLE IF NOT EXISTS `ventemedicament` (
  `codemedicament` varchar(20) NOT NULL,
  `numvente` int(20) NOT NULL,
  `qtevente` int(20) NOT NULL,
  KEY `ven-cle-etr-med` (`codemedicament`),
  KEY `ven-cle-etr-ven` (`numvente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `com-cle-etr-four` FOREIGN KEY (`codefournisseur`) REFERENCES `fournisseur` (`codefournisseur`);

--
-- Contraintes pour la table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `lig-cle-etr-com` FOREIGN KEY (`numcommande`) REFERENCES `commande` (`numcommande`),
  ADD CONSTRAINT `lig-cle-etr-med` FOREIGN KEY (`codemedicament`) REFERENCES `medicament` (`codemedicament`);

--
-- Contraintes pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `med-cle-etr-type` FOREIGN KEY (`code`) REFERENCES `typemedicament` (`code`);

--
-- Contraintes pour la table `ventemedicament`
--
ALTER TABLE `ventemedicament`
  ADD CONSTRAINT `ven-cle-etr-med` FOREIGN KEY (`codemedicament`) REFERENCES `medicament` (`codemedicament`),
  ADD CONSTRAINT `ven-cle-etr-ven` FOREIGN KEY (`numvente`) REFERENCES `vente` (`numvente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
