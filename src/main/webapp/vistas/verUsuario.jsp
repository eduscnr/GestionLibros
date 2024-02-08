<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 06/02/2024
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Ver usuarios</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<table class="border-collapse w-full">
    <thead>
    <tr>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Nombre</th>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Apellidos</th>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Rol</th>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Acción</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="usuario" items="${listaUsuario}">
    <tr class="bg-white lg:hover:bg-gray-100 flex lg:table-row flex-row lg:flex-row flex-wrap lg:flex-no-wrap mb-10 lg:mb-0">
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span class="w-16 h-16 mx-auto object-cover">${usuario.nombre}</span>
        </td>
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span>${usuario.apellido}</span>
        </td>
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span>${usuario.rol}</span>
        </td>
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <a href="editarUsuario/${usuario.idCliente}" class="text-blue-400 hover:text-blue-600 underline">Editar</a>
            <%--<a href="eliminar/${usuario.idCliente}" class="text-blue-400 hover:text-blue-600 underline pl-6">Eliminar</a>--%>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
