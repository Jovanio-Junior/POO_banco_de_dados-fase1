CREATE TABLE pessoas(
    id SERIAL UNIQUE,
    cpf BIGINT not null,
    Nome VARCHAR(50) not null,
    Endereco VARCHAR(50),
    Telefone int,
    Sexo VARCHAR(1),
    E_mail VARCHAR(30),

    PRIMARY KEY(cpf)
);

CREATE TABLE passageiros(
    id SERIAL UNIQUE,
    cpf_pass BIGINT not null,
    cartao_credito VARCHAR(20),
    bandeira_cartao VARCHAR(20),
    cidade_origem VARCHAR(30),

    PRIMARY KEY(cpf_pass),
    FOREIGN KEY(cpf_pass) REFERENCES pessoas(cpf)
);

CREATE TABLE motoristas(
    id SERIAL UNIQUE,
    cpf_motorista BIGINT not null,
    cnh VARCHAR(15) not null,
    banco_mot int not null,
    agencia_mot int not null,
    conta_mot int not null,

    PRIMARY KEY(cpf_motorista),
    FOREIGN KEY(cpf_motorista) REFERENCES pessoas(cpf)
);

CREATE TABLE proprietarios(
    id SERIAL UNIQUE,
    cpf_proprietario BIGINT not null,
    cnh_proprietario VARCHAR(15) not null,
    banco_proprietario int not null,
    agencia_proprietario int not null,
    conta_proprietario int not null,

    PRIMARY KEY(cpf_proprietario),
    FOREIGN KEY(cpf_proprietario) REFERENCES pessoas(cpf)
);