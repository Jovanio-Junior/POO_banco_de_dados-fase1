CREATE TABLE proprietarios(
    id SERIAL UNIQUE,
    cpf_proprietario BIGINT not null,
    cnh_proprietario VARCHAR(15) not null,
    banco_proprietario int not null,
    agencia_proprietario int not null,
    conta_proprietario int not null,


    PRIMARY KEY(cpf_proprietario)
)