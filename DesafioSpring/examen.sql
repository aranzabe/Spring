-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-03-2018 a las 12:44:47
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `examen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `email` varchar(50) NOT NULL,
  `nota` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `notas`
--

INSERT INTO `notas` (`email`, `nota`) VALUES
('2@gmail.com', 6),
('null', 8),
('cristina@gmail.com', 7),
('bea@gmail.com', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `email` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`email`, `nombre`, `apellido`, `pass`, `rol`) VALUES
('1@gmail.com', '1', '1', '1', 'profesor'),
('2@gmail.com', '2', '2', '2', 'alumno'),
('bea@gmail.com', 'Beatriz', 'Recuero', '1', 'alumno'),
('cristina@gmail.com', 'Cristina', 'de Marcos', '1', 'alumno');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id_preg` int(10) NOT NULL,
  `enunciado` varchar(500) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id_preg`, `enunciado`, `tipo`) VALUES
(22, 'De que color es el caballo blanco de Santiago?', 'radio'),
(24, 'Cuales de estas peliculas son de star wars?', 'check'),
(26, 'Si un hombre caba en una hora un hoyo y dos hombres caban 2 hoyos en dos horas, cuantos hoyos cabara un hombre en media hora?', 'radio'),
(31, 'Quienes son princesas Disney?', 'check'),
(32, 'Es mio, pero mis amigos lo usan mas que yo. Que es?', 'desarrollo'),
(35, '8=56  -->  7=42 --> 6=30 --> 5=20 --> 3= ?', 'desarrollo'),
(37, 'Si un hombre tiene 6 hijas, y cada hija tiene un hermano, \r\ncuantos hijos tiene el hombre en total?', 'radio'),
(38, '20 + 30x0 + 1= ?', 'desarrollo'),
(41, 'Quien es el personaje principal de Star Wars en La amenaza fantasma?', 'radio'),
(42, 'Que series son de Netflix?', 'check');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--

CREATE TABLE `respuesta` (
  `id_resp` int(30) NOT NULL,
  `id_preg` int(10) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `correcta` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `respuesta`
--

INSERT INTO `respuesta` (`id_resp`, `id_preg`, `descripcion`, `correcta`) VALUES
(38, 22, 'Negro', 0),
(39, 22, 'Marron', 0),
(40, 22, 'Blanco', 1),
(41, 22, 'Gris', 0),
(43, 24, 'El imperio contraataca', 1),
(44, 24, 'El amanecer de los jedi', 0),
(45, 24, 'El despertar de la fuerza', 1),
(46, 24, 'La venganza de los Sith', 1),
(47, 24, 'El despertar de Darth Vader', 0),
(48, 24, 'El unicornio contraataca', 0),
(52, 26, '2 hoyos', 0),
(53, 26, 'Medio hoyo', 0),
(54, 26, '1 hoyo', 1),
(55, 26, 'Un cuarto de hoyo', 0),
(56, 26, '1 hoyo y medio', 0),
(61, 31, 'Ariel', 1),
(62, 31, 'Jasmin', 1),
(63, 31, 'Elisa', 0),
(64, 31, 'Blanca', 0),
(65, 31, 'Aurora', 1),
(66, 31, 'Alicia', 0),
(67, 31, 'Bella', 1),
(68, 32, 'Mi nombre', 1),
(71, 35, '6', 1),
(77, 37, '12', 0),
(78, 37, '6', 0),
(79, 37, '1', 0),
(80, 37, '7', 1),
(81, 37, '10', 0),
(82, 38, '21', 1),
(95, 41, 'Lucke Skywalker', 0),
(96, 41, 'Anakin Skywalker', 1),
(97, 41, 'Obi-Wan Kenobi', 0),
(98, 41, 'Jar Jar Binks', 0),
(99, 42, 'El principe', 0),
(100, 42, 'Por 13 razones', 1),
(101, 42, 'Narcos', 1),
(102, 42, 'Bloodline', 1),
(103, 42, 'El accidente', 0),
(104, 42, 'Se quien eres', 0),
(105, 42, 'Atypical', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`email`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id_preg`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id_resp`),
  ADD KEY `FK_idpreguntas` (`id_preg`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id_preg` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id_resp` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=106;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `FK_idpreguntas` FOREIGN KEY (`id_preg`) REFERENCES `preguntas` (`id_preg`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
