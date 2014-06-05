<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="br.catolica.artigoservlets.model.Pessoa"%>
<%@ page import="br.catolica.artigoservlets.dao.PessoaDAO"%>
<%@ page import="java.util.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>All User</title>
    </head>
    <body>
        <%
        //UserBean user = new UserBean();
            PessoaDAO dao = new PessoaDAO();
            List<Pessoa> list = dao.list();
        //Iterator<UserBean> itr = list.iterator();
        %>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Idade</th>
            </tr>
            <tr>
                <%
                    /*while(itr.hasNext())
                     {
                     System.out.println(user.getId());*/
                    for (Pessoa pessoa : list) {
                %>
                <td><%=pessoa.getNome()%></td>
                <td><%=pessoa.getIdade()%></td>
                <td><a
                        href="PessoaController?action=editform&pessoaId=<%=pessoa.getId()%>">Update</a></td>
                <td><a
                        href="PessoaController?action=delete&pessoaId=<%=pessoa.getId()%>">Delete</a></td>

            </tr>
            <%
                }
            //}
            %>
        </table>
        <p><a href="PessoaController?action=insert">Add User</a></p>
    </body>
</html>