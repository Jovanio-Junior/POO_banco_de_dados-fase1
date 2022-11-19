CREATE TABLE motoristas(
    id SERIAL UNIQUE,
    cpf_motorista BIGINT not null,
    cnh VARCHAR(15) not null,
    banco_mot int not null,
    agencia_mot int not null,
    conta_mot int not null,


    PRIMARY KEY(cpf_motorista)
)