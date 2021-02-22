package com.example.demo;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PessoaController {
    @Autowired
    private PessoaService service;


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


}