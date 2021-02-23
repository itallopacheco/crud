package com.example.demo;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        Usuario usuario = new Usuario();
        usuario.setEmail("joaopedro@hotmail.com");
        usuario.setSenha("12345677");
        usuario.setNome("João");
        usuario.setSobrenome("Pedro");

        Usuario savedUser = usuarioRepository.save(usuario);

        Usuario existUser = entityManager.find(Usuario.class, savedUser.getId());

       assertThat(existUser.getEmail()).isEqualTo(usuario.getEmail());

    }

    @Test
    public void testFindUsuarioByEmail(){
        String email = "itallo0@hotmail.com";
        Usuario usuario = usuarioRepository.findBYEmail(email);

        assertThat(usuario).isNotNull();
    }

}
