package cmp1611.api.motoristas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MotoristaRepository extends JpaRepository<Motorista,Long>{
    @Query("from Motorista where cpf_motorista = :cpf_motorista")
    public Motorista findByCpfMotorista(@Param("cpf_motorista") Long cpf_motorista);
}
