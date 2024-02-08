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
<%--<h3>Bienvenido, ${sessionScope.usuario}!</h3>--%>
<c:if test="${!empty sessionScope.rol}">
    <div class="flex flex-wrap mb-8">
        <section class="relative mx-auto">
            <!-- navbar -->
            <nav class="flex justify-between bg-gray-900 text-white w-screen">
                <div class="px-5 xl:px-12 py-6 flex w-full items-center">
                    <a class="text-3xl font-bold font-heading" href="#">
                        <!-- <img class="h-9" src="logo.png" alt="logo"> -->
                        Kobo
                    </a>
                    <!-- Nav Links -->
                    <ul class="hidden md:flex px-4 mx-auto font-semibold font-heading space-x-12">
                        <li><a class="hover:text-gray-200" href="verLibros">Listado de libros</a></li>
                        <li><a class="hover:text-gray-200" href="verGeneros">Genero</a></li>
                        <c:if test="${sessionScope.rol eq 'usuario'}">
                            <li><a class="hover:text-gray-200" href="verHistorialCompra">Historial de compra</a></li>
                        </c:if>
                        <c:if test="${sessionScope.rol eq 'administrador'}">
                            <li><a class="hover:text-gray-200" href="edicionLibros">Edicion libros</a></li>
                            <li><a class="hover:text-gray-200" href="administrarUsuarios">Consultar usuarios</a></li>
                            <li><a class="hover:text-gray-200" href="mostrarUsuariosyDatos">Consultar todas las compras</a></li>
                        </c:if>
                    </ul>
                    <!-- Header Icons -->
                    <div class="hidden xl:flex items-center space-x-5 items-center">
                        <%--Ver carrito y su contenido para procesar la compra--%>
                        <a class="flex items-center hover:text-gray-200" href="verCarrito">
                            <c:if test="${not carritoVacio}">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                     stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                          d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
                                </svg>
                                <span class="flex absolute -mt-5 ml-4">
                                <span class="animate-ping absolute inline-flex h-3 w-3 rounded-full bg-pink-400 opacity-75"></span>
                                <span class="relative inline-flex rounded-full h-3 w-3 bg-pink-500"></span>
                            </span>
                            </c:if>
                            <c:if test="${carritoVacio}">
                                <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                                     stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                          d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
                                </svg>
                            </c:if>
                        </a>
                        <!-- Sign In / Register -->
                        <a class="flex items-center hover:text-gray-200" href="logout">
                            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                                 viewBox="0 0 24 24" stroke="currentColor">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                      d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
                            </svg>
                        </a>
                    </div>
                </div>
                <!-- Responsive navbar -->
                <a class="xl:hidden flex mr-6 items-center" href="#">
                    <c:if test="${not carritoVacio}">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
                        </svg>
                        <span class="flex absolute -mt-5 ml-4">
                                <span class="animate-ping absolute inline-flex h-3 w-3 rounded-full bg-pink-400 opacity-75"></span>
                                <span class="relative inline-flex rounded-full h-3 w-3 bg-pink-500"></span>
                            </span>
                    </c:if>
                    <c:if test="${carritoVacio}">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
                        </svg>
                    </c:if>
                </a>
                <a class="navbar-burger self-center mr-12 xl:hidden" href="logout">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                         viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
                    </svg>
                </a>
            </nav>
        </section>
    </div>
    <div class="flex justify-center items-center">
        <form action="buscarLibros" method="get">
            <input type="text" name="q" placeholder="Buscar por título..." class="mb-4 px-4 py-2 border rounded-lg">
            <button type="submit" class="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600">Buscar</button>
        </form>
    </div>

    <div class="max-w-4xl mx-auto grid grid-cols-3 gap-6">
        <c:forEach var="libro" items="${libros}">
            <div class="shadow-md rounded-lg mx-2 w-72 xl:mb-0 mb-6 bg-gray-800 border-gray-700 mb-4 ml-4">
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
    </div>
</c:if>
</body>
</html>
