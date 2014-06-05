package br.catolica.artigo.controller;

import br.catolica.artigo.model.Pessoa;
import br.catolica.artigo.repository.PessoaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaDAO dao;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void salvar(@RequestBody Pessoa pessoa) {
        this.dao.save(pessoa);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ResponseBody
    public void remove(@RequestBody Pessoa pessoa) {
        this.dao.remove(pessoa);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Pessoa> list() {
        return this.dao.listPessoa();
    }
}
