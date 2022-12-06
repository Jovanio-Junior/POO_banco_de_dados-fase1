CREATE TABLE proprietario_possui_veiculo (
	cpf_proprietario bigint NOT NULL,
	placa varchar(7) NULL,
	
	CONSTRAINT proprietario_possui_veiculo_pk PRIMARY KEY (placa),
	CONSTRAINT proprietario_possui_veiculo_fk FOREIGN KEY (placa) REFERENCES veiculos(placa),
	CONSTRAINT proprietario_possui_veiculo_fk_1 FOREIGN KEY (cpf_proprietario) REFERENCES proprietarios(cpf_proprietario)
);


CREATE TABLE motorista_viagem_veiculo (
	cpf_motorista bigint NOT NULL,
	placa_veiculo varchar(7) NOT NULL,
	CONSTRAINT motorista_viagem_veiculo_pk PRIMARY KEY (cpf_motorista,placa_veiculo),
	CONSTRAINT motorista_viagem_veiculo_fk FOREIGN KEY (cpf_motorista,placa_veiculo) REFERENCES motorista_veiculos(cpf_motorista,placa_veiculo)
);


ALTER TABLE viagens ADD CONSTRAINT viagens_fk FOREIGN KEY (cpf_motorista_viagem,placa_veiculo_viagem) REFERENCES motorista_viagem_veiculo(cpf_motorista,placa_veiculo);