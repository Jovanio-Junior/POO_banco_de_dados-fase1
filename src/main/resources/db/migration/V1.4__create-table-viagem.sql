CREATE TABLE viagens(
    id SERIAL UNIQUE,
    cpf_passageiro_viagem BIGINT not null,
    cpf_motorista_viagem BIGINT not null,
    placa_veiculo_viagem VARCHAR(7) not null,
    local_origem_viagem VARCHAR(30),
    local_destino_viagem VARCHAR(30),
    data_hora_inicio TIMESTAMP not null,
    data_hora_fim TIMESTAMP,
    quantidade_passageiros int,
    forma_pagamento VARCHAR(15),
    valor_pagamento NUMERIC(10,2),
    cancelado_por_motorista VARCHAR(1),
    cancelado_por_passageiro VARCHAR(1),


    PRIMARY KEY(
        cpf_passageiro_viagem,
        cpf_motorista_viagem,
        placa_veiculo_viagem,
        data_hora_inicio
    )
);


