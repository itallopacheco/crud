package com.example.demo.controller;

import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import com.example.demo.domain.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PessoaController {
    @Autowired
    private PessoaService service;

    private PessoaRepository pessoaRepository;
    public PessoaController (PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }


    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        Pessoa pessoa = new Pessoa();
        model.addAttribute("pessoa", pessoa);

        return "add_pessoa";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        service.save(pessoa);
        return "redirect:/";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_pessoa");

        Pessoa pessoa = service.get(id);
        mav.addObject("pessoa", pessoa);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePessoa(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
    @GetMapping("/")
    public String filtrarPessoa(Model model, String keyword){

        if (keyword != null){
            model.addAttribute("pessoasList", service.findByKeyword(keyword));
        } else{
            model.addAttribute("pessoasList", service.listAll());
        }

        return "index";
    }

    @GetMapping("/pessoas")
    public String pessoasPage(HttpServletRequest request, Model model){

        int page = 0;
        int size = 5;

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()){
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()){
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("pessoas", pessoaRepository.findAll(PageRequest.of(page,size)));
        return "pessoas";

    }



}