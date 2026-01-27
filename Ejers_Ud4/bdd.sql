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
    PRIMARY KEY (idea_Duende)
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
    PRIMARY KEY (id_Pico)
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
alter table caracolGigante add constraint fk_duendeCaracol foreign key(fk_Duende) references DuendeCombate(id_Duende);


-- INSERT
