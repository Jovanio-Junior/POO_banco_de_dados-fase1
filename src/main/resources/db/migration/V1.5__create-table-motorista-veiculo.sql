CREATE TABLE motorista_veiculos(
    id SERIAL UNIQUE,
    cpf_motorista BIGINT not null,
    placa_veiculo VARCHAR(7) not null,


    PRIMARY KEY(cpf_motorista, placa_veiculo),
    FOREIGN KEY(placa_veiculo) REFERENCES veiculos (Placa)
)