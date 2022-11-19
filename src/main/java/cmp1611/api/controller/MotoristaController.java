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

import cmp1611.api.motoristas.MotoristaRepository;
import cmp1611.api.motoristas.Motorista;

import cmp1611.api.motoristas.motoristaCadastro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;;;
@RestController
public class MotoristaController {
    @Autowired
    private MotoristaRepository repository;

    @RequestMapping(value = "/motorista", method = RequestMethod.POST)
    @Transactional
    public void cadastrarMotorista(@RequestBody @Valid motoristaCadastro dado) {
        System.out.println(dado);
        repository.save(new Motorista(dado));
    }

    @RequestMapping(value = "/motorista", method = RequestMethod.GET)
    public List<Motorista> buscarTudo(){
        return repository.findAll();
    }

    @RequestMapping(value = "/motorista/{cpf_pass}", method = RequestMethod.GET)
    public ResponseEntity<Motorista> porCPF(@PathVariable("cpf_pass") Long cpf_pass){
        Motorista motorista = repository.findByCpfMotorista(cpf_pass);
        if(!motorista.vazio())
            return new ResponseEntity<Motorista>(motorista, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/motorista/delete/{cpf_pass}", method = RequestMethod.DELETE)
    @Transactional
    public void deletar(@PathVariable("cpf_pass") Long cpf_pass){
        Motorista motorista = repository.findByCpfMotorista(cpf_pass);
        repository.delete(motorista);
    }

    @RequestMapping(value = "/motorista/atualizar/{cpf}", method = RequestMethod.PUT)
    @Transactional
    public void atualizar(@RequestBody @Valid motoristaCadastro dado){
        Motorista motorista = repository.findByCpfMotorista(dado.cpf_motorista());
        motorista.atualizarInformacoes(dado);
    }
}
