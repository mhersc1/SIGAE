-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-11-2014 a las 08:28:49
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbsigae`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristicas`
--

CREATE TABLE IF NOT EXISTS `caracteristicas` (
  `idCARACTERISTICAS` int(11) NOT NULL,
  `Tamanio` int(11) DEFAULT NULL,
  `Tipo_Dato` int(1) DEFAULT NULL,
  `Cifrado` varchar(1) DEFAULT NULL,
  `Transformado` varchar(2) DEFAULT NULL,
  `caracter` varchar(1) DEFAULT NULL,
  `posicion` int(1) DEFAULT NULL,
  `idNivelConfig` int(11) NOT NULL,
  `idETIQUETA` int(11) NOT NULL,
  `idPLANTILLA` int(11) NOT NULL,
  `Campo` varchar(25) DEFAULT NULL,
  `Descripcion` varchar(25) DEFAULT NULL,
  `Orden` int(10) DEFAULT NULL,
  PRIMARY KEY (`idCARACTERISTICAS`,`idNivelConfig`,`idETIQUETA`,`idPLANTILLA`),
  KEY `fk_CARACTERISTICAS_NivelConfig1_idx` (`idNivelConfig`,`idETIQUETA`,`idPLANTILLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `caracteristicas`
--

INSERT INTO `caracteristicas` (`idCARACTERISTICAS`, `Tamanio`, `Tipo_Dato`, `Cifrado`, `Transformado`, `caracter`, `posicion`, `idNivelConfig`, `idETIQUETA`, `idPLANTILLA`, `Campo`, `Descripcion`, `Orden`) VALUES
(1, 20, 'numerico', 's', 'n', '*', 'derecha', 1, 1, 1, 'sueldo', 'porsemana', '1'),
(2, 10, 'alfanumerico', 'n', 's', '#', 'derecha', 2, 1, 1, 'nombre', 'porlote', '2'),
(3, 15, 'numerico', 's', 's', '$', 'izquierda', 3, 2, 1, 'apellido', 'porsemana', '1'),
(4, 25, 'numerico', 's', 'n', '*', 'derecha', 4, 3, 2, 'vivienda', 'porsemana', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiqueta`
--

CREATE TABLE IF NOT EXISTS `etiqueta` (
  `idETIQUETA` int(11) NOT NULL,
  `idPLANTILLA` int(11) NOT NULL,
  `Tipo_Etiqueta` varchar(20) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idETIQUETA`,`idPLANTILLA`),
  KEY `fk_ETIQUETA_PLANTILLA1_idx` (`idPLANTILLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `etiqueta`
--

INSERT INTO `etiqueta` (`idETIQUETA`, `idPLANTILLA`, `Tipo_Etiqueta`, `cantidad`) VALUES
(1, 1, 'H', 2),
(2, 1, 'D', 1),
(3, 2, 'H', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivelconfig`
--

CREATE TABLE IF NOT EXISTS `nivelconfig` (
  `idNivelConfig` int(11) NOT NULL,
  `Posicion` int(11) DEFAULT NULL,
  `idETIQUETA` int(11) NOT NULL,
  `idPLANTILLA` int(11) NOT NULL,
  PRIMARY KEY (`idNivelConfig`,`idETIQUETA`,`idPLANTILLA`),
  KEY `fk_NivelConfig_ETIQUETA1_idx` (`idETIQUETA`,`idPLANTILLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `nivelconfig`
--

INSERT INTO `nivelconfig` (`idNivelConfig`, `Posicion`, `idETIQUETA`, `idPLANTILLA`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 1, 2, 1),
(4, 1, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opciones`
--

CREATE TABLE IF NOT EXISTS `opciones` (
  `idOpciones` int(11) NOT NULL,
  `Descripcion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idOpciones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE IF NOT EXISTS `perfil` (
  `idPerfil` int(11) NOT NULL,
  `nombreperfil` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfilopciones`
--

CREATE TABLE IF NOT EXISTS `perfilopciones` (
  `idPerfil` int(11) NOT NULL,
  `idOpciones` int(11) NOT NULL,
  PRIMARY KEY (`idPerfil`,`idOpciones`),
  KEY `fk_Perfil_has_Opciones_Opciones2_idx` (`idOpciones`),
  KEY `fk_Perfil_has_Opciones_Perfil2_idx` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantilla`
--

CREATE TABLE IF NOT EXISTS `plantilla` (
  `idPLANTILLA` int(11) NOT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `Direccion` varchar(30) DEFAULT NULL,
  `query` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPLANTILLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `plantilla`
--

INSERT INTO `plantilla` (`idPLANTILLA`, `nombre`, `Direccion`, `query`) VALUES
(1, 'bancos ', 'Av. Wilson', 'select '),
(2, ' ventas ', 'Av. Abancay', 'select from '),
(3, 'cines', 'Av. Tacna', 'sql'),
(4, 'instituto', 'Av.28 de julio', 'sql ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `query`
--

CREATE TABLE IF NOT EXISTS `query` (
  `idQuery` int(11) NOT NULL,
  `texto_query` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(35) DEFAULT NULL,
  `idCARACTERISTICAS` int(11) NOT NULL,
  `idNivelConfig` int(11) NOT NULL,
  `idETIQUETA` int(11) NOT NULL,
  `idPLANTILLA` int(11) NOT NULL,
  `Nombre` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idQuery`,`idCARACTERISTICAS`,`idNivelConfig`,`idETIQUETA`,`idPLANTILLA`),
  KEY `fk_Query_CARACTERISTICAS1_idx` (`idCARACTERISTICAS`,`idNivelConfig`,`idETIQUETA`,`idPLANTILLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido_paterno` varchar(10) DEFAULT NULL,
  `apellido_materno` varchar(10) DEFAULT NULL,
  `usuario` varchar(6) DEFAULT NULL,
  `contrasenia` varchar(8) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`,`idPerfil`),
  KEY `fk_Usuario_Perfil_idx` (`idPerfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `caracteristicas`
--
ALTER TABLE `caracteristicas`
  ADD CONSTRAINT `fk_CARACTERISTICAS_NivelConfig1` FOREIGN KEY (`idNivelConfig`, `idETIQUETA`, `idPLANTILLA`) REFERENCES `nivelconfig` (`idNivelConfig`, `idETIQUETA`, `idPLANTILLA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
  ADD CONSTRAINT `fk_ETIQUETA_PLANTILLA1` FOREIGN KEY (`idPLANTILLA`) REFERENCES `plantilla` (`idPLANTILLA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `nivelconfig`
--
ALTER TABLE `nivelconfig`
  ADD CONSTRAINT `fk_NivelConfig_ETIQUETA1` FOREIGN KEY (`idETIQUETA`, `idPLANTILLA`) REFERENCES `etiqueta` (`idETIQUETA`, `idPLANTILLA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `perfilopciones`
--
ALTER TABLE `perfilopciones`
  ADD CONSTRAINT `fk_Perfil_has_Opciones_Opciones2` FOREIGN KEY (`idOpciones`) REFERENCES `opciones` (`idOpciones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Perfil_has_Opciones_Perfil2` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `query`
--
ALTER TABLE `query`
  ADD CONSTRAINT `fk_Query_CARACTERISTICAS1` FOREIGN KEY (`idCARACTERISTICAS`, `idNivelConfig`, `idETIQUETA`, `idPLANTILLA`) REFERENCES `caracteristicas` (`idCARACTERISTICAS`, `idNivelConfig`, `idETIQUETA`, `idPLANTILLA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Perfil` FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
