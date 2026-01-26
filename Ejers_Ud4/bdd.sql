-- Base de Datos
create database proyecto; 
create user proyecto identified by 'proyecto';
grant select, insert, update, delete on proyecto.* to 'proyecto'@'localhost';

use proyecto;

-- Tablas
--GnomoAnciano
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


--TopoCombate
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

--HadaMadrina
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
--DuendeCombate
CREATE TABLE DuendeCombate (
    id_Duende INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL, 
    apodoGuerra VARCHAR(100) NOT NULL, 
    modelo VARCHAR(500) NOT NULL, 
    agilidad INT, 
    nivelSarcasmo INT NOT NULL, 
    horasSombra TIME NOT NULL, 
    tiempoBrilloCegador TIME,
    PRIMARY KEY ()
    )


--PicoPuntiagudo

--VaritaMagica

--CaracolGigante