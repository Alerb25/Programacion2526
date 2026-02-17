--  Base de Datos
create database proyecto; 
create user proyecto identified by 'proyecto';
grant select, insert, update, delete on proyecto.* to 'proyecto'@'localhost';

use proyecto;

--  Tablas
-- ENTIDAES PRINCIPALES
-- GnomoAnciano
CREATE TABLE gnomo (
    id_Gnomo INT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    alturaBarba DECIMAL(5,2) NOT NULL,
    nivelCascarrabias INT NOT NULL,
    energiaRefunfunno INT NOT NULL,
    PRIMARY KEY (id_Gnomo)
);


-- TopoCombate
CREATE TABLE topoCombate (
    id_Topo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    modelo VARCHAR(100)  NOT NULL,
    fuerzaExcavacion INT NOT NULL,
    agudezaOlfativa INT NOT NULL,
    horasSuenno TIME NOT NULL,
    tiempoTierraEnOjos INT NOT NULL,
    PRIMARY KEY (id_Topo)
);

-- HadaMadrina
CREATE TABLE hadaMadrina(
    id_Hada INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apodoGuerra VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    envergaduraAlas INT NOT NULL,
    nivelPasivoAgresivo INT NOT NULL,
    polvoPurpurina BOOLEAN NOT NULL,
    PRIMARY KEY (id_Hada)
);
-- DuendeCombate
CREATE TABLE duendeCombate (
    id_Duende INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL, 
    apodoGuerra VARCHAR(100) NOT NULL, 
    modelo VARCHAR(500) NOT NULL, 
    agilidad INT, 
    nivelSarcasmo INT NOT NULL, 
    horasSombra TIME NOT NULL, 
    tiempoBrilloCegador TIME,
    PRIMARY KEY (id_Duende)
    );

-- ENTIDADES SECUNDARIAS
-- PicoPuntiagudo
CREATE TABLE picoPuntiagudo(
    id_Pico INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL, 
    dannio INT NOT NULL,
    tiempoRecarga TIME, 
    material VARCHAR(100),
    PRIMARY KEY (id_Pico)
);

-- VaritaMagica
CREATE TABLE varitaMagica(
    id_Varita INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL, 
    dannio INT NOT NULL,
    tiempoRecarga TIME, 
    tipoPurpurina VARCHAR(100),
    PRIMARY KEY (id_Varita)
);

-- CaracolGigante
CREATE TABLE caracolGigante(
    id_Caracol INT NOT NULL AUTO_INCREMENT,
    nunSerie INT NOT NULL, 
    raza VARCHAR(100),
    velocidadMax DECIMAL NOT NULL,
    armamento VARCHAR(100), 
    municionBaba INT NOT NULL,
    estado INT,
    PRIMARY KEY (id_Caracol)
);

-- RELACIONES
--  1:n topo y gnomo
alter table topoCombate add column fk_gnomo int;
alter table topoCombate add constraint fk_topognomo foreign key(fk_gnomo) references gnomo(id_Gnomo);

--  1:n hada y duende
alter table duendeCombate add column fk_Hada int;
alter table duendeCombate add constraint fk_DuendeHada foreign key(fk_Hada) references hadaMadrina(id_Hada);

--  n:m topo y picos
create table toposPicos (
    id_ToposPicos INT NOT NULL AUTO_INCREMENT,
    fk_Topos INT,
    fk_Picos INT,
    PRIMARY KEY (id_ToposPicos)
);
alter table toposPicos add constraint fk_ToposPicos1 foreign key(fk_Topos) references topoCombate(id_Topo);
alter table toposPicos add constraint fk_ToposPicos2 foreign key(fk_Picos) references picoPuntiagudo(id_Pico);

--  n:m duende y varita
create table duendeVaritas (
    id_DuendeVaritas INT NOT NULL AUTO_INCREMENT,
    fk_Duende INT,
    fk_VARITA INT,
    PRIMARY KEY (id_DuendeVaritas)
);
alter table duendeVaritas add constraint fk_DuendeVaritas1 foreign key(fk_Duende) references duendeCombate(id_Duende);
alter table duendeVaritas add constraint fk_DuendeVaritas2 foreign key(fk_Varita) references varitaMagica(id_Varita);

--  1:n topo y caracoles
alter table caracolGigante add column fk_topo int;
alter table caracolGigante add constraint fk_topoCaracol foreign key(fk_topo) references topoCombate(id_Topo);

--  1:n duende y caracoles
alter table caracolGigante add column fk_Duende int;
alter table duendeCombate add constraint fk_duendeCaracol foreign key(fk_Caracol) references CaracolGigante(id_Caracol);


-- INSERT

-- GNOMO
INSERT INTO gnomo(nombre, apodoGuerra, edad, alturaBarba, nivelCascarrabias, energiaRefunfunno)
VALUES
('Gnomo_1','BarbaRota',210,55.2,7,80),
('Gnomo_2','PuñoGris',215,58.1,6,75),
('Gnomo_3','Gruñon',220,60.0,9,90),
('Gnomo_4','TruenoBarba',225,62.3,8,85),
('Gnomo_5','Refunfuñon',230,64.5,10,95),
('Gnomo_6','RocaVieja',235,66.7,7,70),
('Gnomo_7','Martillo',240,68.9,6,65),
('Gnomo_8','BarbaSanta',245,70.0,5,60);

-- TOPOS
INSERT INTO topoCombate
(nombre, apodoGuerra, edad, modelo, fuerzaExcavacion, agudezaOlfativa, horasSuenno, tiempoTierraEnOjos, fk_gnomo)
VALUES
('Topo_1','Tunelador',5,'MX',80,70,'08:00:00',10,1),
('Topo_2','Taladro',6,'MX',82,72,'08:00:00',11,2),
('Topo_3','Destructor',7,'MX',85,75,'08:00:00',12,3),
('Topo_4','CiegoFeliz',8,'MX',78,68,'08:00:00',13,4),
('Topo_5','Excavador',9,'MX',90,80,'08:00:00',14,5),
('Topo_6','RompeRocas',10,'MX',88,77,'08:00:00',15,6),
('Topo_7','Subterraneo',11,'MX',86,74,'08:00:00',16,7),
('Topo_8','TierraFuria',12,'MX',92,82,'08:00:00',17,8),
('Topo_9','Tunelador2',13,'MX',81,71,'08:00:00',18,1),
('Topo_10','Taladro2',14,'MX',83,73,'08:00:00',19,2);

-- HADAS
INSERT INTO hadaMadrina(nombre, apodoGuerra, edad, envergaduraAlas, nivelPasivoAgresivo, polvoPurpurina)
VALUES
('Hada_1','BrilloLetal',300,120,9,TRUE),
('Hada_2','Susurro',280,110,7,TRUE),
('Hada_3','Destello',290,115,8,TRUE),
('Hada_4','LuzFatal',310,130,10,TRUE),
('Hada_5','Chispa',270,105,6,TRUE),
('Hada_6','Iris',260,100,5,TRUE),
('Hada_7','Aurora',320,135,9,TRUE),
('Hada_8','Centella',295,118,8,TRUE);

-- DUENDES 
INSERT INTO duendeCombate
(nombre, apodoGuerra, modelo, agilidad, nivelSarcasmo, horasSombra, tiempoBrilloCegador, fk_Hada)
VALUES
('Duende_1','SarcasmoPuro','Z1',80,9,'06:00:00','00:00:30',1),
('Duende_2','LenguaFilosa','Z1',78,8,'06:00:00','00:00:30',2),
('Duende_3','Burla','Z1',82,10,'06:00:00','00:00:30',3),
('Duende_4','Ironico','Z1',76,7,'06:00:00','00:00:30',4),
('Duende_5','Mordaz','Z1',85,9,'06:00:00','00:00:30',5),
('Duende_6','Cruel','Z1',79,8,'06:00:00','00:00:30',6),
('Duende_7','Seco','Z1',77,7,'06:00:00','00:00:30',7),
('Duende_8','Hiriente','Z1',83,10,'06:00:00','00:00:30',8);


-- CARACOLES
INSERT INTO caracolGigante
(nunSerie, raza, velocidadMax, armamento, municionBaba, estado, fk_topo, fk_Duende)
VALUES
(2001,'Gigantus',2.5,'BabaAcida',50,1,1,1),
(2002,'Gigantus',2.6,'BabaExplosiva',55,1,2,2),
(2003,'Turbo',2.7,'Caparazon',60,1,3,3),
(2004,'Turbo',2.8,'BabaPegajosa',65,1,4,4),
(2005,'Omega',3.0,'BabaCorrosiva',70,1,5,5),
(2006,'Omega',3.1,'Caparazon',75,1,6,6),
(2007,'Titan',2.9,'BabaAcida',80,1,7,7),
(2008,'Titan',3.2,'BabaExplosiva',85,1,8,8),
(2009,'Colosal',3.3,'Caparazon',90,1,9,9),
(2010,'Colosal',3.4,'BabaCorrosiva',95,1,10,10),
(2011,'Mega',3.5,'BabaPegajosa',100,1,11,11),
(2012,'Mega',3.6,'Caparazon',105,1,12,12),
(2013,'Ultra',3.7,'BabaAcida',110,1,13,13),
(2014,'Ultra',3.8,'BabaExplosiva',115,1,14,14),
(2015,'Ultra',4.0,'Caparazon',120,1,15,15);

-- PICOS PUNTIAGUDOS
INSERT INTO picoPuntiagudo(nombre, dannio, tiempoRecarga, material)
VALUES
('Pico_1',20,'00:00:10','Hierro'),
('Pico_2',22,'00:00:10','Acero'),
('Pico_3',24,'00:00:10','Mithril'),
('Pico_4',26,'00:00:10','Hierro'),
('Pico_5',28,'00:00:10','Acero'),
('Pico_6',30,'00:00:10','Mithril'),
('Pico_7',32,'00:00:10','Hierro'),
('Pico_8',34,'00:00:10','Acero'),
('Pico_9',36,'00:00:10','Mithril'),
('Pico_10',38,'00:00:10','Hierro');

-- VARITAS 
INSERT INTO varitaMagica(nombre, dannio, tiempoRecarga, tipoPurpurina)
VALUES
('Varita_1',25,'00:00:20','Rosa'),
('Varita_2',27,'00:00:20','Azul'),
('Varita_3',29,'00:00:20','Verde'),
('Varita_4',31,'00:00:20','Dorada'),
('Varita_5',33,'00:00:20','Plateada'),
('Varita_6',35,'00:00:20','Arcoiris'),
('Varita_7',37,'00:00:20','Rosa'),
('Varita_8',39,'00:00:20','Azul'),
('Varita_9',41,'00:00:20','Verde'),
('Varita_10',43,'00:00:20','Dorada');

