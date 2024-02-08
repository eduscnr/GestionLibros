<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 06/02/2024
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<form action="mostrarDetallesVenta" method="get" class="flex justify-center items-center">
    <select name="fechaVenta">
        <option value="">Mostrar todo</option>
        <c:forEach var="fecha" items="${fechasVenta}">
            <option value="${fecha.fechaVenta}">${fecha.fechaVenta}</option>
        </c:forEach>
    </select>
    <button type="submit" class="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600">Mostras</button>
</form>
<c:forEach var="venta" items="${listaVenta}">
    <div class="flex justify-center items-center">
    <h1>Nombre del cliente: ${venta.idCliente.nombre}</h1>
        <p> Fecha de la venta: ${venta.fechaVenta}</p>
    </div>
<table class="border-collapse w-full">
    <thead>
    <tr>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Libro</th>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Titulo</th>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Precio</th>
        <th class="p-3 font-bold uppercase bg-gray-200 text-gray-600 border border-gray-300 hidden lg:table-cell">Cantidad</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="detalles" items="${venta.detallesVentasList}">
    <tr class="bg-white lg:hover:bg-gray-100 flex lg:table-row flex-row lg:flex-row flex-wrap lg:flex-no-wrap mb-10 lg:mb-0">
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span class="w-16 h-16 mx-auto object-cover"><img src="${detalles.libroId.url}"></span>
        </td>
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span>${detalles.libroId.titulo}</span>
        </td>
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span>${detalles.pvp}€</span>
        </td>
        <td class="w-full lg:w-auto p-3 text-gray-800 text-center border border-b block lg:table-cell relative lg:static">
            <span>${detalles.cantidad}</span>
        </td>
    </tr>
</table>
    </c:forEach>
</c:forEach>
</body>
</html>
