package br.catolica.artigoservlets.model;

import java.util.List;

/**
 *
 * @author Raphael
 */
public class Cidade {

    private Long id;
    private String nome;
    private List<Pessoa> pessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
