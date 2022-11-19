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

import cmp1611.api.pessoas.PessoaRepository;
import cmp1611.api.pessoas.Pessoa;

import cmp1611.api.pessoas.pessoaCadastro; 
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;;;
@RestController
public class PessoasController {
    @Autowired
    private PessoaRepository repository;

    @RequestMapping(value = "/pessoas", method = RequestMethod.POST)
    @Transactional
    public void cadastrarPessoa(@RequestBody @Valid pessoaCadastro dado) {
        System.out.println(dado);
        repository.save(new Pessoa(dado));
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public List<Pessoa> buscarTudo(){
        return repository.findAll();
    }
    
    @RequestMapping(value = "/pessoas/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> porCPF(@PathVariable("cpf") Long cpf){
        Pessoa pessoa = repository.findByCpfPessoa(cpf);
        if(!pessoa.vazio())
            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoas/delete/{cpf}", method = RequestMethod.DELETE)
    @Transactional
    public void deletar(@PathVariable("cpf") Long cpf){
        Pessoa pessoa = repository.findByCpfPessoa(cpf);
        repository.delete(pessoa);
    }

    @RequestMapping(value = "/pessoas/atualizar/{cpf}", method = RequestMethod.PUT)
    @Transactional
    public void atualizar(@RequestBody @Valid pessoaCadastro dado){
        Pessoa pessoa = repository.findByCpfPessoa(dado.cpf());
        pessoa.atualizarInformacoes(dado);
    }
}
