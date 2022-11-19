package cmp1611.api.passageiros;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record passageiroCadastro(
    @NotNull
    Long cpf_pass,
    @NotBlank
    String cartao_credito,
    @NotNull
    bandeira_cartao bandeira_Cartao,
    @NotBlank
    String cidade_origem
) {
    
}
 