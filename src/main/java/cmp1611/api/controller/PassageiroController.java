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


import cmp1611.api.passageiros.PassageiroRepository;
import cmp1611.api.passageiros.Passageiro;

import cmp1611.api.passageiros.passageiroCadastro; 
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;;;
@RestController
public class PassageiroController {
    @Autowired
    private PassageiroRepository repository;

    @RequestMapping(value = "/passageiro", method = RequestMethod.POST)
    @Transactional
    public void cadastrarPassageiro(@RequestBody @Valid passageiroCadastro dado) {
        System.out.println(dado);
        repository.save(new Passageiro(dado));
    }

    @RequestMapping(value = "/passageiro", method = RequestMethod.GET)
    public List<Passageiro> buscarTudo(){
        return repository.findAll();
    }

    @RequestMapping(value = "/passageiro/{cpf_pass}", method = RequestMethod.GET)
    public ResponseEntity<Passageiro> porCPF(@PathVariable("cpf_pass") Long cpf_pass){
        Passageiro passageiro = repository.findByCpfPassageiro(cpf_pass);
        if(!passageiro.vazio())
            return new ResponseEntity<Passageiro>(passageiro, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/passageiro/delete/{cpf_pass}", method = RequestMethod.DELETE)
    @Transactional
    public void deletar(@PathVariable("cpf_pass") Long cpf_pass){
        Passageiro passageiro = repository.findByCpfPassageiro(cpf_pass);
        repository.delete(passageiro);
    }

    @RequestMapping(value = "/passageiro/atualizar/{cpf}", method = RequestMethod.PUT)
    @Transactional
    public void atualizar(@RequestBody @Valid passageiroCadastro dado){
        Passageiro passageiro = repository.findByCpfPassageiro(dado.cpf_pass());
        passageiro.atualizarInformacoes(dado);
    }
}
