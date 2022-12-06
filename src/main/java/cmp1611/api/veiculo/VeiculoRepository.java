package cmp1611.api.veiculo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
    // @Query("from Veiculo where Placa = :Placa")
    // public Veiculo findByPlacaVeiculo(@Param("Placa") String Placa);
    @Query("from Veiculo where Placa = :Placa")
    Veiculo findByPlacaVeiculo(String Placa);


    @Query("from Veiculo where Marca = :Marca")
    List<Veiculo> findByMarcaVeiculo(String Marca);
    // @Query("from Veiculo where Marca = :Marca")
    // public Veiculo findByMarcaVeiculo(@Param("Marca" String Marca));
}
 