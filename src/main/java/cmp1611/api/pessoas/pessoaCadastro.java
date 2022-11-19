package cmp1611.api.pessoas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record pessoaCadastro(
    @NotNull
    Long cpf,
    @NotBlank
    String Nome,
    @NotBlank
    String Endereco,
    @NotNull
    int Telefone,
    @NotBlank
    String E_mail,
    @NotNull
    Sexo sexo
    ) {
    
}
