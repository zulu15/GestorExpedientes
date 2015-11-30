-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-11-2015 a las 13:29:18
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gestor_judicial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delitos`
--

CREATE TABLE IF NOT EXISTS `delitos` (
`cod_delito` bigint(20) NOT NULL,
  `caratula` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `delitos`
--

INSERT INTO `delitos` (`cod_delito`, `caratula`) VALUES
(1, 'Amenaza'),
(2, 'Usurpacion'),
(3, 'Lesiones Culposas'),
(4, 'Lesiones Dolosas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE IF NOT EXISTS `estados` (
`codigo` bigint(20) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`codigo`, `estado`) VALUES
(1, 'archivado(art 346)'),
(2, 'remitido a defensoria'),
(3, 'cancelado'),
(4, 'remitido AEV a Juzgado Civil'),
(5, 'normal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expedientes`
--

CREATE TABLE IF NOT EXISTS `expedientes` (
`nro_expte` bigint(20) NOT NULL,
  `id_persona` bigint(20) DEFAULT NULL,
  `fecha_denuncia` date NOT NULL,
  `fecha_hecho` date NOT NULL,
  `cod_delito` bigint(20) NOT NULL,
  `descripcion` longtext NOT NULL,
  `id_estado` bigint(20) DEFAULT NULL,
  `cod_operador` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operadores`
--

CREATE TABLE IF NOT EXISTS `operadores` (
`cod_operador` bigint(20) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `operadores`
--

INSERT INTO `operadores` (`cod_operador`, `usuario`, `clave`) VALUES
(1, 'luis', '123'),
(2, 'Gaby', '123'),
(3, 'joaquin', '1234'),
(4, 'Andy', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE IF NOT EXISTS `personas` (
  `dni` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `delitos`
--
ALTER TABLE `delitos`
 ADD PRIMARY KEY (`cod_delito`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
 ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `expedientes`
--
ALTER TABLE `expedientes`
 ADD PRIMARY KEY (`nro_expte`), ADD KEY `FK_expedientes` (`cod_delito`), ADD KEY `FK_expedientes1` (`id_estado`), ADD KEY `FK_expedientes_operador` (`cod_operador`), ADD KEY `FK_expedientes_personas` (`id_persona`);

--
-- Indices de la tabla `operadores`
--
ALTER TABLE `operadores`
 ADD PRIMARY KEY (`cod_operador`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
 ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `delitos`
--
ALTER TABLE `delitos`
MODIFY `cod_delito` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `expedientes`
--
ALTER TABLE `expedientes`
MODIFY `nro_expte` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `operadores`
--
ALTER TABLE `operadores`
MODIFY `cod_operador` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `expedientes`
--
ALTER TABLE `expedientes`
ADD CONSTRAINT `FK_expedientes` FOREIGN KEY (`cod_delito`) REFERENCES `delitos` (`cod_delito`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_expedientes1` FOREIGN KEY (`id_estado`) REFERENCES `estados` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_expedientes_operador` FOREIGN KEY (`cod_operador`) REFERENCES `operadores` (`cod_operador`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_expedientes_personas` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
