-- Base de Datos project-Manager
CREATE DATABASE puerto_motor;
USE puerto_motor;

-- Tabla Coche
CREATE TABLE coche (
    idCoche INT PRIMARY KEY AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anno  INT NOT NULL,
    potencia INT NOT NULL
)