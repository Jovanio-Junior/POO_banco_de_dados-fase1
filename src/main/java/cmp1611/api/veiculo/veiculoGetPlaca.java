package cmp1611.api.veiculo;

import jakarta.validation.constraints.NotNull;

public record veiculoGetPlaca(
    @NotNull
    String placa
) {
    
}
