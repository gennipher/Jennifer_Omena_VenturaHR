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
            <h1>VenturaHR - Candidato</h1>
            <h2>Olá, ${usuario.nome}</h2>
            <div style="background-color: lightgray; width: 600px">
                <table id="vagasPublicadas" border="0">
                    <thead>
                        <tr>
                            <th>Vagas</th>
                            <th>Cidade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="vaga" items="${publicadas}">
                            <tr>
                                <td>${vaga.cargo}</td>
                                <td>${vaga.cidade}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </body>
    </html>
