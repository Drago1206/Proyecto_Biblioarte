<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%
    if (session.getAttribute("Comprador") != null) {
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
    <link rel="stylesheet" href="SytlesComprador/subastas.css">
    <link rel="stylesheet" href="StylesComprador/encabezado.css">

	<!-- Fuentes -->
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,300;1,400&display=swap" rel="stylesheet">    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"  crossorigin="anonymous"></script>
        
        <script>
            console.log("Valor de ofertaExitosa:", ${ofertaExitosa});
        </script>
    
    
        <c:if test="${not empty ofertaExitosa and ofertaExitosa}">
    <script>
        $(document).ready(function () {
            $('#ofertaExitosaModal').modal('show');
        });
    </script>
        </c:if>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- Contenedor del encabezado -->
        <div class="container-fluid"  style="background: #00AD00;">
            <div >
                <a class="navbar-brand d-none d-md-block text-light" href="/8_Mi_perfil/miperfil.html">
                    <img src="../Artista/Iconos/perfil.png" alt="" style=" width: 30px; height: 30px;" class="d-inline-block">
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
 
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Men�
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="inicio_comprador.jsp"><img class="icon" src="../Artista/Iconos/Inicio.png"> Inicio</a></li>

                            <li><a class="dropdown-item" href="Perfil.jsp" ><img class="icon" src="Iconos/mi_cuenta.png">  Mi cuenta</a></li>

                            <li><a class="dropdown-item" href="Configuracion.jsp"><img class="icon"  src="Iconos/Config.png" >  Configuracion</a></li>

                            <li><a class="dropdown-item" href="subastas.jsp"><img class="icon"  src="Iconos/negocia.png" >  Negociaciones</a></li>
                            
                            <li><a class="dropdown-item" href="/../inicio.jsp"><img class="icon"  src="Iconos/cerrar-sesion.png" >  Salir</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


    <section class="">
        <div class="container">
            <div class="row justify-content-center pt-5">
                <div class="col-mt-7">
                    <div class="card mb-8 ">
                        <!-- <div class="card-body"> -->
                            <div class="card ">
                                <div class="espaci position-absolute top-20 start-50" style="display: flex; align-items: center;">
                                    <p class="text" style="color: #00AD00; margin-right: 10px;">Obra a Negociar</p>
                                    
                                    <p class="text" style="color: #00AD00; margin-right: 10px;">${ObrasSubasta.getNombre_obra()}</p>
                                     
                                     <img src="${ObrasSubasta.getUrl()}" width="100px" height="110px">
                                </div>
                                <div class="card-body">
                                    <form action="../Mv_Usuarios?menu=Compradores&accion=subastainsert&fecha=${ObrasSubasta.getFecha_subasta()}&valorIni=${ObrasSubasta.getValor_obra()}" method="post">
                                        <div class="rectangulo">

                                        </div>
                                        <div class="coont container">
                                            <div class="mb-3">
                                                <input type="text" hidden name="txtIdComp" value="${Comp.getNroDocumento()}">
                                                <input type="text" hidden name="txtIdArt" value="${ObrasSubasta.getArtista().getNroDocumento()}">
                                                <input type="text" hidden name="txtIdObr" value="${ObrasSubasta.getId_obra()}">
                                                

                                                <div class="espaci mb-3" style="display: flex; align-items: center;">
                                                    <p style="margin-right: 10px;">Fecha de subasta</p>
                                                    
                                                    <h6>${ObrasSubasta.getFecha_subasta()}</h6>
                                                </div>
                                                <div class="espaci mb-3" style="display: flex; align-items: center;">
                                                    <p style="margin-right: 10px;">Valor inicial</p>
                                                    <h6>${ObrasSubasta.getValor_obra()}</h6>
                                                </div>
                                                <div class="espaci mb-3" style="display: flex; align-items: center;">
                                                    <p style="margin-right: 10px;">Valor a ofertar</p>
                                                    <input type="number" class="form-control" name="txtValorOfrecido"id="exampleInputPassword1" placeholder="El valor que ofreces">
                                                </div>
                                                <br>
                                                <br>
                                                <!-- Bot�n para registrarse -->
                                                <div class="d-grid gap-2 col-3 mx-auto">
                                                    <button class="btn text-light" style="background-color: #00AD00;" type="submit">Realizar oferta</button>
                                                    <!-- <button class="btn text-light" style="background-color: #00AD00;" type="button"><a style=" color: white; text-decoration: none" href="">Iniciar</a></button> -->
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- Se inicializa el formulario para el registro -->
                        <!-- </div> -->
                    </div>
                </div>
            </div>
        </div>
            <div class="modal fade" id="ofertaExitosaModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Oferta Exitosa</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            �Tu oferta se ha enviado con �xito!
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>                                       
    </section>


          
</body>
</html>
<%}else{
response.sendRedirect("index.jsp");
} %>