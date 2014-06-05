package br.catolica.artigoservlets.controller;

import br.catolica.artigoservlets.dao.PessoaDAO;
import br.catolica.artigoservlets.model.Cidade;
import br.catolica.artigoservlets.model.Pessoa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raphael
 */
@WebServlet(value = "/PessoaController", name = "PessoaController")
public class PessoaController extends HttpServlet {

    private static String INSERT = "/pessoa.jsp";
    private static String EDIT = "/edit.jsp";
    private static String LIST = "/list.jsp";

    private PessoaDAO dao;

    public PessoaController() {
        dao = new PessoaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = "";
        String id = request.getParameter("pessoaId");

        String action = request.getParameter("action");
        if ((id == null) && action.equalsIgnoreCase("insert")) {

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(request.getParameter("nome"));
            pessoa.setIdade(Integer.parseInt(request.getParameter("idade")));
            
            dao.save(pessoa);
            redirect = LIST;
            request.setAttribute("pessoas", dao.list());

        } else if (action.equalsIgnoreCase("delete")) {

            dao.remove(Long.parseLong(id));
            redirect = LIST;
            request.setAttribute("pessoas", dao.list());

        } else if (action.equalsIgnoreCase("editform")) {
           
            redirect = EDIT;
            
        } else if (action.equalsIgnoreCase("edit")) {
            
            Pessoa pessoa = new Pessoa();
            id = request.getParameter("pessoaId");
            pessoa.setId(Long.parseLong(id));
            pessoa.setNome(request.getParameter("nome"));
            pessoa.setIdade(Integer.parseInt(request.getParameter("idade")));
            dao.update(pessoa);
            request.setAttribute("pessoa", pessoa);
            redirect = LIST;
            
        } else if (action.equalsIgnoreCase("list")) {
            
            redirect = LIST;
            request.setAttribute("pessoas", dao.list());
        
        } else {
            redirect = INSERT;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
}
