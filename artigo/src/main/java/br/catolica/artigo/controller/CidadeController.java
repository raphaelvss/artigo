package br.catolica.artigo.controller;

import br.catolica.artigo.model.Cidade;
import br.catolica.artigo.repository.CidadeDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeDAO dao;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void salvar(@RequestBody Cidade cidade) {
        this.dao.save(cidade);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ResponseBody
    public void remove(@RequestBody Cidade cidade) {
        this.dao.remove(cidade);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Cidade> list() {
        return this.dao.listCidade();
    }
}
