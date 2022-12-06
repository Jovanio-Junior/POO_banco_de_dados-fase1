CREATE TABLE veiculos(
    id SERIAL UNIQUE,
    Placa VARCHAR(7) not null,
    Marca VARCHAR(30) not null,
    Modelo VARCHAR(30) not null,
    Ano_Fabricacao int not null,
    Capacidade_Passageiros int not null,
    Cor VARCHAR(30) not null,
    Tipo_Combustivel VARCHAR(1) not null,
    Potencia_Motor int,

    PRIMARY KEY(Placa)
)