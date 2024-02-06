<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 03/02/2024
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Detalles del Libro</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<section class="text-gray-700 body-font overflow-hidden bg-white">
    <div class="container px-5 py-24 mx-auto">
        <div class="lg:w-4/5 mx-auto flex flex-wrap">
            <img alt="ecommerce" class="lg:w-1/3 w-full object-cover object-center rounded border border-gray-200"
                 src="${libro.url}">
            <div class="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0">
                <h2 class="text-sm title-font text-gray-500 tracking-widest">${libro.autor.nombre}</h2>
                <h1 class="text-gray-900 text-3xl title-font font-medium mb-1">${libro.titulo}</h1>
                <p class="leading-relaxed">${libro.descripcion}</p>
                <div class="flex mt-8">
                    <span class="title-font font-medium text-2xl text-gray-900">${libro.precio}€</span>
                    <form:form method="post" action="../agregarAlCarrito" modelAttribute="elementosCarrito">
                        <input type="hidden" name="idLibro" value="${libro.idLibro}" />
                        <input type="hidden" name="titulo" value="${libro.titulo}" />
                        <input type="hidden" name="precio" value="${libro.precio}" />
                        <input type="number" name="cantidad" value="1" />
                        <input type="hidden" name="url" value="${libro.url}">
                        <button class="flex ml-auto text-white bg-red-500 border-0 py-2 px-6 focus:outline-none hover:bg-red-600 rounded">
                            Comprar
                        </button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
