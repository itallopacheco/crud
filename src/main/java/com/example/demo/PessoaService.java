package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listAll(){
        return pessoaRepository.findAll();
    }

    public void save(Pessoa pessoa){pessoaRepository.save(pessoa);
    }

    public Pessoa get(Long id){
        return pessoaRepository.findById(id).get();
    }

    public void delete(Long id){
        pessoaRepository.deleteById(id);
    }

    public List<Pessoa> getByName(String Name){
        return pessoaRepository.findPessoaByName(Name);
    }

    public List<Pessoa> getBylastName(String lastName){
        return pessoaRepository.findPessoaByLastName (lastName);
    }

    public List<Pessoa> getByCPF(String CPF){
        return pessoaRepository.findPessoaByCPF(CPF);
    }

    public List<Pessoa> findByKeyword(String keyword){
        return pessoaRepository.findByKeyword(keyword);
    }



}
