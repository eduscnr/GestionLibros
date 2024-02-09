<%--
  Created by IntelliJ IDEA.
  User: Eduardo
  Date: 04/02/2024
  Time: 1:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<form:form class="min-h-screen bg-gray-900 flex flex-col justify-center sm:py-12"  action="" method="post" modelAttribute="inicioUsuario">
    <div class="p-10 xs:p-0 mx-auto md:w-full md:max-w-md">
        <h1 class="font-bold text-center text-2xl mb-5 text-white">Kobo</h1>
        <div class="bg-white shadow w-full rounded-lg divide-y divide-gray-200">
            <div class="px-5 py-7">
                <label class="font-semibold text-sm text-gray-600 pb-1 block">E-mail</label>
                <input:input type="text" path="nombre" class="border rounded-lg px-3 py-2 mt-1 mb-5 text-sm w-full" />
                <label class="font-semibold text-sm text-gray-600 pb-1 block">Password</label>
                <input:input type="password" path="password" class="border rounded-lg px-3 py-2 mt-1 mb-5 text-sm w-full" />
                <button id="enviar" name="enviar" class="transition duration-200 bg-blue-500 hover:bg-blue-600 focus:bg-blue-700 focus:shadow-sm focus:ring-4 focus:ring-blue-500 focus:ring-opacity-50 text-white w-full py-2.5 rounded-lg text-sm shadow-sm hover:shadow-md font-semibold text-center inline-block">
                    <span class="inline-block mr-2">Login</span>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="w-4 h-4 inline-block">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3" />
                    </svg>
                </button>
            </div>
        </div>
    </div>
</form:form>
<form:form action="registrar" method="get" modelAttribute="cliente">
    <button id="enviarRegistrar" name="enviarRegistrar" class="transition duration-200 bg-blue-500 hover:bg-blue-600 focus:bg-blue-700 focus:shadow-sm focus:ring-4 focus:ring-blue-500 focus:ring-opacity-50 text-white w-full py-2.5 rounded-lg text-sm shadow-sm hover:shadow-md font-semibold text-center inline-block">
        <span class="inline-block mr-2">Registrar</span>
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" class="w-4 h-4 inline-block">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3" />
        </svg>
    </button>
</form:form>
</body>
</html>
