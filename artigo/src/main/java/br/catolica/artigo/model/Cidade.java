package br.catolica.artigo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "TB_CIDADE")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "PK_CIDADE")
    private Long id;
    
    @Column(name = "NOME")
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cidadeNatal", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
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
