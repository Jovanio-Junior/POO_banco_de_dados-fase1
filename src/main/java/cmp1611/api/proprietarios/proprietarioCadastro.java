package cmp1611.api.proprietarios;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record proprietarioCadastro(
    @NotNull
    Long cpf_proprietario,
    @NotBlank
    String cnh_proprietario,
    @NotNull
    int banco_proprietario,
    @NotNull
    int agencia_proprietario,
    @NotNull
    int conta_proprietario
) {
    
}
