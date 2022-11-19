package cmp1611.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cmp1611.api.veiculo.VeiculoRepository;
import cmp1611.api.veiculo.Veiculo;

import cmp1611.api.veiculo.veiculoCadastro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;;;
@RestController
public class VeiculosController {
    @Autowired
    private VeiculoRepository repository;

    @RequestMapping(value = "/veiculos", method = RequestMethod.POST)
    @Transactional
    public void cadastrarVeiculo(@RequestBody @Valid veiculoCadastro dado) {
        repository.save(new Veiculo(dado));
    }

    @RequestMapping(value = "/veiculos", method = RequestMethod.GET)
    public List<Veiculo> buscarTudo(){
        return repository.findAll();
    }

    @RequestMapping(value = "/veiculos/{placa}", method = RequestMethod.GET)
    public ResponseEntity<Veiculo> porPlaca(@PathVariable("placa") String placa){
        Veiculo veiculo = repository.findByPlacaVeiculo(placa);
        if(!veiculo.vazio())
            return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        

    }
    @RequestMapping(value = "/delete/{placa}", method = RequestMethod.DELETE)
    @Transactional
    public void deletar(@PathVariable("placa") String placa){
        Veiculo veiculo = repository.findByPlacaVeiculo(placa);
        repository.delete(veiculo);
    }

    @RequestMapping(value = "/atualizar/{placa}", method = RequestMethod.PUT)
    @Transactional
    public void atualizar(@RequestBody @Valid veiculoCadastro dado){
        Veiculo veiculo = repository.findByPlacaVeiculo(dado.Placa());
        veiculo.atualizarInformacoes(dado);
    }

}
