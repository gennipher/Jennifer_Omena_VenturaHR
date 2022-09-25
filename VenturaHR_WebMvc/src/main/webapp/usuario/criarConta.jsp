<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>VenturaHR</title>
        </head>
        <body>
            <h1>VenturaHR - Cadastro</h1>
            <form action="criarConta" method="post">
                <table border="0" cellpadding="10" cellspacing="0">
                    <tr>
                        <td>Nome:</td>
                        <td>
                            <input type="text" name="nome" size="50" maxlength="50" value="${usuario.nome}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Endereço:</td>
                        <td>
                            <input type="text" name="endereco" size="100" maxlength="100" value="${usuario.endereco}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Telefone:</td>
                        <td>
                            <input type="text" name="telefone" size="20" maxlength="20" value="${usuario.telefone}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>E-mail:</td>
                        <td>
                            <input type="text" name="email" size="30" maxlength="30" value="${usuario.email}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Senha:</td>
                        <td>
                            <input type="text" name="senha" size="32" maxlength="32" value="${usuario.senha}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>CPF:</td>
                        <td>
                            <input type="text" name="cpf" size="11" maxlength="11" value="${usuario.cpf}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo:</td>
                        <td>
                            <input type="radio" name="tipo"  value="C"/> Candidato
                            <input type="radio" name="tipo"  value="E"/> Empresa
                        </td>
                    </tr>
                    <tr>
                        <td>Razão Social:</td>
                        <td>
                            <input type="text" name="razaoSocial" size="50" maxlength="50" value="${usuario.razaoSocial}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>CNPJ:</td>
                        <td>
                            <input type="text" name="cnpj" size="14" maxlength="14" value="${usuario.cnpj}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Criar Conta"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <a href="/login" >Já possui cadastro? Clique aqui e Faça Login</a>
                        </td>
                    </tr>
                </table>
            </form>
            <div style="color:red">
                <c:forEach var = "erro" items="${erros}">
                    <h3>Erros: ${erro.defaultMessage}</h3>
                </c:forEach>
            </div> 
            <c:if test="${not empty mensagem}">
                <div class="alert alert-danger">
                  <strong>Problema!</strong> ${mensagem}
                </div>
            </c:if>
        </body>
    </html>



