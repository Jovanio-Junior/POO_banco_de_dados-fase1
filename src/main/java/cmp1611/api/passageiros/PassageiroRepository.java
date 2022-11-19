package cmp1611.api.passageiros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long>{
    @Query("from Passageiro where cpf_pass = :cpf_pass")
    public Passageiro findByCpfPassageiro(@Param("cpf_pass") Long cpf_pass);
}
