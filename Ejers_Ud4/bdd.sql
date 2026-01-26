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
    modelo VARCHAR(100)  NOT NULL,
    fuerzaExcavacion INT NOT NULL,
    agudezaOlfativa INT NOT NULL,
    horasSuenno INT NOT NULL,
    tiempoTierraEnOjos INT NOT NULL,
    PRIMARY KEY (id_Topo)
)

--HadaMadrina

--DuendeCombate

--PicoPuntiagudo

--VaritaMagica

--CaracolGigante