package br.catolica.artigo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.catolica.artigo.model.Pessoa;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PessoaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Pessoa pessoa) {
        entityManager.merge(pessoa);
    }

    @Transactional
    public void remove(Pessoa pessoa) {
        entityManager.remove(entityManager.getReference(Pessoa.class, pessoa.getId()));
    }

    public List<Pessoa> listPessoa() {
        List<Pessoa> result = entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
        return result;
    }

    public Pessoa findById(Long id) {
        Pessoa result = entityManager.find(Pessoa.class, id);
        return result;
    }
}