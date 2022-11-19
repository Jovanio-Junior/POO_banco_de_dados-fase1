package cmp1611.api.viagem;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record viagemCadastro(
    @NotNull
    Long cpf_passageiro_viagem,
    @NotNull
    Long cpf_motorista_viagem,
    @NotBlank
    String placa_veiculo_viagem,
    String local_origem_viagem,
    String local_destino_viagem,
    @NotNull
    Date data_hora_inicio,
    Date data_hora_fim,
    int quantidade_passageiros,
    forma_pagamento forma_Pagamento,
    Float valor_pagamento,
    String cancelado_por_motorista,
    String cancelado_por_passageiro
) {
    
}
