package com.example.demo.service;

import com.example.demo.domain.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


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


    public List<Pessoa> findByKeyword (String keyword){
        return pessoaRepository.findByKeyword(keyword);
    }


}
