package cmp1611.api.proprietarios;
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

@Table(name = "proprietarios")
@Entity(name = "Proprietario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Proprietario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cpf_proprietario;
    private String cnh_proprietario;
    private int banco_proprietario;
    private int agencia_proprietario;
    private int conta_proprietario;

    public Proprietario(proprietarioCadastro dado) {
        this.cpf_proprietario = dado.cpf_proprietario();
        this.cnh_proprietario = dado.cnh_proprietario();
        this.banco_proprietario = dado.banco_proprietario();
        this.agencia_proprietario = dado.agencia_proprietario();
        this.conta_proprietario = dado.conta_proprietario();
    }

    public Proprietario(Proprietario proprietario) {
        this.cpf_proprietario = proprietario.getCpf_proprietario();
        this.cnh_proprietario = proprietario.getCnh_proprietario();
        this.banco_proprietario = proprietario.getBanco_proprietario();
        this.agencia_proprietario = proprietario.getAgencia_proprietario();
        this.conta_proprietario = proprietario.getConta_proprietario();
    }

    public boolean vazio() {
        if(
            this.cpf_proprietario == null
        )
            return true;
        else
            return false;
    }

    public void atualizarInformacoes(@Valid proprietarioCadastro dado) {
        if (
            this.cpf_proprietario != null
        ) {
            this.cpf_proprietario = dado.cpf_proprietario();
            this.cnh_proprietario = dado.cnh_proprietario();
            this.banco_proprietario = dado.banco_proprietario();
            this.agencia_proprietario = dado.agencia_proprietario();
            this.conta_proprietario = dado.conta_proprietario();
        } 
    }
}
