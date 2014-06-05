<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Pessoa</title>
    </head>
    <body>
        <form method="POST" action='PessoaController' name="frmAddPessoa"><input
                type="hidden" name="action" value="insert" />
            <p><b>Adicionar Pessoa</b></p>
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
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
        <p><a href="PessoaController?action=list">Listar</a></p>
    </body>
</html>