<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <h1>Estudiantes</h1>
        <h3>Autor: Jhoel Brandon Quispe Coila</h3>
        <a class="btn-nuv" href="MainController?action=nuevo">Nuevo Estudiante</a>
        <br>
        <br>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Email</th>
                <th>Fecha de Nacimiento</th>
                <th></th>
                <th></th>
            </tr>

            <c:forEach var="estudiante" items="${estudiantes}">
                <tr>
                    <td>${estudiante.id}</td>
                    <td>${estudiante.nombre}</td>
                    <td>${estudiante.apellidos}</td>
                    <td>${estudiante.email}</td>
                    <td>
                        <fmt:formatDate value="${estudiante.fechaNacimiento}" pattern="dd-MM-yyyy" var="fechaFormateada" />
                        ${fechaFormateada}
                    </td>
                    <td><a class="btn-edit" href="MainController?action=editar&id=${estudiante.id}">Editar</a></td>
                    <td><a class="btn-del" href="MainController?action=eliminar&id=${estudiante.id}" onclick="return confirm('Está seguro ???')">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
    <footer>
        <p>&copy; Jhoel Brandon Quispe Coila TEM-742</p>
    </footer>
</html>
