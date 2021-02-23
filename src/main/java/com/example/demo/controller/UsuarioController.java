package com.example.demo.controller;


import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/login")
    public String showLoginPage(){
        return "redirect:/";
    }

    @GetMapping("/registrar")
    public String showRegistrationPage(Model model){
        model.addAttribute("usuario", new Usuario());

        return "registrar";
    }

    @PostMapping("/process_register")
    public String processRegistration(Usuario usuario){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encodedPassword);

        usuarioRepository.save(usuario);
        return  "register_success";
    }

}
