package cmp1611.api.motoristas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record motoristaCadastro(
    @NotNull
    Long cpf_motorista,
    @NotBlank
    String cnh,
    @NotNull
    int banco_mot,
    @NotNull
    int agencia_mot,
    @NotNull
    int conta_mot
) {
    
}
