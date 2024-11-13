-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2024 a las 13:01:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bbddseck`
--
CREATE DATABASE IF NOT EXISTS `bbddseck` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bbddseck`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acomodadores`
--

DROP TABLE IF EXISTS `acomodadores`;
CREATE TABLE `acomodadores` (
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(30) DEFAULT NULL,
  `Numsala` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
CREATE TABLE `peliculas` (
  `Titulo` varchar(100) NOT NULL,
  `Genero` varchar(100) DEFAULT NULL,
  `Anio` int(4) DEFAULT NULL,
  `Director` varchar(100) DEFAULT NULL,
  `actoresPrincipales` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`Titulo`, `Genero`, `Anio`, `Director`, `actoresPrincipales`) VALUES
('Forrest Gump', 'Drama Romance', 1994, 'Robert Zemeckis', 'Tom Hanks, Robin Wright, Gary Sinise'),
('Inception', 'Acción Ciencia Ficción', 2010, 'Christopher Nolan', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page'),
('Interstellar', 'Ciencia Ficción Drama', 2014, 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain'),
('One piece red', 'Animación Comedia', 2022, 'Goro Taniguchi', 'animados'),
('Pulp Fiction', 'Crimen Drama', 1994, 'Quentin Tarantino', 'John Travolta, Uma Thurman, Samuel L. Jackson'),
('Soul', 'Animación Comedia Drama', 2020, 'Pete Docter', 'Jamie Foxx, Tina Fey, Graham Norton'),
('The Dark Knight', 'Acción Crimen Drama', 2008, 'Christopher Nolan', 'Christian Bale, Heath Ledger, Aaron Eckhart'),
('The fatherGod', 'Crimen Drama', 1972, 'Francis Ford Coppola', 'Marlon Brando, Al Pacino, James Caan'),
('The Matrix Resurrections', 'Acción Ciencia Ficción', 2021, 'Lana Wachowski', 'Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II'),
('The Shawshank Redemption', 'Drama Crimen', 1994, 'Frank Darabont', 'Tim Robbins, Morgan Freeman, Bob Gunton');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

DROP TABLE IF EXISTS `salas`;
CREATE TABLE `salas` (
  `NumSala` int(3) NOT NULL,
  `Planta` varchar(255) DEFAULT NULL,
  `pases` varchar(255) DEFAULT NULL,
  `Pelicula` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`NumSala`, `Planta`, `pases`, `Pelicula`) VALUES
(1, 'Planta 1', '15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | ', 'One piece red'),
(2, 'Planta 1', '15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | ', 'The Matrix Resurrections'),
(3, 'Planta 3', '15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 5 | 18 :15 nº butacas: 6 | 15 :15 nº butacas: 5 | 18 :15 nº butacas: 6 | ', 'Pulp Fiction'),
(4, 'Planta 1', '15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 5 | 18 :15 nº butacas: 6 | ', 'Soul'),
(5, 'Planta 3', '15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 46 | 18 :15 nº butacas: 2 | 15 :15 nº butacas: 5 | 18 :15 nº butacas: 6 | 15 :15 nº butacas: 5 | 18 :15 nº butacas: 6 | 15 :15 nº butacas: 3 | 18 :15 nº butacas: 4 | ', 'The Shawshank Redemption');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acomodadores`
--
ALTER TABLE `acomodadores`
  ADD PRIMARY KEY (`Nombre`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`Titulo`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`NumSala`),
  ADD KEY `Pelicula` (`Pelicula`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `salas`
--
ALTER TABLE `salas`
  ADD CONSTRAINT `salas_ibfk_1` FOREIGN KEY (`Pelicula`) REFERENCES `peliculas` (`Titulo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
