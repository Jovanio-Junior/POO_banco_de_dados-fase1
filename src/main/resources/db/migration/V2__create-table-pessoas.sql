CREATE TABLE pessoas(
    id SERIAL UNIQUE,
    cpf BIGINT not null,
    Nome VARCHAR(50) not null,
    Endereco VARCHAR(50),
    Telefone int,
    Sexo VARCHAR(1),
    E_mail VARCHAR(30),


    PRIMARY KEY(cpf)
)