CREATE TABLE tipo_pagamento(
    id SERIAL UNIQUE,
    codigo_pagamento int not null,
    desconto_pagamento VARCHAR(20) not null,


    PRIMARY KEY(codigo_pagamento)
)