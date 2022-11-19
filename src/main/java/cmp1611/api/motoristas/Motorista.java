package cmp1611.api.motoristas;
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

@Table(name = "motoristas")
@Entity(name = "Motorista")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Motorista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cpf_motorista;
    private int banco_mot;
    private int agencia_mot;
    private int conta_mot;

    public Motorista(motoristaCadastro dado) {
        this.cpf_motorista = dado.cpf_motorista();
        this.banco_mot = dado.banco_mot();
        this.agencia_mot = dado.agencia_mot();
        this.conta_mot = dado.conta_mot();
    }

    public Motorista(Motorista motorista) {
        this.cpf_motorista = motorista.getCpf_motorista();
        this.banco_mot = motorista.getBanco_mot();
        this.agencia_mot = motorista.getAgencia_mot();
        this.conta_mot = motorista.getConta_mot();
    }

    public boolean vazio() {
        if(
            this.cpf_motorista == null
        )
            return true;
        else
            return false;
    }

    public void atualizarInformacoes(@Valid motoristaCadastro dado) {
        if (
            this.cpf_motorista != null
        ) {
            this.cpf_motorista = dado.cpf_motorista();
            this.banco_mot = dado.banco_mot();
            this.agencia_mot = dado.agencia_mot();
            this.conta_mot = dado.conta_mot();
        } 
    }
}
