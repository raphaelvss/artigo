package br.catolica.artigo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.catolica.artigo.model.Cidade;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CidadeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Cidade cidade) {
        entityManager.merge(cidade);
    }

    @Transactional
    public void remove(Cidade cidade) {
        entityManager.remove(cidade);
    }

    public List<Cidade> listCidade() {
        List<Cidade> result = entityManager.createQuery("SELECT c FROM Cidade c", Cidade.class).getResultList();
        return result;
    }

    public Cidade findById(Long id) {
        Cidade result = entityManager.find(Cidade.class, id);
        return result;
    }
}