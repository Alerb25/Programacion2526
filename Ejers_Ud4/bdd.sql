
-- BASE DE DATOS

DROP DATABASE IF EXISTS proyecto;
CREATE DATABASE proyecto;
USE proyecto;


-- TABLAS PRINCIPALES


-- GNOMO
CREATE TABLE gnomo (
    id_Gnomo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    alturaBarba DECIMAL(5,2) NOT NULL,
    nivelCascarrabias INT NOT NULL,
    energiaRefunfunno INT NOT NULL
);

-- TOPO
CREATE TABLE topoCombate (
    id_Topo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    fuerzaExcavacion INT NOT NULL,
    agudezaOlfativa INT NOT NULL,
    horasSuenno TIME NOT NULL,
    tiempoTierraEnOjos INT NOT NULL,
    fk_gnomo INT,
    CONSTRAINT fk_topognomo FOREIGN KEY (fk_gnomo)
        REFERENCES gnomo(id_Gnomo)
);

-- HADA
CREATE TABLE hadaMadrina (
    id_Hada INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    envergaduraAlas INT NOT NULL,
    nivelPasivoAgresivo INT NOT NULL,
    polvoPurpurina BOOLEAN NOT NULL
);

-- CARACOL
CREATE TABLE caracolGigante (
    id_Caracol INT AUTO_INCREMENT PRIMARY KEY,
    nunSerie INT NOT NULL,
    raza VARCHAR(100),
    velocidadMax DECIMAL(5,2) NOT NULL,
    armamento VARCHAR(100),
    municionBaba INT NOT NULL,
    estado INT,
    fk_topo INT,
    CONSTRAINT fk_topoCaracol FOREIGN KEY (fk_topo)
        REFERENCES topoCombate(id_Topo)
);

-- DUENDE
CREATE TABLE duendeCombate (
    id_Duende INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    modelo VARCHAR(500) NOT NULL,
    agilidad INT,
    nivelSarcasmo INT NOT NULL,
    horasSombra TIME NOT NULL,
    tiempoBrilloCegador TIME,
    fk_Hada INT,
    fk_Caracol INT,
    CONSTRAINT fk_DuendeHada FOREIGN KEY (fk_Hada)
        REFERENCES hadaMadrina(id_Hada),
    CONSTRAINT fk_duendeCaracol FOREIGN KEY (fk_Caracol)
        REFERENCES caracolGigante(id_Caracol)
);


-- TABLAS SECUNDARIAS


CREATE TABLE picoPuntiagudo (
    id_Pico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dannio INT NOT NULL,
    tiempoRecarga TIME,
    material VARCHAR(100)
);

CREATE TABLE varitaMagica (
    id_Varita INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dannio INT NOT NULL,
    tiempoRecarga TIME,
    tipoPurpurina VARCHAR(100)
);


-- TABLAS RELACIÓN


CREATE TABLE toposPicos (
    id_ToposPicos INT AUTO_INCREMENT PRIMARY KEY,
    fk_Topos INT,
    fk_Picos INT,
    CONSTRAINT fk_ToposPicos1 FOREIGN KEY (fk_Topos)
        REFERENCES topoCombate(id_Topo),
    CONSTRAINT fk_ToposPicos2 FOREIGN KEY (fk_Picos)
        REFERENCES picoPuntiagudo(id_Pico)
);

CREATE TABLE duendeVaritas (
    id_DuendeVaritas INT AUTO_INCREMENT PRIMARY KEY,
    fk_Duende INT,
    fk_Varita INT,
    CONSTRAINT fk_DuendeVaritas1 FOREIGN KEY (fk_Duende)
        REFERENCES duendeCombate(id_Duende),
    CONSTRAINT fk_DuendeVaritas2 FOREIGN KEY (fk_Varita)
        REFERENCES varitaMagica(id_Varita)
);


-- INSERTS


-- GNOMOS
INSERT INTO gnomo (nombre, apodoGuerra, edad, alturaBarba, nivelCascarrabias, energiaRefunfunno) VALUES
('Gnomo_1','BarbaRota',210,55.20,7,80),
('Gnomo_2','PuñoGris',215,58.10,6,75),
('Gnomo_3','Gruñon',220,60.00,9,90),
('Gnomo_4','TruenoBarba',225,62.30,8,85),
('Gnomo_5','Refunfuñon',230,64.50,10,95),
('Gnomo_6','RocaVieja',235,66.70,7,70),
('Gnomo_7','Martillo',240,68.90,6,65),
('Gnomo_8','BarbaSanta',245,70.00,5,60);

-- TOPOS
INSERT INTO topoCombate VALUES
(NULL,'Topo_1','Tunelador',5,'MX',80,70,'08:00:00',10,1),
(NULL,'Topo_2','Taladro',6,'MX',82,72,'08:00:00',11,2),
(NULL,'Topo_3','Destructor',7,'MX',85,75,'08:00:00',12,3),
(NULL,'Topo_4','CiegoFeliz',8,'MX',78,68,'08:00:00',13,4),
(NULL,'Topo_5','Excavador',9,'MX',90,80,'08:00:00',14,5),
(NULL,'Topo_6','RompeRocas',10,'MX',88,77,'08:00:00',15,6),
(NULL,'Topo_7','Subterraneo',11,'MX',86,74,'08:00:00',16,7),
(NULL,'Topo_8','TierraFuria',12,'MX',92,82,'08:00:00',17,8),
(NULL,'Topo_9','Tunelador2',13,'MX',81,71,'08:00:00',18,1),
(NULL,'Topo_10','Taladro2',14,'MX',83,73,'08:00:00',19,2);

-- HADAS
INSERT INTO hadaMadrina VALUES
(NULL,'Hada_1','BrilloLetal',300,120,9,TRUE),
(NULL,'Hada_2','Susurro',280,110,7,TRUE),
(NULL,'Hada_3','Destello',290,115,8,TRUE),
(NULL,'Hada_4','LuzFatal',310,130,10,TRUE),
(NULL,'Hada_5','Chispa',270,105,6,TRUE),
(NULL,'Hada_6','Iris',260,100,5,TRUE),
(NULL,'Hada_7','Aurora',320,135,9,TRUE),
(NULL,'Hada_8','Centella',295,118,8,TRUE);

-- CARACOLES (fk_topo válido 1–10)
INSERT INTO caracolGigante VALUES
(NULL,2001,'Gigantus',2.50,'BabaAcida',50,1,1),
(NULL,2002,'Gigantus',2.60,'BabaExplosiva',55,1,2),
(NULL,2003,'Turbo',2.70,'Caparazon',60,1,3),
(NULL,2004,'Turbo',2.80,'BabaPegajosa',65,1,4),
(NULL,2005,'Omega',3.00,'BabaCorrosiva',70,1,5),
(NULL,2006,'Omega',3.10,'Caparazon',75,1,6),
(NULL,2007,'Titan',2.90,'BabaAcida',80,1,7),
(NULL,2008,'Titan',3.20,'BabaExplosiva',85,1,8),
(NULL,2009,'Colosal',3.30,'Caparazon',90,1,9),
(NULL,2010,'Colosal',3.40,'BabaCorrosiva',95,1,10);

-- DUENDES
INSERT INTO duendeCombate VALUES
(NULL,'Duende_1','SarcasmoPuro','Z1',80,9,'06:00:00','00:00:30',1,1),
(NULL,'Duende_2','LenguaFilosa','Z1',78,8,'06:00:00','00:00:30',2,2),
(NULL,'Duende_3','Burla','Z1',82,10,'06:00:00','00:00:30',3,3),
(NULL,'Duende_4','Ironico','Z1',76,7,'06:00:00','00:00:30',4,4),
(NULL,'Duende_5','Mordaz','Z1',85,9,'06:00:00','00:00:30',5,5),
(NULL,'Duende_6','Cruel','Z1',79,8,'06:00:00','00:00:30',6,6),
(NULL,'Duende_7','Seco','Z1',77,7,'06:00:00','00:00:30',7,7),
(NULL,'Duende_8','Hiriente','Z1',83,10,'06:00:00','00:00:30',8,8);

