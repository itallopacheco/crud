package com.example.demo.repository;

import com.example.demo.domain.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    @Query (value = "SELECT * FROM pessoa WHERE name LIKE concat('%', :keyword, '%') " , nativeQuery = true  )
    List<Pessoa> findByKeyword(@Param("keyword") String keyword);


}
