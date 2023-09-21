-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-09-2023 a las 21:15:47
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tp2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Carrera`
--

CREATE TABLE `Carrera` (
  `id_carrera` int(11) NOT NULL,
  `duracion` int(11) DEFAULT NULL,
  `institucion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Carrera`
--

INSERT INTO `Carrera` (`id_carrera`, `duracion`, `institucion`, `nombre`) VALUES
(1, 3, 'UBA', 'Odontologia'),
(2, 1, 'UNICEN', 'Arquitectura Web'),
(3, 5, 'UNICEN', 'Periodismo'),
(4, 5, 'UNICEN', 'Periodismo'),
(5, 5, 'UNICEN', 'Periodismo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Estudiante`
--

CREATE TABLE `Estudiante` (
  `nro_libreta` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Estudiante`
--

INSERT INTO `Estudiante` (`nro_libreta`, `apellido`, `ciudad`, `edad`, `genero`, `nombre`, `dni`) VALUES
(1, 'unaillino', '1 arroyos', 41, 'femenina', 'una', 29550561),
(2, 'dosillino', '2arroyos', 42, 'masculine', 'dos', 29550562),
(3, 'tres de los ultimos', '3a', 43, 'femenina', 'tres', 29550563),
(4, 'cuatro de los ultimos', '4a', 44, 'femenina', 'cuatro', 29550564);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Inscripto`
--

CREATE TABLE `Inscripto` (
  `id` int(11) NOT NULL,
  `antiguedad` int(11) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  `graduado` bit(1) DEFAULT NULL,
  `carrera` int(11) DEFAULT NULL,
  `nro_libreta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `Inscripto`
--

INSERT INTO `Inscripto` (`id`, `antiguedad`, `fecha`, `graduado`, `carrera`, `nro_libreta`) VALUES
(0, 10, NULL, b'0', 2, 2),
(6, 10, NULL, b'0', 2, 1),
(7, 12, NULL, b'1', 2, 2),
(8, 13, NULL, b'1', 2, 3),
(9, 14, NULL, b'0', 1, 4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Carrera`
--
ALTER TABLE `Carrera`
  ADD PRIMARY KEY (`id_carrera`);

--
-- Indices de la tabla `Estudiante`
--
ALTER TABLE `Estudiante`
  ADD PRIMARY KEY (`nro_libreta`);

--
-- Indices de la tabla `Inscripto`
--
ALTER TABLE `Inscripto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtc8ethhvo5h9twb5n595j6c67` (`carrera`),
  ADD KEY `FKiti89hdjwwvhhv01d9jbnkkmf` (`nro_libreta`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Inscripto`
--
ALTER TABLE `Inscripto`
  ADD CONSTRAINT `FKiti89hdjwwvhhv01d9jbnkkmf` FOREIGN KEY (`nro_libreta`) REFERENCES `Estudiante` (`nro_libreta`),
  ADD CONSTRAINT `FKtc8ethhvo5h9twb5n595j6c67` FOREIGN KEY (`carrera`) REFERENCES `Carrera` (`id_carrera`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
