<%@page import="java.util.List"%>
<%@page import="modelo.Artistas"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("Artista") != null) {
%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="StylesArtista/perfil.css">
    <link rel="stylesheet" href="StylesArtista/encabezado.css">

	<!-- Fuentes -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,300;1,400&display=swap" rel="stylesheet">    
    </head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- Contenedor del encabezado -->
        <div class="container-fluid"  style="background: #00AD00;">
            <div >
                <a class="navbar-brand d-none d-md-block text-light" href="Artista/Perfil.jsp">
                    <img src="Iconos/perfil.png" alt="" style=" width: 30px; height: 30px;" class="d-inline-block">
                    Biblioarte
                </a>
            </div>
            
            <form class="d-flex">
                <div class="search-bar">
                    <input type="text" class="search-input" placeholder="Buscar">
                    <button class="search-button">
                        <i class="fas fa-search icon ">
                            <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="35" height="25" viewBox="0,0,256,256">
                            <g fill="#fffefe" fill-rule="nonzero" stroke="none" stroke-width="1
                            " stroke-linecap="butt" stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0" font-family="none" font-weight="none" font-size="none" text-anchor="none" style="mix-blend-mode: normal"><g transform="scale(5.12,5.12)"><path d="M21,3c-9.37891,0 -17,7.62109 -17,17c0,9.37891 7.62109,17 17,17c3.71094,0 7.14063,-1.19531 9.9375,-3.21875l13.15625,13.125l2.8125,-2.8125l-13,-13.03125c2.55469,-2.97656 4.09375,-6.83984 4.09375,-11.0625c0,-9.37891 -7.62109,-17 -17,-17zM21,5c8.29688,0 15,6.70313 15,15c0,8.29688 -6.70312,15 -15,15c-8.29687,0 -15,-6.70312 -15,-15c0,-8.29687 6.70313,-15 15,-15z"></path></g></g>
    
                            </svg></i>
                    </button>
                </div>
            </form>
            
            
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse pe-5" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Categorias
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Naturaleza</a></li>
                            <li><a class="dropdown-item" href="#">Surrealista</a></li>
                            <li><a class="dropdown-item" href="#">Abstracto</a></li>
                            <li><a class="dropdown-item" href="#">Otros.</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active text-light" aria-current="page" href="Artista/Crear.jsp">Crear</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Menú
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                             <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Artista/inicio.jsp"><img class="icon" src="Iconos/Inicio.png"> Inicio</a></li>

                            <li><a class="dropdown-item" href="Perfil.jsp" ><img class="icon" src="Iconos/mi_cuenta.png">  Mi cuenta</a></li>

                            <li><a class="dropdown-item" href="../Mv_Usuarios?menu=Perfil&accion=Cargar"><img class="icon"  src="Iconos/Config.png" >  Configuracion</a></li>

                            <li><a class="dropdown-item" href="Subastas.jsp"><img class="icon"  src="Iconos/negocia.png" >  Negociaciones</a></li>
                            
                            <li><a class="dropdown-item" href="../inicio.jsp"><img class="icon"  src="Iconos/cerrar-sesion.png" >  Salir</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <section class="">
        <div class="container">
            <div class="row justify-content-center pt-5">
                <div class="">
                    <div class="card mb-3">
                        <div class="card shadow p-3 bg-body rounded">
                            <div class="card-body">
                                <div class="container">
                                    <div class="row">
                                        <!-- Espacio para mostrar imagen de perfil -->
                                        <div class="col-md-3 text-center">
                                            <div class="rectangulo">
                                                
                                                <img src="${Art.getImg_perfil()}" class="img-fluid" alt="...">
                                            </div>
                                        </div>
                                        
                                        
                                         
                                        <div class="col-md-3 text-center mb-1">
                                            <div class="icon1">
                                                 
                                                <img src="Iconos/usuario.png" alt="">
                                            </div>
                                            <div>
                                              
                                            <p>${Art.getNombreUsuario()}</p>
                                            </div>
                                        </div>
    
                                        <!-- Icono del teléfono -->
                                        <div class="col-md-3 text-center mb-3">
                                            <div class="icon2">
                                                <img src="Iconos/telefono-movil.png" alt="">
                                                
                                                <p>${Art.getTelefono()}</p>
                                            </div>
                                        </div>
    
                                        <!-- Icono de correo -->
                                        <div class="col-md-3 text-center mb-3">
                                            <div class="icon3">
                                                <img src="Iconos/correo.png" alt="">
                                                
                                                <p>${Art.getCorreoUsuario()}</p>
                                            </div>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        
    </section>

    <div class="ob"><p>MIS OBRAS</p></div>
    
    

</body>
</html>
<%}else{
response.sendRedirect("index.jsp");
} %>

