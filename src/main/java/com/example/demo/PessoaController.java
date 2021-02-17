package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PessoaController {
    @Autowired
    private PessoaService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Pessoa> pessoasList = service.listAll();
        model.addAttribute("pessoasList", pessoasList);

        return "index";
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


}