
import br.catolica.artigo.model.Cidade;
import br.catolica.artigo.model.Pessoa;
import br.catolica.artigo.repository.CidadeDAO;
import br.catolica.artigo.repository.PessoaDAO;

/**
 *
 * @author raphael
 */
public class Main {
    public static void main(String[] args) {
        Cidade cidade = new CidadeDAO().findById(1L);
        Pessoa pessoa = new Pessoa();
           
        pessoa.setCidadeNatal(cidade);
        pessoa.setNome("Eu");
        pessoa.setIdade(21);
          
        new PessoaDAO().save(pessoa);
    }
}
