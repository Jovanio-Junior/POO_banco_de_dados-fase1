CREATE TABLE passageiros(
    id SERIAL UNIQUE,
    cpf_pass BIGINT not null,
    cartao_credito VARCHAR(20),
    bandeira_cartao VARCHAR(20),
    cidade_origem VARCHAR(30),


    PRIMARY KEY(cpf_pass)
)