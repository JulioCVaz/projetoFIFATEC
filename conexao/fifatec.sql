-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 28-Set-2018 às 05:48
-- Versão do servidor: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fifatec`
--
CREATE DATABASE IF NOT EXISTS `fifatec` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `fifatec`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `camiseta`
--

CREATE TABLE `camiseta` (
  `id_camiseta` int(11) NOT NULL,
  `num_camiseta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `emblematime`
--

CREATE TABLE `emblematime` (
  `id_emblema` int(11) NOT NULL,
  `path_image` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `entidadejogo`
--

CREATE TABLE `entidadejogo` (
  `id_entidade` int(11) NOT NULL,
  `camisetaID` int(11) DEFAULT NULL,
  `timeID` int(11) DEFAULT NULL,
  `pessoaID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcoes`
--

CREATE TABLE `funcoes` (
  `id_funcao` int(11) NOT NULL,
  `desc_funcao` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcoes`
--

INSERT INTO `funcoes` (`id_funcao`, `desc_funcao`) VALUES
(1, 'Tecnico'),
(2, 'Goleiro'),
(3, 'Batedorpenalti'),
(4, 'Arbitro'),
(5, 'Bandeirinha'),
(6, 'Juíz'),
(7, 'Gandula'),
(8, 'Torcedor Educado'),
(9, 'Torcedor Mal Educado');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id_pessoa` int(11) NOT NULL,
  `nome_pessoa` varchar(255) DEFAULT NULL,
  `funcaoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id_pessoa`, `nome_pessoa`, `funcaoID`) VALUES
(1, 'Julio Vaz', 2),
(2, 'Douglas', 2),
(3, 'Caio de sá', 3),
(4, 'Italo', 3),
(5, 'Guilherme', 9),
(6, 'Gustavo', 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ranking`
--

CREATE TABLE `ranking` (
  `id_ranking` int(11) NOT NULL,
  `timeID` int(11) DEFAULT NULL,
  `pontos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `time`
--

CREATE TABLE `time` (
  `id_time` int(11) NOT NULL,
  `nome_time` varchar(255) DEFAULT NULL,
  `emblematimeID` int(11) DEFAULT NULL,
  `torcedorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `time`
--

INSERT INTO `time` (`id_time`, `nome_time`, `emblematimeID`, `torcedorID`) VALUES
(1, 'Santos etec club', 1, 5),
(2, 'Corinthians etec club', 2, 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `camiseta`
--
ALTER TABLE `camiseta`
  ADD PRIMARY KEY (`id_camiseta`);

--
-- Indexes for table `emblematime`
--
ALTER TABLE `emblematime`
  ADD PRIMARY KEY (`id_emblema`);

--
-- Indexes for table `entidadejogo`
--
ALTER TABLE `entidadejogo`
  ADD PRIMARY KEY (`id_entidade`),
  ADD KEY `camisetaID` (`camisetaID`),
  ADD KEY `timeID` (`timeID`),
  ADD KEY `pessoaID` (`pessoaID`);

--
-- Indexes for table `funcoes`
--
ALTER TABLE `funcoes`
  ADD PRIMARY KEY (`id_funcao`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id_pessoa`),
  ADD KEY `funcaoID` (`funcaoID`);

--
-- Indexes for table `ranking`
--
ALTER TABLE `ranking`
  ADD PRIMARY KEY (`id_ranking`),
  ADD KEY `timeID` (`timeID`);

--
-- Indexes for table `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`id_time`),
  ADD KEY `torcedorID` (`torcedorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `camiseta`
--
ALTER TABLE `camiseta`
  MODIFY `id_camiseta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `emblematime`
--
ALTER TABLE `emblematime`
  MODIFY `id_emblema` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `entidadejogo`
--
ALTER TABLE `entidadejogo`
  MODIFY `id_entidade` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `funcoes`
--
ALTER TABLE `funcoes`
  MODIFY `id_funcao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id_pessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ranking`
--
ALTER TABLE `ranking`
  MODIFY `id_ranking` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `time`
--
ALTER TABLE `time`
  MODIFY `id_time` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `entidadejogo`
--
ALTER TABLE `entidadejogo`
  ADD CONSTRAINT `entidadejogo_ibfk_1` FOREIGN KEY (`camisetaID`) REFERENCES `camiseta` (`id_camiseta`),
  ADD CONSTRAINT `entidadejogo_ibfk_2` FOREIGN KEY (`timeID`) REFERENCES `time` (`id_time`),
  ADD CONSTRAINT `entidadejogo_ibfk_3` FOREIGN KEY (`pessoaID`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `pessoa_ibfk_1` FOREIGN KEY (`funcaoID`) REFERENCES `funcoes` (`id_funcao`);

--
-- Limitadores para a tabela `ranking`
--
ALTER TABLE `ranking`
  ADD CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`timeID`) REFERENCES `time` (`id_time`);

--
-- Limitadores para a tabela `time`
--
ALTER TABLE `time`
  ADD CONSTRAINT `time_ibfk_1` FOREIGN KEY (`torcedorID`) REFERENCES `pessoa` (`id_pessoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
