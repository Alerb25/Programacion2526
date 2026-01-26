-- Base de Datos
create database proyecto; 
create user proyecto identified by 'proyecto';
grant select, insert, update, delete on proyecto.* to 'proyecto'@'localhost';

use proyecto;

-- Tablas
--GnomoAnciano
CREATE TABLE gnomo (
    id_Gnomo INT NOT NULL AUTO_INCREMENT, 
    nombre VARCHAR(100),
    apodoGuerra VARCHAR(100),
    edad INT,
    alturaBarba DECIMAL(5,2),
    nivelCascarrabias INT,
    energiaRefunfunno INT,
    PRIMARY KEY (id_Gnomo)
);


--TopoCombate

--HadaMadrina

--DuendeCombate

--PicoPuntiagudo

--VaritaMagica

--CaracolGigante