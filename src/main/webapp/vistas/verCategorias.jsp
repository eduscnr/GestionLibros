<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 07/02/2024
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Categorias</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="max-w-4xl mx-auto grid grid-cols-3 gap-6">
    <c:forEach var="genero" items="${listaGenero}">
        <h2>${genero.tipo}</h2>
        <c:forEach var="libro" items="${genero.libros}">
        <div class="bg-white shadow-md rounded-lg mx-2 w-72 xl:mb-0 mb-6 dark:bg-gray-800 dark:border-gray-700 mb-4 ml-4">
            <a href="mostrarInformacion/${libro.idLibro}">
                <img class="rounded-t-lg p-8 mx-auto"
                     src="${libro.url}" alt="product image">
            </a>
            <div class="px-5 pb-5">
                <a href="mostrarInformacion/${libro.idLibro}">
                    <h3 class="text-gray-900 font-semibold text-xl tracking-tight dark:text-white">${libro.titulo}</h3>
                </a>
                <h4 class="text-gray-900 font-semibold text-xl tracking-tight dark:text-white">${libro.autor.nombre}</h4>
                <div class="flex items-center justify-between mt-4">
                    <span class="text-3xl font-bold text-gray-900 dark:text-white">${libro.precio}€</span>
                </div>
            </div>
        </div>
        </c:forEach>
    </c:forEach>
</div>
</body>
</html>
