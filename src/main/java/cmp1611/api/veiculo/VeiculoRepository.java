package cmp1611.api.veiculo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
    @Query("from Veiculo where Placa = :Placa")
    public Veiculo findByPlacaVeiculo(@Param("Placa") String Placa);
}
