<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        div {
            cursor: pointer;
        }
    </style>
</head>
<body>
<h3>Bienvenido, ${sessionScope.usuario}!</h3>
<c:if test="${!empty sessionScope.rol}">
    <div class="max-w-4xl mx-auto grid grid-cols-3 gap-6">
        <c:forEach var="libro" items="${libros}">
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
                        <a href="#"
                           class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Add
                            to cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>
</body>
</html>
