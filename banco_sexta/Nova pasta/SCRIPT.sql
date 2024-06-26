-- Geração de Modelo físico
 -- Sql ANSI 2003 - brModelo.



CREATE TABLE IF NOT EXISTS CLIENTE (
CPF VARCHAR(14) NOT NULL PRIMARY KEY,
ENDERECO VARCHAR (80) NOT NULL,
NOME VARCHAR(50) NOT NULL,
TELEFONE VARCHAR (15) NOT NULL 
)

CREATE TABLE IF NOT EXISTS PEDIDO  (
NOME_PEDIDO INT NOT NULL PRIMARY KEY,
DATA_PEDIDO DATE NOT NULL,
TOTAL_PEDIDO DECIMAL(7,2) NOT NULL,
CPF VARCHAR(14) ,
FOREIGN KEY(CPF) REFERENCES CLIENTE (CPF)
)

CREATE TABLE IF NOT EXISTS PRODUTO (
ID_PRODUTO INT NOT NULL PRIMARY KEY,
ESTOQUE INT NOT NULL,
NOME_PRODUTO VARCHAR (50),
PRECO DECIMAL (5,2) NOT NULL
)

CREATE TABLE IF NOT EXISTS CONTEM (
COMPROVANTE VARCHAR (30) PRIMARY KEY,
QUANTIDADE INT NOT NULL,
ID_PRODUTO INT NOT NULL,
NOME_PEDIDO INT NOT NULL,
FOREIGN KEY(ID_PRODUTO) REFERENCES PRODUTO (ID_PRODUTO),
FOREIGN KEY(NOME_PEDIDO) REFERENCES PEDIDO (NOME_PEDIDO)
)

