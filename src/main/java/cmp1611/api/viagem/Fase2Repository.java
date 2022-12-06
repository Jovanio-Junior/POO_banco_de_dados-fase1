package cmp1611.api.viagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Fase2Repository extends JpaRepository<Viagem, String>{
    @Query("from Viagem where placa_veiculo_viagem = :placa_veiculo_viagem")
    Viagem findByfase2Viagem(@Param("placa_veiculo_viagem") String placa_veiculo_viagem);
}
