package cmp1611.api.viagem;
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
import java.util.Date;

@Table(name = "viagens")
@Entity(name = "Viagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Viagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cpf_passageiro_viagem;
    private Long cpf_motorista_viagem;
    private String placa_veiculo_viagem;
    private String local_origem_viagem;
    private String local_destino_viagem;
    private Date data_hora_inicio;
    private Date data_hora_fim;
    private int quantidade_passageiros;
    private Float valor_pagamento;
    private String cancelado_por_motorista;
    private String cancelado_por_passageiro;

    @Enumerated(EnumType.STRING)
    private forma_pagamento forma_Pagamento;


    public Viagem(viagemCadastro dado) {
        this.cpf_passageiro_viagem = dado.cpf_passageiro_viagem();
        this.cpf_motorista_viagem = dado.cpf_motorista_viagem();
        this.placa_veiculo_viagem = dado.placa_veiculo_viagem();
        this.local_origem_viagem = dado.local_origem_viagem();
        this.local_destino_viagem = dado.local_destino_viagem();
        this.data_hora_inicio = dado.data_hora_inicio();
        this.data_hora_fim = dado.data_hora_fim();
        this.quantidade_passageiros = dado.quantidade_passageiros();
        this.valor_pagamento = dado.valor_pagamento();
        this.cancelado_por_motorista = dado.cancelado_por_motorista();
        this.cancelado_por_passageiro = dado.cancelado_por_passageiro();
        this.forma_Pagamento = dado.forma_Pagamento();
    }

    public Viagem(Viagem viagem) {
        this.cpf_passageiro_viagem = viagem.getCpf_passageiro_viagem();
        this.cpf_motorista_viagem = viagem.getCpf_motorista_viagem();
        this.placa_veiculo_viagem = viagem.getPlaca_veiculo_viagem();
        this.local_origem_viagem = viagem.getLocal_origem_viagem();
        this.local_destino_viagem = viagem.getLocal_destino_viagem();
        this.data_hora_inicio = viagem.getData_hora_inicio();
        this.data_hora_fim = viagem.getData_hora_fim();
        this.quantidade_passageiros = viagem.getQuantidade_passageiros();
        this.valor_pagamento = viagem.getValor_pagamento();
        this.cancelado_por_motorista = viagem.getCancelado_por_motorista();
        this.cancelado_por_passageiro = viagem.getCancelado_por_passageiro();
        this.forma_Pagamento = viagem.getForma_Pagamento();
    }

    public boolean vazio() {
        if(
            this.cpf_passageiro_viagem == null
        )
            return true;
        else
            return false;
    }

    public void atualizarInformacoes(@Valid viagemCadastro dado) {
        if (
            this.cpf_passageiro_viagem != null
        ) {
            this.cpf_passageiro_viagem = dado.cpf_passageiro_viagem();
            this.cpf_motorista_viagem = dado.cpf_motorista_viagem();
            this.placa_veiculo_viagem = dado.placa_veiculo_viagem();
            this.local_origem_viagem = dado.local_origem_viagem();
            this.local_destino_viagem = dado.local_destino_viagem();
            this.data_hora_inicio = dado.data_hora_inicio();
            this.data_hora_fim = dado.data_hora_fim();
            this.quantidade_passageiros = dado.quantidade_passageiros();
            this.valor_pagamento = dado.valor_pagamento();
            this.cancelado_por_motorista = dado.cancelado_por_motorista();
            this.cancelado_por_passageiro = dado.cancelado_por_passageiro();
            this.forma_Pagamento = dado.forma_Pagamento();
        } 
    }
}
