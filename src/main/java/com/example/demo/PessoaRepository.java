package com.example.demo;

import org.springframework.boot.util.LambdaSafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    public List<Pessoa> findPessoaByName (String Name);

    public List<Pessoa> findPessoaByLastName (String lastName);

    public List<Pessoa> findPessoaByCPF (String CPF);

    @Query (value = "select * from Pessoa where name like keyword% or last_name like keyword%" , nativeQuery = true  )
    List<Pessoa> findByKeyword(@Param("keyword") String keyword);

}
