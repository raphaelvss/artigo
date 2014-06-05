package br.catolica.artigo.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "PK_PESSOA")
    private Long id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "IDADE")
    private int idade;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_CIDADE", referencedColumnName = "PK_CIDADE")
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
