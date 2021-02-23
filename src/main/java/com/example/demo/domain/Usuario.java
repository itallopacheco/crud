package com.example.demo.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Getter
    @Setter
    @Column(nullable = false, length = 250)
    private String senha;

    @Getter
    @Setter
    @Column(nullable = false, length = 25)
    private String nome;

    @Getter
    @Setter
    @Column(nullable = false, length = 25)
    private String sobrenome;
}
