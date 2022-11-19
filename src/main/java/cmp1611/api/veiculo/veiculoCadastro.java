package cmp1611.api.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record veiculoCadastro(
    @NotBlank
    String Placa,
    @NotBlank
    String Marca,
    @NotBlank
    String Modelo,
    @NotNull
    int Ano_Fabricacao,
    @NotNull
    int Capacidade_Passageiros,
    @NotBlank
    String Cor,
    @NotNull
    Tipo_Combustivel tipo,
    
    int Potencia_Motor
) {

}



