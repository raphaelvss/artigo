<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="br.catolica.artigoservlets.model.Pessoa"%>
<%@ page import="br.catolica.artigoservlets.dao.PessoaDAO"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Edit User</title>
    </head>
    <body>
        <%
            Pessoa pessoa = new Pessoa();
        %>
        <%
            PessoaDAO dao = new PessoaDAO();
        %>
        <form method="POST" action='PessoaController' name="frmEditPessoa"><input
                type="hidden" name="action" value="edit" /> <%
                    String id = request.getParameter("pessoaId");
                    if (!((id) == null)) {
                        pessoa = dao.findByPk(Long.parseLong(id));
            %>
            <table>
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" /></td>
                </tr>
                <tr>
                    <td>Idade</td>
                    <td><input type="text" name="idade" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update" /></td>
                </tr>
            </table>
            <%
                } else
                    out.println("ID Not Found");
            %>
        </form>
    </body>
</html>