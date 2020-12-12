-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 18-10-2020 a las 18:49:00
-- Versión del servidor: 10.5.6-MariaDB-1:10.5.6+maria~focal
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `database`
--

-- --------------------------------------------------------
DROP TABLE IF EXISTS reparacion;
DROP TABLE IF EXISTS usuario;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparacion`
--

CREATE TABLE `reparacion` (
  `CODREP` varchar(50) NOT NULL,
  `MARCA_RELOJ` varchar(50) NOT NULL,
  `FECHA_PETICION` date NOT NULL DEFAULT current_timestamp(),
  `IMPORTE` double(8,2) NOT NULL,
  `DNI_CLIENTE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reparacion`
--

INSERT INTO `reparacion` (`CODREP`, `MARCA_RELOJ`, `FECHA_PETICION`, `IMPORTE`, `DNI_CLIENTE`) VALUES
('01A', 'TISSOT', '2015-09-07', 13.40, '04234790-F'),
('02A', 'GUCCI', '2015-09-17', 59.90, '08948174-R'),
('06Q', 'VICEROY', '2020-08-01', 30.00, '93968025-F'),
('10L', 'ROLEX', '2019-01-30', 47.05, '71292823-E'),
('26A', 'OMEGA', '2020-10-13', 28.95, '78471486-V'),
('33A', 'LUMINOX', '2020-01-22', 18.60, '60724474-N'),
('33C', 'ROLEX', '2020-10-16', 28.95, '61237728-K'),
('44T', 'ADIDAS', '2019-11-07', 2.00, '37699504-C'),
('47Y', 'LOTUS', '2020-07-05', 47.50, '37721223-G'),
('48G', 'ROLEX', '2020-10-07', 28.95, '52164086-V'),
('55H', 'SANDOZ', '2020-05-07', 28.95, '69486930-C'),
('67W', 'NIKE', '2020-06-22', 3.25, '23422805-L'),
('80O', 'LOTUS', '2020-01-02', 31.15, '53224616-V'),
('92B', 'GUESS', '2016-12-10', 40.00, '11111111-H'),
('99I', 'CASIO', '2019-09-07', 5.50, '98356894-Q'),
('99Z', 'OMEGA', '2020-10-18', 28.98, '51197944-J');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `DNI` varchar(10) NOT NULL,
  `NOMBRE_USUARIO` varchar(50) NOT NULL,
  `CONTRASENA` varchar(60) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `APELLIDO` varchar(50) NOT NULL,
  `TELEFONO` int(9) DEFAULT NULL,
  `FECHA_NACIMIENTO` date DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `CUENTA_BANCARIA` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`DNI`, `NOMBRE_USUARIO`, `CONTRASENA`, `NOMBRE`, `APELLIDO`, `TELEFONO`, `FECHA_NACIMIENTO`, `EMAIL`, `CUENTA_BANCARIA`) VALUES
('04234790-F', 'BOB42', '$2y$10$0HlFJ5P3yb8maAZdMzZgfOS97una.qFDT.khmfDiLRzj6KQzNMS2y', 'BOB', 'SMITH', 555555551, '2020-10-12', 'BOB42@gmail.com', '12345678901234567890'),
('06504433-X', 'Luigi', '$2y$10$HxKfDzskhty2lORMkT2UaOV06UJRgma.ot/flGv4zTAfVmmt2hMTa', 'Luigi', 'Bro', 654321987, '1974-06-18', 'luigi@gmail.com', '84521478523699516123'),
('08948174-R', 'DarthVader', '$2y$10$P2R1r/jRaB/jnnZJv4VxjuKhJ526pafgJZH67op3d.8jIBWyTIPs6', 'Anakin', 'Skywalker', 658423159, '1931-01-17', 'darth@gmail.com','74185296374102589603'),
('11111111-H', 'Portador', '$2y$10$UAS.bgclx8DTfJaVAOUHFe/MqfePfuWYF6EM/SkheM8iAonyR9sUK', 'Frodo', 'Bolson', 110011002, '1981-01-28', 'anillo@gmail.com','01470258036901470258'),
('17834414-F', 'Alex1', '$2y$10$X0dxHnbmJTI.a.zR8cGnZ.02PnppZj/ySkPgmV6VLmgmg0f1IjTIq', 'Alex', 'Platas', 695326895, '1999-05-15', 'alex@gmail.com','00011122233344455567'),
('23422805-L', 'Khaleesi', '$2y$10$4kkMLJP0J0iGKkC7PDMage5F5a5YgGjeLXvJVNxKGOcnwWe.VoyBC', 'Daenerys', 'Targaryen', 652369584, '1986-10-23', 'daenerys@gmail.com','12312312301231231230'),
('31397374-M', 'Iria', '$2y$10$8qv.RJhDg9oX6d5LZoYOvu.1e3uClDe/nXF3W6dWwKgYhJEDQfdxy', 'Iria', 'San Miguel', 975632145, '2000-08-14', 'iria@gmail.com','03201405826947515895'),
('37699504-C', 'Hermione', '$2y$10$boi/jD.MKkoDJRsBwtA28OFHr8OGOdEDKgCPIg61ZwN8Hlw4Fp2km', 'Hermione', 'Granger', 123456789, '1990-04-15', 'hermione@gmail.com','15926348701596234875'),
('37721223-G', 'Nadie', '$2y$10$tfDqCgEj/2l.qBMpbNalOuOCqaIOkIsUvt9zX5pRtOJsHmI8sMJne', 'Arya', 'Stark', 625489156, '1997-04-15', 'arya@gmail.com','52147896301478520152'),
('41405007-Q', 'Albus12', '$2y$10$bYjsllg.YA9dnL2dj1exmuZ1P8TU/iidzH6A.Lc/0.mdQA47kXxEi', 'Albus Percival Wulfric Brian', 'Dumbledore', 695326895, '1881-04-15', 'albus@gmail.com','01472580159623547895'),
('51197944-J', 'Iker', '$2y$10$JHsyBAu58Ux70VI8kUV2JumrwsVYwY7sfaE1L9sN5c8GVMfgbuNMC', 'Iker', 'De la Iglesia', 647654654, '2000-10-06', 'iker@gmail.com','02365418759621458730'),
('52164086-V', 'HojaVerde', '$2y$10$/L3KLcXdtYZYE0Mhf4DkC.xHSHyaawV42hvqR0L3TyPyfuW21nML.', 'Legolas', 'Hijo de Thranduil', 123456789, '1932-07-25', 'legolas@gmail.com','25814736902584569874'),
('53224616-V', 'Cersei', '$2y$10$cSzZuUBctaX6z17ewMrMSe4vQoDTG4oA/p8sSO.97BktVKRSN7Ptq', 'Cersei', 'Lannister', 698523147, '1976-10-03', 'cersei@gmail.com','32165498798765432130'),
('60724474-N', 'ElCuervo', '$2y$10$.M.KpdP8E3.8ljZ4FxdVn.0reFJvQb9.w7eYOqBy.daxc6ejkRBru', 'Brandon', 'Stark', 659847315, '1999-04-09', 'bran@gmail.com','54123698754123698700'),
('61237728-K', 'Ned', '$2y$10$X7aKSF1oRRGda3.Jtdi84eM6MtpaDNto7pXWMuPm/mhi7geRzsb4q', 'Eddar', 'Stark', 695148257, '1959-04-17', 'ned@gmail.com','02581473699512634789'),
('67143340-S', 'Ironside', '$2y$10$x4.TO3xNRFEXTesyHywXu.EHjCCr8hW7uNOz7WAwBsChijaN3s2CO', 'Bjorn', 'Ragnarsson', 654987321, '1992-05-07', 'bjorn@gmail.com','15962348702154789630'),
('69486930-C', 'Sam', '$2y$10$cBRnCMBnDQ6fhgdXjJaiau38.upBsQVkrp7DIW5ikwfPuzDQm7rRW', 'Samsagaz', 'Gamyi', 666854951, '1971-02-25', 'sam@gmail.com','95126348715962348702'),
('71292823-E', 'Ramsey', '$2y$10$IG3e7agknflnersD.lyd7O0L5pGhO6rDwWS2DUH/.poDfjbkRa/Ia', 'Ramsey', 'Bolton', 649325871, '1985-05-13', 'ramsey@gmail.com','85426971236547890125'),
('78471486-V', 'Wario', '$2y$10$ea01Ng8p3v3PT/qbE07lKeHvRGOU6D/YlJF4qbhhVby1qZHeO5CpW', 'Wario', 'Wro', 123456789, '1968-06-25', 'wario@gmail.com','02365478914785236987'),
('93968025-F', 'HighgroundJedi', '$2y$10$0sa6hkZiQf1jWUuAo8XGb.m9vUmXei1U4zbI34Sott6svIqj7YiTm', 'Obi Wan', 'Kenobi', 147258369, '1931-09-25', 'obiwan@gmail.com','98765432105847963215'),
('98356894-Q', 'Boneless', '$2y$10$ckhPyyogsIZ4Ta57Fy17cOJAJCbZRNti9TN0eAsZx1xH6xv/wMX0m', 'Ivar', 'Ragnarsson', 632541789, '1994-05-20', 'ivar@gmail.com','96385274109638527410');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`DNI`),
  ADD CONSTRAINT `uq_usuario` UNIQUE (`DNI`);

--
-- Indices de la tabla `reparacion`
--
ALTER TABLE `reparacion`
  ADD PRIMARY KEY (`CODREP`),
  ADD CONSTRAINT `fk_reparacion`
  FOREIGN KEY (`DNI_CLIENTE`)
  REFERENCES `usuario` (`DNI`);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
