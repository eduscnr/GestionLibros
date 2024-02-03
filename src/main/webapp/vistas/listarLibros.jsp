<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <style>
        div {
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach var="libro" items="${libros}">
            <div class="col-md-4 mb-4" onclick="window.location='mostrarInformacion/${libro.idLibro}'">
                <div class="card">
                    <c:if test="${not empty libro.url}">
                        <img src="${libro.url}" alt="libro de ${libro.titulo}" class="card-img-top">
                    </c:if>
                    <div class="card-body">
                        <h5 class="card-title">${libro.titulo}</h5>
                        <p class="card-text">${libro.autor.nombre}</p>
                        <p class="card-text">${libro.precio}€</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
