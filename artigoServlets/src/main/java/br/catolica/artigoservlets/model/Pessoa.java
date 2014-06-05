package br.catolica.artigoservlets.model;

/**
 *
 * @author Raphael
 */
public class Pessoa {

    private Long id;
    private String nome;
    private int idade;
    private Cidade cidadeNatal;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cidade getCidadeNatal() {
        return cidadeNatal;
    }

    public void setCidadeNatal(Cidade cidadeNatal) {
        this.cidadeNatal = cidadeNatal;
    }

}
