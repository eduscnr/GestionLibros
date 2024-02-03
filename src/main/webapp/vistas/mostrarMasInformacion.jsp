<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 03/02/2024
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detalles del Libro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-4">
            <img src="${libro.url}" alt="Portada del libro ${libro.titulo}" class="img-fluid">
        </div>
        <div class="col-md-8">
            <h1>${libro.titulo}</h1>
            <p><strong>Autor:</strong> ${libro.autor.nombre}</p>
            <p><strong>Género:</strong> ${libro.genero.tipo}</p>
            <p><strong>Descripción:</strong> ${libro.descripcion}</p>
            <p><strong>Precio:</strong> ${libro.precio}€</p>
        </div>
    </div>
</div>

<!-- Agregar el script de Bootstrap para JavaScript, opcional -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8y+JGf3itMYb6p8A+PqZlgyuDsFzKGgk5bFQK5tr5P5Qc/TDAHzdBz9CBAQ" crossorigin="anonymous"></script>
</body>
</html>
