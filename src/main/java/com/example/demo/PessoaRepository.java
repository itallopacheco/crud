package com.example.demo;

import org.springframework.boot.util.LambdaSafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    @Query (value = "SELECT * FROM pessoa WHERE name LIKE concat('%', :keyword, '%') " , nativeQuery = true  )
    List<Pessoa> findByKeyword(@Param("keyword") String keyword);

}
