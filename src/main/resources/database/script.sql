create database sistema_bancario;
use sistema_bancario;
CREATE TABLE titular
(
    id_titular INT AUTO_INCREMENT PRIMARY KEY,
    cpf        VARCHAR(14)  NOT NULL UNIQUE,
    nome       VARCHAR(100) NOT NULL,
    endereco   VARCHAR(255),
    telefone   VARCHAR(20),
    email      VARCHAR(100)
);
CREATE TABLE conta_bancaria
(
    numero_conta  VARCHAR(20) PRIMARY KEY,
    agencia       VARCHAR(10) NOT NULL,
    saldo         DECIMAL(15, 2) DEFAULT 0.00,
    status        VARCHAR(20) NOT NULL,
    data_abertura DATE        NOT NULL,
    titular_id    INT         NOT NULL,
    FOREIGN KEY (titular_id) REFERENCES titular (id_titular) ON DELETE CASCADE
);