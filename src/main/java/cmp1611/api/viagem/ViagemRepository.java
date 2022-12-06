package cmp1611.api.viagem;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    @Query("from Viagem where cpf_passageiro_viagem = :cpf_passageiro_viagem")
    public Viagem findBycpf_passageiroViagem(@Param("cpf_passageiro_viagem") Long cpf_passageiro_viagem);

    @Query("from Viagem where cpf_motorista_viagem = :cpf_motorista_viagem")
    public Viagem findBycpf_motoristaViagem(@Param("cpf_motorista_viagem") Long cpf_motorista_viagem);

    @Query("from Viagem where placa_veiculo_viagem = :placa_veiculo_viagem")
    public Viagem findByplaca_veiculoViagem(@Param("placa_veiculo_viagem") String placa_veiculo_viagem);

    @Query("from Viagem where data_hora_inicio = :data_hora_inicio")
    public Viagem findBydata_horaViagem(@Param("data_hora_inicio") Date data_hora_inicio);
}