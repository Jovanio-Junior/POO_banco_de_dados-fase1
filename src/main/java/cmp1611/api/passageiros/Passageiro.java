package cmp1611.api.passageiros;

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

@Table(name = "passageiros")
@Entity(name = "Passageiro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Passageiro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cpf_pass;
    private String cartao_credito;
    
    private String cidade_origem;

    @Enumerated(EnumType.STRING)
    private bandeira_cartao bandeira_Cartao;


    public Passageiro(passageiroCadastro dado) {
        this.cpf_pass = dado.cpf_pass();
        this.cartao_credito = dado.cartao_credito();
        this.cidade_origem = dado.cidade_origem();
        this.bandeira_Cartao = dado.bandeira_Cartao();
    }

    public Passageiro(Passageiro passageiro) {
        this.cpf_pass = passageiro.getCpf_pass();
        this.cartao_credito = passageiro.getCartao_credito();
        this.cidade_origem = passageiro.getCidade_origem();
        this.bandeira_Cartao = passageiro.getBandeira_Cartao();
    }

    public boolean vazio() {
        if(
            this.cpf_pass == null
        )
            return true;
        else
            return false;
    }

    public void atualizarInformacoes(@Valid passageiroCadastro dado) {
        if (
            this.cpf_pass != null
        ) {
            this.cpf_pass = dado.cpf_pass();
            this.cartao_credito = dado.cartao_credito();
            this.cidade_origem = dado.cidade_origem();
            this.bandeira_Cartao = dado.bandeira_Cartao();
        } 
    }
}
