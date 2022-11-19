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

import cmp1611.api.proprietarios.ProprietarioRepository;
import cmp1611.api.proprietarios.Proprietario;

import cmp1611.api.proprietarios.proprietarioCadastro; 
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;;;
@RestController
public class ProprietariosController {
    @Autowired
    private ProprietarioRepository repository;

    @RequestMapping(value = "/proprietario", method = RequestMethod.POST)
    @Transactional
    public void cadastrarProprietario(@RequestBody @Valid proprietarioCadastro dado) {
        System.out.println(dado);
        repository.save(new Proprietario(dado));
    }

    @RequestMapping(value = "/proprietario", method = RequestMethod.GET)
    public List<Proprietario> buscarTudo(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/proprietario/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Proprietario> porCPF(@PathVariable("cpf") Long cpf){
        Proprietario proprietario = repository.findByCpfProprietario(cpf);
        if(!proprietario.vazio())
            return new ResponseEntity<Proprietario>(proprietario, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/proprietario/delete/{cpf}", method = RequestMethod.DELETE)
    @Transactional
    public void deletar(@PathVariable("cpf") Long cpf){
        Proprietario proprietario = repository.findByCpfProprietario(cpf);
        repository.delete(proprietario);
    }

    @RequestMapping(value = "/proprietario/atualizar/{cpf}", method = RequestMethod.PUT)
    @Transactional
    public void atualizar(@RequestBody @Valid proprietarioCadastro dado){
        Proprietario proprietario = repository.findByCpfProprietario(dado.cpf_proprietario());
        proprietario.atualizarInformacoes(dado);
    }
}
