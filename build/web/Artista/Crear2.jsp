<%-- 
    Document   : Crear2
    Created on : 16/11/2023, 4:54:45 p. m.
    Author     : jhoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Artista/StylesArtista/encabezado.css" rel="stylesheet" type="text/css"/>
        <link href="Artista/StylesArtista/crear.css" rel="stylesheet" type="text/css"/>
        <!-- Fuentes -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,300;1,400&display=swap" rel="stylesheet"> 
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!-- Contenedor del encabezado -->
            <div class="container-fluid"  style="background: #00AD00;">
                <div>
                    <a class="navbar-brand d-none d-md-block text-light" href="Artista/Perfil.jsp">
                        <img src="Artista/Iconos/perfil.png" alt="" style=" width: 30px; height: 30px;" class="d-inline-block">
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
                                </svg>
                            </i>
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
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}""><img class="icon" src="Artista/Iconos/Inicio.png"> Inicio</a></li>
                                <li><a class="dropdown-item" href="Artista/Perfil.jsp" ><img class="icon" src="Artista/Iconos/mi_cuenta.png">  Mi cuenta</a></li>
                                <li><a class="dropdown-item" href="Artista/Configuracion.jsp"><img class="icon"  src="Artista/Iconos/Config.png" >  Configuracion</a></li>
                                <li><a class="dropdown-item" href="Artista/Subastas.jsp"><img class="icon"  src="Artista/Iconos/negocia.png" >  Negociaciones</a></li>
                                <li><a class="dropdown-item" href="../inicio.jsp"><img class="icon"  src="Artista/Iconos/cerrar-sesion.png" >  Salir</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        
        
        
        
        <section>
            <!-- Se solicita el ingreso del correo -->
            <input type="hidden" id="IdUsu" value="${obr.getArtista().getIdUsuario()}">
            <input type="hidden" name="txtdocumento" id="Documento" value="${obr.getArtista().getNroDocumento()}">
            <p class="text-center" style="color: #00AD00;" id="NombreUsu">${obr.getArtista().getNombreUsuario()}</p>
            <p class="text-center" style="color: #00AD00;" id="Nivel_Formacion">${obr.getArtista().getNivel_Formacion()}</p>
            <div class="espaci mb-3">
                <form  id="form" method="post" enctype="multipart/form-data">
                    <div class="rectangu">
                    <img src="src" alt="alt"/>
                    <input type="file" class="btn1 btn-outline-secondary" id="img" style="text-decoration: none; border: 2px solid #00AD00;">
                    </div>
                    
                    <input type="text"  class="form-control" id="NomObr" placeholder="Nombre de la obra" name="NameObr">
                    <br>
                    <input type="text"  class="form-control" id="Tecnica" placeholder="Tecnica" name="Tecnica">
                    <br>
                    <input type="text"  class="form-control" id="Descripcion" placeholder="Descripción" name="Descripcion">
                    <br>
                    <input type="text"  class="form-control" id="Precio" placeholder="Valor de la obra" name="Precio">
                    <br>
                    <select class="form-control" id="Categoria"  name="txtCategoria">
                        <option >Seleccione la categoria de la obra</option>
                        <option value="1">Lapiz de grafito</option>
                        <option value="2">Lapices de colores</option>
                        <option value="3">Técnicas artísticas con rotuladores</option>
                        <option value="4">Carboncillo</option>
                        <option value="5">Ceras</option>
                        <option value="6">Pastel</option>
                        <option value="7">Tempera</option>
                        <option value="8">Acuarela</option>
                        <option value="9">Oleo</option>
                    </select>
                    <br>
                    <select name="txtModoVenta"  class="form-control" id="ModoVent" >
                        <option>Seleccione el modo de venta que le convenga</option>
                        <option value="VentaDirecta">Venta directa</option>
                        <option value="Subasta">Subasta</option>
                    </select>
                    <br>
                    <input class="btn text-light" style="background-color: #00AD00;" type="submit">
                </form>
            </div>
                                                
                
                                                <br>
                                                <!-- Botón para registrarse -->
                                               <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                                               <script src="JS/Script.js"></script>    
                                                  
                                                     <!-- <button class="btn text-light" style="background-color: #00AD00;" type="button"><a style=" color: white; text-decoration: none" href="">Iniciar</a></button> -->
                                              
                                               
        </section>
    </body>
</html>
