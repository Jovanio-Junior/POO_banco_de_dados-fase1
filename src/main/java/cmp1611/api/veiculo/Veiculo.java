package cmp1611.api.veiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "veiculos")
@Entity(name = "Veiculo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {
    
    

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Placa;
    private String Marca;
    private String Modelo;
    private int Ano_Fabricacao;
    private int Capacidade_Passageiros;
    private String Cor;
    private int Potencia_Motor;

    @Enumerated(EnumType.STRING)
    private Tipo_Combustivel tipo_Combustivel;
    
    public Veiculo(veiculoCadastro dado) {
        this.Placa = dado.Placa();
        this.Marca = dado.Marca();
        this.Modelo = dado.Modelo();
        this.Ano_Fabricacao = dado.Ano_Fabricacao();
        this.Capacidade_Passageiros = dado.Capacidade_Passageiros();
        this.Cor = dado.Cor();
        this.Potencia_Motor = dado.Potencia_Motor();
        this.tipo_Combustivel = dado.tipo();
    }

    public Veiculo(Veiculo veiculo) {
        this.Placa = veiculo.getPlaca();
        this.Marca = veiculo.getMarca();
        this.Modelo = veiculo.getModelo();
        this.Ano_Fabricacao = veiculo.getAno_Fabricacao();
        this.Capacidade_Passageiros = veiculo.getCapacidade_Passageiros();
        this.Cor = veiculo.getCor();
        this.Potencia_Motor = veiculo.getPotencia_Motor();
        this.tipo_Combustivel = veiculo.getTipo_Combustivel();
    }

    public boolean vazio() {
        if(
            this.Placa.isEmpty()
        )
            return true;
        else
            return false;
    }

    public void atualizarInformacoes(@Valid veiculoCadastro dado) {
        if (
            (dado.Placa() != null) && (dado.Marca() != null) && (dado.Modelo() != null) && (dado.Cor() != null)  && (dado.tipo() != null)
        ) {
            this.Placa = dado.Placa();
            this.Marca = dado.Marca();
            this.Modelo = dado.Modelo();
            this.Ano_Fabricacao = dado.Ano_Fabricacao();
            this.Capacidade_Passageiros = dado.Capacidade_Passageiros();
            this.Cor = dado.Cor();
            this.Potencia_Motor = dado.Potencia_Motor();
            this.tipo_Combustivel = dado.tipo();
        } 
    }

}
