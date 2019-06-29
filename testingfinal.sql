-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: testing0627
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consulta_final`
--

DROP TABLE IF EXISTS `consulta_final`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consulta_final` (
  `idpaciente` int(11) NOT NULL,
  `albumina` varchar(255) DEFAULT NULL,
  `cel_plasmatic_en_medula_osea` varchar(255) DEFAULT NULL,
  `comentarios_extrax` varchar(255) DEFAULT NULL,
  `fecha_realizacion` varchar(255) DEFAULT NULL,
  `fecha_de_trasplante` varchar(255) DEFAULT NULL,
  `fecha_injerto_plaquetario` varchar(255) DEFAULT NULL,
  `electro_foresis_de_proteinas_orina` varchar(255) DEFAULT NULL,
  `electro_foresis_de_proteinas_suero` varchar(255) DEFAULT NULL,
  `enfermedad_minima_residual` varchar(255) DEFAULT NULL,
  `hematocrito` varchar(255) DEFAULT NULL,
  `hemoglobina` varchar(255) DEFAULT NULL,
  `iga` varchar(255) DEFAULT NULL,
  `igg` varchar(255) DEFAULT NULL,
  `igm` varchar(255) DEFAULT NULL,
  `sitio_infeccion` varchar(255) DEFAULT NULL,
  `infusion_med_reaction` varchar(255) DEFAULT NULL,
  `inm_fijacion_tipo_cll` varchar(255) DEFAULT NULL,
  `inm_fijacion_tipo_ig` varchar(255) DEFAULT NULL,
  `deshidrogenasa_lactica` varchar(255) DEFAULT NULL,
  `leucocitos` varchar(255) DEFAULT NULL,
  `cadenas_ligeras_kappa` varchar(255) DEFAULT NULL,
  `cadenas_ligeras_lambda` varchar(255) DEFAULT NULL,
  `linfocitos` varchar(255) DEFAULT NULL,
  `fecha_injerto_mieloide` varchar(255) DEFAULT NULL,
  `neutrofilos` varchar(255) DEFAULT NULL,
  `numcd34infundidas` varchar(255) DEFAULT NULL,
  `plaquetas` varchar(255) DEFAULT NULL,
  `repuestaatratamiento` varchar(255) DEFAULT NULL,
  `calcio_serico` varchar(255) DEFAULT NULL,
  `tox_gasto_diarrea` varchar(255) DEFAULT NULL,
  `tox_gastro_nausea` varchar(255) DEFAULT NULL,
  `tox_hemto_neutrofilos` varchar(255) DEFAULT NULL,
  `tox_hemto_plaquetas` varchar(255) DEFAULT NULL,
  `tox_hemto_serie_roja` varchar(255) DEFAULT NULL,
  `tox_hepatics` varchar(255) DEFAULT NULL,
  `tox_infecciosa` varchar(255) DEFAULT NULL,
  `tox_neuroatia_perif` varchar(255) DEFAULT NULL,
  `tox_renal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpaciente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta_final`
--

LOCK TABLES `consulta_final` WRITE;
/*!40000 ALTER TABLE `consulta_final` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta_final` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta_mensual`
--

DROP TABLE IF EXISTS `consulta_mensual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consulta_mensual` (
  `id_consulta_mensual` int(11) NOT NULL AUTO_INCREMENT,
  `reccion_adversa` varchar(255) DEFAULT NULL,
  `albumina` varchar(255) DEFAULT NULL,
  `fecha_realizacion` varchar(255) DEFAULT NULL,
  `hematocrito` varchar(255) DEFAULT NULL,
  `hemoglobina` varchar(255) DEFAULT NULL,
  `iga` varchar(255) DEFAULT NULL,
  `igg` varchar(255) DEFAULT NULL,
  `igm` varchar(255) DEFAULT NULL,
  `sitio_infeccion` varchar(255) DEFAULT NULL,
  `reac_infucionde_medic` varchar(255) DEFAULT NULL,
  `deshidrogenasa_lactica` varchar(255) DEFAULT NULL,
  `leucocitos` varchar(255) DEFAULT NULL,
  `cadenas_ligeras_kappa` varchar(255) DEFAULT NULL,
  `cadenas_ligeras_lambda` varchar(255) DEFAULT NULL,
  `linfocitos` varchar(255) DEFAULT NULL,
  `neutrofilos` varchar(255) DEFAULT NULL,
  `plaquetas` varchar(255) DEFAULT NULL,
  `calcio_serico` varchar(255) DEFAULT NULL,
  `tox_gasto_diarrea` varchar(255) DEFAULT NULL,
  `tox_gastro_nausea` varchar(255) DEFAULT NULL,
  `tox_hemto_neutrofilos` varchar(255) DEFAULT NULL,
  `tox_hemto_plaquetas` varchar(255) DEFAULT NULL,
  `tox_hemto_serie_roja` varchar(255) DEFAULT NULL,
  `tox_hepatics` varchar(255) DEFAULT NULL,
  `tox_infecciosa` varchar(255) DEFAULT NULL,
  `tox_neuroatia_perif` varchar(255) DEFAULT NULL,
  `tox_renal` varchar(255) DEFAULT NULL,
  `num_ciclo_tratamiento` varchar(255) DEFAULT NULL,
  `idpaciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_consulta_mensual`),
  KEY `FKdtum2sm0whgmvrs6spkvp3j0o` (`idpaciente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta_mensual`
--

LOCK TABLES `consulta_mensual` WRITE;
/*!40000 ALTER TABLE `consulta_mensual` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta_mensual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (9),(9),(9);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paciente` (
  `idpaciente` int(11) NOT NULL,
  `activa` varchar(255) DEFAULT NULL,
  `edad` varchar(255) DEFAULT NULL,
  `albumina` varchar(255) DEFAULT NULL,
  `b2microglobulina` varchar(255) DEFAULT NULL,
  `proteinuria_de_bence_jones` varchar(255) DEFAULT NULL,
  `fechanac` varchar(255) DEFAULT NULL,
  `imc` varchar(255) DEFAULT NULL,
  `supcorporal` varchar(255) DEFAULT NULL,
  `lesiones_oseas` varchar(255) DEFAULT NULL,
  `numlesiones_oseas` varchar(255) DEFAULT NULL,
  `delecion17p` varchar(255) DEFAULT NULL,
  `dep_creatinina` varchar(255) DEFAULT NULL,
  `amiloidosis_distemica` varchar(255) DEFAULT NULL,
  `ecog` varchar(255) DEFAULT NULL,
  `electro_foresis_de_proteinas_orina` varchar(255) DEFAULT NULL,
  `electro_foresis_de_proteinas_suero` varchar(255) DEFAULT NULL,
  `plasmocitomas_extramedulares` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `talla` varchar(255) DEFAULT NULL,
  `hematocrito` varchar(255) DEFAULT NULL,
  `hemoglobina` varchar(255) DEFAULT NULL,
  `iga` varchar(255) DEFAULT NULL,
  `igg` varchar(255) DEFAULT NULL,
  `igm` varchar(255) DEFAULT NULL,
  `inm_fijacion_tipo_cll` varchar(255) DEFAULT NULL,
  `inm_fijacion_tipo_ig` varchar(255) DEFAULT NULL,
  `deshidrogenasa_lactica` varchar(255) DEFAULT NULL,
  `apmat` varchar(255) DEFAULT NULL,
  `appat` varchar(255) DEFAULT NULL,
  `leucocitos` varchar(255) DEFAULT NULL,
  `cadenas_ligeras_kappa` varchar(255) DEFAULT NULL,
  `cadenas_ligeras_lambda` varchar(255) DEFAULT NULL,
  `linfocitos` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `neutrofilos` varchar(255) DEFAULT NULL,
  `cel_plasmatic_en_sangre_perif` varchar(255) DEFAULT NULL,
  `cel_plasmatic_en_medula_osea` varchar(255) DEFAULT NULL,
  `num_plasmocitomas` varchar(255) DEFAULT NULL,
  `plaquetas` varchar(255) DEFAULT NULL,
  `calcio_serico` varchar(255) DEFAULT NULL,
  `creatinina_serica` varchar(255) DEFAULT NULL,
  `fechainiciotratamiento` varchar(255) DEFAULT NULL,
  `translocacion4a14` varchar(255) DEFAULT NULL,
  `translocacion14a16` varchar(255) DEFAULT NULL,
  `peso` varchar(255) DEFAULT NULL,
  `idmedico` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idpaciente`),
  KEY `FKaqlfvi7jo6yo55kduyh47mdeh` (`idmedico`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (6,'No','40','4','5','No','1978-09-07','20','1.65 m²','No','0','No','7','No','2','8','4','No','M','168','5','9','7','5','15','Kappa','IgG','15','Caballero','Hernandez','25','2','6','10','Adriana','22','12','10','5','10','8','2','2019-04-01','No','No','58',2),(7,'No','35','5','8','No','1984-06-14','27','2.1 m²','Si','0','No','7','No','1','23','4','Si','H','180','10','9','12','10','15','No secretor','IgG','15','Mendoza','Juarez','25','16','6','10','Julio','22','8','10','5','10','9','10','2017-06-08','Si','Si','88',2),(8,'No','25','6','8','No','1985-06-04','30','2.21 m²','No','0','No','7','No','2','8','4','Si','H','180','21','9','5','5','16','No secretor','IgG','15','Lopez','Rosas','25','16','14','10','Eduardo','22','4','15','5','10','9','10','2010-06-08','No','Si','98',3);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_DOCTOR'),(2,'ROLE_MONITOR'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `tipo` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_namem` varchar(255) DEFAULT NULL,
  `last_namep` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `fecha_nac` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `telefono_movil` varchar(255) DEFAULT NULL,
  `telefono_fijo` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `hospital` varchar(255) DEFAULT NULL,
  `ced_prof` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin',1,'investigacion@gohema.mx','Pamela','Islas','Baez','123admin','02-07-1991','Mujer',NULL,NULL,NULL,NULL,NULL),('medico',2,'medico1@gohema.mx','Raul','Fuentes','Cisneros','123','1986-09-12','H','44444444','55555555','CDMX','Angeles 2','123456'),('medico',3,'medico2@gohema.mx','Ana','Fernandez','Arellano','123','1981-09-17','M','44444444','55555555','Monterrey','santa fe','1234'),('monitor',4,'monitor1@gohema.mx','Joel','Juarez','Saldaña','123','1980-11-19','H','44444444','55555555',NULL,NULL,NULL),('monitor',5,'monitor2@gohema.mx','Rocio','Prado','Ramirez','123','1978-01-20','M','44444444','55555555',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,3),(2,1),(3,1),(4,2),(5,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-27 20:19:11
