<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 06/02/2024
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Editar usuario</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="flex items-center justify-center p-12">
    <!-- Author: FormBold Team -->
    <!-- Learn More: https://formbold.com -->
    <div class="mx-auto w-full max-w-[550px]">
        <form:form action="../editarUsuario" method="post" modelAttribute="cliente">
            <div class="form-group">
                <label class="col-md-4 control-label" for="idCliente">Id</label>
                <div class="col-md-4">
                    <form:input id="idCliente" path="idCliente" type="hidden" placeholder="Id" class="form-control input-md" required=""/>
                    <form:input id="password" path="password" type="hidden" placeholder="password" class="form-control input-md" required=""/>
                </div>
            </div>
            <div class="mb-5">
                <label
                        for="nombre"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Nombre
                </label>
                <input:input
                        path="nombre"
                        type="text"
                        name="nombre"
                        id="nombre"
                        placeholder="Nombre del cliente"
                        class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                />
            </div>
            <div class="mb-5">
                <label
                        for="apellido"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Apellidos
                </label>
                <input:input
                        path="apellido"
                        name="apellido"
                        id="apellido"
                        class="w-full resize-none rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                ></input:input>
            </div>
            <div class="mb-5">
                <label
                        for="rol"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Rol
                </label>
                <form:select path="rol" id="rol" name="rol">
                    <form:option value="usuario">Usuario</form:option>
                    <form:option value="administrador">Administrador</form:option>
                </form:select>
            </div>
            <div>
                <button class="hover:shadow-form rounded-md bg-[#6A64F1] py-3 px-8 text-base font-semibold text-white outline-none">
                    Agregar
                </button>
            </div>
        </form:form>
    </div>
</body>
</html>
