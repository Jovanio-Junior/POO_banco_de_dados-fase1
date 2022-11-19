package cmp1611.api.pessoas;


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

@Table(name = "pessoas")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cpf;
    private String Nome;
    private String Endereco;
    private int Telefone;
    private String E_mail;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    public Pessoa(pessoaCadastro dado) {
        this.cpf = dado.cpf();
        this.Nome = dado.Nome();
        this.Endereco = dado.Endereco();
        this.Telefone = dado.Telefone();
        this.E_mail = dado.E_mail();
        this.sexo = dado.sexo();
    }

    public Pessoa(Pessoa pessoa) {
        this.cpf = pessoa.getCpf();
        this.Nome = pessoa.getNome();
        this.Endereco = pessoa.getEndereco();
        this.Telefone = pessoa.getTelefone();
        this.E_mail = pessoa.getE_mail();
        this.sexo = pessoa.getSexo();
    }

    public boolean vazio() {
        if(
            this.Nome.isEmpty()
        )
            return true;
        else
            return false;
    }

    public void atualizarInformacoes(@Valid pessoaCadastro dado) {
        if (
            (dado.Nome() != null)
        ) {
            this.cpf = dado.cpf();
            this.Nome = dado.Nome();
            this.Endereco = dado.Endereco();
            this.Telefone = dado.Telefone();
            this.E_mail = dado.E_mail();
            this.sexo = dado.sexo();
        } 
    }

}
