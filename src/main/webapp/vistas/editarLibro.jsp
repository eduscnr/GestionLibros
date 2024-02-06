<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 06/02/2024
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Editar libro</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="flex items-center justify-center p-12">
    <!-- Author: FormBold Team -->
    <!-- Learn More: https://formbold.com -->
    <div class="mx-auto w-full max-w-[550px]">
        <form:form action="../editarLibro" method="post" modelAttribute="libro">
            <div class="form-group">
                <label class="col-md-4 control-label" for="idLibro">Id</label>
                <div class="col-md-4">
                    <form:input id="idLibro" path="idLibro" type="hidden" placeholder="Id" class="form-control input-md" required=""/>
                </div>
            </div>
            <div class="mb-5">
                <label
                        for="titulo"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Titulo
                </label>
                <input:input
                        path="titulo"
                        type="text"
                        name="titulo"
                        id="titulo"
                        placeholder="Titulo"
                        class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                />
            </div>
            <div class="mb-5">
                <label
                        for="descripcion"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Descripcion
                </label>
                <textarea:textarea
                        path="descripcion"
                        rows="4"
                        name="descripcion"
                        id="descripcion"
                        placeholder="descripcion del libro"
                        class="w-full resize-none rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                ></textarea:textarea>
            </div>
            <div class="mb-5">
                <label
                        for="precio"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Precio
                </label>
                <input:input
                        path="precio"
                        type="text"
                        name="precio"
                        id="precio"
                        placeholder="precio del libro"
                        class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                />
            </div>
            <div class="mb-5">
                <label
                        for="isbn"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    ISBN
                </label>
                <input:input
                        path="isbn"
                        type="text"
                        name="isbn"
                        id="isbn"
                        placeholder="ISBN del libro"
                        class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                />
            </div>
            <div class="mb-5">
                <label
                        for="url"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    URL
                </label>
                <input:input
                        path="url"
                        type="text"
                        name="url"
                        id="url"
                        placeholder="URL de la caratula del libro"
                        class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                />
            </div>
            <div class="mb-5">
                <label
                        for="genero"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    Genero
                </label>
                <form:select path="genero.idGenero" id="genero" name="genero">
                    <form:option value="1">Ciencia ficción</form:option>
                    <form:option value="2">Magia</form:option>
                    <form:option value="3">Suspense</form:option>
                    <form:option value="4">Fantasia</form:option>
                    <form:option value="5">Terror</form:option>
                    <form:option value="6">Romance</form:option>
                </form:select>
            </div>
            <div class="mb-5">
                <label
                        for="autor"
                        class="mb-3 block text-base font-medium text-[#07074D]"
                >
                    autor
                </label>
                <form:select path="autor.idAutor" id="autor" name="autor">
                    <form:option value="1">Suzanne Collins</form:option>
                    <form:option value="2">J. K. Rowling</form:option>
                    <form:option value="3">Jules Verne</form:option>
                    <form:option value="4">Daisy Meadows</form:option>
                    <form:option value="5">Stephen King</form:option>
                    <form:option value="6">Mike Lightwood</form:option>
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
