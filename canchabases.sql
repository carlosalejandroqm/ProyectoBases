-- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: canchabases
-- ------------------------------------------------------
-- Server version	10.5.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  CONSTRAINT `administrador_empleado_fk` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrador_bodega`
--

DROP TABLE IF EXISTS `administrador_bodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador_bodega` (
  `id_empleado` int(11) NOT NULL,
  `clave_bodega` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `administrador_bodega_pkv1` (`clave_bodega`),
  CONSTRAINT `administrador_bodega_empleado_fk` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador_bodega`
--

LOCK TABLES `administrador_bodega` WRITE;
/*!40000 ALTER TABLE `administrador_bodega` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador_bodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bodega`
--

DROP TABLE IF EXISTS `bodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bodega` (
  `id_inventario` int(11) NOT NULL,
  `administrador_bodega_clave_bodega` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_inventario`),
  KEY `bodega_administrador_bodega_fk` (`administrador_bodega_clave_bodega`),
  CONSTRAINT `bodega_administrador_bodega_fk` FOREIGN KEY (`administrador_bodega_clave_bodega`) REFERENCES `administrador_bodega` (`clave_bodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodega`
--

LOCK TABLES `bodega` WRITE;
/*!40000 ALTER TABLE `bodega` DISABLE KEYS */;
/*!40000 ALTER TABLE `bodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cajero`
--

DROP TABLE IF EXISTS `cajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cajero` (
  `id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cajero`
--

LOCK TABLES `cajero` WRITE;
/*!40000 ALTER TABLE `cajero` DISABLE KEYS */;
/*!40000 ALTER TABLE `cajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargo` (
  `id_cargo` int(2) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Administrador'),(2,'Cajero'),(3,'Administrador de Bodega'),(4,'Cliente');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `nro_reservas` int(11) DEFAULT NULL,
  `telefono` varchar(30) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cliente__idx` (`usuario_id_usuario`),
  UNIQUE KEY `correo` (`correo`),
  CONSTRAINT `usuario_id_usuario_fk` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Juan','Sanchez','juandsas@gmail.com',32,'3219810',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_compra` date NOT NULL,
  `descuento` int(11) NOT NULL,
  `monto_total` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `id_proveedor` (`id_proveedor`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumible`
--

DROP TABLE IF EXISTS `consumible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumible` (
  `id__producto` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  PRIMARY KEY (`id__producto`),
  UNIQUE KEY `consumible_pkv1` (`precio`),
  CONSTRAINT `consumible_producto_fk` FOREIGN KEY (`id__producto`) REFERENCES `producto` (`id__producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumible`
--

LOCK TABLES `consumible` WRITE;
/*!40000 ALTER TABLE `consumible` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrato` (
  `id_contrato` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `empleado_id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_contrato`),
  KEY `contrato_empleado_fk` (`empleado_id_empleado`),
  CONSTRAINT `contrato_empleado_fk` FOREIGN KEY (`empleado_id_empleado`) REFERENCES `empleado` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL,
  `dni` varchar(30) NOT NULL DEFAULT '',
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `telefono` int(20) DEFAULT NULL,
  `cargo` int(2) NOT NULL DEFAULT 0,
  `correo` varchar(30) NOT NULL,
  `horas_extra` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `id_usuario` (`id_usuario`) USING BTREE,
  UNIQUE KEY `dni` (`dni`),
  KEY `cargo` (`cargo`),
  CONSTRAINT `cargo` FOREIGN KEY (`cargo`) REFERENCES `cargo` (`id_cargo`),
  CONSTRAINT `id_usuario_fk` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'1193530331','Juan','Sanchez ',3219810,1,'juansa@gmail.com',0,2);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `factura_id` int(11) NOT NULL,
  `reserva_id_reserva` int(11) NOT NULL,
  `cajero_clave_cajero` int(11) NOT NULL,
  PRIMARY KEY (`factura_id`),
  UNIQUE KEY `factura__idx` (`reserva_id_reserva`),
  KEY `factura_cajero_fk` (`cajero_clave_cajero`),
  CONSTRAINT `factura_cajero_fk` FOREIGN KEY (`cajero_clave_cajero`) REFERENCES `cajero` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`factura_id`) REFERENCES `reserva` (`id_factura`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funciones`
--

DROP TABLE IF EXISTS `funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funciones` (
  `id_funciones` int(11) NOT NULL AUTO_INCREMENT,
  `concepto` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `contrato_id_contrato` int(11) NOT NULL,
  PRIMARY KEY (`id_funciones`),
  KEY `funciones_contrato_fk` (`contrato_id_contrato`),
  CONSTRAINT `funciones_contrato_fk` FOREIGN KEY (`contrato_id_contrato`) REFERENCES `contrato` (`id_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funciones`
--

LOCK TABLES `funciones` WRITE;
/*!40000 ALTER TABLE `funciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `funciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `implemento`
--

DROP TABLE IF EXISTS `implemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `implemento` (
  `id__producto` int(11) NOT NULL,
  `estado` varchar(30) NOT NULL,
  PRIMARY KEY (`id__producto`),
  UNIQUE KEY `implemento_pkv1` (`estado`),
  CONSTRAINT `implemento_producto_fk` FOREIGN KEY (`id__producto`) REFERENCES `producto` (`id__producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `implemento`
--

LOCK TABLES `implemento` WRITE;
/*!40000 ALTER TABLE `implemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `implemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liquidacion`
--

DROP TABLE IF EXISTS `liquidacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liquidacion` (
  `id_liquidacion` int(11) NOT NULL,
  `horas_extra` int(11) DEFAULT NULL,
  `basico` int(11) DEFAULT NULL,
  `bonificaciones` int(11) DEFAULT NULL,
  `contrato_id_contrato` int(11) NOT NULL,
  PRIMARY KEY (`id_liquidacion`),
  KEY `liquidacion_contrato_fk` (`contrato_id_contrato`),
  CONSTRAINT `liquidacion_contrato_fk` FOREIGN KEY (`contrato_id_contrato`) REFERENCES `contrato` (`id_contrato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liquidacion`
--

LOCK TABLES `liquidacion` WRITE;
/*!40000 ALTER TABLE `liquidacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `liquidacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `id__producto` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `bodega_id_inventario` int(11) NOT NULL,
  PRIMARY KEY (`id__producto`),
  KEY `producto_bodega_fk` (`bodega_id_inventario`),
  CONSTRAINT `producto_bodega_fk` FOREIGN KEY (`bodega_id_inventario`) REFERENCES `bodega` (`id_inventario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_proveedor`
--

DROP TABLE IF EXISTS `producto_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`,`id_producto`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `producto_proveedor_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id__producto`),
  CONSTRAINT `producto_proveedor_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_proveedor`
--

LOCK TABLES `producto_proveedor` WRITE;
/*!40000 ALTER TABLE `producto_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `RUT` int(20) NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_salida` datetime NOT NULL,
  `vigencia` varchar(30) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `tipo_cancha` varchar(20) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `reserva_usuario_fk` (`usuario_id_usuario`),
  KEY `id_factura` (`id_factura`),
  CONSTRAINT `reserva_usuario_fk` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `clave_usuario` varchar(30) NOT NULL,
  `tipo_cargo` int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `tipo_cargo` (`tipo_cargo`),
  CONSTRAINT `tipo_cargo` FOREIGN KEY (`tipo_cargo`) REFERENCES `cargo` (`id_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Sebasan07','1234',4),(2,'jsanchez','1234',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-08 11:48:58
