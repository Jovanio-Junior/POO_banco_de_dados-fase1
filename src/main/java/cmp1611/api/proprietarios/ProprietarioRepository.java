package cmp1611.api.proprietarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
    @Query("from Proprietario where cpf_proprietario = :cpf_proprietario")
    public Proprietario findByCpfProprietario(@Param("cpf_proprietario") Long cpf_proprietario);
}
