package cmp1611.api.pessoas;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("from Pessoa where cpf = :cpf")
    public Pessoa findByCpfPessoa(@Param("cpf") Long cpf);
}
