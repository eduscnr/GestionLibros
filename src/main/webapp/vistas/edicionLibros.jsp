<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 06/02/2024
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edición libros</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<table class="border-collapse w-full">
  <thead>
  <tr>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Libro</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Titulo</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Descripcion</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Precio</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Autor</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Genero</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">ISBN</th>
    <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Acción</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="libro" items="${listaLibros}">
  <tr class="bg-white lg:hover:bg-gray-100 flex lg:table-row flex-row lg:flex-row flex-wrap lg:flex-no-wrap mb-10 lg:mb-0">
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span><img src="${libro.url}" class="w-16 h-16 mx-auto object-cover"></span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span>${libro.titulo}</span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span>${libro.descripcion}</span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span>${libro.precio}</span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span>${libro.autor.nombre}</span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span>${libro.genero.tipo}</span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <span>${libro.isbn}</span>
    </td>
    <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
      <a href="editarLibro/${libro.idLibro}" class="text-blue-400 hover:text-blue-600 underline">Editar</a>
      <a href="eliminar/${libro.idLibro}" class="text-blue-400 hover:text-blue-600 underline pl-6">Eliminar</a>
    </td>
  </tr>
  </c:forEach>
</table>
<form:form method="post" action="irNuevoLibro">
  <button class="flex ml-auto text-white bg-red-500 border-0 py-2 px-6 focus:outline-none hover:bg-red-600 rounded">Nuevo libro</button>
</form:form>
</body>
</html>
